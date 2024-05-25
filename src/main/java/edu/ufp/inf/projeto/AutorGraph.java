package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Bag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutorGraph {
    private Graph grafo;
    private Map<Integer, Autor> autores;
    private Map<Integer, Bag<Integer>> colaboracoes;

    public AutorGraph(int numeroDeAutores) {
        grafo = new Graph(numeroDeAutores);
        autores = new HashMap<>(numeroDeAutores);
        colaboracoes = new HashMap<>(numeroDeAutores);
        for (int i = 0; i < numeroDeAutores; i++) {
            colaboracoes.put(i, new Bag<>());
        }
    }

    public void adicionarAutor(Autor autor) {
        autores.put(autor.getORCID(), autor);
    }

    public void adicionarColaboracao(Autor autor1, Autor autor2) {
        int id1 = autor1.getORCID();
        int id2 = autor2.getORCID();
        if (!colaboracoes.containsKey(id1)) {
            colaboracoes.put(id1, new Bag<>());
        }
        if (!colaboracoes.containsKey(id2)) {
            colaboracoes.put(id2, new Bag<>());
        }
        colaboracoes.get(id1).add(id2);
        colaboracoes.get(id2).add(id1);
        grafo.addEdge(id1, id2);
    }

    public Iterable<Integer> obterColaboradores(int idAutor) {
        return grafo.adj(idAutor);
    }

    public int calcularNumeroDeColaboradores(int idAutor) {
        return grafo.degree(idAutor);
    }

    public boolean verificarConectividade() {
        for (int i = 0; i < grafo.V(); i++) {
            if (!isReachableFrom(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isReachableFrom(int v) {
        boolean[] marked = new boolean[grafo.V()];
        dfs(v, marked);
        for (boolean m : marked) {
            if (!m) return false;
        }
        return true;
    }

    private void dfs(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : grafo.adj(v)) {
            if (!marked[w]) dfs(w, marked);
        }
    }

    // Métodos auxiliares para buscar autores e artigos por suas propriedades
    public Autor buscarAutor(int orcid) {
        return autores.get(orcid);
    }

    public void adicionarArtigos(List<Artigo> artigos) {
        for (Artigo artigo : artigos) {
            for (Autor autor1 : artigo.getAutores()) {
                for (Autor autor2 : artigo.getAutores()) {
                    if (!autor1.equals(autor2)) {
                        adicionarColaboracao(autor1, autor2);
                    }
                }
            }
        }
    }
}
