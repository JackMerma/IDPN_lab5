package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnNuevo = findViewById(R.id.buttonNuevo);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startActivity(intent);
            }
        });

        Button btnInfoPostulante = findViewById(R.id.buttonInfoPostulante);

        btnInfoPostulante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), PostulanteInfoActivity.class);
                startActivity(intent2);
            }
        });
    }
}