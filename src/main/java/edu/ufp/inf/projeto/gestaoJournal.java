package edu.ufp.inf.projeto;

public interface gestaoJournal {

void addJournal(Double key,String value);

void addJournalNode(double key,String value);

void deleteJournal(double key);
  
Node deleteJournalNode(Node h, double key);
  
Iterable<Double> getJournais();
}
