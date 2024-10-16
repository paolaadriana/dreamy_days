package com.example.apppractica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HorariosActivity extends BaseActivity {

    private RecyclerView recyclerViewHorarios;
    private HorarioAdapter horarioAdapter;
    private TextView especialidadTextView;
    private TextView medicoTextView;
    private List<Horario> horarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);

        recyclerViewHorarios = findViewById(R.id.recyclerViewHorarios);
        recyclerViewHorarios.setLayoutManager(new LinearLayoutManager(this));

//        especialidadTextView = findViewById((R.id.especialidadTextView));
//        animateTitle(especialidadTextView);

//        medicoTextView = findViewById((R.id.medicoTextView));
//        animateTitle(medicoTextView);

        // Obtener datos del Intent
        // HorariosActivity.java
        Intent intent = getIntent();
        String especialidad = intent.getStringExtra("especialidad_nombre"); // Corregido para coincidir
        String medico = intent.getStringExtra("medico_nombre"); // Corregido para coincidir
        String nombreCompleto = intent.getStringExtra("nombre_completo");  // Recibir el nombre completo


        // Configurar título
        TextView especialidadTextView = findViewById(R.id.especialidadTextView);
        TextView medicoTextView = findViewById(R.id.medicoTextView);
        especialidadTextView.setText(especialidad);
        medicoTextView.setText(medico);

        // Inicializar lista de horarios
        horarios = new ArrayList<>();
        horarios.add(new Horario("8:00 AM"));
        horarios.add(new Horario("8:30 AM"));
        horarios.add(new Horario("9:00 AM"));
        horarios.add(new Horario("9:30 AM"));
        horarios.add(new Horario("10:00 AM"));
        horarios.add(new Horario("10:30 AM"));
        horarios.add(new Horario("11:00 AM"));
        horarios.add(new Horario("11:30 AM"));

        // Configurar el adaptador
        horarioAdapter = new HorarioAdapter(horarios);
        recyclerViewHorarios.setAdapter(horarioAdapter);

        // Manejar clics en los horarios
        horarioAdapter.setOnItemClickListener(new HorarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Horario horario) {
                // Iniciar ReservaActivity al hacer clic en un horario
                Intent reservaIntent = new Intent(HorariosActivity.this, ReservaActivity.class);
                reservaIntent.putExtra("nombreApellido", medico);
                reservaIntent.putExtra("especialidad", especialidad);
                reservaIntent.putExtra("hora", horario.getHora());
                reservaIntent.putExtra("nombre_completo", nombreCompleto);  // Pasar el nombre completo
                startActivity(reservaIntent);
            }
        });
    }
}
