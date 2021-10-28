package ucv.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_Registrar extends AppCompatActivity implements  View.OnClickListener {

    ArrayList<Usuario> lista =null;
    Usuario objUsuario;
    UsuarioDAO objUsuarioDAO;
    EditText txtusuario,txtcontraseña;
    Button btnregistrar,btncancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusuario=findViewById(R.id.txtUsuario);
        txtcontraseña=findViewById(R.id.txtContraseña);
        btnregistrar=findViewById(R.id.btn_Registrar);
        btncancelar=findViewById(R.id.btnCancelar);
        btnregistrar.setOnClickListener(this);

        objUsuarioDAO=new UsuarioDAO(this);
        objUsuarioDAO.open();

    }
    public void Grabar(){
        String nombre=txtusuario.getText().toString();
        String clave=txtcontraseña.getText().toString();

        long estado=objUsuarioDAO.insertar(nombre,clave);
        if(estado==0){

            Toast.makeText(getApplicationContext(), "No se registro",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(getApplicationContext(), "Se registro correctamente",Toast.LENGTH_LONG).show();
        }
        LimpiarCampos();

    }

    public void registrar(View v){
        String user = txtusuario.getText().toString();
        String pass = txtcontraseña.getText().toString();


    }
    public void LimpiarCampos(){
        txtusuario.setText("");
        txtcontraseña.setText("");
        txtusuario.requestFocus();
    }
    public void Cancelar (View v) {
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setMessage("¿Estás seguro que quieres salir?");
        ad.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent ingresar=new Intent(MainActivity_Registrar.this,Login.class);
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

    @Override
    public void onClick(View v) {
        if(v==btnregistrar){
            Grabar();
        }
    }
}