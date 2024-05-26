package edu.ufp.inf.projeto.JavaFXStuff;
import edu.ufp.inf.projeto.Artigo;
import edu.ufp.inf.projeto.Autor;
import edu.ufp.inf.projeto.BD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;

public class GrafoApp extends Application {

    BD bd = new BD();
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        EntidadePane entidadePane = new EntidadePane();
        GrafoPane grafoPane = new GrafoPane();
        AdicionarEntidadePane adicionarEntidadePane = new AdicionarEntidadePane();
        PesquisaPane pesquisaPane = new PesquisaPane();

        TabPane tabPane = new TabPane();

        Tab tabEntidades = new Tab("Entidades", entidadePane);
        Tab tabGrafo = new Tab("Grafo", grafoPane);
        Tab tabAdicionar = new Tab("Adicionar", adicionarEntidadePane);
        Tab tabPesquisa = new Tab("Pesquisa", pesquisaPane);

        tabPane.getTabs().addAll(tabEntidades, tabGrafo, tabAdicionar, tabPesquisa);

        root.setCenter(tabPane);

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Visualização de Grafos");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Exemplo de interação (Adicionar Autor)
        adicionarEntidadePane.getAdicionarAutorButton().setOnAction(e -> {
            String nome = adicionarEntidadePane.getNomeAutor();
            Autor autor = new Autor(nome, "ORCID" + nome.hashCode(), "InstituicaoExemplo", 1, 2, 3, 4);
            // Adicionar o autor ao grafo e atualizar a interface
            // ...
            entidadePane.atualizarAutores((List<Autor>) autor);
        });

        // Exemplo de interação (Pesquisar)
        pesquisaPane.getPesquisarButton().setOnAction(e -> {
            String tipo = pesquisaPane.getTipoPesquisa();
            String parametro = pesquisaPane.getParametro();
            LocalDate inicio = pesquisaPane.getDataInicio();
            LocalDate fim = pesquisaPane.getDataFim();

            switch (tipo) {
                case "Por Jornal":
                    List<Artigo> artigosPorJornal = (List<Artigo>) bd.buscarJournal(parametro);
                    entidadePane.atualizarArtigos(artigosPorJornal);
                    break;
                case "Por Conferência":
                    List<Artigo> artigosPorConferencia = (List<Artigo>) bd.buscarConferencia(parametro);
                    entidadePane.atualizarArtigos(artigosPorConferencia);
                    break;
                case "Por Autor":
                    List<Artigo> artigosPorAutor = (List<Artigo>) bd.buscarAutor(parametro);
                    entidadePane.atualizarArtigos(artigosPorAutor);
                    break;
                default:
                    System.out.println("Tipo de pesquisa inválido");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GrafoApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Visualização de Grafos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/