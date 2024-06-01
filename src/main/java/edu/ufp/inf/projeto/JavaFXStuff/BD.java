package edu.ufp.inf.projeto.JavaFXStuff;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BD implements gestaoAutor, gestaoConferencia, gestaoArtigo, gestaoJournal {
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

  @Override
  /*
   * Adiciona um autor à base de dados
   */
  public void adicionarAutor(Autor autor) {
    autores.put(autor.getORCID(), autor);
  }


  @Override
  /*
   * // Adiciona um artigo à base de dados
   */
  public void adicionarArtigo(Artigo artigo) {
    artigos.put(artigo.getTitulo(), artigo);
  }

  /*
   * Adiciona um artigo à base de dados
   */
@Override
  public void adicionarJournal(Journal journal) {
    publicacoes.put(journal.getNome(), journal);
    journais.put(journal.getNome(), journal);
  }
@Override
/*
 * Adicionar conferencia
 */
  public void adicionarConferencia(Conferencia conferencia) {
    publicacoes.put(conferencia.getNome(), conferencia);
    conferencias.put(conferencia.getNome(), conferencia);
  }

  /*
   * Remove um autor da base de dados
   */
  @Override
  public void removerAutor(String orcid) {
    Autor autor = autores.remove(orcid);
    if (autor != null) {
      for (Artigo artigo : autor.getArtigos()) {
        artigo.removerAutor(autor);
      }
    }
  }

  /*
   * Remove um autor da base de dados
   */
  @Override
  public void removerArtigo(String titulo) {
    Artigo artigo = artigos.remove(titulo);
    if (artigo != null) {
      for (Autor autor : artigo.getAutores()) {
        autor.removerArtigo(artigo);
      }
      for (Artigo referencia : artigo.getReferencias()) {
        referencia.removerReferencia(artigo);
      }
    }
  }
/*
 * Gravar autor removido para ficheiro
 */
  public void gravarAutorRemovido(Autor autor) {
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
  /*
   * Remover autor removido para ficheiro
   */
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

  /**
   * Remover Conferencia para o ficheiro
   * @param nome da conferencia
   * @return conferencia
   */
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

  /**
   * Remover Journal para o Ficheiro
   * @param JCR_IF do Journal
   * @return journal
   */
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

   /*
    * Remove uma publicação da base de dados
    */
  public void removerConferencia(String nome) {
    conferencias.remove(nome);
    publicacoes.remove(nome);
  }
/*
 * Remover Journal da BD
 */
  public void removerJournal(String nome) {
    journais.remove(nome);
    publicacoes.remove(nome);
  }

  /**
   * Buscar Autor
   * @param orcid Autor
   * @return ORCID Autor
   */
  public Autor buscarAutor(String orcid) {
    return autores.get(orcid);
  }

  /**
   * Buscar Artigo
   * @param titulo do artigo
   * @return get titulo do artigo
   */
  public Artigo buscarArtigo(String titulo) {
    return artigos.get(titulo);
  }

  /**
   * Buscar Conferencia
   * @param nome da conferencia
   * @return nome da conferencia
   */
  public Conferencia buscarConferencia(String nome) {
    return conferencias.get(nome);
  }

  /**
   * Buscar Journal
   * @param nome do Journal
   * @return Nome do Journal
   */
  public Journal buscarJournal(String nome) {
    return journais.get(nome);
  }

  /**
   * Buscar Artigos por Autor e Periodo
   * @param orcid do artigo
   * @param anoInicio do artigo
   * @param anoFim do artigo
   * @return artigosEncontrados
   */
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

  /**
   * Buscar Artigos entre um dado Periodo
   * @param anoInicio do artigo
   * @param anoFim do artigo
   * @return artigosEncontrados
   */
  public List<Artigo> buscarArtigos(int anoInicio, int anoFim) {
    List<Artigo> artigosEncontrados = new ArrayList<>();

    for (Artigo artigo : artigos.values()) {
      if (artigo.getAno() >= anoInicio && artigo.getAno() <= anoFim && artigo.getNumDownloads() == 0 && artigo.getNumViewspDia() == 0) {
        artigosEncontrados.add(artigo);
      }
    }
    return artigosEncontrados;
  }

  /**
   *
   * @return lista dos autores
   */
  public List<Autor> getAllAutores() {
    return new ArrayList<>(autores.values());
  }

  /**
   *
   * @return lista dos artigos
   */
  public List<Artigo> getAllArtigos() {
    return new ArrayList<>(artigos.values());
  }

  /**
   * Get top3 Artigos Mais Visualizados
   * @return Lista de artigos
   */
  public List<Artigo> getTop3ArtigosMaisVisualizados() {
    return artigos.values().stream()
            .sorted((a1, a2) -> Integer.compare(a2.getNumViewspDia(), a1.getNumViewspDia()))
            .limit(3)
            .collect(Collectors.toList());
  }
  /*
   * Gerar report
   */
  public void gerarRelatorio() {
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

