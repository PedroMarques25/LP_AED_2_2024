package edu.ufp.inf.projeto;

public class Publicacao {
  private String nome;
  private String tipo;
  public Publicacao(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }
  // Getters
  public String getNome() {
    return nome;
  }

  public String getTipo() {
    return tipo;
  }

  // Setters
  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setAno(String tipo) {
    this.tipo = tipo;
  }
}