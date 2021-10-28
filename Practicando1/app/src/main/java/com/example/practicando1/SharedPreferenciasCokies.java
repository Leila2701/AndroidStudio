package com.example.practicando1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SharedPreferenciasCokies extends AppCompatActivity {
    private Button guardar,cargar;
    private TextView mostrarID,mostrarEdad;
    private EditText User,Edad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferencias_cokies);
        guardar=(Button)findViewById(R.id.btnGuardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCookie();
            }
        });

        cargar=(Button)findViewById(R.id.btnCargar);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento =new Intent(v.getContext(),ConsultasCockies.class);
                startActivity(intento);
            }
        });
        User=(EditText)findViewById(R.id.txtUsuario) ;
        Edad=(EditText)findViewById(R.id.txtEdad) ;
        mostrarID=(TextView)findViewById(R.id.txtVusuario);
        mostrarEdad=(TextView)findViewById(R.id.txtVedad);
        validar();

    }
    private void cargarCockie(){
        SharedPreferences cockie=getSharedPreferences("Datos",Context.MODE_PRIVATE);
        String User=cockie.getString("llaveUsuario","No hay datos");
        String Age=cockie.getString("llaveEdad","No hay datos");
        mostrarID.setText(User);
        mostrarEdad.setText(Age);

    }
    private void guardarCookie(){
        SharedPreferences cockie=getSharedPreferences("Datos", Context.MODE_PRIVATE);
        String user=User.getText().toString();
        String age=Edad.getText().toString();
        SharedPreferences.Editor editor=cockie.edit();
        editor.putString("llaveUsuario",user);
        editor.putString("llaveEdad",age);
        mostrarID.setText(user);
        mostrarEdad.setText(age);
        editor.commit();
    }
    private void validar(){
        SharedPreferences cockie=getSharedPreferences("Datos",Context.MODE_PRIVATE);
        int ageEntero=Integer.parseInt(cockie.getString("llaveEdad","0"));
        if(ageEntero<18){
            cargarCockie();
        }else{
            Intent intentWeb =new Intent(Intent.ACTION_WEB_SEARCH);
            intentWeb.putExtra(SearchManager.QUERY,"Bichota karol g");
            startActivity(intentWeb);
        }


    }

}