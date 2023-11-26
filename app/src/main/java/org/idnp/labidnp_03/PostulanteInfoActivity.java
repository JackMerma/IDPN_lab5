package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;
public class PostulanteInfoActivity extends AppCompatActivity {
    private ListView buscado;
    private EditText edtSearchDNI;
    private Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        // Recibe la lista "registrados" de la actividad anterior

        List<String> registrados = getIntent().getStringArrayListExtra("registrados");
        edtSearchDNI = findViewById(R.id.editTextBuscarDNI);
        buscado = findViewById(R.id.ViewBuscado);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtén el DNI ingresado por el usuario
                String dniToSearch = edtSearchDNI.getText().toString().trim();

                // Realiza la búsqueda del usuario en la lista "registrados"
                for (String userData : registrados) {
                    // Dividir los datos del usuario en DNI y otros campos (separados por coma)
                    String[] userDataArray = userData.split(",");
                    if (userDataArray.length >= 3 && userDataArray[0].equals(dniToSearch)) {
                        // Usuario encontrado, muestra sus datos
                        List<String> strings = new ArrayList<>();
                        strings.add(userData);
                        System.out.println(userData);
                        showUserData(new ArrayList<String>(strings));
                        return; // Sale del bucle al encontrar el usuario
                    }
                }
                // Si no se encuentra el usuario, muestra un mensaje
                showUserNotFoundMessage();
            }
        });
    }

    // Método para mostrar los datos del usuario encontrado
    private void showUserData(List<String> userData) {
        System.out.println(userData);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, userData);
        buscado.setAdapter(adapter);

    }

    // Método para mostrar un mensaje si el usuario no se encuentra
    private void showUserNotFoundMessage() {
        List<String> notFoundMessage = new ArrayList<>();
        notFoundMessage.add("Usuario no encontrado");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notFoundMessage);
        buscado.setAdapter(adapter);
    }
}
