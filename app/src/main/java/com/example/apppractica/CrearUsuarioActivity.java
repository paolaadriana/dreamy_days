package com.example.apppractica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CrearUsuarioActivity extends BaseActivity {

    private EditText nombresEditText;
    private EditText apellidosEditText;
    private EditText usuarioEditText;
    private EditText contraseñaEditText;
    private TextView tituloTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);

        nombresEditText = findViewById(R.id.nombreEditText);
        apellidosEditText = findViewById(R.id.apellidoEditText);
        usuarioEditText = findViewById(R.id.usuarioEditText);
        contraseñaEditText = findViewById(R.id.contraseñaEditText);
        tituloTextView = findViewById(R.id.tituloTextView);

        animateTitle(tituloTextView);

        Button crearUsuarioButton = findViewById(R.id.crearUsuarioButton);
        crearUsuarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener datos del formulario
                String nombres = nombresEditText.getText().toString();
                String apellidos = apellidosEditText.getText().toString();
                String nombreCompleto = nombres + " " + apellidos;
                String usuario = usuarioEditText.getText().toString();
                String contraseña = contraseñaEditText.getText().toString();

                // Guardar nombre de usuario y contraseña en SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("USERNAME", usuario);
                editor.putString("PASSWORD", contraseña);
                editor.apply();

                // Pasar el nombre completo a MainActivity
                Intent intent = new Intent(CrearUsuarioActivity.this, MainActivity.class);
                intent.putExtra("NOMBRE_COMPLETO", nombreCompleto);
                startActivity(intent);
            }
        });
    }
}
