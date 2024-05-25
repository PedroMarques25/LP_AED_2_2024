package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.DijkstraSP;

import java.util.ArrayList;
import java.util.List;

public class ArtigoGraph {
    private Digraph digrafo;
    private List<Artigo> artigos;

    public ArtigoGraph(int numeroDeArtigos) {
        digrafo = new Digraph(numeroDeArtigos);
        artigos = new ArrayList<>(numeroDeArtigos);
    }

    public void adicionarArtigo(Artigo artigo) {
        artigos.add(artigo);
    }

    public void adicionarCitação(int artigo1, int artigo2) {
        digrafo.addEdge(artigo1, artigo2);
    }

    // Método para listar artigos por journal/conferência e período
    public List<Artigo> listarArtigosPorJournalOuConferenciaEPeriodo(String journalOuConferencia, int inicio, int fim) {
        List<Artigo> result = new ArrayList<>();
        for (Artigo artigo : artigos) {
            if (artigo.getTipoDePublicacao().equals(journalOuConferencia) &&
                    artigo.getAno() >= inicio && artigo.getAno() <= fim) {
                result.add(artigo);
            }
        }
        return result;
    }

    public int calcularCitaçõesDePrimeiraOrdem(int idArtigo) {
        return digrafo.outdegree(idArtigo);
    }

    public int calcularCitaçõesDeSegundaOrdem(int idArtigo) {
        int totalCitações = 0;
        for (int citado : digrafo.adj(idArtigo)) {
            totalCitações += digrafo.outdegree(citado);
        }
        return totalCitações;
    }

    public int calcularAutoCitações(int idArtigo) {
        Artigo artigo = artigos.get(idArtigo);
        int autoCitações = 0;
        for (int citado : digrafo.adj(idArtigo)) {
            if (artigo.getAutores().equals(artigos.get(citado).getAutores())) {
                autoCitações++;
            }
        }
        return autoCitações;
    }

    public Iterable<DirectedEdge> calcularCaminhoMaisCurto(int artigo1, int artigo2) {
        EdgeWeightedDigraph grafoPesado = new EdgeWeightedDigraph(digrafo.V());
        for (int v = 0; v < digrafo.V(); v++) {
            for (int w : digrafo.adj(v)) {
                int peso = calcularDiferencaTemporal(artigos.get(v), artigos.get(w));
                grafoPesado.addEdge(new DirectedEdge(v, w, peso));
            }
        }
        DijkstraSP dsp = new DijkstraSP(grafoPesado, artigo1);
        return dsp.pathTo(artigo2);
    }

    private int calcularDiferencaTemporal(Artigo a1, Artigo a2) {
        return Math.abs(a1.getAno() - a2.getAno());
    }

    public Digraph criarSubGrafoPorTipo(String tipo) {
        Digraph subGrafo = new Digraph(digrafo.V());
        for (int v = 0; v < digrafo.V(); v++) {
            Artigo artigo = artigos.get(v);
            if (artigo.getTipoDePublicacao().equals(tipo)) {
                for (int w : digrafo.adj(v)) {
                    if (artigos.get(w).getTipoDePublicacao().equals(tipo)) {
                        subGrafo.addEdge(v, w);
                    }
                }
            }
        }
        return subGrafo;
    }

    public boolean verificarConectidade() {
        for (int i = 0; i < digrafo.V(); i++) {
            if (!isReachableFrom(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isReachableFrom(int v) {
        boolean[] marked = new boolean[digrafo.V()];
        dfs(v, marked);
        for (boolean m : marked) {
            if (!m) return false;
        }
        return true;
    }

    private void dfs(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : digrafo.adj(v)) {
            if (!marked[w]) dfs(w, marked);
        }
    }
}

public static void main(String[] args) {
    // Criar um grafo de artigos com espaço para 100 artigos
    ArtigoGraph artigoGraph = new ArtigoGraph(100);

    // Adicionar alguns artigos
    Artigo artigo1 = new Artigo("Artigo 1", "Palavras-chave 1", "Resumo 1", "Journal", 2010, 100, 10, 5);
    Artigo artigo2 = new Artigo("Artigo 2", "Palavras-chave 2", "Resumo 2", "Journal", 2011, 150, 15, 7);
    Artigo artigo3 = new Artigo("Artigo 3", "Palavras-chave 3", "Resumo 3", "Conference", 2015, 200, 20, 10);
    Artigo artigo4 = new Artigo("Artigo 4", "Palavras-chave 4", "Resumo 4", "Conference", 2017, 250, 25, 15);

    // Adicionar artigos ao grafo
    artigoGraph.adicionarArtigo(artigo1);
    artigoGraph.adicionarArtigo(artigo2);
    artigoGraph.adicionarArtigo(artigo3);
    artigoGraph.adicionarArtigo(artigo4);

    // Adicionar citações entre artigos (exemplo)
    artigoGraph.adicionarCitação(0, 1);
    artigoGraph.adicionarCitação(1, 2);
    artigoGraph.adicionarCitação(2, 3);

    // Listar artigos por Journal e período
    String journalOuConferencia = "Journal";
    int inicio = 2009;
    int fim = 2012;

    List<Artigo> artigosPorJournalEPeriodo = artigoGraph.listarArtigosPorJournalOuConferenciaEPeriodo(journalOuConferencia, inicio, fim);

    // Exibir os artigos encontrados
    for (Artigo artigo : artigosPorJournalEPeriodo) {
        System.out.println("Artigo encontrado: " + artigo.getTitulo() + ", Ano: " + artigo.getAno());
    }
}
