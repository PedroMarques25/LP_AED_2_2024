package edu.ufp.inf.projeto.JavaFXStuff;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.DijkstraSP;
import java.util.ArrayList;
import java.util.List;

public class ArtigoGraph {
    private Digraph digrafo;
    private List<Artigo> artigos;

    /**
     * Set numero de artigos no grafo
     * @param numeroDeArtigos do Artigo
     */
    public ArtigoGraph(int numeroDeArtigos) {
        digrafo = new Digraph(numeroDeArtigos);
        artigos = new ArrayList<>(numeroDeArtigos);
    }

    /**
     * Adicionar Artigo no grafo
     * @param artigo do artigo
     */
    public void adicionarArtigo(Artigo artigo) {
        artigos.add(artigo);
    }

    /**
     * Adicionar citacao no artigo
     * @param artigo1 do primeiro artigo
     * @param artigo2 do segundo artigo
     */
    public void adicionarCitação(int artigo1, int artigo2) {
        digrafo.addEdge(artigo1, artigo2);
    }

    /**
     * Função para listar artigos, journal ou conferencia num dado periodo
     * @param journalOuConferencia do artigo graph
     * @param inicio do artigo graph
     * @param fim do artigo graph
     * @return resultado
     */
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

    /**
     * Calcular citações de Primeira Ordem
     * @param idArtigo do artigo graph
     * @return vertice do grafo
     */
    public int calcularCitaçõesDePrimeiraOrdem(int idArtigo) {
        return digrafo.indegree(idArtigo);
    }

    /**
     * Calcular citações de Segunda Ordem
     * @param idArtigo do artigo graph
     * @return totalCitações
     */
    public int calcularCitaçõesDeSegundaOrdem(int idArtigo) {
        int totalCitações = 0;
        for (int citado : digrafo.adj(idArtigo)) {
            totalCitações += digrafo.outdegree(citado);
        }
        return totalCitações;
    }

    /**
     * calcular AutoCitações
     * @param idArtigo do artigo graph
     * @return autoCitações
     */
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

    /**
     * Calcular o Shortest Path no Grafo
     * @param artigo1 do primeiro artigo do graph
     * @param artigo2 do segundo artigo do graph
     * @return path mais curto
     */
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

    /**
     * Calcular Diferença temporal entre os anos do artigo
     * @param a1 artigo1
     * @param a2 artigo2
     * @return diferença temporal
     */
    private int calcularDiferencaTemporal(Artigo a1, Artigo a2) {
        return Math.abs(a1.getAno() - a2.getAno());
    }

    /**
     * Função para Criar subgrafos por tipo de artigo (journal ou conferencia)
     * @param tipo tipo de grafo
     * @return subGrafo
     */
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

    /**
     * Função que verifica se o vertice tem conectividade no grafo
     * @return false ou true dependendo do resultado da função
     */
    public boolean verificarConectidade() {
        for (int i = 0; i < digrafo.V(); i++) {
            if (!isReachableFrom(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Função que verifica se é alcansável certo vertice no grafo
     * @param v vertice do grafo
     * @return true ou falso com base se é reachable ou nao
     */
    private boolean isReachableFrom(int v) {
        boolean[] marked = new boolean[digrafo.V()];
        dfs(v, marked);
        for (boolean m : marked) {
            if (!m) return false;
        }
        return true;
    }

    /**
     * Algoritmo DFS
     * @param v vertice
     * @param marked marked
     */
    private void dfs(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : digrafo.adj(v)) {
            if (!marked[w]) dfs(w, marked);
        }
    }
}
