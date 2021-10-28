package com.udemyandroid.semana_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class PromedioNotas extends AppCompatActivity {
    private Button btnCalcular;
    private TextView txtmensaje;
    private EditText txtpractica,txtinvestigacion,txtparcial, txtalumno;
    double num1,num2,num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_notas);

        btnCalcular=findViewById(R.id.btnCalcular);
        txtmensaje=findViewById(R.id.txtMensaje);
        txtpractica=findViewById(R.id.txtPractica);
        txtinvestigacion=findViewById(R.id.txtInvestigacion);
        txtparcial=findViewById(R.id.txtParcial);
        txtalumno=findViewById(R.id.txtNombre);

    }

    public void onClickPromedio(View v){
        num1=Double.parseDouble(txtpractica.getText().toString());
        num2=Double.parseDouble(txtinvestigacion.getText().toString());
        num3=Double.parseDouble(txtparcial.getText().toString());
        String nom=txtalumno.getText().toString();
        double promedio=0.30*num1+ 0.40*num2+ 0.30*num3;

        SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("user",nom);
        editor.putString("promedio_nota",String.valueOf(promedio));
        editor.commit();

        String mensaje="";
        if(promedio>=10.5){
            mensaje ="Aprobado";
        }else{
            mensaje="Desaprobado";
        }

        txtmensaje.setText( nom+" esta "+mensaje+" con : "+String.valueOf(promedio));


        Snackbar.make(v,txtalumno+" esta "+mensaje+" con : "+promedio,Snackbar.LENGTH_LONG).show();



    }

}