package com.example.practicando1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticaIntent extends AppCompatActivity {
    private EditText Texto;
    private Button intentWebSearch,intentActionSend,intentScreenOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica_intent);

        Texto=(EditText)findViewById(R.id.txtTextoIntent);
        intentWebSearch=(Button)findViewById(R.id.btnIntenetSearchWeb);
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
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"oscarechegaraym@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "subject");
                email.putExtra(Intent.EXTRA_TEXT, ""+textO);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "oscarechegaraym@gmail.comt :"));
            }
        });
        intentScreenOn=(Button)findViewById(R.id.btnScreenOn);
        intentScreenOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

}