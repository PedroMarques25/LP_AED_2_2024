package edu.ufp.inf.aed2.pr01;
import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class Pr01 {

    public static void main(String[] args) {
        //1st part

        //generateIntsFile(".//PROJ_AED2_LP2_2324//data//30ints.txt",20);
        //loadInts(".//PROJ_AED2_LP2_2324//data//30ints.txt");

        generateInts_test(20);

    }

    public static void generateIntsFile(String fileName, Integer quantity){
        //variables
        Out out = new Out(fileName);

        //generate numbers
        for(int i=0 ; i < quantity; i++){
            out.println(StdRandom.uniform(1000,9999));
        }

        //close the stream
        out.close();
    }

    public static void loadInts(String fileName){
        //variables
        In in = new In(fileName);
        String line;

        //load and show numbers
        while(in.hasNextLine()){
            line = in.readLine();
            System.out.println(line);
        }

        //close stream
        in.close();


    }

    public static int[] generateInts_test(int quantity){
        //variables
        int[] numbers = null;

        //instantiate object
        numbers = new int[quantity];

        //randomize the numbers
        for (int i=0; i < quantity; i++){
            numbers[i] = StdRandom.uniform(1000,9999);
        }

        return numbers;
    }


    public static void show(int[] numbers){
        for (int v : numbers){
            System.out.printf("%d",v);
        }
        System.out.print("\n");
    }

    public static int search(int[] numbers, Integer search){
        return BinarySearch.indexOf(numbers,search);
    }

}
