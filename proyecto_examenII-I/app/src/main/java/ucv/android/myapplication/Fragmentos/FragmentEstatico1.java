package ucv.android.myapplication.Fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ucv.android.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEstatico1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEstatico1 extends Fragment {

    public interface  Comunicador{
        public void enviar(String s);
    }

    Button btnEnviar;
    EditText textoEnviar;
    Comunicador miComunicador;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentEstatico1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEstatico1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEstatico1 newInstance(String param1, String param2) {
        FragmentEstatico1 fragment = new FragmentEstatico1();
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
        View v=inflater.inflate(R.layout.fragment_estatico1, container, false);
        textoEnviar=v.findViewById(R.id.edt_enviar);
        btnEnviar=v.findViewById(R.id.btn_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miComunicador.enviar(textoEnviar.getText().toString());
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        miComunicador = (Comunicador) context;
    }
}