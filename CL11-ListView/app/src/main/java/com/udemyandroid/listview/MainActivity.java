package com.udemyandroid.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin;
    EditText editTextEmail, editTextPassowrd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin =findViewById(R.id.buttonLogin);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassowrd=findViewById(R.id.editTextPassword);

        //Asignacion del evento click

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //CheckBox checkBox =(CheckBox)v;
        // boolean seleccionado = checkBox.isChecked();
        Log.i("App","Click en login");

        String email= editTextEmail.getText().toString();
        String pass=editTextPassowrd.getText().toString();

        if (!email.isEmpty() && !pass.isEmpty()) {
            Intent intentLogin = new Intent(this, HomeActivity.class);
            intentLogin.putExtra("valorEmail",email);
            startActivity(intentLogin);
        }else{
            editTextEmail.setError("Complete el Email");
            editTextPassowrd.setError("Complete el Password");
        }
    }
}