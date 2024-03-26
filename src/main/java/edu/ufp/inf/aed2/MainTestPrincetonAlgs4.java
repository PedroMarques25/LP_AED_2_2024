package edu.ufp.inf.aed2;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.SequentialSearchST;
import edu.princeton.cs.algs4.StdRandom;
import edu.ufp.inf.aed2.pr02.ST_BinarySearch_AED;
import edu.ufp.inf.aed2.pr03.BST_AED2_UFP;


import static edu.ufp.inf.aed2.pr02.ST_BinarySearch_AED.*;


public class MainTestPrincetonAlgs4 {
    public static void main(String[] args) {
        //System.out.println("MainTestPrincetonAlgs4->main(): test Princeton algs4!");
        //exemplo1_princeton();
        /*BinarySearchST<String, Integer> ages = null;
        int aux;
        ages = ST_BinarySearch_AED.generateAges();
        ST_BinarySearch_AED.showST(ages);
        ST_BinarySearch_AED.showST4(ages,"Antonio","Zeferino");*/
        test_BST();
    }

    public static void test_BST(){
        BST_AED2_UFP<Integer, Integer> bst =new BST_AED2_UFP<Integer, Integer>();
        int[] keys = {4,2,6,1,3,5,7};
        Iterable<Integer> numbers;

        for (Integer x : keys){
            bst.put(x, StdRandom.uniform(1000,9999));
        }

        System.out.printf("Number of leafs: %d\n",bst.leafCount());
        System.out.printf("Number of keys: %d\n",bst.keysCount());
        //System.out.printf("Number of leafs: %d\n",bst.evenKeysCount());
        //System.out.printf("Number of leafs: %d\n",bst.treeHeight());
    }

    /*public static void exemplo1_princeton() {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();

        st.put("Azul",10);
        st.put("Verde",50);
        System.out.println("Tabela (inicial):");
        for (String s : st.keys()) {
            System.out.println(s + "-" + st.get(s));
        }
        st.put("Azul",25);
        st.put("Verde",75);
        System.out.println("Tabela (depois de atualizar):");
        for (String s : st.keys()) {
            System.out.println(s + "-" + st.get(s));
        }

    }

    public static void binarySearchST_test3(){
        BinarySearchST<String, Integer> ages = null;
        int aux;

        aux = ages.rank("Maria");
        System.out.printf("\"Maria\" rank is %d\n",aux);

        aux = ages.rank("Bernardo");
        System.out.printf("\"Bernardo\" rank is %d\n",aux);

        System.out.println();
    }

*/
}