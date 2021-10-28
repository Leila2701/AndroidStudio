package ucv.andorid.g06_semana_07;

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


    public CalculadoraFragment() {
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