package EMPRESA.ANDROID.PRINCIPAL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class personalizacion extends BaseAdapter {

    ArrayList<Persona> lista=null;
    LayoutInflater grilla;
    

    public personalizacion(Context context, ArrayList<Persona> lista){
        this.lista= lista;
        this.grilla= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class Componentes{
        TextView lblnombre;
        TextView lblapellido;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Componentes componente;

        if (convertView==null){
            convertView= grilla.inflate(R.layout.grilla, null);
            componente= new Componentes();
            componente.lblnombre=(TextView)convertView.findViewById(R.id.lblnombregrilla);
            componente.lblapellido=(TextView)convertView.findViewById(R.id.lblapellidogrilla);
            convertView.setTag(componente);
        } else {
            componente= (Componentes)convertView.getTag();
        }

        componente.lblnombre.setText(lista.get(position).getNombre());
        componente.lblapellido.setText(lista.get(position).getApellido());

        return convertView;
    }
}
