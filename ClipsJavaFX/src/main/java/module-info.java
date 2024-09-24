module com.example.clipsjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.desktop;
    requires java.sql;

    opens com.example.clipsjavafx to javafx.fxml;
    opens com.example.clipsjavafx.db to javafx.fxml;
    exports com.example.clipsjavafx;
    exports com.example.clipsjavafx.db;
}