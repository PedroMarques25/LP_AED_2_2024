package edu.ufp.inf.projeto;

import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import org.w3c.dom.Node;

import java.util.List;

public class BD implements gestãoSTI,gestãoRedBlack{

  ST<Double, String> st = new ST();
  RedBlackBST<Double, String> devices = new RedBlackBST();

  public Integer ArrayList;

  public static void main(String[] args) {

  }

  @Override
  public void addKeyST(Double key, String value) {
    st.put(key,value);
  }
  @Override
  public String getKey(Double key) {
    return st.get(key);
  }
  @Override
  public void removeKey(Double key) {
    st.remove(key);
  }
  @Override
  public boolean containsKey(Double key) {
    return st.contains(key);
  }
  @Override
  public int getSize() {
    return st.size();
  }
  @Override
  public Iterable<Double> getKeys() {
    return st.keys();
  }
  @Override
  public void addDataRB(Double key, String value) {
    devices.put(key, value);
  }
  @Override
  public void addNode(double key,String value) {

  }
  @Override
  public org.w3c.dom.Node put(org.w3c.dom.Node h, double key, String value) {
    return h;
  }
  @Override
  public void delete(double key) {
     devices.delete(key);
  }
  @Override
  public Node delete(Node h, double key) {
    return null;
  }
  public Iterable<Double> getKeysBST() {
    return devices.keys();
  }
}
