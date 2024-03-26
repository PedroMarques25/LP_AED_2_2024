package edu.ufp.inf.aed2.ficha4;

public class Ficha4 {

    public static void main(String[] args){
        teste_ex1_2();
        teste_ex4_1();
    }

    public static int hashfunc(Integer k, Integer M){
        return k % M * 10;
    }
    public static int hashfunc_ex4(Integer k, Integer M){
        return k % M;
    }


    public static void teste_ex1_2(){
        for (int i = 1; i < 65534; i++) {
            System.out.println(hashfunc(i,255));
        }
    }

    public static void teste_ex4_1() {

    }
}
