package com.udemyandroid.semana_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static com.udemyandroid.semana_03.R.id.myspinnerOP;
import static com.udemyandroid.semana_03.R.id.standard;
import static com.udemyandroid.semana_03.R.id.start;

public class MainActivity extends AppCompatActivity {
    public String nombre;
    private Spinner spinnerOP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerOP=(Spinner) findViewById(myspinnerOP);
        //realizar areglo para introducir en el spiner

     }
     public void MostrarView(View v){
         int posicion=spinnerOP.getSelectedItemPosition();

         if (posicion==0){
             Toast.makeText(getApplicationContext(),"Elija una opción por favor",Toast.LENGTH_SHORT).show();
         }
         else if(posicion==1){
             Intent intent = new Intent (v.getContext(),MainActivityCalculadora.class);
             startActivityForResult(intent, 1);
         }else if(posicion==2){
             Intent intent =new Intent(v.getContext(),Formulario_Covid.class);
             startActivityForResult(intent,2);
         }
         else if(posicion==3){
             Intent intent =new Intent(v.getContext(),IntentsImplicito.class);
             startActivityForResult(intent,3);
         }

         else if(posicion==4){
             Intent intent =new Intent(v.getContext(),PromedioNotas.class);
             startActivityForResult(intent,4);
         }

     }
     }






