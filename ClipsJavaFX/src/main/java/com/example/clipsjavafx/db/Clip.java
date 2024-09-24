package com.example.clipsjavafx.db;

import java.time.LocalDate;

public class Clip {
    private int id;
    private String artista;
    private String titulo;
    private int duracao;
    private LocalDate dataPub;
    private String url;

    public Clip(int id, String artista, String titulo, int duracao, LocalDate dataPub, String url) {
        this.id = id;
        this.artista = artista;
        this.titulo = titulo;
        this.duracao = duracao;
        this.dataPub = dataPub;
        this.url = url;
    }

    public Clip(String artista, String titulo, int duracao, LocalDate dataPub, String url) {
        this(0, artista, titulo, duracao, dataPub, url);
    }

    public Clip() {
        this(0,"","",0,LocalDate.now(),"");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataPub() {
        return dataPub;
    }

    public void setDataPub(LocalDate dataPub) {
        this.dataPub = dataPub;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
