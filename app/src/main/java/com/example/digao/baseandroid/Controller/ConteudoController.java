package com.example.digao.baseandroid.Controller;

import com.example.digao.baseandroid.Model.Conteudo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by digao on 04/05/16.
 */
public class ConteudoController {

    public ArrayList<Conteudo> conteudoList(String lendoJSON, String idCategoria){
        ArrayList<Conteudo> lista = new ArrayList<Conteudo>();

        try {
            JSONObject jsonObject = new JSONObject(lendoJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("conteudo");

            for(int i=0; i<jsonArray.length(); i++){
                Conteudo element = new Conteudo();

                JSONObject registro = (JSONObject) jsonArray.get(i);
                if( Integer.parseInt(registro.getString("categoria_id")) == Integer.parseInt(idCategoria)) {
                    element.setId(Integer.parseInt(registro.getString("id").toString()));
                    element.setCategoria_id(Integer.parseInt(registro.getString("categoria_id")));
                    element.setTitulo_ptbr(registro.getString("titulo_ptbr"));
                    element.setTitulo_eng(registro.getString("titulo_eng"));
                    element.setTexto_ptbr(registro.getString("texto_ptbr"));
                    element.setTexto_eng(registro.getString("texto_eng"));
                    element.setVideo_ptbr(registro.getString("video_ptbr"));
                    element.setVideo_eng(registro.getString("video_eng"));
                    element.setAudio_ptbr(registro.getString("audio_ptbr"));
                    element.setAudio_eng(registro.getString("audio_eng"));
                    //element.setCreated(registro.getString("created"));
                    element.setPermitir_compartilhar(Boolean.parseBoolean(registro.getString("permitir_compartilhar")));
                    element.setTotal_galeria(Integer.parseInt(registro.getString("total_galeria")));
                    element.setGaleria(registro.getString("galeria"));
                    //element.setImg_file(registro.getString("img_file"));
                    //element.setLegenda_ptbr(registro.getString("legenda_ptbr"));
                    //element.setLegenda_eng(registro.getString("legenda_eng"));

                    lista.add(element);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Conteudo conteudo(String lendoJSON, String id){
        Conteudo element = new Conteudo();

        try {
            JSONObject jsonObject = new JSONObject(lendoJSON);
            JSONArray jsonArray = jsonObject.getJSONArray("conteudo");

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject registro = (JSONObject) jsonArray.get(i);

                if( Integer.parseInt(registro.getString("id")) == Integer.parseInt(id)) {
                    element.setId(Integer.parseInt(registro.getString("id").toString()));
                    element.setCategoria_id(Integer.parseInt(registro.getString("categoria_id")));
                    element.setTitulo_ptbr(registro.getString("titulo_ptbr"));
                    element.setTitulo_eng(registro.getString("titulo_eng"));
                    element.setTexto_ptbr(registro.getString("texto_ptbr"));
                    element.setTexto_eng(registro.getString("texto_eng"));
                    element.setVideo_ptbr(registro.getString("video_ptbr"));
                    element.setVideo_eng(registro.getString("video_eng"));
                    element.setAudio_ptbr(registro.getString("audio_ptbr"));
                    element.setAudio_eng(registro.getString("audio_eng"));
                    //element.setCreated(registro.getString("created"));
                    element.setPermitir_compartilhar(Boolean.parseBoolean(registro.getString("permitir_compartilhar")));
                    element.setTotal_galeria(Integer.parseInt(registro.getString("total_galeria")));
                    element.setGaleria(registro.getString("galeria"));
                    element.setImg_file(registro.getString("img_file"));
                    element.setLegenda_ptbr(registro.getString("legenda_ptbr"));
                    element.setLegenda_eng(registro.getString("legenda_eng"));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return element;
    }
}
