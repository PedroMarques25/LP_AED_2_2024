module edu.ufp.inf.aed2_lp2_2324_students {
    requires java.desktop;
    requires java.logging;
    requires edu.princeton.cs.algs4;


    opens edu.ufp.inf.lp2._06_gui_javafx.helloword to javafx.fxml;
    exports edu.ufp.inf.lp2._06_gui_javafx.helloword;
    exports edu.ufp.inf.lp2._06_gui_javafx.calc;
}


