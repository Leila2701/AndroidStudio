package com.udemyandroid.semana_03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_Fc_Resultado extends AppCompatActivity {
    TextView textViewNombre,textEdad,textSexo,textTenperatura,textSaturacion,textMensaje,sintomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__fc__resultado);

        Bundle extras=getIntent().getExtras();
        String NombrePaciente=extras.getString("valorNombre");
        String EdadPaciente=extras.getString("valorEdad");
        String SexoPaciento=extras.getString("valorSexo");
        String CantidadTemperatura=extras.getString("valorCantTemperatura");
        String CantidadSaturacion=extras.getString("valorCantSaturacion");
        String InformePaciente=extras.getString("valorMensaje");
        String Sintomas=extras.getString("valorSintomas");

        textViewNombre=findViewById(R.id.fc_r_editText_Nombre);
        textEdad=findViewById(R.id.fc_r_editText_Edad);
        textSexo=findViewById(R.id.fc_r_editText_Sexo);
        textTenperatura=findViewById(R.id.fc_r_cant_tenperatura);
        textSaturacion=findViewById(R.id.fc_r_cant_saturacion);
        textMensaje=findViewById(R.id.fc_r_textView_Informe);
        sintomas=findViewById(R.id.fr_txt_sintomas);



        textViewNombre.setText(NombrePaciente);
        textEdad.setText(EdadPaciente);
        textSexo.setText(SexoPaciento);
        textTenperatura.setText(CantidadTemperatura);
        textSaturacion.setText(CantidadSaturacion);
        textMensaje.setText(InformePaciente);
        sintomas.setText(Sintomas);
    }
}