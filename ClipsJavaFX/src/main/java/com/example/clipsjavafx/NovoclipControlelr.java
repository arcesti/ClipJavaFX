package com.example.clipsjavafx;

import com.example.clipsjavafx.db.Clip;
import com.example.clipsjavafx.db.ClipDAL;
import com.example.clipsjavafx.db.SingletonDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NovoclipControlelr {
    
    @FXML
    private TextField tfArtista;

    @FXML
    private DatePicker tfData;

    @FXML
    private TextField tfDuracao;

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfUrl;

    public void onConfirm(ActionEvent actionEvent) {
        Clip novo = new Clip(tfArtista.getText(), tfTitulo.getText(), Integer.parseInt(tfDuracao.getText()), tfData.getValue(), tfUrl.getText());
        ClipDAL clipDal = new ClipDAL();
        if(!clipDal.inserir(novo)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(SingletonDB.getConexao().getMensagemErro());
            alert.showAndWait();
        }
        HelloController.carregarTelaTabela();
    }

    public void onCanceler(ActionEvent actionEvent) {
        HelloController.carregarTelaTabela();
    }
}
