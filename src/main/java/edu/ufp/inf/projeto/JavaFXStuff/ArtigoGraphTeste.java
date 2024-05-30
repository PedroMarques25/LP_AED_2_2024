package edu.ufp.inf.projeto.JavaFXStuff;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.ufp.inf.projeto.JavaFXStuff.ArtigoGraph;

import java.util.List;

public class ArtigoGraphTeste {

    public static void main(String[] args) {
        // Criar instância do GrafoDeArtigos com um número inicial de artigos
        ArtigoGraph grafo = new ArtigoGraph(10);

        // Adicionar alguns artigos
        grafo.adicionarArtigo(new Artigo("Artigo 1", "Journal", "?", "journal", 2021, 2, 3, 4,0));
        grafo.adicionarArtigo(new Artigo("Artigo 2", "Conferencia", "?", "conferencia", 2021, 3, 4, 5,1));
        grafo.adicionarArtigo(new Artigo("Artigo 3", "Journal", "?", "journal", 2022, 4, 5, 6,2));
        grafo.adicionarArtigo(new Artigo("Artigo 4", "Conferencia", "?", "conferencia", 2023, 5, 6, 7,3));
        grafo.adicionarArtigo(new Artigo("Artigo 5", "Conferencia", "?", "conferencia", 2023, 5, 6, 7,4));

        // Adicionar algumas citações
        grafo.adicionarCitação(0, 1); // Artigo A cita Artigo B
        grafo.adicionarCitação(1, 2); // Artigo B cita Artigo C
        grafo.adicionarCitação(2, 3); // Artigo C cita Artigo D
        grafo.adicionarCitação(3, 4); // Artigo D cita Artigo E
        grafo.adicionarCitação(4, 0); // Artigo E cita Artigo A (ciclo)

        // Testar listar artigos por journal e período
        List<Artigo> artigosJournal1 = grafo.listarArtigosPorJournalOuConferenciaEPeriodo("Journal 1", 2020, 2024);
        System.out.println("Artigos do Journal 1 em 2022: " + artigosJournal1);

        // Testar calcular citações de primeira ordem
        int citacoesDePrimeiraOrdem = grafo.calcularCitaçõesDePrimeiraOrdem(1); // Esperado: 1
        System.out.println("Citações de primeira ordem do Artigo B: " + citacoesDePrimeiraOrdem);

        // Testar calcular citações de segunda ordem
        int citacoesDeSegundaOrdem = grafo.calcularCitaçõesDeSegundaOrdem(1); // Esperado: 1 (Artigo B -> Artigo C -> Artigo D)
        System.out.println("Citações de segunda ordem do Artigo 2: " + citacoesDeSegundaOrdem);

        // Testar calcular auto-citações
        int autoCitacoes = grafo.calcularAutoCitações(0); // Esperado: 1 (Artigo A -> Artigo B do mesmo autor)
        System.out.println("Auto-citações do Artigo 1: " + autoCitacoes);

        // Testar calcular caminho mais curto
        Iterable<DirectedEdge> caminhoMaisCurto = grafo.calcularCaminhoMaisCurto(0, 3); // Esperado: A -> B -> C -> D
        System.out.print("Caminho mais curto entre Artigo 1 e Artigo 4: ");
        for (DirectedEdge edge : caminhoMaisCurto) {
            System.out.print(edge + " ");
        }
        System.out.println();

        // Testar criar sub-grafo por tipo
        Digraph subGrafoJournal = grafo.criarSubGrafoPorTipo("Artigo 3");
        System.out.println("Sub-grafo apenas com artigos de journals: " + subGrafoJournal);

        // Testar verificar conexidade
        boolean conexo = grafo.verificarConectidade();
        System.out.println("O grafo principal é conexo? " + conexo);

    }
}