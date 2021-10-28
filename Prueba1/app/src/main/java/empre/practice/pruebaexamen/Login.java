package empre.practice.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText txtusuario, txtcontra;
    Button ingresar;
    private SharedPreferences preference;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText txtusuario = (EditText) findViewById(R.id.txtUsuario2);
        EditText txtcontraseña = (EditText) findViewById(R.id.txtContra2);
        Button ingresar = (Button) findViewById (R.id.btnIngresar);

        ingresar.setOnClickListener(view -> {
            /*String usuario = txtusuario.getText().toString();
            String contraseña = txtcontraseña.getText().toString();
            preference = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
            editor = preference.edit();
            iniciarsesion(usuario,contraseña);*/
            Intent ingresar1=new Intent(Login.this, Spin.class);
            startActivity(ingresar1);
        } );
    }

    private void iniciarsesion(String usuario, String contraseña) {
        String users = preference.getString("USUARIO", "null");
        String pass = preference.getString("CONTRA", "NULL");
        if (preference.contains(users)) {
            Intent ingresar=new Intent(Login.this, Spin.class);
            startActivity(ingresar);
        } else {
            Toast.makeText(getApplicationContext(),"Logeo Incorrecto",Toast.LENGTH_LONG).show();
        }



    }

}