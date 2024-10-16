package com.example.apppractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MedicosActivity extends BaseActivity {

    private RecyclerView medicoRecyclerView;
    private MedicoAdapter medicoAdapter;
    private TextView tituloTextView;
    private List<Medico> medicoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicos);

        medicoRecyclerView = findViewById(R.id.medicoRecyclerView);
        medicoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        tituloTextView = findViewById((R.id.tituloTextView));
//        animateTitle(tituloTextView);

        String nombreCompleto = getIntent().getStringExtra("nombre_completo");

        // Obtener el nombre de la especialidad desde el Intent
        String especialidadNombre = getIntent().getStringExtra("especialidad_nombre");
        TextView tituloTextView = findViewById(R.id.tituloTextView);
        tituloTextView.setText("Médicos - " + especialidadNombre);

        // Cargar datos de médicos
        cargarMedicos(especialidadNombre);

        medicoAdapter = new MedicoAdapter(medicoList, new MedicoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Medico medico) {
                // Enviar el nombre del médico y la especialidad a la siguiente actividad
                Intent intent = new Intent(MedicosActivity.this, HorariosActivity.class);
                intent.putExtra("medico_nombre", medico.getNombre());
                intent.putExtra("especialidad_nombre", especialidadNombre);
                intent.putExtra("nombre_completo", nombreCompleto);  // Pasar el nombre completo
                startActivity(intent);
            }
        });

        medicoRecyclerView.setAdapter(medicoAdapter);
    }

    private void cargarMedicos(String especialidadNombre) {
        medicoList = new ArrayList<>();
        // Puedes modificar estos datos según la especialidad seleccionada
        medicoList.add(new Medico("Dr. Juan Pérez"));
        medicoList.add(new Medico("Dra. Ana Martínez"));
        medicoList.add(new Medico("Dr. Carlos López"));
        medicoList.add(new Medico("Dra. Laura Fernández"));
        medicoList.add(new Medico("Dr. José García"));
    }
}
