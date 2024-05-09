package edu.ufp.inf.projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia extends LocalPublicacao {

  public int num_Edicao;

  public String local;

  public Date dataInicio;

  public Date dateFim;
  public List<Artigo> artigos;
  public List<Conferencia> conferencias = new ArrayList<>();

  public void adicionarConferencia(int num_Edicao, String local, Date dateInicio, Date dateFim) {
  }

  public void removerConferencia( int num_Edicao, String local, Date dateInicio, Date dateFim) {
  }

  public void atualizarConferencia(int num_Edicao, String local, Date dateInicio, Date dateFim) {
  }

}
