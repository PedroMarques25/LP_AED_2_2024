package edu.ufp.inf.aed2.pr02;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdOut;

public class ST_BinarySearch_AED {
    public static BinarySearchST<String, Integer> generateAges(){
        //variaveis
        BinarySearchST<String, Integer>st;

        //prepare objects to run
        st = new BinarySearchST<String, Integer>();
        st.put("Fernando",18);
        st.put("Antonio",23);
        st.put("Maria",17);
        st.put("Zeferino",16);

        //return new collection
        return st;
    }

    public static void showST(BinarySearchST<String, Integer> st){
        //present set
        for (String  k: st.keys()){
            System.out.printf("KEY : %-10S, VALUE %d, RANK : %d\n",k,st.get(k),st.rank(k));
        }

        //LARGEST KEY IN THIS SYMBOL TABLE LESS THAN OR EQUAL TO KEY
        System.out.printf("FLOOR(\"MATILDE\"): %s\n",st.floor("Matilde"));

        //SMALLEST KEY IN THIS SYMBOL TABLE GREATER THAN OR EQUAL TO KEY
        System.out.printf("CEILING(\"Bernardo\"): %s\n",st.ceiling("Bernardo"));

        //SMALLEST KEY IN THIS SYMBOL TABLE
        System.out.printf("MIN : %s\n",st.min());

        //LARGEST KEY IN THIS SYMBOL TABLE
        System.out.printf("MAX : %s\n",st.max());

        //NUMBER OF ELEMENTS IN THIS SYMBOL TABLE
        System.out.printf("SIZE : %d\n",st.size());
    }

    public static void showST4(BinarySearchST<String, Integer> st, String from, String to){
        //show parcial set
        System.out.printf("Names between \"%s\" and \"%s\"\n",from, to);
        for (String name : st.keys(from,to)){
            System.out.printf(name + " ");
        }
    }
}
