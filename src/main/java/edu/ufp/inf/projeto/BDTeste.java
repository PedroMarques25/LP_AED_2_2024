package edu.ufp.inf.projeto;
import java.util.Date;
public class BDTeste {
    public static void main(String[] args) {
        BD bd = new BD();
        Date di = new Date( );
        Date df = new Date( );
        Autor autor1 = new Autor("Alice", "ALI", "FERNADO",1,2,3,4);
        Autor autor2 = new Autor("BOB", "BO", "FERNADO",2,3,4,5);

        Artigo artigo1 = new Artigo("Artigo 1", "Journal", "?","journal",2021,2,3,4);
        Artigo artigo2 = new Artigo("Artigo 1", "conferencia", "?","conferencia",2021,2,3,4);

          Conferencia conferencia1 = new Conferencia(1, "rua",di,df,"aaa","conferencia");
          Journal journal1 = new Journal("Conference on Testing", 3,5,7,"bbb","journal");

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
        assert bd.buscarAutor("ORCID1") != null;
        assert bd.buscarArtigo("Artigo 1") != null;
        assert bd.buscarJournal("bbb") != null;
        assert bd.buscarConferencia("aaa") != null;

        // Remover um autor e verificar se foi removido corretamente
        bd.removerAutor("ORCID1");
        assert bd.buscarAutor("ORCID1") == null;

        // Remover um artigo e verificar se foi removido corretamente
        bd.removerArtigo("Artigo 2");
        assert bd.buscarArtigo("Artigo 2") == null;

        // Remover uma publicação e verificar se foi removida corretamente
        bd.removerJournal("bbb");
        assert bd.buscarJournal("bbb") == null;

        System.out.println("Todos os testes passaram.");
    }
}
