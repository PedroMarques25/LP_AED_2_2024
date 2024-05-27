package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.CC;
import java.util.ArrayList;
import java.util.List;

public class AutorGraphTeste {

    public static void main(String[] args) {
        // Criar instância do GrafoDeAutores com um número inicial de autores
        AutorGraph grafo = new AutorGraph(5);

        // Adicionar alguns autores

        Autor autor1 = new Autor("Autor 1", "1", "Instituição A",2,3,4,1);
        Autor autor2 = new Autor("Autor 3", "3", "Instituição B",4,5,6,3);
        Autor autor3 = new Autor("Autor 2", "2", "Instituição B",3,4,5,2);
        Autor autor4 = new Autor("Autor 4", "4", "Instituição C",5,6,7,4);
        Autor autor5 = new Autor("Autor 5", "5", "Instituição C",6,7,8,5);

        // Adicionar autores ao grafo
        grafo.adicionarAutor(autor1);
        grafo.adicionarAutor(autor2);
        grafo.adicionarAutor(autor3);
        grafo.adicionarAutor(autor4);
        grafo.adicionarAutor(autor5);

        // Criar artigos e associar aos autores
        Artigo artigo1 = new Artigo("Artigo 1", "Journal", "?", "journal", 2021, 2, 3, 4,1);
        Artigo artigo2 = new Artigo("Artigo 2", "Conferencia", "?", "conferencia", 2021, 3, 4, 5,2);
        Artigo artigo3 = new Artigo("Artigo 3", "Journal", "?", "journal", 2022, 4, 5, 6,3);
        Artigo artigo4 = new Artigo("Artigo 4", "Conferencia", "?", "conferencia", 2023, 5, 6, 7,4);
        Artigo artigo5 = new Artigo("Artigo 5", "Conferencia", "?", "conferencia", 2023, 5, 6, 7,5);
        // Adicionar artigos ao grafo
        grafo.adicionarArtigo(artigo1);
        grafo.adicionarArtigo(artigo2);
        grafo.adicionarArtigo(artigo3);
        grafo.adicionarArtigo(artigo4);
        grafo.adicionarArtigo(artigo5);

        // Adicionar algumas coautorias
        grafo.adicionarCoautoria(1, 2); // Autor 1 e Autor 2
        grafo.adicionarCoautoria(2, 3); // Autor 2 e Autor 3
        grafo.adicionarCoautoria(3, 4); // Autor 3 e Autor 4
        grafo.adicionarCoautoria(4, 5); // Autor 4 e Autor 5
        grafo.adicionarCoautoria(4, 1); // Autor 5 e Autor 1

        // Testar listar autores por instituições
        List<Autor> autoresInstituicaoA = grafo.listarAutoresPorInstituicoes(new String[]{"Instituição A"});
        System.out.println("Autores da Instituição A: " + autoresInstituicaoA);

        // Testar calcular colaboradores
        int colaboradoresAutor1 = grafo.calcularColaboradores(1); // Esperado: 2
        System.out.println("Número de colaboradores do Autor 1: " + colaboradoresAutor1);

        // Testar calcular artigos escritos entre dois autores
        int artigosEntreAutor1EAutor2 = grafo.calcularArtigosEscritosEntreAutores(1, 2); // Esperado: 1
        System.out.println("Número de artigos escritos entre Autor 1 e Autor 2: " + artigosEntreAutor1EAutor2);

        // Testar calcular caminho mais curto entre dois autores
        List<Integer> caminhoMaisCurto = grafo.calcularCaminhoMaisCurto(1, 3); // Esperado:  1 -> 2 -> 3
        System.out.print("Caminho mais curto entre Autor 1 e Autor 3: ");
        for (int v : caminhoMaisCurto) {
            System.out.print(v + " ");
        }
        System.out.println();

        // Testar criar subgrafo por instituições
        Graph subGrafo = grafo.criarSubGrafoPorInstituicoes(new String[]{"Instituição A"});
        System.out.println("Subgrafo por Instituição A criado.");

        // Testar verificar conexidade do grafo principal
        boolean conexo = grafo.verificarConexidade(grafo.getGrafo());
        System.out.println("O grafo principal é conexo? " + conexo);

        // Testar autores que citaram artigos

        List<Autor> autoresCitadores = grafo.autoresQueCitaramArtigos(List.of(artigo1,artigo2,artigo3), 2020, 2024);
        System.out.println("Autores que citaram artigos entre 2022-01-01 e 2022-12-31: " + autoresCitadores);

        // Testar listar citações de artigos por journal e período
        //List<Artigo> artigosCitados = grafo.listarCitaçõesDeArtigosPorJournalEPeriodo(artigo3, 2020, 2024);
        //System.out.println("Artigos citados do Journal 1 entre 2022-01-01 e 2022-12-31: " + artigosCitados);
    }
}
