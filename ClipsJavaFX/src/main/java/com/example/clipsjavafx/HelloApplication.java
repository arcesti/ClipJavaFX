package com.example.clipsjavafx;

import com.example.clipsjavafx.db.SingletonDB;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMaximized(true);
        stage.setTitle("ClipsFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if(SingletonDB.conectar()) {
            launch();
        }
        else {
            JOptionPane.showMessageDialog(null,"Erro ao conectar o banco de dados: " + SingletonDB.getConexao().getMensagemErro());
            Platform.exit();
        }
    }
}