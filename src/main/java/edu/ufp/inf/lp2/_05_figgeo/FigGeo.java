package edu.ufp.inf.lp2._05_figgeo;

import java.awt.*;
import java.util.ArrayList;
import  edu.ufp.inf.lp2._05_figgeo.Triangle;

public class FigGeo implements FigGeoDimsl, FigGeoDrawI, FigGeoRelsl {

  public Color color;

  private ArrayList<Point> points = new ArrayList<>();

  public FigGeo(Color c) {
    this.color = c;
  }

  public void addPoint(Point p) {
    if(!this.points.contains(p)){
      this.points.add(p);
    }
  }

  public Point getPoint(int index) {
  return (index >=0 && index < this.points.size() ? this.points.get(index) : null);
  }

  public Color getColor() {
  return null;
  }

  public void setColor(Color color) {
  }

  @Override
  public double area() {
    if (this.points.size() == 3){
      Triangle tri = new Triangle();
      tri.setLowerLeftPt(this.points.get(0));
      tri.setUpperPt(this.points.get(1));
      tri.setLowerRightPt(this.points.get(2));
      return tri.area();

    }if (this.points.size() == 2){
      Rectangle rect = new Rectangle(this.points.get(0),this.points.get(1));
      return rect.area();

    }if (this.points.size() == 1){
      Circle circ = new Circle();


    }else System.out.println("Invalid!\n");

      return 0;
  }

  @Override
  public double perimeter() {
    return 0;
  }



  @Override
  public boolean isInside(FigGeo f) {
    Point ul = getPoint(0);
    Point dr = getPoint(1);
    Point dl = new Point(ul.getX(),dr.getY());
    Point ur = new Point(dr.getX(),ul.getY());
    return isInside(ul) && isInside(Point p);
    return false;
  }

  @Override
  public boolean isIntercepted(FigGeo f) {
    return false;
  }

  @Override
  public void draw(Graphics g) {

  }
}