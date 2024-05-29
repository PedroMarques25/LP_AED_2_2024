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

    public List<Artigo> listarArtigosPorJournalOuConferenciaEPeriodo(String journalOuConferencia, int inicio, int fim) {
        List<Artigo> result = new ArrayList<>();
        for (Artigo artigo : Artigo.getArtigos()) {
            if (artigo.getTipoDePublicacao().equals(journalOuConferencia) &&
                    artigo.getAno() >= inicio && artigo.getAno() <= fim) {
                result.add(artigo);
            }
        }
        return result;
    }

    public int calcularCitaçõesDePrimeiraOrdem(int idArtigo) {
        return digrafo.indegree(idArtigo);
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
