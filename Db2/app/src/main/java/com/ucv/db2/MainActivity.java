package com.ucv.db2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String nombre;

    ArrayList<Persona> lista =null;
    Persona objPersona;
    PersonaDAO objPersonaDAO;
    EditText txtNombre, txtApellido, txtDni, txtResultado;
    Button btnGrabar, btnListar,btnModificar,btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre=(EditText)findViewById(R.id.txtNombre);
        txtApellido=(EditText)findViewById(R.id.txtApellidio);
        txtDni=(EditText)findViewById(R.id.txtDni);
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        btnGrabar=(Button)findViewById(R.id.btnGrabar);
        btnListar=(Button)findViewById(R.id.btnListar);
        btnModificar=(Button)findViewById(R.id.btnModificar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnGrabar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        objPersonaDAO= new PersonaDAO(this);
        objPersonaDAO.open();
    }
    public void Grabar(){
        String nombre=txtNombre.getText().toString();
        String apellido=txtApellido.getText().toString();
        String dni=txtDni.getText().toString();
        long estado=objPersonaDAO.insertar(nombre,apellido, dni);
        if(estado==0){
            Toast.makeText(getApplicationContext(), "no se inserto",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "se inserto",Toast.LENGTH_LONG).show();
        }
        LimpiarCampos();

    }

    public void LimpiarCampos(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtNombre.requestFocus();
    }
    public void Listar(){
        String acum="";
        lista=objPersonaDAO.ListadoGeneral();
        for(Persona obj:lista){
            acum=acum+" "+obj.getNombre()+"  "+obj.getApellido()+"  "+obj.getDni()+" \n";
        }
        txtResultado.setText(acum);
    }
    public void Modificar(View v){
        String nombre=txtNombre.getText().toString();
        String apellido=txtApellido.getText().toString();
        String dni=txtDni.getText().toString();
        long estado=objPersonaDAO.modificarRegistro(nombre,apellido,dni);
        if(estado==0){
            Toast.makeText(getApplicationContext(), "No se Modifico correctamente",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "Se Modifico correctamente",Toast.LENGTH_LONG).show();
            LimpiarCampos();
            Listar();
        }

    }
    public void Eliminar(View v){
        String dni = txtDni.getText().toString();
        long estado = objPersonaDAO.Eliminar(Integer.valueOf(dni));
        if (estado == 0) {
            Toast.makeText(getApplicationContext(), "No se Elimino correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Se Elimino correctamente", Toast.LENGTH_LONG).show();
            LimpiarCampos();
            Listar();
        }
    }

    @Override
    public void onClick(View v){
        if(v==btnGrabar){Grabar();}
        if(v==btnListar){Listar();}


    }

}