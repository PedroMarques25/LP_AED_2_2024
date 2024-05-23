package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia extends Publicacao{
  private int numEdicao;
  private String local;
  private Date dataInicio;
  private Date dataFim;

  // Lista estática de conferencias
  private static List<Conferencia> conferencias = new ArrayList<>();
  public Conferencia (int numEdicao, String local, Date dataInicio, Date dataFim,String nome,String tipo) {

    super(nome,tipo);
    this.setNumEdicao(numEdicao);
    this.setLocal(local);
    this.setDataInicio(dataInicio);
    this.setDataFim(dataFim);
  }
  // Getters

  public int getNumEdicao() {
    return numEdicao;
  }

  public String getLocal() {
    return local;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  // Setters
  public void setNumEdicao(int numEdicao) {
    this.numEdicao = numEdicao;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  // Métodos para adicionar, remover e atualizar conferencias
  public static Conferencia adicionarConferencia(int numEdicao, String local, Date dataInicio, Date dataFim,String nome,String tipo) {
    Conferencia conferencia = new Conferencia(numEdicao,  local,  dataInicio, dataFim,nome,tipo);
    conferencias.add(conferencia);
    return conferencia;
  }

  public static void removerConferencia(Conferencia conferencia) {
    conferencias.remove(conferencia);
  }

  public void atualizarConferencia(int numEdicao, String local, Date dataInicio, Date dataFim) {
    this.setNumEdicao(numEdicao);
    this.setLocal(local);
    this.setDataInicio(dataInicio);
    this.setDataFim(dataFim);
  }

  // Método para obter a lista de conferencias (opcional)
  public static List<Conferencia> getConferencias() {
    return conferencias;
  }
}