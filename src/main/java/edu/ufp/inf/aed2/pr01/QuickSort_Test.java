package edu.ufp.inf.aed2.pr01;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort_Test {

    public static void main(String[] args) {
        Integer[] numbers = generateInts_test(20);
        show(generateInts_test(20));
        //sort(numbers);
        merge_sort(numbers);
        show(numbers);
    }

    public static Integer[] generateInts_test(Integer quantity){
        //variables
        Integer[] numbers = null;

        //instantiate object
        numbers = new Integer[quantity];

        //randomize the numbers
        for (int i=0; i < quantity; i++){
            numbers[i] = StdRandom.uniform(1000,9999);
        }

        return numbers;
    }

    public static void show(Integer[] numbers){
        for (int v : numbers){
            System.out.printf("%d ",v);
        }
        System.out.printf("\n");
    }

    public static void sort(Integer[] numbers){
        Quick.sort(numbers);
    }

    public static void merge_sort(Integer[] numbers){
        Merge.sort(numbers);
    }


}
