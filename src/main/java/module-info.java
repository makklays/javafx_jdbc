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
    requires java.naming;

    opens com.techmatrix.javafx_jdbc to javafx.fxml;
    //opens sample.Datamodel;
    exports com.techmatrix.javafx_jdbc;
    exports com.techmatrix.javafx_jdbc.model;
    opens com.techmatrix.javafx_jdbc.model to javafx.fxml;
    exports com.techmatrix.javafx_jdbc.view;
    opens com.techmatrix.javafx_jdbc.view to javafx.fxml;
    exports com.techmatrix.javafx_jdbc.configuration;
    opens com.techmatrix.javafx_jdbc.configuration to javafx.fxml;
}

