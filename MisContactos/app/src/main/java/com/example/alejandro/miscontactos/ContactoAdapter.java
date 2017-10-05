package com.example.alejandro.miscontactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alejandro on 04/10/2017.
 */

public class ContactoAdapter extends ArrayAdapter{
    private Context context;
    private List<Contacto> datos;

    public ContactoAdapter(Context context, ArrayList datos){
        super(context,R.layout.item_list,datos);
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.item_list,null);

        TextView nombre = (TextView)item.findViewById(R.id.textView);
        nombre.setText(datos.get(position).getUsuario().toString());

        TextView email = (TextView)item.findViewById(R.id.textView2);
        email.setText(datos.get(position).getTwitter().toString());

        return item;
    }

}
