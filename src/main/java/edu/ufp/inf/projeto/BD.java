package edu.ufp.inf.projeto;
import java.io.*;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.RedBlackBST.*;
import edu.princeton.cs.algs4.ST;

import java.util.HashMap;
import java.util.Map;

public class BD {
  private Map<Integer, Autor> autores;
  private Map<String, Artigo> artigos;
  private Map<String, Publicacao> publicacoes;

  public BD() {
    this.autores = new HashMap<>();
    this.artigos = new HashMap<>();
    this.publicacoes = new HashMap<>();
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
  public void adicionarPublicacao(Publicacao publicacao) {
    publicacoes.put(publicacao.getNome(), publicacao);
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
  public void removerPublicacao(String nome) {
    publicacoes.remove(nome);
  }

  public Autor buscarAutor(String orcid) {
    return autores.get(orcid);
  }

  public Artigo buscarArtigo(String titulo) {
    return artigos.get(titulo);
  }

  public Publicacao buscarPublicacao(String nome) {
    return publicacoes.get(nome);
  }
}