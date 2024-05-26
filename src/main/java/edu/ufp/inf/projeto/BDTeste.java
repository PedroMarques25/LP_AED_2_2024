package edu.ufp.inf.projeto;
import java.util.Date;
import java.util.List;

public class BDTeste {
    public static void main(String[] args) {
        BD bd = new BD();
        Date di = new Date();
        Date df = new Date();
        ArtigoGraph artigoGraph = new ArtigoGraph(100);
        Autor autor1 = new Autor("Alice", "ALI", "FERNADO", 1, 2, 3, 4);
        Autor autor2 = new Autor("Bob", "BO", "FERNADO", 2, 3, 4, 5);

        Artigo artigo1 = new Artigo("Artigo 1", "Journal", "?", "journal", 2021, 2, 3, 4,1);
        Artigo artigo2 = new Artigo("Artigo 2", "Conferencia", "?", "conferencia", 2021, 3, 4, 5,2);
        Artigo artigo3 = new Artigo("Artigo 3", "Journal", "?", "journal", 2022, 4, 5, 6,3);
        Artigo artigo4 = new Artigo("Artigo 4", "Conferencia", "?", "conferencia", 2023, 5, 6, 7,4);

        System.out.println("Inicializações Completas");

        // Adicionar artigos ao grafo
        artigoGraph.adicionarArtigo(artigo1);
        artigoGraph.adicionarArtigo(artigo2);
        artigoGraph.adicionarArtigo(artigo3);
        artigoGraph.adicionarArtigo(artigo4);

        // Adicionar citações entre artigos (exemplo)
        artigoGraph.adicionarCitação(0, 1);
        artigoGraph.adicionarCitação(1, 2);
        artigoGraph.adicionarCitação(2, 3);

        System.out.println("Adicionamentos Completos");

        String journalOuConferencia = "journal";
        int inicio = 2021;
        int fim = 2023;

        List<Artigo> artigosPorJournalEPeriodo = artigoGraph.listarArtigosPorJournalOuConferenciaEPeriodo(journalOuConferencia, inicio, fim);

        // Exibir os artigos encontrados
        System.out.println("Artigos encontrados no Journal e período especificado:");
        for (Artigo artigo : artigosPorJournalEPeriodo) {
            System.out.println("Artigo encontrado: " + artigo.getTitulo() + ", Ano: " + artigo.getAno());
        }

        Conferencia conferencia1 = new Conferencia(1, "rua", di, df, "aaa", "conferencia");
        Journal journal1 = new Journal("Conference on Testing", 3, 5, 7, "bbb", "journal");

        artigo1.adicionarAutor(autor1);
        artigo1.adicionarAutor(autor2);
        artigo2.adicionarAutor(autor1);

        bd.adicionarAutor(autor1);
        bd.adicionarAutor(autor2);
        bd.adicionarArtigo(artigo1);
        bd.adicionarArtigo(artigo2);
        bd.adicionarJournal(journal1);
        bd.adicionarConferencia(conferencia1);

        // Verificar se os dados foram adicionados corretamente
        System.out.println("Verificando adições:");
        assert bd.buscarAutor("ALI") != null;
        System.out.println("Autor Alice adicionado corretamente.");
        assert bd.buscarAutor("BO") != null;
        System.out.println("Autor Bob adicionado corretamente.");
        assert bd.buscarArtigo("Artigo 1") != null;
        System.out.println("Artigo 1 adicionado corretamente.");
        assert bd.buscarArtigo("Artigo 2") != null;
        System.out.println("Artigo 2 adicionado corretamente.");
        assert bd.buscarJournal("bbb") != null;
        System.out.println("Journal adicionado corretamente.");
        assert bd.buscarConferencia("aaa") != null;
        System.out.println("Conferência adicionada corretamente.");

        // Remover um autor e verificar se foi removido corretamente
        bd.removerAutor("ALI");
        assert bd.buscarAutor("ALI") == null;
        System.out.println("Autor Alice removido corretamente.");

        // Remover um artigo e verificar se foi removido corretamente
        bd.removerArtigo("Artigo 2");
        assert bd.buscarArtigo("Artigo 2") == null;
        System.out.println("Artigo 2 removido corretamente.");

        // Remover uma publicação e verificar se foi removida corretamente
        bd.removerJournal("bbb");
        assert bd.buscarJournal("bbb") == null;
        System.out.println("Journal removido corretamente.");

            System.out.println("Todos os testes passaram.");
    }
}
