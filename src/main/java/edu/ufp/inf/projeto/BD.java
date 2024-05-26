package edu.ufp.inf.projeto;
import java.io.*;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.RedBlackBST.*;
import edu.princeton.cs.algs4.ST;
import edu.ufp.inf.lp2._01_intro.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BD {
  private Map<Integer, Autor> autores;
  private Map<String, Artigo> artigos;
  private Map<String, Publicacao> publicacoes;
  private Map<String, Journal> journais;
  private Map<String, Conferencia> conferencias;

  public BD() {
    this.autores = new HashMap<>();
    this.artigos = new HashMap<>();
    this.publicacoes = new HashMap<>();
    this.journais = new HashMap<>();
    this.conferencias = new HashMap<>();
  }

  // Adiciona um autor à base de dados
  public void adicionarAutor(Autor autor) {
    autores.put(autor.getORCID(), autor);
  }

  // Adiciona um artigo à base de dados
  public void adicionarArtigo(Artigo artigo) {
    artigos.put(artigo.getTitulo(), artigo);
  }

  // Adiciona uma publicação à base de dados

  public void adicionarJournal(Journal journal) {
    publicacoes.put(journal.getNome(), journal);
    journais.put(journal.getNome(), journal);
  }

  public void adicionarConferencia(Conferencia conferencia) {
    publicacoes.put(conferencia.getNome(), conferencia);
    conferencias.put(conferencia.getNome(), conferencia);
  }

  // Remove um autor da base de dados
  public void removerAutor(String orcid) {
    Autor autor = autores.remove(orcid);
    if (autor != null) {
      for (Artigo artigo : autor.getArtigos()) {
        artigo.removerAutor(autor);
      }
    }
  }

  // Remove um artigo da base de dados
  public void removerArtigo(String titulo) {
    Artigo artigo = artigos.remove(titulo);
    if (artigo != null) {
      for (Autor autor : artigo.getAutores()) {
        autor.removerArtigo(artigo);
      }
      for (Artigo referencia : artigo.getReferencias()) {
        referencia.removerReferencia(artigo);
      }
      for (Artigo a : artigos.values()) {
        a.removerReferencia(artigo);
      }
    }
  }

  private void gravarAutorRemovido(Autor autor) {
    String filename = "autores_removidos.txt"; // Nome do ficheiro onde os autores serão armazenados

    try (FileWriter fw = new FileWriter(filename, true);
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter out = new PrintWriter(bw)) {
      // Escreve a representação do autor no ficheiro
      out.println(autor.toString());
    } catch (IOException e) {
      System.err.println("Erro ao gravar autor removido: " + e.getMessage());
    }
  }

  public void removerAutorParaFicheiro(int orcid) {
    Autor autor = autores.remove(orcid);
    if (autor != null) {
      // Grava o autor removido no ficheiro
      gravarAutorRemovido(autor);

      for (Artigo artigo : autor.getArtigos()) {
        artigo.removerAutor(autor);
      }
    }
  }

  public Conferencia removerConferenciaParaFicheiro(String nome) {
    Conferencia conferencia = conferencias.remove(nome);
    if (conferencia != null) {
      String filename = "conferencias_removidas.txt";
      try (FileWriter fw = new FileWriter(filename, true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter out = new PrintWriter(bw)) {
        out.println(conferencia.toString());
      } catch (IOException e) {
        System.err.println("Erro ao gravar conferencia removida: " + e.getMessage());
      }
    }
      return conferencia;
  }

  public Journal removerJournalParaFicheiro(String JCR_IF) {
    Journal journal = journais.remove(JCR_IF);
    if (journal != null) {
      String filename = "journals_removidos.txt";
      try (FileWriter fw = new FileWriter(filename, true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter out = new PrintWriter(bw)) {
        out.println(journal.toString());
      } catch (IOException e) {
        System.err.println("Erro ao gravar journal removido: " + e.getMessage());
      }
    }
      return journal;
  }

   // Remove uma publicação da base de dados
  public void removerConferencia(String nome) {
    conferencias.remove(nome);
    publicacoes.remove(nome);
  }

  public void removerJournal(String nome) {
    journais.remove(nome);
    publicacoes.remove(nome);
  }

  public Autor buscarAutor(String orcid) {
    return autores.get(orcid);
  }

  public Artigo buscarArtigo(String titulo) {
    return artigos.get(titulo);
  }

  public Conferencia buscarConferencia(String nome) {
    return conferencias.get(nome);
  }

  public Journal buscarJournal(String nome) {
    return journais.get(nome);
  }

  public List<Artigo> buscarArtigosPorAutorEPeriodo(String orcid, int anoInicio, int anoFim) {
    List<Artigo> artigosEncontrados = new ArrayList<>();
    Autor autor = buscarAutor(orcid);
    if (autor != null) {
      for (Artigo artigo : autor.getArtigos()) {
        if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
          artigosEncontrados.add(artigo);
        }
      }
    }
    return artigosEncontrados;
  }

  public List<Artigo> buscarArtigos(int anoInicio, int anoFim) {
    List<Artigo> artigosEncontrados = new ArrayList<>();

    for (Artigo artigo : artigos.values()) {
      if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim && artigo.getNumDownloads() == 0 && artigo.getNumViewspDia() == 0) {
        artigosEncontrados.add(artigo);
      }
    }
    return artigosEncontrados;
  }

  public List<Autor> buscarAutoresQueCitaramArtigosEPeriodo(List<String> titulosArtigos, int anoInicio, int anoFim) {
    List<Autor> autoresEncontrados = new ArrayList<>();
    for (Artigo artigo : artigos.values()) {
      if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
        for (Artigo referencia : artigo.getReferencias()) {
          if (titulosArtigos.contains(referencia.getTitulo())) {
            autoresEncontrados.addAll(artigo.getAutores());
            break;
          }
        }
      }
    }
    return autoresEncontrados;
  }

  // Função para buscar as citações de todos os artigos de um journal para um determinado período
  public List<Artigo> buscarCitaçõesDeJournalPeriodo(String journalName, int anoInicio, int anoFim) {
    List<Artigo> citacoes = new ArrayList<>();

    Journal journal = buscarJournal(journalName);

    if (journal != null) {
      for (Artigo artigo : journal.getArtigos()) {
        if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim) {
            citacoes.addAll(artigo.getReferencias());
        }
      }
    }
    return citacoes;
  }
  public void gerarRelatorioAutores() {
    System.out.println("Relatório de Autores:");
    for (Autor autor : autores.values()) {
      System.out.println("Nome: " + autor.getNome());
      System.out.println("Afiliacao: " + autor.getFiliacao());
      System.out.println("ORCID: " + autor.getORCID());
      System.out.println("Número de Artigos: " + autor.getArtigos().size());
      for (Artigo artigos : autor.getArtigos()) {
        System.out.print(artigos.getTitulo() + " ");
      }
      System.out.println();
      System.out.println("-------------------------");
    }
    System.out.println("Relatório de Artigos:");
    for (Artigo artigo : artigos.values()) {
      System.out.println("Título: " + artigo.getTitulo());
      System.out.println("Ano: " + artigo.getAno());
      System.out.println("Tipo de Publicação: " + artigo.getTipoDePublicacao());
      System.out.println("Número de Downloads: " + artigo.getNumDownloads());
      System.out.println("Número de Visualizações: " + artigo.getNumViewspDia());
      System.out.println("Número de Likes: " + artigo.getNumLikespDia());
      System.out.println("Número de Likes: " + artigo.getID());
      System.out.print("Autores: ");
      for (Autor autor : artigo.getAutores()) {
        System.out.print(autor.getNome() + " ");
      }
      System.out.println();
      for (Artigo artigos : artigo.getReferencias()) {
        System.out.print(artigos.getTitulo() + " ");
      }
      System.out.println();
      System.out.println("-------------------------");
    }
    System.out.println("Relatório de Journais:");
    for (Journal journais : journais.values()) {
      System.out.println("Nome: " + journais.getNome());
      System.out.println("Tipo: " + journais.getPublisher());
      for (Artigo artigos : journais.getArtigos()) {
        System.out.print(artigos.getTitulo() + " ");
      }
      System.out.println("-------------------------");
    }
    System.out.println("Relatório de Conferencias:");
    for (Conferencia conferencias : conferencias.values()) {
      System.out.println("Nome: " + conferencias.getNome());
      System.out.println("Tipo: " + conferencias.getLocal());
      for (Artigo artigos : conferencias.getArtigos()) {
        System.out.print(artigos.getTitulo() + " ");
      }
      System.out.println("-------------------------");
    }

  }
}

