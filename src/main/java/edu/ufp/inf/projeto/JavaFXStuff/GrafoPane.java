package edu.ufp.inf.projeto.JavaFXStuff;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GrafoPane {
    private BorderPane mainPane;
    private ArtigoGraph grafoDeArtigos;
    private AutorGraph grafoDeAutores;// Adiciona a lógica do grafo
    private BD bd;

    public GrafoPane() {

        mainPane = new BorderPane();
        mainPane.setPadding(new Insets(10, 10, 10, 10));

        grafoDeArtigos = new ArtigoGraph(10);
        grafoDeAutores = new AutorGraph(10);// Exemplo com 10 vértices
        bd = new BD();

        // Top: Barra de Ferramentas
        HBox toolbar = new HBox(10);
        toolbar.setPadding(new Insets(10, 10, 10, 10));
        Button btnAddArtigo = new Button("Adicionar Artigo");
        Button btnAddAutor = new Button("Adicionar Autor");
        Button btnremoverArtigo = new Button("remover Artigo");
        Button btnremoverAutor = new Button("remover Autor");
        Button btneditarArtigo = new Button("remover Artigo");
        Button btneditarAutor = new Button("remover Autor");
        toolbar.getChildren().addAll(btnAddArtigo, btnAddAutor,btnremoverArtigo,btnremoverAutor);

        mainPane.setTop(toolbar);


        // Configurar ações dos botões
        btnAddArtigo.setOnAction(e -> showAddArtigoDialog());
        btnAddAutor.setOnAction(e -> showAddAutorDialog());
        btnremoverArtigo.setOnAction(e -> showremoverArtigoDialog());
        btnremoverAutor.setOnAction(e -> showremoverArtigoDialog());

    }

    private void showAddArtigoDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Adicionar Artigo");

        VBox dialogVbox = new VBox(10);
        dialogVbox.setPadding(new Insets(10, 10, 10, 10));

        TextField txttitulo = new TextField();
        txttitulo.setPromptText("titulo do Artigo");
        TextField txtpalavrachave = new TextField();
        txtpalavrachave.setPromptText("palavrachave do Artigo");
        TextField txtabstarcttexto = new TextField();
        txtabstarcttexto.setPromptText("abstarcttexto do Artigo");
        TextField txttipodepublicao = new TextField();
        txttipodepublicao.setPromptText("tipodepublicão do Artigo");
        TextField txtano = new TextField();
        txtano.setPromptText("ano do Artigo");
        TextField txtnumdownloads = new TextField();
        txtnumdownloads.setPromptText("numdownloads do Artigo");
        TextField txtnumviews = new TextField();
        txtnumviews.setPromptText("numviews do Artigo");
        TextField txtnumlikes = new TextField();
        txtnumlikes.setPromptText("numlikes do Artigo");
        TextField txtid = new TextField();
        txtid.setPromptText("id do Artigo");

        Button btnSave = new Button("Salvar");
        btnSave.setOnAction(e -> {
            int ano = Integer.parseInt(txtano.getText());
            int numdownloads = Integer.parseInt(txtnumdownloads.getText());
            int numviews = Integer.parseInt(txtnumviews.getText());
            int numlikes = Integer.parseInt(txtnumlikes.getText());
            int id = Integer.parseInt(txtid.getText());
            String titulo = txttitulo.getText();
            String palavrachave = txtpalavrachave.getText();
            String abstarcttexto = txtabstarcttexto.getText();
            String tipodepublicao = txttipodepublicao.getText();
            Artigo artigo = new Artigo( titulo,palavrachave,abstarcttexto,tipodepublicao,ano,numdownloads,numviews,numlikes,id);
            grafoDeArtigos.adicionarArtigo(artigo);
            bd.adicionarArtigo(artigo);
            dialog.close();
        });

        dialogVbox.getChildren().addAll(new Label("titulo:"), txttitulo, new Label("palavrachave:"), txtpalavrachave,
                new Label("abstarcttexto:"), txtabstarcttexto, new Label("tipodepublicao:"), txttipodepublicao,
                new Label("ano:"), txtano, new Label("numdownloads:"), txtnumdownloads,new Label("numviews:"),
                txtnumviews, new Label("numlikes:"), txtnumlikes,new Label("ID:"), txtid, btnSave);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    private void showAddAutorDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Adicionar Autor");

        VBox dialogVbox = new VBox(10);
        dialogVbox.setPadding(new Insets(10, 10, 10, 10));

        TextField txtnome = new TextField();
        txtnome.setPromptText("nome do Autor");
        TextField txtnomecurto = new TextField();
        txtnomecurto.setPromptText("nomecurto do Autor");
        TextField txtfiliacao = new TextField();
        txtfiliacao.setPromptText("filiacao do Autor");
        TextField txtorcid = new TextField();
        txtorcid.setPromptText("orcid do Autor");
        TextField txtcienciaid = new TextField();
        txtcienciaid.setPromptText("cienciaid do Autor");
        TextField txtgooglescholarid = new TextField();
        txtgooglescholarid.setPromptText("googlescholarid do Autor");
        TextField txtscopusauthorid = new TextField();
        txtscopusauthorid.setPromptText("scopusauthorid do Autor");

        Button btnSave = new Button("Salvar");
        btnSave.setOnAction(e -> {
            int orcid = Integer.parseInt(txtorcid.getText());
            int cienciaid = Integer.parseInt(txtcienciaid.getText());
            int googlescholarid = Integer.parseInt(txtgooglescholarid.getText());
            int scopusauthorid = Integer.parseInt(txtscopusauthorid.getText());
            String nome = txtnome.getText();
            String nomecurto = txtnomecurto.getText();
            String filiacao = txtfiliacao.getText();

            Autor autor = new Autor( nome,nomecurto,filiacao,orcid,cienciaid,googlescholarid,scopusauthorid);
            grafoDeAutores.adicionarAutor(autor);
            bd.adicionarAutor(autor);
            dialog.close();
        });

        dialogVbox.getChildren().addAll(new Label("nome:"), txtnome, new Label("nomecurto:"), txtnomecurto,
                new Label("filiacao:"), txtfiliacao, new Label("orcid:"), txtorcid,
                new Label("cienciaid:"), txtcienciaid, new Label("googlescholarid:"), txtgooglescholarid,new Label("scopusauthorid:"),
                txtscopusauthorid, btnSave);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    private void showremoverArtigoDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Adicionar Artigo");

        VBox dialogVbox = new VBox(10);
        dialogVbox.setPadding(new Insets(10, 10, 10, 10));

        TextField txttitulo = new TextField();
        txttitulo.setPromptText("titulo do Artigo");
        TextField txtpalavrachave = new TextField();
        txtpalavrachave.setPromptText("palavrachave do Artigo");
        TextField txtabstarcttexto = new TextField();
        txtabstarcttexto.setPromptText("abstarcttexto do Artigo");
        TextField txttipodepublicao = new TextField();
        txttipodepublicao.setPromptText("tipodepublicão do Artigo");
        TextField txtano = new TextField();
        txtano.setPromptText("ano do Artigo");
        TextField txtnumdownloads = new TextField();
        txtnumdownloads.setPromptText("numdownloads do Artigo");
        TextField txtnumviews = new TextField();
        txtnumviews.setPromptText("numviews do Artigo");
        TextField txtnumlikes = new TextField();
        txtnumlikes.setPromptText("numlikes do Artigo");
        TextField txtid = new TextField();
        txtid.setPromptText("id do Artigo");

        Button btnSave = new Button("Salvar");
        btnSave.setOnAction(e -> {
            int ano = Integer.parseInt(txtano.getText());
            int numdownloads = Integer.parseInt(txtnumdownloads.getText());
            int numviews = Integer.parseInt(txtnumviews.getText());
            int numlikes = Integer.parseInt(txtnumlikes.getText());
            int id = Integer.parseInt(txtid.getText());
            String titulo = txttitulo.getText();
            String palavrachave = txtpalavrachave.getText();
            String abstarcttexto = txtabstarcttexto.getText();
            String tipodepublicao = txttipodepublicao.getText();
            Artigo artigo = new Artigo( titulo,palavrachave,abstarcttexto,tipodepublicao,ano,numdownloads,numviews,numlikes,id);
            grafoDeArtigos.removerArtigo(artigo);
            bd.removerArtigo(titulo);
            dialog.close();
        });

        dialogVbox.getChildren().addAll(new Label("titulo:"), txttitulo, new Label("palavrachave:"), txtpalavrachave,
                new Label("abstarcttexto:"), txtabstarcttexto, new Label("tipodepublicao:"), txttipodepublicao,
                new Label("ano:"), txtano, new Label("numdownloads:"), txtnumdownloads,new Label("numviews:"),
                txtnumviews, new Label("numlikes:"), txtnumlikes,new Label("ID:"), txtid, btnSave);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    private void showremoverAutorDialog() {
        Stage dialog = new Stage();
        dialog.setTitle("Adicionar Autor");

        VBox dialogVbox = new VBox(10);
        dialogVbox.setPadding(new Insets(10, 10, 10, 10));

        TextField txtnome = new TextField();
        txtnome.setPromptText("nome do Autor");
        TextField txtnomecurto = new TextField();
        txtnomecurto.setPromptText("nomecurto do Autor");
        TextField txtfiliacao = new TextField();
        txtfiliacao.setPromptText("filiacao do Autor");
        TextField txtorcid = new TextField();
        txtorcid.setPromptText("orcid do Autor");
        TextField txtcienciaid = new TextField();
        txtcienciaid.setPromptText("cienciaid do Autor");
        TextField txtgooglescholarid = new TextField();
        txtgooglescholarid.setPromptText("googlescholarid do Autor");
        TextField txtscopusauthorid = new TextField();
        txtscopusauthorid.setPromptText("scopusauthorid do Autor");

        Button btnSave = new Button("Salvar");
        btnSave.setOnAction(e -> {
            int orcid = Integer.parseInt(txtorcid.getText());
            int cienciaid = Integer.parseInt(txtcienciaid.getText());
            int googlescholarid = Integer.parseInt(txtgooglescholarid.getText());
            int scopusauthorid = Integer.parseInt(txtscopusauthorid.getText());
            String nome = txtnome.getText();
            String nomecurto = txtnomecurto.getText();
            String filiacao = txtfiliacao.getText();

            Autor autor = new Autor( nome,nomecurto,filiacao,orcid,cienciaid,googlescholarid,scopusauthorid);
            grafoDeAutores.removerAutor(autor);
            bd.removerAutor(orcid);
            dialog.close();
        });

        dialogVbox.getChildren().addAll(new Label("nome:"), txtnome, new Label("nomecurto:"), txtnomecurto,
                new Label("filiacao:"), txtfiliacao, new Label("orcid:"), txtorcid,
                new Label("cienciaid:"), txtcienciaid, new Label("googlescholarid:"), txtgooglescholarid,new Label("scopusauthorid:"),
                txtscopusauthorid, btnSave);

        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    public BorderPane getMainPane() {
        return mainPane;
    }
}
