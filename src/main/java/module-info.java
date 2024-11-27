module com.strukdat.strukdat {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.strukdat to javafx.fxml;
    exports com.strukdat;
}