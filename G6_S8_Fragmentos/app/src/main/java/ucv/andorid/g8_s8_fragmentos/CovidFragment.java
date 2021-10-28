package ucv.andorid.g8_s8_fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CovidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CovidFragment extends Fragment {
    TextView textView_temporatura,textView_saturacion,editTextNombre,editTextEdad, resultado;
    private Button btnprogresar;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CovidFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CovidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CovidFragment newInstance(String param1, String param2) {
        CovidFragment fragment = new CovidFragment();
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