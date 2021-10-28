package ucv.andorid.g8_s8_fragmentos;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItentFragment extends Fragment {
    private EditText Texto;
    private Button intentWebSearch,intentActionSend,intentIntel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItentFragment newInstance(String param1, String param2) {
        ItentFragment fragment = new ItentFragment();
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
        return inflater.inflate(R.layout.fragment_itent, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Texto=view.findViewById(R.id.txtTexto);
        intentWebSearch=view.findViewById(R.id.btnSearchWeb);
        intentWebSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String texto=Texto.getText().toString();
                Intent intentWeb =new Intent(Intent.ACTION_WEB_SEARCH);
                intentWeb.putExtra(SearchManager.QUERY,texto);
                startActivity(intentWeb);

            }
        });
        intentActionSend=view.findViewById(R.id.btnActionSend);
        intentActionSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textO=Texto.getText().toString();
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"leilacordova6@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, ""+textO);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "leilacordova6@gmail.comt :"));
            }
        });

        intentIntel=view.findViewById(R.id.btnIntel);
        intentIntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent1 = new Intent(Intent.ACTION_DIAL);
                startActivity(MyIntent1);

            }
        });
    }
}