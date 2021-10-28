package ucv.andorid.spinner_personalizado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import ucv.andorid.spinner_personalizado.R;
import ucv.andorid.spinner_personalizado.model.LenguajeProgramacion;

public class AdaptadorLenguajeProgramacion extends BaseAdapter {
    private Context contexto;
    private List<LenguajeProgramacion> listaLenguaje;

    public AdaptadorLenguajeProgramacion (Context context, List<LenguajeProgramacion> listaLenguaje){
        this.contexto= context;
        this.listaLenguaje= listaLenguaje;
    }

    @Override
    public int getCount() {
        return listaLenguaje.size();
    }

    @Override
    public Object getItem(int position) {
        return listaLenguaje.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.item_spinner, null);

        ImageView imagen = (ImageView) vista.findViewById(R.id.iv_lenguaje);
        TextView descripcion = (TextView) vista.findViewById(R.id.tv_lenguaje);

        imagen.setImageResource(listaLenguaje.get(position).getImagen_lenguaje());
        descripcion.setText(listaLenguaje.get(position).getNombre_lenguaje());
        return vista;
    }
}
