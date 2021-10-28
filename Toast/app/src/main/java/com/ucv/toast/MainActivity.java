package com.ucv.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View layout;
    LayoutInflater inflater;
    EditText txtUsuario, txtClave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //cajaClave();
        //Toast.makeText(getApplicationContext(), "Hola Mundo", Toast.LENGTH_SHORT).show();
/*
        //IMAGEN Y CENTRAR EN EL TOAST
        Toast myObj=Toast.makeText(getApplicationContext(), "Hola UCV", Toast.LENGTH_LONG);
        myObj.setGravity(Gravity.CENTER,0,0);
        LinearLayout myView=(LinearLayout)myObj.getView();

        ImageView imagen=new ImageView(getApplicationContext());
        imagen.setImageResource(R.drawable.ic_launcher_foreground);
        myView.addView(imagen,0);

        myObj.show();*/

/*      //TEXTO SE AJUSTA A DIALOG
        Dialog myBox=new Dialog(this);
        myBox.setTitle("Caja de Dialogo Simple");

        TextView myDescription= new TextView(this);
        myDescription.setText("\n\n\t\t Descripcion");

        myBox.setContentView(myDescription);
        myBox.show();

*/
/*      //ALERTA DE MENSAJE
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("titulo");
        ad.setMessage("Mensaje");
        ad.setPositiveButton("Cerrar",null);
        ad.show();
*/
/*
        //ALERTA CON ITEM
        final String items[]={"opcion1","opcion2","Opcion3"};
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("titulo");
        ad.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),""+items[which],Toast.LENGTH_LONG).show();
            }
        });
        ad.show();
*/

/*     //MENSAJE DE CONFIRMACION Y CANCELARON
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Confirmacion ");
        ad.setMessage("¿Confirma la acción seleccionada?");
        ad.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Accion Ejecutada",Toast.LENGTH_LONG).show();
            }
        });

        ad.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        ad.show();
*/

/*      //MENSAJE CON CHECKBOX
        final String items[]={"opcion1","opcion2","Opcion3"};
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Seleccion ");
        ad.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getApplicationContext()," "+items[which],Toast.LENGTH_LONG).show();
            }
        });
        ad.show();
     */

/*      //MENSAJE CON RADIO BUTOON
        final String items[]={"opcion1","opcion2","Opcion3"};
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Seleccion ");
        ad.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext()," "+items[which],Toast.LENGTH_LONG).show();
            }
        });
        ad.show();

*/

    }
    /*
    public void  cajaClave(){
        inflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout=inflater.inflate(R.layout.activity_main,(ViewGroup)findViewById(R.id.root));
        //View layout =inflater.inflate(R.layout.password_dialog,(ViewGroup) findViewById(R.id.root));
        txtUsuario=(EditText)layout.findViewById(R.id.txtU);
        txtClave=(EditText)layout.findViewById(R.id.txtC);

        AlertDialog.Builder ad= new AlertDialog.Builder(this);
        ad.setTitle("Ventana de Acceso");
        ad.setView(layout);
        ad.setPositiveButton("entrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String usuario=txtUsuario.getText().toString();
                String clave=txtClave.getText().toString();
                if(usuario.equalsIgnoreCase("yamil")&& clave.equalsIgnoreCase("123")){
                    Toast.makeText(getApplicationContext(),"Entro al sistema",Toast.LENGTH_LONG).show();
                }
            }
        });

        ad.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        ad.show();

    }*/
}