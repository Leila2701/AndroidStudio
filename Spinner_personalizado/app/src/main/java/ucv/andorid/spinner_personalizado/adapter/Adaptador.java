package ucv.andorid.spinner_personalizado.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ucv.andorid.spinner_personalizado.R;
import ucv.andorid.spinner_personalizado.model.Entidad;

public class Adaptador extends BaseAdapter {
    private Context context;
    private ArrayList<Entidad> listItems;

    public Adaptador(Context context, ArrayList<Entidad> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertTiew, ViewGroup viewGroup) {


        Entidad Item=(Entidad) getItem(position);

        convertTiew= LayoutInflater.from(context).inflate(R.layout.item,null);
        ImageView imgFoto=(ImageView) convertTiew.findViewById(R.id.imgFoto);
        TextView tvTitulo=(TextView) convertTiew.findViewById(R.id.tvTitulo);

        imgFoto.setImageResource(Item.getImgFoto());
        tvTitulo.setText(Item.getTitulo());

        return convertTiew;
    }
}
