package com.example.apppractica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaProductosActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter adapter;
    private ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Recuperar la lista de productos del Intent
        productos = getIntent().getParcelableArrayListExtra("productos");

        // Inicializar el adaptador con el contexto y la lista de productos
        adapter = new ProductoAdapter(this, productos);
        recyclerView.setAdapter(adapter);
    }
}
