module com.example.clipsjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clipsjavafx to javafx.fxml;
    exports com.example.clipsjavafx;
}