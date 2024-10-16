package com.example.apppractica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends BaseActivity {

    private EditText usuarioEditText;
    private EditText contraseñaEditText;
    private ImageView iconEye;
    private boolean isPasswordVisible = false;
    private String nombreCompleto;
    private TextView welcomeTextView;
    private String welcomeText = "Welcome"; // El texto que quieres mostrar
    private int index = 0; // Índice para las letras
    private long delay = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioEditText = findViewById(R.id.usuarioEditText);
        contraseñaEditText = findViewById(R.id.contraseñaEditText);
        iconEye = findViewById(R.id.iconEye);

        // Recibir el nombre completo de CrearUsuarioActivity
        Intent intent = getIntent();
        nombreCompleto = intent.getStringExtra("NOMBRE_COMPLETO");

        iconEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility();
            }
        });

//        TextView welcomeTextView = findViewById(R.id.titleTextView);
//
//        // Cargar la animación desde XML
//        Animation welcomeAnimation = AnimationUtils.loadAnimation(this, R.anim.welcome_animation);
//
//        // Aplicar la animación al TextView
//        welcomeTextView.startAnimation(welcomeAnimation);
        welcomeTextView = findViewById(R.id.titleTextView);

        // Iniciar la animación de máquina de escribir
        animateTitle(welcomeTextView);

        Button ingresarButton = findViewById(R.id.ingresarButton);
        ImageView logoImageView = findViewById(R.id.logoImageView);


        Animation fadeInSlideUp = AnimationUtils.loadAnimation(this, R.anim.fade_in_slide_up);
        logoImageView.startAnimation(fadeInSlideUp);

        ingresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsuario = usuarioEditText.getText().toString();
                String inputContraseña = contraseñaEditText.getText().toString();

                // Recuperar el nombre de usuario y la contraseña guardados
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedUsuario = sharedPreferences.getString("USERNAME", "");
                String savedContraseña = sharedPreferences.getString("PASSWORD", "");

                if (inputUsuario.equals(savedUsuario) && inputContraseña.equals(savedContraseña)) {
                    // Si los datos son correctos, continuar a la actividad principal
                    Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
                    intent.putExtra("NOMBRE_COMPLETO", nombreCompleto);
                    startActivity(intent);
                } else {
                    // Mostrar mensaje de error si el usuario o la contraseña son incorrectos
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button crearUsuarioButton = findViewById(R.id.crearUsuarioButton);
        crearUsuarioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa a CrearUsuarioActivity si se necesita
                Intent intent = new Intent(MainActivity.this, CrearUsuarioActivity.class);
                startActivity(intent);
            }
        });
    }

    private void animateText() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Mostrar el texto progresivamente
                welcomeTextView.setText(welcomeText.substring(0, index++));

                if (index <= welcomeText.length()) {
                    // Repetir hasta que todas las letras se hayan mostrado
                    handler.postDelayed(this, delay);
                }
            }
        }, delay);
    }

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            contraseñaEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            iconEye.setImageResource(R.drawable.ic_eye);
        } else {
            contraseñaEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            iconEye.setImageResource(R.drawable.ic_eye_open);
        }
        isPasswordVisible = !isPasswordVisible;
    }
}
