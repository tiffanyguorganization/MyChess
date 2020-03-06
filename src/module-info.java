module a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires transitive javafx.graphics;
    opens chess to javafx.controls, javafx.fxml;
   
    exports chess;
}