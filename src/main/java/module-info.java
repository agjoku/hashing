module com.github.agjoku.hashing {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.github.agjoku.hashing to javafx.fxml;
    exports com.github.agjoku.hashing;
}