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

    opens com.organizer.timeorganizer to javafx.fxml;
    exports com.organizer.timeorganizer;
    exports com.organizer.timeorganizer.controllers;
    opens com.organizer.timeorganizer.controllers to javafx.fxml;
}