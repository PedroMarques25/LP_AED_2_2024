module edu.ufp.inf.aed2_lp2_2324_students {
    requires java.desktop;
    requires java.logging;
    requires edu.princeton.cs.algs4;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.ufp.inf.projeto.JavaFXStuff;
    exports edu.ufp.inf.projeto.JavaFXStuff;

}


