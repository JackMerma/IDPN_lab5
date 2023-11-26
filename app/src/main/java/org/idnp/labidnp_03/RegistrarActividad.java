package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegistrarActividad extends AppCompatActivity {
    TextView textViewConfirmacionRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_actividad);

        textViewConfirmacionRegistro = findViewById(R.id.textViewConfirmacionRegistro);
        String datos = getIntent().getStringExtra("datos");
        textViewConfirmacionRegistro.setText(datos);

        Button buttonRegresar = findViewById(R.id.buttonRegresar);
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
