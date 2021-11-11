module com.organizer.timeorganizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;

    opens mytimeorganizer to javafx.fxml;
    exports mytimeorganizer;
    exports mytimeorganizer.controllers;
    opens mytimeorganizer.controllers to javafx.fxml;
}