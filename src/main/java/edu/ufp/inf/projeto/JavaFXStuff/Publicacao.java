package edu.ufp.inf.projeto.JavaFXStuff;

public class Publicacao {
  private String nome;
  private String tipo;

  /**
   * Publicação
   * @param nome da Publicação
   * @param tipo da Publicação
   */
  public Publicacao(String nome, String tipo) {
    this.nome = nome;
    this.tipo = tipo;
  }
  // Getters

  /**
   * Get nome da Publicação
   * @return nome da Publicação
   */
  public String getNome() {
    return nome;
  }

  /**
   * Get tipo da Publicação
   * @return tipo da Publicação
   */
  public String getTipo() {
    return tipo;
  }

  // Setters

  /**
   * Set Nome da Publicação
   * @param nome da publicação
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Set Ano da Publicação
   * @param tipo da publicação
   */
  public void setAno(String tipo) {
    this.tipo = tipo;
  }
}