package com.example.clipsjavafx.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClipDAL {
    public boolean inserir(Clip clip) {
                String insert = """
                INSERT INTO public.clip(
                clip_id, clip_artista, clip_titulo, clip_duracao, clip_pubdata, clip_url)
                VALUES (default, '#1', '#2', #3, '#4', '#5');""";
        insert = insert.replace("#1", clip.getArtista());
        insert = insert.replace("#2", clip.getTitulo());
        insert = insert.replace("#3", "" + clip.getDuracao());
        insert = insert.replace("#4", clip.getDataPub().toString());
        insert = insert.replace("#5", clip.getUrl());

        return SingletonDB.getConexao().manipular(insert);
    }
    public boolean alterar(Clip clip) {
        String alterar = """
                UPDATE clip
	            SET clip_artista='#1', clip_titulo='#2', clip_duracao=#3, clip_pubdata='#4', clip_url='#5'
	            WHERE clip_id = #6;
	            """;
        alterar = alterar.replace("#1", clip.getArtista());
        alterar = alterar.replace("#2", clip.getTitulo());
        alterar = alterar.replace("#3", "" + clip.getDuracao());
        alterar = alterar.replace("#4", clip.getDataPub().toString());
        alterar = alterar.replace("#5", clip.getUrl());
        alterar = alterar.replace("#6",""+clip.getId());

        return SingletonDB.getConexao().manipular(alterar);
    }

    public boolean apagar(Clip clip) {
        return SingletonDB.getConexao().manipular("DELETE FROM clip WHERE clip_id="+clip.getId());
    }

    public Clip get(int id) {
        Clip clip = null;
        ResultSet resultSet = SingletonDB.getConexao().consultar("SELECT * FROM clip WHERE clip_id = " + id);
        try {
            if(resultSet.next()) {
                clip = new Clip(id, resultSet.getString("clip_artista"), resultSet.getString("clip_titulo"),
                        resultSet.getInt("clip_duracao"), resultSet.getDate("clip_pubdata").toLocalDate(), resultSet.getString("clip_url"));
            }
        } catch (Exception e) {
            System.out.println("Erro nao esperado: " + e.getMessage());
        }
        return clip;
    }

    public List<Clip> get(String filtro) {
        List<Clip> clips = new ArrayList<>();
        String select = "SELECT * FROM clip";
        if(!filtro.isEmpty()) {
            select += " WHERE " + filtro;
        }
        ResultSet resultSet = SingletonDB.getConexao().consultar(select);
        try {
            while(resultSet.next()) {
                clips.add(new Clip(resultSet.getInt("clip_id"), resultSet.getString("clip_artista"), resultSet.getString("clip_titulo"),
                        resultSet.getInt("clip_duracao"), resultSet.getDate("clip_pubdata").toLocalDate(),
                        resultSet.getString("clip_url")));
            }
        } catch (Exception e) {
            System.out.println("Erro nao esperado: " + e.getMessage());
        }
        return clips;
    }
}
