package edu.ufp.inf.projeto.JavaFXStuff;

import edu.ufp.inf.projeto.Artigo;
import edu.ufp.inf.projeto.Autor;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;

public class EntidadePane extends VBox {

    private TableView<Autor> tabelaAutores;
    private TableView<Artigo> tabelaArtigos;

    public EntidadePane() {
        // Inicializar a tabela de autores
        tabelaAutores = new TableView<>();
        TableColumn<Autor, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(cellData -> cellData.getValue().getNome());
        tabelaAutores.getColumns().add(colNome);

        // Inicializar a tabela de artigos
        tabelaArtigos = new TableView<>();
        TableColumn<Artigo, String> colTitulo = new TableColumn<>("Título");
        colTitulo.setCellValueFactory(cellData -> cellData.getValue().getTitulo());
        tabelaArtigos.getColumns().add(colTitulo);

        getChildren().addAll(new Label("Autores"), tabelaAutores, new Label("Artigos"), tabelaArtigos);
    }

    public void atualizarAutores(List<Autor> autores) {
        tabelaAutores.getItems().setAll(autores);
    }

    public void atualizarArtigos(List<Artigo> artigos) {
        tabelaArtigos.getItems().setAll(artigos);
    }
}

