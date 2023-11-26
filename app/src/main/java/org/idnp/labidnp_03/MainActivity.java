package org.idnp.labidnp_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtUsuario = findViewById(R.id.edtUsuario);
        EditText edtPassword = findViewById(R.id.edtPassword);
        TextView txtMensaje = findViewById(R.id.textView4);

        Button btnActivityMenu = findViewById(R.id.btnActivityMenu);
        btnActivityMenu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String usuario = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();

                if (usuario.equals("test") && password.equals("1234")){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                } else{
                    txtMensaje.setText("Autenticacion no valida");
                    Log.d(TAG, "invalido, " + usuario + "," + password);
                }
            }
        });

    }
}