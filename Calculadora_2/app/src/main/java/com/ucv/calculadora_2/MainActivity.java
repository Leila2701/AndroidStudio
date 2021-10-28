package com.ucv.calculadora_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn_suma, btn_resta, btn_multiplicacion, btn_division,btn_limpiar;
    private EditText txt_num1,txt_num2;
    private TextView txt_resultado;
    int num1,num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botones
        btn_suma= findViewById(R.id.btnSuma);
        btn_resta=findViewById(R.id.btnResta);
        btn_multiplicacion=findViewById(R.id.btnMultiplicacion);
        btn_division=findViewById(R.id.btnDivision);
        btn_limpiar=findViewById(R.id.btn_limpiar);
        //Textos editables
        txt_num1=findViewById(R.id.editTextNumero1);
        txt_num2=findViewById(R.id.editTextNumero2);
        //Resultado
        txt_resultado=findViewById(R.id.textViewResultado);

    }
    public void onClickSuma (View v){
        num1=Integer.parseInt(txt_num1.getText().toString());
        num2=Integer.parseInt(txt_num2.getText().toString());
        txt_resultado.setText(suma(num1,num2)+" ");
    }
    public void onClickResta (View v){
        num1=Integer.parseInt(txt_num1.getText().toString());
        num2=Integer.parseInt(txt_num2.getText().toString());
        txt_resultado.setText(resta(num1,num2)+" ");
    }
    public void onClickMultiplicacion (View v){
        num1=Integer.parseInt(txt_num1.getText().toString());
        num2=Integer.parseInt(txt_num2.getText().toString());
        txt_resultado.setText(multiplicacion(num1,num2)+" ");
    }
    public void onClickDivision (View v){
        num1=Integer.parseInt(txt_num1.getText().toString());
        num2=Integer.parseInt(txt_num2.getText().toString());
        txt_resultado.setText(division(num1,num2)+" ");
    }
    public void onClickLimpiar(View v){
        txt_num1.setText(" ");
        txt_num2.setText(" ");
        txt_resultado.setText(" ");
    }
    

    //metodos
    public int suma (int a, int b){
        return a+b;
    }
    public int resta (int a, int b){
        return a-b;
    }
    public int multiplicacion (int a, int b){
        return a*b;
    }
    public int division (int a, int b){
        int respuesta = 0;
        if (b!=0) {
            respuesta=a/b;
        }
        return respuesta;
    }





}