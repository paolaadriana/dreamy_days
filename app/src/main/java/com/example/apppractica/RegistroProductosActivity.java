package com.example.apppractica;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class RegistroProductosActivity extends AppCompatActivity {

    private EditText etNombre, etPrecioCompra;
    private Spinner spCategoria, spTemporada;
    private Button btnRegistrar, btnLista;
    private ArrayList<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_productos);

        etNombre = findViewById(R.id.etNombre);
        etPrecioCompra = findViewById(R.id.etPrecioCompra);
        spCategoria = findViewById(R.id.spCategoria);
        spTemporada = findViewById(R.id.spTemporada);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnLista = findViewById(R.id.btnLista);

        productos = new ArrayList<>();

        // Configurar Spinner para Categorías
        ArrayAdapter<CharSequence> categoriaAdapter = ArrayAdapter.createFromResource(this,
                R.array.categorias_array, android.R.layout.simple_spinner_item);
        categoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategoria.setAdapter(categoriaAdapter);

        // Configurar Spinner para Temporadas
        ArrayAdapter<CharSequence> temporadaAdapter = ArrayAdapter.createFromResource(this,
                R.array.temporadas_array, android.R.layout.simple_spinner_item);
        temporadaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTemporada.setAdapter(temporadaAdapter);

        btnRegistrar.setOnClickListener(v -> registrarProducto());
        btnLista.setOnClickListener(v -> mostrarLista());
    }

    private void registrarProducto() {
        String nombre = etNombre.getText().toString();
        String categoria = spCategoria.getSelectedItem().toString();
        String temporada = spTemporada.getSelectedItem().toString();
        double precioCompra = Double.parseDouble(etPrecioCompra.getText().toString());

        double precioVenta = calcularPrecioVenta(categoria, precioCompra);

        Producto producto = new Producto(nombre, categoria, temporada, precioCompra, precioVenta);
        productos.add(producto);

        // Lógica para registrar el producto (guardar en base de datos, etc.)
    }

    private double calcularPrecioVenta(String categoria, double precioCompra) {
        double precioVenta;
        if (categoria.equals("Frutas")) {
            precioVenta = precioCompra + 4 + (precioCompra * 0.03);
        } else { // Verdura
            precioVenta = precioCompra + 3 + (precioCompra * 0.05);
        }
        return precioVenta;
    }


    private void mostrarLista() {
        Intent intent = new Intent(this, ListaProductosActivity.class);
        intent.putParcelableArrayListExtra("productos", productos);
        startActivity(intent);
    }
}
