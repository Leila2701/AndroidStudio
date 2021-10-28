package com.example.practicando1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class Formulario_Covid extends AppCompatActivity {
    private EditText nombre,edad;
    private RadioButton sexoMasculino,SexoFemenino;
    private CheckBox tos,estornudo,dolor_garganta,fiebre,dolor_cabeza;
    private SeekBar temperatura,saturacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__covid);

        nombre=(EditText)findViewById(R.id.txtNombre);
        edad=(EditText)findViewById(R.id.txtEdad);
        sexoMasculino=(RadioButton)findViewById(R.id.rbMasculino);
        SexoFemenino=(RadioButton)findViewById(R.id.rbfemenino);
        tos=(CheckBox)findViewById(R.id.cbTos);
        dolor_garganta=(CheckBox)findViewById(R.id.cbDolorGarganta);
        fiebre=(CheckBox)findViewById(R.id.cbFiebre);
        dolor_cabeza=(CheckBox)findViewById(R.id.cbDolorCabeza);
        temperatura=(SeekBar)findViewById(R.id.sbTemperatura);
        saturacion=(SeekBar)findViewById(R.id.sbSaturacion);

        
    }

}