package edu.ufp.inf.lp2._01_intro;

import java.util.ArrayList;

public class MyArrayDemo {
    public static void main(String[] args) {
        testArrayPrimitives();
        testArrayObjects();

    }

    public static void testArrayPrimitives(){
        int[] intArray = new int[3];
        float floatArray[] = new float[3];

        for (int i = 0; i < intArray.length; i++)
        {
            intArray[i] = 2;

        }
        System.out.println(intArray.length);

        intArray[3] = 4;
    }

    public static void testArrayObjects(){
        Point[] pointArray = new Point[3];

        for(int i=0; i < pointArray.length;i++){
            pointArray[i] = new Point((float) i, (float)i);
            //System.out.println(printArray[i]);
        }
    }

    public static void testRawArrayList(){
        ArrayList arrlist1 = new ArrayList();
        arrlist1.add(new Point());
        arrlist1.add("Hello");
        arrlist1.add(new Integer(1));

        Point p1 = (Point) arrlist1.get(0);
    }
}
