package ucv.andorid.grupo_06.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.BreakIterator;
import java.util.ArrayList;

import ucv.andorid.grupo_06.R;
import ucv.andorid.grupo_06.model.Framework;

public class FrameworkAdapter extends ArrayAdapter<Framework> {

    public FrameworkAdapter(@NonNull Context context, @NonNull ArrayList<Framework> frameworks) {
        super(context, 0, frameworks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return view(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(position==0){
            return viewInicial(position, convertView, parent);
        }

        return view(position, convertView, parent);
    }

    private View view(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(
                R.layout.item_framework, parent, false
        );

        ImageView imgFramework = convertView.findViewById(R.id.imgFramework);
        TextView txtNomFramework= convertView.findViewById(R.id.txtNombreFramework);
        Framework framework = getItem(position);
        imgFramework.setImageResource(framework.getImg());
        txtNomFramework.setText(framework.getNombre());
        return convertView;
    }
    private View viewInicial(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(getContext()).inflate(
                R.layout.item_inicial, parent, false
         );
        Framework framework = getItem(position);
        TextView txtNomFramework = convertView.findViewById(R.id.txtNombreFramework);
        txtNomFramework.setText(framework.getNombre());

        return convertView;
    }






}
