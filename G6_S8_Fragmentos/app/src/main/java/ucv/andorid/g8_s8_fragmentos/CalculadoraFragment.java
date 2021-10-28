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
 * Use the {@link CalculadoraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculadoraFragment extends Fragment {
    private Button btn_suma, btn_resta, btn_multiplicacion, btn_division,btn_limpiar,btn_regresar;
    private EditText txt_num1,txt_num2;
    private TextView txt_resultado;
    int num1,num2;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculadoraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculadoraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculadoraFragment newInstance(String param1, String param2) {
        CalculadoraFragment fragment = new CalculadoraFragment();
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
        return inflater.inflate(R.layout.fragment_calculadora, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_suma= view.findViewById(R.id.btnSuma);
        btn_resta=view.findViewById(R.id.btnResta);
        btn_multiplicacion=view.findViewById(R.id.btnMultiplicacion);
        btn_division=view.findViewById(R.id.btnDivision);
        btn_limpiar=view.findViewById(R.id.btn_limpiar);
        //Textos editables
        txt_num1=view.findViewById(R.id.editTextNumero1);
        txt_num2=view.findViewById(R.id.editTextNumero2);
        //Resultado
        txt_resultado=view.findViewById(R.id.textViewResultado);

        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(txt_num1.getText().toString());
                num2=Integer.parseInt(txt_num2.getText().toString());
                txt_resultado.setText(suma(num1,num2)+" ");
            }
        });
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(txt_num1.getText().toString());
                num2=Integer.parseInt(txt_num2.getText().toString());
                txt_resultado.setText(resta(num1,num2)+" ");
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(txt_num1.getText().toString());
                num2=Integer.parseInt(txt_num2.getText().toString());
                txt_resultado.setText(division(num1,num2)+" ");
            }
        });
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1=Integer.parseInt(txt_num1.getText().toString());
                num2=Integer.parseInt(txt_num2.getText().toString());
                txt_resultado.setText(multiplicacion(num1,num2)+" ");
            }
        });
        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_num1.setText(" ");
                txt_num2.setText(" ");
                txt_resultado.setText(" ");
            }
        });


    }
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