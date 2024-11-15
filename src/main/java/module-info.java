module org.example.vendaingressos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires jdk.compiler;

    opens vendaingressos to javafx.fxml;
    exports vendaingressos;
    exports vendaingressos.controllers;
    opens vendaingressos.controllers to javafx.fxml;
    exports vendaingressos.repository;
    opens vendaingressos.repository to javafx.fxml;
    opens vendaingressos.models to com.google.gson;
}
