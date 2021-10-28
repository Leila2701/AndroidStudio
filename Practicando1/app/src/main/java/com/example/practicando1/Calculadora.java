package com.example.practicando1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity{
     EditText resultado;
     EditText num1;
     EditText num2;
     Button suma;
     Button resta;
     Button multiplicacion;

     Button division;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        resultado=(EditText) findViewById(R.id.txtResultado);
        num1=(EditText)findViewById(R.id.txtPrimerNumero);
        num2=(EditText)findViewById(R.id.txtSegundoNumero);
        suma=(Button)findViewById(R.id.btnSuma);
        resultado.setText("uwu");

        suma.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auxnum1=Integer.parseInt(num1.getText().toString());
                int auxnum2=Integer.parseInt(num2.getText().toString());
                resultado.setText(Sumatoria(auxnum1,auxnum2)+"");
                Toast.makeText(getApplicationContext(),"Amgel chupapinga",Toast.LENGTH_SHORT).show();
            }
        });

        division=(Button) findViewById(R.id.btnDivision);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auxnum1=Integer.parseInt(num1.getText().toString());
                int auxnum2=Integer.parseInt(num2.getText().toString());
                resultado.setText(Division(auxnum1,auxnum2)+"");}
        });
        resta=(Button)findViewById(R.id.btnResta) ;
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auxnum1=Integer.parseInt(num1.getText().toString());
                int auxnum2=Integer.parseInt(num2.getText().toString());
                resultado.setText(Resta(auxnum1,auxnum2)+"");
            }
        });
        multiplicacion=(Button)findViewById(R.id.btnMultiplicacion);
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int auxnum1=Integer.parseInt(num1.getText().toString());
                int auxnum2=Integer.parseInt(num2.getText().toString());
                resultado.setText(Multiplicacion(auxnum1,auxnum2)+"");
            }
        });
    }

    public int Sumatoria(int a,int b){
        return a+b;
    }
    public double Resta(double a,double b){
        return a-b;
    }
    public int Multiplicacion(int a,int b){
        return a*b;
    }
    public int Division(int a ,int b){
        return a/b;
    }
}