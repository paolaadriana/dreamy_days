package com.example.apppractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EspecialidadActivity extends BaseActivity {

    private RecyclerView especialidadRecyclerView;
    private EspecialidadAdapter especialidadAdapter;
    private TextView tituloTextView;
    private List<Especialidad> especialidadList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidad);
        String nombreCompleto = getIntent().getStringExtra("nombre_completo");

        especialidadRecyclerView = findViewById(R.id.especialidadRecyclerView);
        especialidadRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tituloTextView = findViewById((R.id.tituloTextView));
        animateTitle(tituloTextView);

        // Cargar datos de especialidades
        cargarEspecialidades();

        especialidadAdapter = new EspecialidadAdapter(especialidadList, new EspecialidadAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Especialidad especialidad) {
                // Enviar el nombre de la especialidad a la siguiente actividad
                Intent intent = new Intent(EspecialidadActivity.this, MedicosActivity.class);
                intent.putExtra("especialidad_nombre", especialidad.getNombre());
                intent.putExtra("nombre_completo", nombreCompleto);
                startActivity(intent);
            }
        });

        especialidadRecyclerView.setAdapter(especialidadAdapter);
    }

    private void cargarEspecialidades() {
        especialidadList = new ArrayList<>();
        especialidadList.add(new Especialidad("Ginecología"));
        especialidadList.add(new Especialidad("Pediatría"));
        especialidadList.add(new Especialidad("Cardiología"));
        especialidadList.add(new Especialidad("Oftalmología"));
        especialidadList.add(new Especialidad("Neumología"));

    }
}
