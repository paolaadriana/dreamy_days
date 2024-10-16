package com.example.apppractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends BaseActivity {

    private TextView nameTextView;
    private TextView mainTitleView;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        nameTextView = findViewById(R.id.nameTextView);
        imageButton = findViewById(R.id.imageButton);

        // Recuperar el nombre completo del Intent
        Intent intent = getIntent();
        String nombreCompleto = intent.getStringExtra("NOMBRE_COMPLETO");
        if (nombreCompleto != null) {
            nameTextView.setText(nombreCompleto);
        }

        ImageButton imageButton2 = findViewById(R.id.imageButton);

        mainTitleView = findViewById(R.id.mainTitleTextView);

        // Iniciar la animación de máquina de escribir
        animateTitle(mainTitleView);

        Animation fadeInSlideUp = AnimationUtils.loadAnimation(this, R.anim.fade_in_slide_up);
        imageButton2.startAnimation(fadeInSlideUp);

        // Configurar el botón para navegar a EspecialidadActivity
        imageButton.setOnClickListener(v -> {
            Intent especialidadesIntent = new Intent(PrincipalActivity.this, EspecialidadActivity.class);
            especialidadesIntent.putExtra("nombre_completo", nombreCompleto); // Pasar el nombre completo
            startActivity(especialidadesIntent);
        });
    }
}
