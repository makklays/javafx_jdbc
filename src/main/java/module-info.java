module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    requires org.slf4j;

    requires org.hibernate.orm.core;
    requires java.persistence;
    //requires javax.naming.Referenceable;


    opens com.example.demo3 to javafx.fxml;
    //opens sample.Datamodel;
    exports com.example.demo3;
    exports com.example.demo3.model;
    opens com.example.demo3.model to javafx.fxml;
    exports com.example.demo3.view;
    opens com.example.demo3.view to javafx.fxml;
    exports com.example.demo3.configuration;
    opens com.example.demo3.configuration to javafx.fxml;
}

