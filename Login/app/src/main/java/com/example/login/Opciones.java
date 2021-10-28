package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Opciones extends AppCompatActivity {
    private TextView user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        user=(TextView)findViewById(R.id.txtUser);
        cargarDatos();
    }
    private void cargarDatos(){
        SharedPreferences cockie=getSharedPreferences("DatosUsuarios", Context.MODE_PRIVATE);
        String usuario=cockie.getString("user","No se registraron datos");
        user.setText("Bienvenido "+usuario);
    }

}