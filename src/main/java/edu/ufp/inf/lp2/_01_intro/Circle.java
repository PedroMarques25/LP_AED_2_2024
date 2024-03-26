package edu.ufp.inf.lp2._01_intro;

public class Circle {

    public Point center;

    public Point periferic;

    public void move(float dx, float dy) {
        this.center.x+= dx;
        this.center.y+=dy;
    }

    public float area() {
        return (float) (Math.PI*(Math.pow(radius(),2)));
    }

    public float perimeter() {
        return (float) ((2*Math.PI)*radius());
    }

    public float radius() {
        return this.center.dist(this.periferic);
    }

    public boolean isInside(Point p) {
        return (p.dist(this.center) < this.radius());
    }

    public boolean isOutside(Point p) {
        return (p.dist(this.center) > this.radius());
    }

}
