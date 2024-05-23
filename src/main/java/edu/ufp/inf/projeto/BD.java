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
  private RedBlackBST<String, Publicacao> publicacoes;
  private RedBlackBST<String, Journal> journais;
  private RedBlackBST<String, Conferencia> conferencias;

  public BD() {
    this.autores = new HashMap<>();
    this.artigos = new HashMap<>();
    this.publicacoes = new RedBlackBST<>();
    this.journais = new RedBlackBST<>();
    this.conferencias = new RedBlackBST<>();
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

  // Remove uma publicação da base de dados
  public void removerConferencia(String nome) {
    conferencias.delete(nome);
    publicacoes.delete(nome);
  }

  public void removerJournal(String nome) {
    journais.delete(nome);
    publicacoes.delete(nome);
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
}

