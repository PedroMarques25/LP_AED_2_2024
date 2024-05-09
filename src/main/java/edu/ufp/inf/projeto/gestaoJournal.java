package edu.ufp.inf.projeto;

import org.w3c.dom.Node;

public interface gestaoJournal {

void addJournal(Double key,String value);

Node addJournalNode(Node node,double key,String value);

void deleteJournal(double key);
  
Node deleteJournalNode(Node h, double key);
  
Iterable<Double> getJournais();
}
