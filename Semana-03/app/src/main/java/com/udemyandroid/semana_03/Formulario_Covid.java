package com.udemyandroid.semana_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.udemyandroid.semana_03.R.id.fc_textView_cantidad_saturacion;
import static com.udemyandroid.semana_03.R.id.fc_textView_cantidad_temporatura;
import static com.udemyandroid.semana_03.R.id.start;


public class Formulario_Covid extends AppCompatActivity {
    TextView textView_temporatura,textView_saturacion,editTextNombre,editTextEdad, etiqueta;
    private ProgressBar progressBar_temperatura;
    private SeekBar seekBar_temperatura,seekBar_saturacion;
    private Spinner SP_opiones_sexo;
    private CheckBox op1,op2,op3,op4,op5;
    private String cad1="",cad2="",cad3="",cad4="",cad5="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__covid);


        editTextNombre=(TextView)findViewById(R.id.fc_editTextText_Nombre);
        editTextEdad=(TextView)findViewById(R.id.fc_editTextText_Edad);
        textView_temporatura=(TextView)findViewById(R.id.fc_textView_cantidad_temporatura);
        textView_saturacion=(TextView)findViewById(fc_textView_cantidad_saturacion);
        progressBar_temperatura=(ProgressBar)findViewById(R.id.fc_seekBar_temperatura);
        seekBar_temperatura=(SeekBar)findViewById(R.id.fc_seekBar_temperatura);
        seekBar_saturacion=(SeekBar)findViewById(R.id.fc_seekBar_saturacion);
        SP_opiones_sexo=(Spinner)findViewById(R.id.fc_spinner_sexo);

        etiqueta=findViewById(R.id.fc_salida);
        op1=findViewById(R.id.checkBoxOp01);
        op2=findViewById(R.id.checkBoxOp02);
        op3=findViewById(R.id.checkBoxOp03);
        op4=findViewById(R.id.checkBoxOp04);
        op5=findViewById(R.id.checkBoxOp05);


        seekBar_temperatura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                textView_temporatura.setText(""+i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBar_saturacion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView_saturacion.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        }
        public void Op1(View vista){
            if(op1.isChecked()==true)
                cad1="Fiebre ";
            else
                cad1=" ";
            etiqueta.setText(cad1+cad2+cad3+cad4+cad5);
        }
        public void Op2(View vista){
            if(op2.isChecked()==true)
                cad2="Perdida Olfato/Gusto ";
            else
                cad2=" ";
            etiqueta.setText(cad1+cad2+cad3+cad4+cad5);
        }
        public void Op3(View vista){
            if(op3.isChecked()==true)
                cad3="Tos Seca ";
            else
                cad3=" ";
            etiqueta.setText(cad1+cad2+cad3+cad4+cad5);
        }
        public void Op4(View vista){
            if(op4.isChecked()==true)
                cad4="Molestias y Dolores ";
            else
                cad4=" ";
            etiqueta.setText(cad1+cad2+cad3+cad4+cad5);
        }
        public void Op5(View vista){
            if(op5.isChecked()==true)
                cad5="Diificultad al Respirar ";
            else
                cad5=" ";
            etiqueta.setText(cad1+cad2+cad3+cad4+cad5);
        }

    public void MostrarResultado(View v){
             String nombre= editTextNombre.getText().toString();
             String edad=editTextEdad.getText().toString();
             String sexo=SP_opiones_sexo.getSelectedItem().toString();
             String tem= textView_temporatura.getText().toString();
             String satu= textView_saturacion.getText().toString();
             String sin=etiqueta.getText().toString();

            int temperatura= Integer.valueOf(textView_temporatura.getText().toString());
            int saturacion=Integer.valueOf(textView_saturacion.getText().toString());
            int ed=Integer.valueOf(editTextEdad.getText().toString());

            if(ed>60 &&   temperatura>=37 &&  saturacion <=94){
                String mes=nombre+" "+  "usted necesita hospitalización";
                Intent view_FC_resultado=new Intent(this,MainActivity_Fc_Resultado.class);
                view_FC_resultado.putExtra("valorNombre",nombre);
                view_FC_resultado.putExtra("valorEdad",edad);
                view_FC_resultado.putExtra("valorSexo",sexo);
                view_FC_resultado.putExtra("valorCantTemperatura",tem);
                view_FC_resultado.putExtra("valorCantSaturacion",satu);
                view_FC_resultado.putExtra("valorMensaje",mes);
                view_FC_resultado.putExtra("valorSintomas",sin);
                startActivity(view_FC_resultado);
            }

            else if(ed<60 && temperatura>=37 && saturacion <=92){
                String mes= nombre+" "+  "usted necesita hospitalización";
                Intent view_FC_resultado=new Intent(this,MainActivity_Fc_Resultado.class);
                view_FC_resultado.putExtra("valorNombre",nombre);
                view_FC_resultado.putExtra("valorEdad",edad);
                view_FC_resultado.putExtra("valorSexo",sexo);
                view_FC_resultado.putExtra("valorCantTemperatura",tem);
                view_FC_resultado.putExtra("valorCantSaturacion",satu);
                view_FC_resultado.putExtra("valorMensaje",mes);
                view_FC_resultado.putExtra("valorSintomas",sin);
                startActivity(view_FC_resultado);
            }
            else {
                String mes=nombre+" "+  "usted debe realizar un tratamiento en casa";
                Intent view_FC_resultado=new Intent(this,MainActivity_Fc_Resultado.class);
                view_FC_resultado.putExtra("valorNombre",nombre);
                view_FC_resultado.putExtra("valorEdad",edad);
                view_FC_resultado.putExtra("valorSexo",sexo);
                view_FC_resultado.putExtra("valorCantTemperatura",tem);
                view_FC_resultado.putExtra("valorCantSaturacion",satu);
                view_FC_resultado.putExtra("valorMensaje",mes);
                view_FC_resultado.putExtra("valorSintomas",sin);
                startActivity(view_FC_resultado);
            }



    }

}