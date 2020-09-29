package com.example.projectmomento1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import entidades.Usuario;
import utilidades.Utilidades;

public class ConsultarListaListViewActivity extends AppCompatActivity {

    ListView listViewPersonas;

    ArrayList<String > listaInformacion;
    ArrayList<Usuario> listaUsuarios;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_lista_list_view);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        listViewPersonas=(ListView) findViewById(R.id.listVewPersonas);

        consultarListaPersonas();

        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewPersonas.setAdapter(adaptador);

        listViewPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {

                String informacion="id:  = "+listaUsuarios.get(pos).getId()+"\n";
                informacion+="Nombre: = "+listaUsuarios.get(pos).getNombre()+"\n";
                informacion+="Nota: = "+listaUsuarios.get(pos).getTelefono()+"\n";

//                Toast.makeText(getApplicationContext(),informacion,Toast.LENGTH_SHORT).show();

                Usuario user=listaUsuarios.get(pos);

                Intent intent=new Intent(ConsultarListaListViewActivity.this,Activity_detalle_usuario.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("usuario",user);

                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

    }

    private void consultarListaPersonas() {

        SQLiteDatabase db=conn.getReadableDatabase();
        Usuario usuario=null;
        listaUsuarios=new ArrayList<Usuario>();

        //Select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario= new  Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuarios.add(usuario);

        }

        obtenerLista();

    }

    private void obtenerLista() {

        listaInformacion=new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size();i++){
            listaInformacion.add("id := "+listaUsuarios.get(i).getId()+"\n"+
                    "   Nombre :"+listaUsuarios.get(i).getNombre()+"\n"+
                    "   Nota :"+listaUsuarios.get(i).getTelefono()+"\n");
        }
    }
}