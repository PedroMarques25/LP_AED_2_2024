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
      devices.put(key,value);
  }

  @Override
  public Node addArtigoNode(Node node,double key, String value) {
      devices.put(node,key,value);
      return node;
  }

  @Override
  public void deleteArtigo(double key) {
    devices.delete(key);
  }

  @Override
  public Node deleteArtigoNode(Node h, double key) {
    devices.delete(h,key);
    return null;
  }

  @Override
  public Iterable<Double> getArtigo() {
    return devices.keys();
  }

  @Override
  public void addAutor(Double key, String value) {
    devices.put(key,value);
  }

  @Override
  public Node addAutorNode(Node node,double key, String value) {
    devices.put(node,key,value);
    return node;
  }

  @Override
  public void deleteAutor(double key) {
    devices.delete(key);
  }

  @Override
  public Node deleteAutorNode(Node h, double key) {
    devices.delete(h,key);
    return null;
  }

  @Override
  public Iterable<Double> getAutores() {
    return devices.keys();
  }

  @Override
  public void addConferencia(Double key, String value) {
    devices.put(key,value);
  }

  @Override
  public Node addConferenciaNode(Node node,double key, String value) {
    devices.put(node,key,value);
    return node;
  }

  @Override
  public void deleteConferencia(double key) {
    devices.delete(key);
  }

  @Override
  public Node deleteConferenciaNode(Node h, double key) {
    devices.delete(h,key);
    return null;
  }

  @Override
  public Iterable<Double> getConferencias() {
    return devices.keys();
  }

  @Override
  public void addJournal(Double key, String value) {
    devices.put(key,value);
  }

  @Override
  public Node addJournalNode(Node node,double key, String value) {
    devices.put(node,key,value);
    return node;
  }

  @Override
  public void deleteJournal(double key) {
    devices.delete(key);
  }

  @Override
  public Node deleteJournalNode(Node h, double key) {
    devices.delete(node,key);
    return null;
  }

  @Override
  public Iterable<Double> getJournais() {
    return devices.keys();

  }
}
