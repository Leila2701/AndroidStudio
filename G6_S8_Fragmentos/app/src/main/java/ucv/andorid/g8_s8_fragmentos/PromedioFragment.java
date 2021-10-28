package ucv.andorid.g8_s8_fragmentos;

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PromedioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PromedioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PromedioFragment newInstance(String param1, String param2) {
        PromedioFragment fragment = new PromedioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
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