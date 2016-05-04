package com.example.digao.baseandroid.Model;

import java.util.Date;

/**
 * Created by digao on 04/05/16.
 */
public class Conteudo {
    private int id;
    private int categoria_id;
    private String titulo_ptbr;
    private String titulo_eng;
    private String texto_ptbr;
    private String texto_eng;
    private String video_ptbr;
    private String video_eng;
    private String audio_ptbr;
    private String audio_eng;
    private Date created;
    private Boolean permitir_compartilhar;
    private int total_galeria;
    private Object galeria;
    private String img_file;
    private String legenda_ptbr;
    private String legenda_eng;

    public Conteudo() {

    }

    public Conteudo(int id, int categoria_id, String titulo_ptbr, String titulo_eng, String texto_ptbr, String texto_eng, String video_ptbr, String video_eng, String audio_ptbr, String audio_eng, Date created, Boolean permitir_compartilhar, int total_galeria, Object galeria, String img_file, String legenda_ptbr, String legenda_eng) {
        this.id = id;
        this.categoria_id = categoria_id;
        this.titulo_ptbr = titulo_ptbr;
        this.titulo_eng = titulo_eng;
        this.texto_ptbr = texto_ptbr;
        this.texto_eng = texto_eng;
        this.video_ptbr = video_ptbr;
        this.video_eng = video_eng;
        this.audio_ptbr = audio_ptbr;
        this.audio_eng = audio_eng;
        this.created = created;
        this.permitir_compartilhar = permitir_compartilhar;
        this.total_galeria = total_galeria;
        this.galeria = galeria;
//        this.img_file = img_file;
//        this.legenda_ptbr = legenda_ptbr;
//        this.legenda_eng = legenda_eng;
    }

    @Override
    public String toString() {
        return "Conteudo{" +
                "texto_ptbr='" + texto_ptbr + '\'' +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getTitulo_ptbr() {
        return titulo_ptbr;
    }

    public void setTitulo_ptbr(String titulo_ptbr) {
        this.titulo_ptbr = titulo_ptbr;
    }

    public String getTitulo_eng() {
        return titulo_eng;
    }

    public void setTitulo_eng(String titulo_eng) {
        this.titulo_eng = titulo_eng;
    }

    public String getTexto_ptbr() {
        return texto_ptbr;
    }

    public void setTexto_ptbr(String texto_ptbr) {
        this.texto_ptbr = texto_ptbr;
    }

    public String getTexto_eng() {
        return texto_eng;
    }

    public void setTexto_eng(String texto_eng) {
        this.texto_eng = texto_eng;
    }

    public String getVideo_ptbr() {
        return video_ptbr;
    }

    public void setVideo_ptbr(String video_ptbr) {
        this.video_ptbr = video_ptbr;
    }

    public String getVideo_eng() {
        return video_eng;
    }

    public void setVideo_eng(String video_eng) {
        this.video_eng = video_eng;
    }

    public String getAudio_ptbr() {
        return audio_ptbr;
    }

    public void setAudio_ptbr(String audio_ptbr) {
        this.audio_ptbr = audio_ptbr;
    }

    public String getAudio_eng() {
        return audio_eng;
    }

    public void setAudio_eng(String audio_eng) {
        this.audio_eng = audio_eng;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getPermitir_compartilhar() {
        return permitir_compartilhar;
    }

    public void setPermitir_compartilhar(Boolean permitir_compartilhar) {
        this.permitir_compartilhar = permitir_compartilhar;
    }

    public int getTotal_galeria() {
        return total_galeria;
    }

    public void setTotal_galeria(int total_galeria) {
        this.total_galeria = total_galeria;
    }

    public Object getGaleria() {
        return galeria;
    }

    public void setGaleria(Object galeria) {
        this.galeria = galeria;
    }

    public String getImg_file() {
        return img_file;
    }

    public void setImg_file(String img_file) {
        this.img_file = img_file;
    }

    public String getLegenda_ptbr() {
        return legenda_ptbr;
    }

    public void setLegenda_ptbr(String legenda_ptbr) {
        this.legenda_ptbr = legenda_ptbr;
    }

    public String getLegenda_eng() {
        return legenda_eng;
    }

    public void setLegenda_eng(String legenda_eng) {
        this.legenda_eng = legenda_eng;
    }
}
