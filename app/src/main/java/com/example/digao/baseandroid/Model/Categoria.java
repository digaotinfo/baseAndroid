package com.example.digao.baseandroid.Model;

/**
 * Created by digao on 04/05/16.
 */
public class Categoria {
    private int id;
    private String categoria_ptbr;
    private String categoria_eng;
    private String botao_ptbr;
    private String botao_eng;
    private String imagem_bg;
    private String cor;

    public Categoria(){

    }

    public Categoria(int id, String categoria_ptbr, String categoria_eng, String botao_ptbr, String botao_eng, String imagem_bg, String cor) {
        this.id = id;
        this.categoria_ptbr = categoria_ptbr;
        this.categoria_eng = categoria_eng;
        this.botao_ptbr = botao_ptbr;
        this.botao_eng = botao_eng;
        this.imagem_bg = imagem_bg;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                ", categoria_ptbr='" + categoria_ptbr +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria_ptbr() {
        return categoria_ptbr;
    }

    public void setCategoria_ptbr(String categoria_ptbr) {
        this.categoria_ptbr = categoria_ptbr;
    }

    public String getCategoria_eng() {
        return categoria_eng;
    }

    public void setCategoria_eng(String categoria_eng) {
        this.categoria_eng = categoria_eng;
    }

    public String getBotao_ptbr() {
        return botao_ptbr;
    }

    public void setBotao_ptbr(String botao_ptbr) {
        this.botao_ptbr = botao_ptbr;
    }

    public String getBotao_eng() {
        return botao_eng;
    }

    public void setBotao_eng(String botao_eng) {
        this.botao_eng = botao_eng;
    }

    public String getImagem_bg() {
        return imagem_bg;
    }

    public void setImagem_bg(String imagem_bg) {
        this.imagem_bg = imagem_bg;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
