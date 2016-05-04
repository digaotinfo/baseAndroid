package com.example.digao.baseandroid.Controller;

import com.example.digao.baseandroid.Model.Categoria;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by digao on 04/05/16.
 */
public class CategoriasController {
    public ArrayList<Categoria> categoriaList(String lendoJSON){
        ArrayList<Categoria> lista = new ArrayList<Categoria>();

        try {
            JSONObject jsonObject = new JSONObject(lendoJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("categorias");

            for(int i=0; i<jsonArray.length(); i++){
                Categoria cat = new Categoria();

                JSONObject registro = (JSONObject) jsonArray.get(i);
                cat.setId(Integer.parseInt(registro.getString("id").toString()) );
                cat.setCategoria_ptbr(registro.getString("categoria_ptbr"));
                cat.setCategoria_eng(registro.getString("categoria_eng"));
                cat.setBotao_ptbr(registro.getString("botao_ptbr"));
                cat.setBotao_eng(registro.getString("botao_eng"));
                cat.setImagem_bg(registro.getString("imagem_bg"));
                cat.setCor(registro.getString("cor"));

                lista.add(cat);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Categoria categoria(String lendoJSON, String id){
        Categoria cat = new Categoria();

        try {
            JSONObject jsonObject = new JSONObject(lendoJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("categorias");

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject registro = (JSONObject) jsonArray.get(i);

                if( Integer.parseInt(registro.getString("id")) == Integer.parseInt(id)) {
                    cat.setId(Integer.parseInt(registro.getString("id").toString()));
                    cat.setCategoria_ptbr(registro.getString("categoria_ptbr"));
                    cat.setCategoria_eng(registro.getString("categoria_eng"));
                    cat.setBotao_ptbr(registro.getString("botao_ptbr"));
                    cat.setBotao_eng(registro.getString("botao_eng"));
                    cat.setImagem_bg(registro.getString("imagem_bg"));
                    cat.setCor(registro.getString("cor"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cat;
    }
}
