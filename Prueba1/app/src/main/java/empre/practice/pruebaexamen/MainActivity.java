package empre.practice.pruebaexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contra;
    Button btnCancelar, btnRegistro;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       final EditText usuario = (EditText) findViewById(R.id.txtUsuario);
       final EditText contra = (EditText) findViewById(R.id.txtContra);
       final Button btnRegistro = (Button) findViewById(R.id.btnRegistro);
       final TextView resultado = (TextView) findViewById (R.id.resultado);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usuario.getText().toString();
                String pass = contra.getText().toString();
                resultado.setText("Usuario: "+user+"\n"+"Contraseña: "+pass);

                SharedPreferences preferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("USUARIO",user);
                editor.putString("CONTRA",pass);
                editor.commit();
            }
        });
    }

    public void Cancelar (View v) {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setMessage("¿Estás seguro que quieres salir?");
        ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ingresar=new Intent(MainActivity.this,Login.class);
                startActivity(ingresar);
            }
        });

        ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad.show();
    }


}