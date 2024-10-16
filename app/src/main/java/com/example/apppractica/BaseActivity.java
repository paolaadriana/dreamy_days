package com.example.apppractica;

import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Método para aplicar la animación tipo "máquina de escribir" al título
    protected void animateTitle(final TextView textView) {
        final String fullText = textView.getText().toString(); // Obtener el texto del TextView
        final Handler handler = new Handler();
        final long delay = 100; // Retraso entre letras en milisegundos (puedes ajustar esto)
        final int length = fullText.length();
        final long[] index = {0};  // Usamos un array para modificar el índice dentro del Runnable

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Mostrar el texto progresivamente
                textView.setText(fullText.substring(0, (int)index[0] + 1));
                index[0]++;

                if (index[0] < length) {
                    // Repetir hasta que todas las letras se hayan mostrado
                    handler.postDelayed(this, delay);
                }
            }
        }, delay);
    }

    protected void animateTitle(final TextView textView, final SpannableString styledText) {
        final Handler handler = new Handler();
        final String fullText = styledText.toString(); // Obtener el texto del SpannableString
        final long delay = 100; // Retraso entre letras en milisegundos (ajusta si es necesario)
        final int length = fullText.length();
        final StringBuilder currentText = new StringBuilder(); // Usamos StringBuilder para construir el texto en tiempo real

        // Configura el texto inicial con estilo
        textView.setText(styledText);

        handler.postDelayed(new Runnable() {
            int index = 0; // Usamos un índice para controlar la parte del texto que se muestra

            @Override
            public void run() {
                // Mostrar el texto progresivamente
                currentText.append(fullText.charAt(index));
                textView.setText(currentText.toString()); // Actualiza el texto en el TextView

                index++;
                if (index < length) {
                    // Repetir hasta que todas las letras se hayan mostrado
                    handler.postDelayed(this, delay);
                }
            }
        }, delay);
    }



}
