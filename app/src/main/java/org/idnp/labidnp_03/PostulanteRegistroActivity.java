package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PostulanteRegistroActivity extends AppCompatActivity {
    private EditText editTextDni, editTextApellidos, editTextNombres, editTextColegio, editTextCarrera;
    private TextView textViewDate;
    private Button buttonLista, buttonRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);

        editTextDni = findViewById(R.id.editTextDni);
        editTextApellidos = findViewById(R.id.editTextApellidos);
        editTextNombres = findViewById(R.id.editTextNombres);
        editTextColegio = findViewById(R.id.editTextColegio);
        editTextCarrera = findViewById(R.id.editTextCarrera);
        textViewDate = findViewById(R.id.textViewDate);
        buttonLista = findViewById(R.id.buttonLista);
        buttonRegistrar = findViewById(R.id.buttonRegistrar);

        List<String> registrados = new ArrayList<>();

        textViewDate.setOnClickListener(view -> {
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            int mes = calendario.get(Calendar.MONTH);
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    (view1, year, monthOfYear, dayOfMonth) ->
                            textViewDate.setText(String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year)),
                    anio, mes, dia);

            datePickerDialog.show();
        });

        buttonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextNombres.getText().toString().equals("")){
                    Toast.makeText(PostulanteRegistroActivity.this, "Agrega texto", Toast.LENGTH_LONG);
                }
                else if(editTextApellidos.getText().toString().equals("")){
                    Toast.makeText(PostulanteRegistroActivity.this, "Agrega texto", Toast.LENGTH_LONG);
                }
                else {
                    Intent intent = new Intent(PostulanteRegistroActivity.this, RegistrarActividad.class);
                    String datos = "DNI: " + editTextDni.getText().toString()+ "\n"
                            + "Apellidos: " + editTextApellidos.getText().toString()+ "\n"
                            + "Nombres: " + editTextNombres.getText().toString()+ "\n"
                            + "Fecha: " + textViewDate.getText().toString()+ "\n"
                            + "Colegio: " + editTextColegio.getText().toString()+ "\n"
                            + "Carrera: " + editTextCarrera.getText().toString()+ "\n";

                    intent.putExtra("datos",datos);
                    registrados.add(datos);
                    startActivity(intent);
                }
            }
        });

        buttonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostulanteRegistroActivity.this, ListarRegistrados.class);
                intent.putStringArrayListExtra("registrados", (ArrayList<String>) registrados);
                startActivity(intent);
            }
        });

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        // Borra los campos de texto
        editTextDni.setText("");
        editTextApellidos.setText("");
        editTextNombres.setText("");
        textViewDate.setText("dd/mm/aaaa");
        editTextColegio.setText("");
        editTextCarrera.setText("");
    }
}