package edu.ufp.inf.projeto.JavaFXStuff;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia extends Publicacao {
  private int numEdicao;
  private String nome;
  private String local;
  private Date dataInicio;
  private Date dataFim;
  private List<Artigo> artigos;

  // Lista estática de conferencias
  private static List<Conferencia> conferencias = new ArrayList<>();
  public Conferencia (int numEdicao, String local, Date dataInicio, Date dataFim,String nome,String tipo) {

    super(nome,tipo);
    this.setNome(nome);
    this.setNumEdicao(numEdicao);
    this.setLocal(local);
    this.setDataInicio(dataInicio);
    this.setDataFim(dataFim);
    this.artigos = new ArrayList<>();
  }
  // Getters

  /**
   * GetNumEdicao da conferencia
   * @return do numEdicao
   */
  public int getNumEdicao() {
    return numEdicao;
  }

  /**
   * getLocal da conferencia
   * @return local da conferencia
   */
  public String getLocal() {
    return local;
  }

  /**
   * getDataInicio da conferencia
   * @return da dataInicio da conferencia
   */
  public Date getDataInicio() {
    return dataInicio;
  }

  /**
   * getDataFim da conferencia
   * @return dataFim da conferencia
   */
  public Date getDataFim() {
    return dataFim;
  }

  /**
   * getNome da conferencia
   * @return nome da conferencia
   */
  public String getNome(){
    return nome;
  }

  // Setters

  /**
   * setNumEdicao da conferencia
   * @param numEdicao da conferencia
   */
  public void setNumEdicao(int numEdicao) {
    this.numEdicao = numEdicao;
  }

  /**
   * setLocal da Conferencia
   * @param local da conferencia
   */
  public void setLocal(String local) {
    this.local = local;
  }

  /**
   * setDataInicio da conferencia
   * @param dataInicio da conferencia
   */
  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  /**
   * setDataFim da conferencia
   * @param dataFim da conferencia
   */
  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  /**
   * Listar artigos
   * @return artigos
   */
  public List<Artigo> getArtigos() {
    return artigos;
  }

  /**
   * Adicionar artigo a conferencia
   * @param artigo da conferencia
   */
  public void adicionarArtigo(Artigo artigo) {
    artigos.add(artigo);
  }

  /**
   * Remover Artigo da conferencia
   * @param artigo da conferencia
   */
  public void removerArtigo(Artigo artigo) {
    artigos.remove(artigo);
  }

  /**
   * setNome da conferencia
   * @param nome da conferencia
   */
  public void setNome(String nome){
    this.nome = nome;
  }

  /**
   * Métodos para adicionar
   * @param numEdicao da conferencia
   * @param local da conferencia
   * @param dataInicio da conferencia
   * @param dataFim da conferencia
   * @param nome da conferencia
   * @param tipo da conferencia
   * @return conferencia
   */
  public static Conferencia adicionarConferencia(int numEdicao, String local, Date dataInicio, Date dataFim,String nome,String tipo) {
    Conferencia conferencia = new Conferencia(numEdicao,  local,  dataInicio, dataFim,nome,tipo);
    conferencias.add(conferencia);
    return conferencia;
  }

  /**
   * Remover a conferencia
   * @param conferencia c
   */
  public static void removerConferencia(Conferencia conferencia) {
    conferencias.remove(conferencia);
  }

  /**
   *  atualizar conferencias
   * @param numEdicao da conferencia
   * @param local da conferencia
   * @param dataInicio da conferencia
   * @param dataFim da conferencia
   */
  public void atualizarConferencia(int numEdicao, String local, Date dataInicio, Date dataFim) {
    this.setNumEdicao(numEdicao);
    this.setLocal(local);
    this.setDataInicio(dataInicio);
    this.setDataFim(dataFim);
  }

  /**
   * Método para obter a lista de conferencias (opcional)
   * @return conferencias
   */
  public static List<Conferencia> getConferencias() {
    return conferencias;
  }
  @Override
  public String toString() {
    return "Conferencia{" +
            "SetNumEdição='" + numEdicao + '\'' +
            ", local='" + local + '\'' +
            '}';
  }
}
