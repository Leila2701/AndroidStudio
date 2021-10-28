package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user,pass;
    private Button ingresar;
    private CheckBox recordar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.txtUser);
        pass=(EditText)findViewById(R.id.txtPassword);
        ingresar=(Button)findViewById(R.id.btnIngresar);
        recordar=(CheckBox)findViewById(R.id.cbRecordar) ;
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario=user.getText().toString();
                String contrasena=pass.getText().toString();
                if(!usuario.equals("")){
                    if(!contrasena.equals("")) {
                        if(recordar.isChecked()==true){
                            guardarDatos();
                        }Intent intent=new Intent(v.getContext(),Opciones.class);
                        startActivityForResult(intent,0);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Debe llenar el espacio Contraseña",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Debe llenar el espacio Usuario",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
    private void guardarDatos(){
        SharedPreferences cockie=getSharedPreferences("DatosUsuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor editar=cockie.edit();
        String usuario=user.getText().toString();
        String contraseña=pass.getText().toString();
        editar.putString("user",usuario);
        editar.putString("password",contraseña);
        editar.commit();
    }
    private void cargarDatos(){
        SharedPreferences cockie=getSharedPreferences("DatosUsuarios", Context.MODE_PRIVATE);
        String usuario=cockie.getString("user","No se registraron datos");
        String contraseña=cockie.getString("password","No se registró datos");
        user.setText(usuario);
        pass.setText(contraseña);
    }

}
