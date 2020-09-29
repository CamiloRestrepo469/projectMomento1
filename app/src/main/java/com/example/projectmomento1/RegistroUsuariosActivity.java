package com.example.projectmomento1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;

import utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);


        campoId=(EditText) findViewById(R.id.campaId);
        campoNombre=(EditText) findViewById(R.id.campoNombre);
        campoTelefono=(EditText) findViewById(R.id.campoTelefono);

    }

    public void onClick(View view){
        registarUsuarios();
    }

    private void registarUsuarios() {
        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values=new ContentValues();

        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);


        campoTelefono.setText(" ");
        campoNombre.setText(" ");
        campoId.setText(" ");
        campoId.requestFocus();

        Intent miIntent=null;
        miIntent=new Intent(RegistroUsuariosActivity.this,ConsultarListaListViewActivity.class);
        startActivity(miIntent);

//        Intent intent=new Intent(RegistroUsuariosActivity.this,ConsultarListaListViewActivity.class);
//        Toast.makeText(getApplicationContext(),"id registro: "+idResultante,Toast.LENGTH_SHORT).show();

        db.close();

    }
}