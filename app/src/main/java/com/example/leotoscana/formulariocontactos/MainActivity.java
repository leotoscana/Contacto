package com.example.leotoscana.formulariocontactos;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.annotation.IdRes;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.support.v4.app.DialogFragment;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button            siguiente;
    TextInputEditText nombre;
    DatePicker        fecha;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declaracion de views
        siguiente   = (Button)            findViewById(R.id.button);
        nombre      = (TextInputEditText) findViewById(R.id.nombre);
        fecha       = (DatePicker)        findViewById(R.id.fecha);
        telefono    = (TextInputEditText) findViewById(R.id.telefono);
        email       = (TextInputEditText) findViewById(R.id.email);
        descripcion = (TextInputEditText) findViewById(R.id.descripcion);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent para cambiar de activity con el boton siguiente y envio de datos
                Intent intent=new Intent(MainActivity.this,Confirmacion.class);
                int[] fechas= new int[3];
                fechas[0]   = fecha.getYear();
                fechas[1]   = fecha.getMonth()+1;
                fechas[2]   = fecha.getDayOfMonth();
                intent.putExtra("Nombre",     nombre.getText().toString());
                intent.putExtra("Fecha",      fechas);
                intent.putExtra("Telefono",   telefono.getText().toString());
                intent.putExtra("Email",      email.getText().toString());
                intent.putExtra("Descripcion",descripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        if (getIntent().getBooleanExtra("entra",false)){
            //parametros a recibir cuando se apreta el boton de editar
            Bundle param = getIntent().getExtras();
            String nombreDos      = param.getString("NombreDos");
            int [] fechaDos       = param.getIntArray("FechaDos");
            String telefonoDos    = param.getString("TelefonoDos");
            String emailDos       = param.getString("EmailDos");
            String descripcionDos = param.getString("DescripcionDos");
            nombre.setText(nombreDos);
            fecha.updateDate(fechaDos[0],(fechaDos[1]-1),fechaDos[2]);
            telefono.setText(telefonoDos);
            email.setText(emailDos);
            descripcion.setText(descripcionDos);
        }


    }

}
