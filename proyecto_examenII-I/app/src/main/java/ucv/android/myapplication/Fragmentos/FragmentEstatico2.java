package ucv.android.myapplication.Fragmentos;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ucv.android.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentEstatico2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentEstatico2 extends Fragment implements View.OnClickListener{
    private Button button1,button2;
    private View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentEstatico2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentEstatico2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentEstatico2 newInstance(String param1, String param2) {
        FragmentEstatico2 fragment = new FragmentEstatico2();
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
        view= inflater.inflate(R.layout.fragment_estatico2, container, false);
        button1=(Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2=(Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(this);
        return view;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Toast.makeText(getActivity(),"presionaste el boton del centro",Toast.LENGTH_LONG).show();
                view.setBackgroundColor(Color.parseColor("#ffc622BB"));
                break;
            case R.id.button2:
                Toast.makeText(getActivity(),"presionaste el boton del inferior",Toast.LENGTH_LONG).show();
                view.setBackgroundColor(Color.parseColor("#ffDDE238"));
                break;
        }
    }
}