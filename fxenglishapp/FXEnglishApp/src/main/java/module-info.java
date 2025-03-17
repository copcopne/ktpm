module com.si.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    
    opens com.si.pojo to javafx.base;
    opens com.si.fxenglishapp to javafx.fxml;
    exports com.si.fxenglishapp;
}
