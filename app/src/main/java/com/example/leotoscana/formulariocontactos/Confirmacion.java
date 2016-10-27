package com.example.leotoscana.formulariocontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        //recepcion de datos del MainActivity
        Bundle parametros  = getIntent().getExtras();
        final String nombre      = parametros.getString("Nombre");
        final int[]  fecha       = parametros.getIntArray("Fecha");
        final String telefono    = parametros.getString("Telefono");
        final String email       = parametros.getString("Email");
        final String descripcion = parametros.getString("Descripcion");
        TextView nomb = (TextView) findViewById(R.id.nomb);
        TextView fech = (TextView) findViewById(R.id.fech);
        TextView tel  = (TextView) findViewById(R.id.tel);
        TextView em   = (TextView) findViewById(R.id.em);
        TextView desc = (TextView) findViewById(R.id.descr);
        nomb.setText(nombre);
        fech.setText(fecha[2]+"/"+fecha[1]+"/"+fecha[0]);
        tel .setText(telefono);
        em  .setText(email);
        desc.setText(descripcion);

        //intent para volver al primer activiti a editar los datos
        Button editar=(Button) findViewById(R.id.button2);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Confirmacion.this,MainActivity.class);
                intent.putExtra("NombreDos",nombre);
                intent.putExtra("FechaDos",fecha);
                intent.putExtra("TelefonoDos",telefono);
                intent.putExtra("EmailDos",email);
                intent.putExtra("DescripcionDos",descripcion);
                intent.putExtra("entra",true);
                startActivity(intent);
                finish();
            }
        });
    }

    //intent para volver al primer activity con el boton de atras
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent inte=new Intent(Confirmacion.this,MainActivity.class);
            startActivity(inte);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
