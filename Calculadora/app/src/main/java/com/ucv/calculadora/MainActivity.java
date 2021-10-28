package com.ucv.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_multi;
    private Button btn_div;
    private TextView text_respuesta;
    private EditText edit_numero_uno;
    private EditText edit_numero_dos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_respuesta = findViewById(R.id.respuesta);
        edit_numero_uno = findViewById(R.id.numero1);
        edit_numero_dos = findViewById(R.id.numero2);

        btn_suma = findViewById(R.id.btn_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                text_respuesta.setText( suma (Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });

        btn_resta = findViewById(R.id.btn_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                text_respuesta.setText( resta (Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });

        btn_multi = findViewById(R.id.btn_multi);
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( multiplicacion (Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });

        btn_div = findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_respuesta.setText( division (Integer.parseInt(edit_numero_uno.getText().toString()),Integer.parseInt(edit_numero_dos.getText().toString()) )+"");
            }
        });
    }

    public int suma (int a, int b) {
        return a+b;
    }

    public int resta (int a, int b) {
        return a-b;
    }

    public int multiplicacion (int a, int b) {
        return a*b;
    }

    public double division (int a, int b) {
        int respuesta = 0;
        if (b!=0) {
            respuesta=a/b;
        }
        return respuesta;
    }

}