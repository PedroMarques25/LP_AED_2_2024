package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.BreadthFirstPaths;

import java.util.*;

public class AutorGraph {
    private Graph grafo;
    private Map<Integer, Autor> autores;
    private Map<Integer, Bag<Integer>> colaboracoes;
    private List<Artigo> artigos; // Presumindo que artigos seja um List<Artigo>
    private Map<String, Integer> colaboracoesArtigos = new HashMap<>();

    public AutorGraph(int numeroDeAutores) {
        grafo = new Graph(numeroDeAutores);
        autores = new HashMap<>(numeroDeAutores);
        colaboracoes = new HashMap<>(numeroDeAutores);
        artigos = new ArrayList<>();
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

        adicionarColaboracaoArtigo(autor1, autor2);
    }

    private void adicionarColaboracaoArtigo(Autor autor1, Autor autor2) {
        String chave = autor1.getORCID() + "-" + autor2.getORCID();
        colaboracoesArtigos.put(chave, colaboracoesArtigos.getOrDefault(chave, 0) + 1);
    }

    public Iterable<Integer> obterColaboradores(int idAutor) {
        return grafo.adj(idAutor);
    }

    public int calcularNumeroDeColaboradores(int idAutor) {
        return grafo.degree(idAutor);
    }

    public int calcularNumeroDeArtigosEntreAutores(int idAutor1, int idAutor2) {
        String chave = idAutor1 + "-" + idAutor2;
        return colaboracoesArtigos.getOrDefault(chave, 0);
    }

    public int calcularCaminhoMaisCurto(int idAutor1, int idAutor2) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(grafo, idAutor1);
        return bfs.distTo(idAutor2);
    }

    public AutorGraph criarSubGrafoPorInstituicoes(List<String> instituicoes) {
        Set<Integer> vertices = new HashSet<>();
        for (Autor autor : autores.values()) {
            if (instituicoes.contains(autor.getFiliacao())) {
                vertices.add(autor.getORCID());
            }
        }

        AutorGraph subGrafo = new AutorGraph(vertices.size());
        for (int v : vertices) {
            for (int w : grafo.adj(v)) {
                if (vertices.contains(w)) {
                    subGrafo.adicionarColaboracao(autores.get(v), autores.get(w));
                }
            }
        }
        return subGrafo;
    }

    public boolean verificarConectividade() {
        if (grafo.V() == 0) {
            return true; // Grafo vazio é considerado conectado
        }
        boolean[] marcado = new boolean[grafo.V()];
        dfs(0, marcado); // Inicia a busca a partir do primeiro vértice
        for (boolean visitado : marcado) {
            if (!visitado) {
                return false; // Se algum vértice não foi visitado, o grafo não é conectado
            }
        }
        return true; // Todos os vértices foram visitados, o grafo é conectado
    }

    private void dfs(int v, boolean[] marcado) {
        marcado[v] = true;
        for (int w : grafo.adj(v)) {
            if (!marcado[w]) {
                dfs(w, marcado);
            }
        }
    }

    public List<Autor> listarAutoresPorInstituicoes(List<String> instituicoes, boolean combinarOperadores) {
        List<Autor> resultado = new ArrayList<>();
        for (Autor autor : autores.values()) {
            if (combinarOperadores && instituicoes.contains(autor.getFiliacao()) ||
                    !combinarOperadores && !Collections.disjoint(autor.getFiliacao(), instituicoes)) {
                resultado.add(autor);
            }
        }
        return resultado;
    }

    public void adicionarArtigos(List<Artigo> artigos) {
        this.artigos.addAll(artigos); // Adiciona os artigos à lista interna
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

    public List<Artigo> listarCitaçõesPorJournalEPeriodo(String journal, int inicio, int fim) {
        List<Artigo> resultado = new ArrayList<>();
        for (Artigo artigo : artigos) { // Assumindo que artigos é um List<Artigo>
            if (artigo.getTipoDePublicacao().equals(journal) && artigo.getAno() >= inicio && artigo.getAno() <= fim) {
                resultado.add(artigo);
            }
        }
        return resultado;
    }

    // Métodos auxiliares para buscar autores e artigos por suas propriedades
    public Autor buscarAutor(int orcid) {
        return autores.get(orcid);
    }
}
