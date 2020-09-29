package com.example.projectmomento1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import entidades.Usuario;

public class Activity_detalle_usuario extends AppCompatActivity {

    TextView campoId, campoNombre, campoTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        campoId = (TextView) findViewById(R.id.campoId);
        campoNombre = (TextView) findViewById(R.id.campoNombre);
        campoTelefono = (TextView) findViewById(R.id.campoTelefono);

        Bundle objetoEnviado=getIntent().getExtras();
        Usuario user=null;

        if(objetoEnviado!=null) {
            user = (Usuario) objetoEnviado.getSerializable("usuario");
            campoId.setText(user.getId().toString());
            campoNombre.setText(user.getNombre().toString());
            campoTelefono.setText(user.getTelefono().toString());
        }

    }
}