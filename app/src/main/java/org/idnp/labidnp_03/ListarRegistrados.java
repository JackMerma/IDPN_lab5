package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListarRegistrados extends AppCompatActivity {
    private ListView ListViewLista;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registrados);

        List<String> registrados = getIntent().getStringArrayListExtra("registrados");
        ListViewLista = findViewById(R.id.ListViewLista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, registrados);
        ListViewLista.setAdapter(adapter);

        Button buttonRegresarLista = findViewById(R.id.buttonRegresarLista);
        buttonRegresarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PostulanteRegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}