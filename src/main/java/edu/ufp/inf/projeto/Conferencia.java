package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia extends LocalPublicacao {

  public int num_Edicao;

  public String local;

  public Date dataInicio;

  public Date dateFim;
  public List<Artigo> artigosdeconferencias = new ArrayList<>();
  public Conferencia(int num_Edicao, String local, Date dataInicio,Date dateFim,List<Artigo> artigosdeconferencias){
    this.num_Edicao=num_Edicao;
    this.dataInicio=dataInicio;
    this.dateFim=dateFim;
    this.artigosdeconferencias=artigosdeconferencias;
  }
  public List<Artigo> artigos;
  public List<Conferencia> conferencias = new ArrayList<>();


  public void adicionarConferencia(Conferencia conferencia) {
    conferencias.add(conferencia);
  }

  public void removerConferencia(Conferencia conferencia) {
    conferencias.remove(conferencia);
  }

  public void atualizarConferencia(int num_Edicao, String local, Date dateInicio, Date dateFim,List<Artigo>artigosdeconferencia,int key) {
    conferencias.get(key).num_Edicao=num_Edicao;
    conferencias.get(key).local=local;
    conferencias.get(key).dataInicio=dataInicio;
    conferencias.get(key).dateFim=dateFim;
    conferencias.get(key).artigosdeconferencias=artigosdeconferencia;
  }

}
