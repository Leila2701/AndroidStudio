package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    ArrayList<Usuario> lista =null;
    Usuario objUsuario;
    UsuarioDAO objUsuarioDAO;
    TextView txtiniusuario,txtinicontraseña;
    Button btningresar,btnregistrar;
    //private SharedPreferences preference;
    //private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtiniusuario=findViewById(R.id.txt_ini_usuario);
        txtinicontraseña=findViewById(R.id.txt_ini_contraseña);
        btningresar=findViewById(R.id.btnI_iniIngresar);
        btnregistrar=findViewById(R.id.btnloginRegistrar);
        objUsuarioDAO=new UsuarioDAO(this);
        objUsuarioDAO.open();


    }
     public void Ingresar (View v){


         //String users = preference.getString("USUARIO", "null");
         //String pass = preference.getString("CONTRA", "NULL");
         //if (preference.contains(users)) {
             Intent ingresar=new Intent(Login.this, Spinner.class);
             startActivity(ingresar);
         //} else {
           //  Toast.makeText(getApplicationContext(),"Logeo Incorrecto",Toast.LENGTH_LONG).show();
         //}
     }

    public void Registrar (View v) {
        Intent ingresar=new Intent(Login.this, MainActivity_Registrar.class);
        startActivity(ingresar);
    }
    public void ValidacionLogin(View v) {
        String n=txtiniusuario.getText().toString();
        String p=txtinicontraseña.getText().toString();
        if (n.equals("")&& p.equals("")){
            Toast.makeText(this,"error campos vacios",Toast.LENGTH_LONG).show();
        }else if(objUsuarioDAO.login(n,p)==1){
            Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
            Intent ingresar = new Intent(Login.this, Spinner.class);
            startActivity(ingresar);
        }
        else if(objUsuarioDAO.login(n,p)==0) {
            Toast.makeText(this,"Usuario y contraseña Incorrectos",Toast.LENGTH_LONG).show();
        }
    }
}