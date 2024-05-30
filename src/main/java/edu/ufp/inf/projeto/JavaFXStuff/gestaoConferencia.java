package edu.ufp.inf.projeto.JavaFXStuff;


import edu.ufp.inf.projeto.JavaFXStuff.Conferencia;

public interface gestaoConferencia {

    /**
     * Adiciona Conferencia
     * @param conferencia conferencia
     */
    void adicionarConferencia(Conferencia conferencia);

    /**
     * Remover Conferencia
     * @param nome da conferecia
     */
     void removerConferencia(String nome);

    /**
     * Buscar Conferencia
     * @param nome da conferencia
     * @return nome da conferencia
     */
    Conferencia buscarConferencia(String nome);

    /**
     * Remover Conferencia
     * @param nome da conferencia
     * @return Nome
     */
    Conferencia removerConferenciaParaFicheiro(String nome);

}

