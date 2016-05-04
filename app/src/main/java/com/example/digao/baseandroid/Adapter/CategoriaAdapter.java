package com.example.digao.baseandroid.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.digao.baseandroid.Model.Categoria;
import com.example.digao.baseandroid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digao on 04/05/16.
 */
public class CategoriaAdapter extends ArrayAdapter<Categoria> {
            private Context context;
            private ArrayList<Categoria> categoriaList;

            public CategoriaAdapter(Context context, ArrayList<Categoria> categoriaList){
                super(context, 0 , (List<Categoria>) categoriaList);

        this.context = context;
        this.categoriaList = categoriaList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Categoria categoriPosicao = this.categoriaList.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.categorias_list, null);

        TextView categoria = (TextView)convertView.findViewById(R.id.categoria);
        categoria.setText(categoriPosicao.getCategoria_ptbr());

        ImageView imagem = (ImageView)convertView.findViewById(R.id.img);
        if( categoriPosicao.getBotao_ptbr().toString() != "" ) {
            Picasso.with(context)
                    .load(categoriPosicao.getBotao_ptbr())
                    .into(imagem);
        }

        convertView.setTag(categoriaList.get(position).getId());

        return convertView;
    }
}
