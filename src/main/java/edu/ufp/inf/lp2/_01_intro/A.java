package edu.ufp.inf.lp2._01_intro;

import java.util.ArrayList;

public class A {
    public static void main(String[] args) {
        A a = new A();
        Object o = new Object();
        o = new A();
        o = new Point(0.0f, 0.0f);
        ((Point) o).dist(new Point(1.0f, 1.0f));
        Rectangle r = new Rectangle(new Point(0.0f, 1.0f), new Point(1.0f, 0.0f));
        o = r;
        System.out.println(((Rectangle) o).isInside(new Point(0.5f, 0.5f)));
        // Cast usamos para "enganar" o compilador e apontar para a classe rectangle e NÂO para o Object dentro da classe rectangle
    }
    public static void testRawArrayList(){
        ArrayList arrList1 = new ArrayList<>();
        arrList1.add("Hello");
        arrList1.add(new Point(1.0f, 1.0f));
        arrList1.add(new Rectangle(new Point(2.0f, 1.0f), new Point(1.0f, 2.0f))); // Os valores são aleatórios, a ideia é mostrar o cast
        Point p = (Point) arrList1.get(1); // Temos de fazer cast porque o compilador acha que são objetos
    }
    public static void testArrayList(){
        ArrayList<Point> arrList1 = new ArrayList<>();
       // arrList1.add("Hello");  Não dá mesmo com cast porque foi definido que o array é Point
        arrList1.add(new Point(1.0f, 1.0f));
        arrList1.add(new Point(2.0f, 1.0f));
        Point p3 = new Point(3.0f, 1.0f);
        arrList1.add(p3);
        System.out.println(arrList1.indexOf(p3));
        arrList1.add(0, p3); // Libertamos na posição 0 o conteudo dela e pomos o conteudo de p3
        //arrList1.add(5, p3);  Vai dar erro porque não podemos ter buracos no array.
    }

    public A() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
