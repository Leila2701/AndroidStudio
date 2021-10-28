package ucv.andorid.g06_semana_07;

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


public class ItentFragment extends Fragment {
    private EditText Texto;
    private Button intentWebSearch,intentActionSend,intentIntel;

    public ItentFragment() {
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