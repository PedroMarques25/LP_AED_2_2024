package edu.ufp.inf.projeto;



public interface gestaoJournal {

void addJournal(Double key,String value);

//Node addJournalNode(Node node,Double key,String value);

void deleteJournal(Double key);
  
//Node deleteJournalNode(Node h, Double key);
  
Iterable<Double> getJournais();
}
