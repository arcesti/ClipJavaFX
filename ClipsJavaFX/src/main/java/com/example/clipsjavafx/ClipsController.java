package com.example.clipsjavafx;

import com.example.clipsjavafx.db.Clip;
import com.example.clipsjavafx.db.ClipDAL;
import com.example.clipsjavafx.db.SingletonDB;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClipsController implements Initializable {
    public WebView webView;
    @FXML
    private TableColumn<Clip, String> colArtista;

    @FXML
    private TableColumn<Clip, String> colData;

    @FXML
    private TableColumn<Clip, String> colDuracao;

    @FXML
    private TableColumn<Clip, String> colId;

    @FXML
    private TableColumn<Clip, String> colTitulo;

    @FXML
    private TableView<Clip> tableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colArtista.setCellValueFactory(new PropertyValueFactory<>("artista"));
        colData.setCellValueFactory(new PropertyValueFactory<>("datapub"));
        colDuracao.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        ClipDAL clipDAL = new ClipDAL();
        List<Clip> clips = clipDAL.get("");
        tableView.setItems(FXCollections.observableArrayList(clips));
        webView.getEngine().load("https://www.google.com/url?sa=t&source=web&rct=j&opi=89978449&url=https://www.youtube.com/watch%3Fv%3D6Y1swEeFwYo&ved=2ahUKEwi2nZ_rzNuIAxUkqJUCHWgYBnMQtwJ6BAgMEAI&usg=AOvVaw3BEmEvIkgz0Qzsu3rBDgwv");
    }
}
