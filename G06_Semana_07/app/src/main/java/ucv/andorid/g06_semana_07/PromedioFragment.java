package ucv.andorid.g06_semana_07;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PromedioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PromedioFragment extends Fragment {

    private Button btnCalcular;
    private TextView txtmensaje;
    private EditText txtpractica,txtinvestigacion,txtparcial, txtalumno;
    double num1,num2,num3;

    public PromedioFragment() {
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
        return inflater.inflate(R.layout.fragment_promedio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCalcular=view.findViewById(R.id.btnCalcular);
        txtmensaje=view.findViewById(R.id.txtMensaje);
        txtpractica=view.findViewById(R.id.txtPractica);
        txtinvestigacion=view.findViewById(R.id.txtInvestigacion);
        txtparcial=view.findViewById(R.id.txtParcial);
        txtalumno=view.findViewById(R.id.txtNombre);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Double.parseDouble(txtpractica.getText().toString());
                num2=Double.parseDouble(txtinvestigacion.getText().toString());
                num3=Double.parseDouble(txtparcial.getText().toString());
                String nom=txtalumno.getText().toString();
                double promedio=0.30*num1+ 0.40*num2+ 0.30*num3;

                String mensaje="";
                if(promedio>=10.5){
                    mensaje ="Aprobado";
                }else{
                    mensaje="Desaprobado";
                }
                txtmensaje.setText( nom+" esta "+mensaje+" con : "+String.valueOf(promedio));
            }
        });
    }
}