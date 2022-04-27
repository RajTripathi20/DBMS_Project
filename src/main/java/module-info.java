module com.example.hostel_management_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    //requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;
    requires ojdbc10.g;
    //requires eu.hansolo.tilesfx;

    opens com.example.hostel_management_system to javafx.fxml;
    exports com.example.hostel_management_system;
}