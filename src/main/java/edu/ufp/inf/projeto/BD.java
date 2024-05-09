package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import org.w3c.dom.Node;

import java.util.List;

public class BD implements gestaoAutor,gestaoJournal,gestaoArtigo,gestaoConferencia{

  ST<Double, String> st = new ST();
  RedBlackBST<Double, String> devices = new RedBlackBST();

  public Integer ArrayList;

  public static void main(String[] args) {

  }

  @Override
  public void addArtigo(Double key, String value) {

  }

  @Override
  public void addArtigoNode(double key, String value) {

  }

  @Override
  public void deleteArtigo(double key) {

  }

  @Override
  public Node deleteArtigoNode(Node h, double key) {
    return null;
  }

  @Override
  public Iterable<Double> getArtigo() {
    return null;
  }

  @Override
  public void addAutor(Double key, String value) {

  }

  @Override
  public void addAutorNode(double key, String value) {

  }

  @Override
  public void deleteAutor(double key) {

  }

  @Override
  public Node deleteAutorNode(Node h, double key) {
    return null;
  }

  @Override
  public Iterable<Double> getAutores() {
    return null;
  }

  @Override
  public void addConferencia(Double key, String value) {

  }

  @Override
  public void addConferenciaNode(double key, String value) {

  }

  @Override
  public void deleteConferencia(double key) {

  }

  @Override
  public Node deleteConferenciaNode(Node h, double key) {
    return null;
  }

  @Override
  public Iterable<Double> getConferencias() {
    return null;
  }

  @Override
  public void addJournal(Double key, String value) {

  }

  @Override
  public void addJournalNode(double key, String value) {

  }

  @Override
  public void deleteJournal(double key) {

  }

  @Override
  public Node deleteJournalNode(Node h, double key) {
    return null;
  }

  @Override
  public Iterable<Double> getJournais() {
    return null;
  }
}
