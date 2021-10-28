package ucv.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdaptadorNombre extends BaseAdapter {
    private Context contexto;
    private List<Nombres> listaNombre;

    public AdaptadorNombre (Context context, List<Nombres> listaNombre){
        this.contexto= context;
        this.listaNombre= listaNombre;
    }

    @Override
    public int getCount() { return listaNombre.size();
    }

    @Override
    public Object getItem(int position) {
        return listaNombre.get(position);
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

        imagen.setImageResource(listaNombre.get(position).getImagen());
        descripcion.setText(listaNombre.get(position).getNombre());
        return vista;
    }


}
