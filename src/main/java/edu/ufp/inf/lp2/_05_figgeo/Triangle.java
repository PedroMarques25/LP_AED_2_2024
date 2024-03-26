package edu.ufp.inf.lp2._05_figgeo;

public class Triangle {

  private Point upperPt;

  private Point lowerLeftPt;

  private Point lowerRightPt;

  public void move(float dx, float dy, float dz) {
      this.upperPt.x += dx;
      this.upperPt.y += dy;

    this.lowerLeftPt.x += dx;
    this.lowerLeftPt.y += dy;

    this.lowerRightPt.x += dx;
    this.lowerRightPt.y += dy;

  }

  public double area() {
  return ((lowerLeftPt.dist(lowerRightPt)) * upperPt.distY(lowerRightPt)/2);
  }

  public float perimeter() {
   return this.lowerLeftPt.dist(this.lowerRightPt) + this.lowerLeftPt.dist(this.upperPt) + this.lowerRightPt.dist(this.upperPt);
  }

  public boolean isInside(Point p) {
   return !isOutside(p);
  }

  public boolean isOutside(Point p) {
    float d1 = crossPoint(p, upperPt, lowerLeftPt);
    float d2 = crossPoint(p, lowerLeftPt, lowerRightPt);
    float d3 = crossPoint(p, lowerRightPt, upperPt);
    if((d1 > 0) == (d2 > 0) && (d2 > 0) == (d3 > 0)){
      return true;
    } else {
      return false;
    }
  }

  private float crossPoint(Point p1, Point p2, Point p3) {
    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
  }

  @Override
  public String toString() {
    return "Triangle{" +
            "upperPt=" + upperPt +
            ", lowerLeftPt=" + lowerLeftPt +
            ", lowerRightPt=" + lowerRightPt +
            '}';
  }

  public Point getUpperPt() {
    return upperPt;
  }

  public void setUpperPt(Point upperPt) {
    this.upperPt = upperPt;
  }

  public Point getLowerLeftPt() {
    return lowerLeftPt;
  }

  public void setLowerLeftPt(Point lowerLeftPt) {
    this.lowerLeftPt = lowerLeftPt;
  }

  public Point getLowerRightPt() {
    return lowerRightPt;
  }

  public void setLowerRightPt(Point lowerRightPt) {
    this.lowerRightPt = lowerRightPt;
  }
}