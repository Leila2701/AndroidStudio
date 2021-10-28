package com.udemyandroid.semana_03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentsImplicito extends AppCompatActivity {
    private EditText Texto;
    private Button intentWebSearch,intentActionSend,intentIntel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intents_implicito);
        Texto=(EditText)findViewById(R.id.txtTexto);
        intentWebSearch=(Button)findViewById(R.id.btnSearchWeb);
        intentWebSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String texto=Texto.getText().toString();
                Intent intentWeb =new Intent(Intent.ACTION_WEB_SEARCH);
                intentWeb.putExtra(SearchManager.QUERY,texto);
                startActivity(intentWeb);

            }
        });
        intentActionSend=(Button)findViewById(R.id.btnActionSend);
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

        intentIntel=(Button)findViewById(R.id.btnIntel);
        intentIntel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyIntent1 = new Intent(Intent.ACTION_DIAL);
                startActivity(MyIntent1);

            }
        });

    }
}