package com.example.projectmomento1;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
    }
    public void onClick(View view){

        Intent miIntent=null;
        switch (view.getId()){
            case R.id.btnOpcionRegistrar:
                miIntent=new Intent(MainActivity.this,RegistroUsuariosActivity.class);
                break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }

    }
    public void onClick2(View view){

        Intent miIntent=null;
                miIntent=new Intent(MainActivity.this,ConsultarListaListViewActivity.class);
            startActivity(miIntent);
        }

}