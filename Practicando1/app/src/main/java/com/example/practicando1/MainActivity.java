package com.example.practicando1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String nombre;
    public Spinner spinner_opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_opciones=(Spinner) findViewById(R.id.spinnerOpciones);
    }
    public void procesarDatos(View v){
        int posicion=spinner_opciones.getSelectedItemPosition();
        if (posicion==0){
            Toast.makeText(getApplicationContext(),"Elija una opción por favor",Toast.LENGTH_SHORT).show();
        }
        else if(posicion==1){
           Intent intent = new Intent (v.getContext(), Calculadora.class);
            startActivityForResult(intent, 1);
        }else if(posicion==2){
            Intent intent =new Intent(v.getContext(),Formulario_Covid.class);
            startActivityForResult(intent,2);
        }
        else if(posicion==3){
            Intent intent =new Intent(v.getContext(),PracticaIntent.class);
            startActivityForResult(intent,3);
        }
        else {
            Intent intent=new Intent(v.getContext(), SharedPreferenciasCokies.class);
            startActivityForResult(intent,2);
        }


    }
}