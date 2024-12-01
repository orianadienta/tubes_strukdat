module com.strukdat.strukdat {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.strukdat.controllers to javafx.fxml; // Memberikan akses ke FXML
    exports com.strukdat;
}