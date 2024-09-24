package com.example.clipsjavafx.db;

public class SingletonDB {
    static private Conexao conexao;

    private SingletonDB() {

    }

    public static boolean conectar() {
        conexao = new Conexao();
        conexao.conectar("jdbc:postgresql://localhost:5432/", "db_musics", "postgres", "postgres123");
        return conexao.getEstadoConexao();
    }

    public static Conexao getConexao() {
        return conexao;
    }
}
