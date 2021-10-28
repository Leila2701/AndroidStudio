package ucv.andorid.g06_semana_07;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class CovidFragment extends Fragment {
    TextView textView_temporatura,textView_saturacion,editTextNombre,editTextEdad, resultado;
    private Button btnprogresar;

    public CovidFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextNombre=view.findViewById(R.id.fc_editTextText_Nombre);
        editTextEdad=view.findViewById(R.id.fc_editTextText_Edad);
        textView_temporatura=view.findViewById(R.id.txtTemperatura);
        textView_saturacion=view.findViewById(R.id.txtSaturacion);
        resultado=view.findViewById(R.id.txtResultado);
        btnprogresar=view.findViewById(R.id.fc_button_procesar);

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