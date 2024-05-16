package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.RedBlackBST.*;
import edu.princeton.cs.algs4.ST;

import java.util.List;


public class BD implements gestaoAutor,gestaoJournal,gestaoArtigo,gestaoConferencia  {


  RedBlackBST<Double, String> devices = new RedBlackBST<>();
  ST<Double, String> st = new ST();
  public List<Autor> autor;
  public List<Artigo> artigos;
  public List<Conferencia> conferencias;
  public List<Journal> jornais;

  public Integer ArrayList;

  public static void main(String[] args) {

  }

  @Override
  public void addArtigo(Double key, String value) {
      st.put(key,value);
  }

  @Override
  public void deleteArtigo(Double key) {
    st.delete(key);
  }


  @Override
  public Iterable<Double> getArtigo() {
    return st.keys();
  }

  @Override
  public void addAutor(Double key, String value) {
    st.put(key,value);
  }

  @Override
  public void deleteAutor(Double key) {
    st.delete(key);
  }

  @Override
  public Iterable<Double> getAutores() {
    return st.keys();
  }

  @Override
  public void addConferencia(Double key, String value) {
    at.put(key,value);
  }

  /*@Override
  public Node addConferenciaNode(Node node,Double key, String value) {
    devices.put(node,key,value);
    return node;
  }*/

  @Override
  public void deleteConferencia(Double key) {
    devices.delete(key);
  }

 /* @Override
  public Node deleteConferenciaNode(Node h, Double key) {
    devices.delete(h,key);
    return null;
  }*/

  @Override
  public Iterable<Double> getConferencias() {
    return devices.keys();
  }

  @Override
  public void addJournal(Double key, String value) {
    devices.put(key,value);
  }

  /*@Override
  public Node addJournalNode(Node node,Double key, String value) {
    devices.put(node,key,value);
    return node;
  }*/

  @Override
  public void deleteJournal(Double key) {
    devices.delete(key);
  }

 /* @Override
  public Node deleteJournalNode(Node h, Double key) {
    devices.delete(h,key);
    return null;
  }*/

  @Override
  public Iterable<Double> getJournais() {
    return devices.keys();

  }

  //1st attempt
/*  public void deleteCascade(Double key) {

    devices.delete(key);


      artigos.removeIf(artigo -> artigo.getAutor().equals(key));

      artigos.removeIf(artigo -> artigo.getConferencia().equals(key));

    for (Journal journal : jornais) {
      if (journal.getArtigos().contains(key)) {
        journal.getArtigos().remove(key);
      }
    }

    for (Conferencia conferencia : conferencias) {
      if (conferencia.getArtigos().contains(key)) {
        conferencia.getArtigos().remove(key);
      }
    }
*/

  //2nd attempt
public void deleteCascade(Double key) {

  devices.delete(key);

  for (Artigo artigo : artigos) {
    if (artigo.getAutores().equals(key)) {
      artigos.remove(artigo);
    }
  }

  for (Artigo artigo : artigos) {
    if (artigo.getConferencia().equals(key)) {
      artigos.remove(artigo);
    }
  }

  for (Journal journal : jornais) {
    for (Double artigoKey : journal.getArtigos()) {
      if (artigoKey.equals(key)) {
        journal.getArtigos().remove(artigoKey);
        break;
      }
    }
  }

  for (Conferencia conferencia : conferencias) {
    for (Double artigoKey : conferencia.getArtigos()) {
      if (artigoKey.equals(key)) {
        conferencia.getArtigos().remove(artigoKey);
        break;
      }
    }
  }
}

}
