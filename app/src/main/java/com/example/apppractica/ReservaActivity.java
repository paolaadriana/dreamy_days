package com.example.apppractica;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class ReservaActivity extends BaseActivity {

    private TextView nombreApellidoTextView;
    private TextView especialidadTextView;
    private TextView horaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        nombreApellidoTextView = findViewById(R.id.nombreApellidoTextView);
        especialidadTextView = findViewById(R.id.especialidadTextView);
        horaTextView = findViewById(R.id.horaTextView);



        // Obtener datos del Intent
        Intent intent = getIntent();
        String nombreCompleto = getIntent().getStringExtra("nombre_completo");

        String nombreApellido = intent.getStringExtra("nombreApellido");
        String especialidad = intent.getStringExtra("especialidad");
        String hora = intent.getStringExtra("hora");

        // Configurar los textos
//        SpannableString spannable = new SpannableString("Nombre y Apellido:\n" + nombreCompleto);
//        spannable.setSpan(new StyleSpan(Typeface.BOLD), 0, 18, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        nombreApellidoTextView.setText(nombreCompleto);

//        SpannableString spannable1 = new SpannableString("Especialidad:\n " + especialidad);
//        spannable1.setSpan(new StyleSpan(Typeface.BOLD), 0, 13, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        especialidadTextView.setText(especialidad);
//
//        SpannableString spannable2 = new SpannableString("Hora:\n " + hora);
//        spannable2.setSpan(new StyleSpan(Typeface.BOLD), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        horaTextView.setText(hora);
//
        animateTitle(especialidadTextView);
        animateTitle(nombreApellidoTextView);
        animateTitle(horaTextView);
    }
}
