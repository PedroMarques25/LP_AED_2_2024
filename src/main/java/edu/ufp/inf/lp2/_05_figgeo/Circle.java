package edu.ufp.inf.lp2._05_figgeo;

import java.awt.*;

public class Circle extends FigGeo{

  public Point center;

  public Point periferic;

  private float radius;

  public Color color;

  public Circle(float radius, Color c) {
    super(c);
    this.radius = radius;
  }

  public Circle(Color c, Point center, float radius, Color color) {
    super(c);
    this.center = center;
    this.radius = radius;
    this.color = color;
  }

    public Circle() {
        super(Color.cyan);
    }

    public void move(float dx, float dy) {
    this.center.x+= dx;
    this.center.y+=dy;
  }

  public double area() {
    return (float) (Math.PI*(Math.pow(radius(),2)));
  }

  public double perimeter() {
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