package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Graph;
import java.util.ArrayList;
import java.util.List;

public class AutorGraph {
    private List<Autor> autores;
    private List<Artigo> artigos;
    private Graph grafo;

    public AutorGraph(int numAutores) {
        autores = new ArrayList<>(numAutores);
        artigos = new ArrayList<>();
        grafo = new Graph(numAutores);
    }

    public void adicionarAutor(Autor autor) {
        autores.add(autor);
    }

    public void adicionarArtigo(Artigo artigo) {
        artigos.add(artigo);
        for (Autor autor : artigo.getAutores()) {
            autor.getArtigos().add(artigo);
        }
    }

    public void adicionarCoautoria(int idAutor1, int idAutor2) {
        grafo.addEdge(idAutor1, idAutor2);
    }

    public List<Autor> listarAutoresPorInstituicoes(String[] Filiacao) {
        List<Autor> resultado = new ArrayList<>();
        for (Autor autor : autores) {
            for (String instituicao : Filiacao) {
                if (autor.getFiliacao().contains(instituicao)) {
                     resultado.add(autor);
                    }
                }
            }
        return resultado;
    }

    public int calcularColaboradores(int idAutor) {
        return grafo.degree(idAutor);
    }

    public int calcularArtigosEscritosEntreAutores(int idAutor1, int idAutor2) {
        Autor autor1 = autores.get(idAutor1);
        Autor autor2 = autores.get(idAutor2);
        int contagem = 0;

        for (Artigo artigo : autor1.getArtigos()) {
            if (artigo.getAutores().contains(autor2)) {
                contagem++;
            }
        }

        return contagem;
    }

    public List<Integer> calcularCaminhoMaisCurto(int idAutor1, int idAutor2) {
        BreadthFirstPaths bfs = new BreadthFirstPaths(grafo, idAutor1);
        List<Integer> caminho = new ArrayList<>();
        for (int v : bfs.pathTo(idAutor2)) {
            caminho.add(v);
        }
        return caminho;
    }

    public Graph criarSubGrafoPorInstituicoes(String[] filiacoes) {
        Graph subGrafo = new Graph(grafo.V());
        for (int v = 0; v < grafo.V(); v++) {
            Autor autor = autores.get(v);
            for (String instituicao : filiacoes) {
                if (autor.getFiliacao().contains(instituicao)) {
                    for (int w : grafo.adj(v)) {
                        if (autores.get(w).getFiliacao().contains(instituicao)) {
                            subGrafo.addEdge(v, w);
                        }
                    }
                    break;
                }
            }
        }
        return subGrafo;
    }

    public boolean verificarConexidade(Graph g) {
        CC cc = new CC(g);
        return cc.count() == 1;
    }

    public List<Autor> autoresQueCitaramArtigos(List<Artigo> Artigos, int inicio, int fim) {
        List<Autor> autoresCitadores = new ArrayList<>();
        for (Autor autor : autores) {
            for (Artigo artigo : autor.getArtigos()) {
                if (artigo.getAno() >= inicio && artigo.getAno() <= fim) {
                    for (Artigo Artigo : Artigos) {
                        if (Artigo.getReferencias() == Artigos) {
                                autoresCitadores.add(autor);
                        }
                    }
                }
            }
        }
        return autoresCitadores;
    }

    public List<Artigo> listarCitaçõesDeArtigosPorJournalEPeriodo(Journal journal, int inicio, int fim) {
        List<Artigo> artigosCitados = new ArrayList<>();
        for (Artigo journais : journal.getArtigos()) {
            if (journais.getAno() >= inicio &&
                    journais.getAno() <= fim) {
                artigosCitados.addAll(journais.getReferencias());
            }
        }
        return artigosCitados;
    }

    public Graph getGrafo() {
        return grafo;
    }
}



