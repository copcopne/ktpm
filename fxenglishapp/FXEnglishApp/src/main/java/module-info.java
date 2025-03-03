module com.si.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.si.fxenglishapp to javafx.fxml;
    exports com.si.fxenglishapp;
}
