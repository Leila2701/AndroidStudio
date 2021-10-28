package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Formulario_Covid extends AppCompatActivity {
    TextView textView_temporatura,textView_saturacion,editTextNombre,editTextEdad, resultado;
    private Button btnprogresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__covid);
        editTextNombre=findViewById(R.id.fc_editTextText_Nombre);
        editTextEdad=findViewById(R.id.fc_editTextText_Edad);
        textView_temporatura=findViewById(R.id.txtTemperatura);
        textView_saturacion=findViewById(R.id.txtSaturacion);
        resultado=findViewById(R.id.txtResultado);
        btnprogresar=findViewById(R.id.fc_button_procesar);
        btnprogresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre= editTextNombre.getText().toString();
                int temperatura= Integer.valueOf(textView_temporatura.getText().toString());
                int saturacion=Integer.valueOf(textView_saturacion.getText().toString());
                int ed=Integer.valueOf(editTextEdad.getText().toString());
                String mes=" ";
                if(ed>60 && temperatura>=37 &&  saturacion <=94){
                    mes="usted necesita hospitalización";
                }

                else if(ed<60 && temperatura>=37 && saturacion <=92){
                    mes= "usted necesita hospitalización";
                }
                else {
                    mes="usted debe realizar un tratamiento en casa";
                }
                resultado.setText(nombre+" " + mes);
            }
        });
    }
}