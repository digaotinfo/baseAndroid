package com.example.digao.baseandroid.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.example.digao.baseandroid.Model.Conteudo;
import com.example.digao.baseandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digao on 04/05/16.
 */
public class ConteudoAdapter extends ArrayAdapter<Conteudo> {

    private Context context;
    private ArrayList<Conteudo> conteudoArrayList;

    public ConteudoAdapter(Context context, ArrayList<Conteudo> conteudoList){
        super(context, 0 , (List<Conteudo>) conteudoList);

        this.context = context;
        this.conteudoArrayList = conteudoList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Conteudo conteudoPosicao = this.conteudoArrayList.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.conteudo_list, null);

        TextView conteudoTitulo = (TextView)convertView.findViewById(R.id.conteudoTitulo);
        conteudoTitulo.setText( conteudoPosicao.getTitulo_ptbr() );

        convertView.setTag(conteudoArrayList.get(position).getId());

        return convertView;
    }
}
