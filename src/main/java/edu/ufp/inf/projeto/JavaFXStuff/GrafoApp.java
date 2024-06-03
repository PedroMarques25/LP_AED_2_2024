package edu.ufp.inf.projeto.JavaFXStuff;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GrafoApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Gestão de Grafos de Artigos e Autores");

            // Criação da visualização principal
            GrafoPane mainView = new GrafoPane();
            Scene scene = new Scene(mainView.getMainPane(), 800, 600);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

