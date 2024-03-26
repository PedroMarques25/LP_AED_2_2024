package edu.ufp.inf.lp2._01_intro;

public class Point {

    float x = 0.0f;
    float y = 0.0f;

    /**
     * Default Constructor: automatically provided, given there are no
     * other contructors
     */


    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    //Getters & Setter


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float distX(Point p) {

        if(p.x > this.x){
            return p.x-this.x;
        } else if (p.x < this.x) {

            return this.x-p.x;
        }
        return 0.0f;
    }

    public float distY(Point p) {


        if(p.y > this.y){
            return p.y-this.y;
        } else if (p.y < this.y) {

            return this.y-p.y;
        }
        return 0.0f;
    }



    public float dist(Point p) {

        float largura= 0 , altura= 0;

        largura=this.distX(p);
        altura=this.distY(p);

        return (float) Math.sqrt(Math.pow(altura,2) + Math.pow(altura,2));
    }

    public void moveX(float delta) {
        this.setX(delta);
    }

    public void moveY(float delta) {
        this.setY(delta);
    }

    public void move(float x, float y) {
        this.moveX(x);
        this.moveY(y);
    }

    public void printPoint() {
        System.out.println("X="+this.x+"\nY="+this.y+"\n");
    }

    public boolean betweenPointsX(Point leftPt, Point rightPt){
        if(this.x > leftPt.x && this.x < rightPt.x){
            return true;
        } else {
            return false;
        }
    }

    public boolean betweenPointsY(Point upPt, Point downPt){
        if(this.y > upPt.y && this.y < downPt.y){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {

        return false;
    }

    public static void main(String[] agrs) {

        Point p1 = new Point(1.0f, 2.0f);
        Point p2 = new Point(7.0f, 5.0f);
        Point p3 = new Point(8.0f, 6.0f);
        p1.printPoint();
        p2.printPoint();
        System.out.println(p1.distX(p2));
        System.out.println(p1.distX(p1));
        System.out.println(p2.distY(p1));
        System.out.println(p2.distY(p2));
        System.out.println(p1.dist(p2));
        p1.move(p1.distX(p2), p1.distY(p2));
        p1.printPoint();
        System.out.println(p2.betweenPointsX(p1, p3));
        System.out.println(p2.betweenPointsY(p3, p1));

    }

}
