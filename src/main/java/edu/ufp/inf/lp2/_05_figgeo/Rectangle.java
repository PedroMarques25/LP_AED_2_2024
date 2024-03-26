package edu.ufp.inf.lp2._05_figgeo;

public class Rectangle {

  private Point ulc;

  private Point lrc;

  public Rectangle(Point ulc, Point lrc) {
    this.ulc = ulc;
    this.lrc = lrc;
  }

  public Point getUlc() {
    return ulc;
  }

  public void setUlc(Point ulc) {
    this.ulc = ulc;
  }

  public Point getLrc() {
    return lrc;
  }

  public void setLrc(Point lrc) {
    this.lrc = lrc;
  }

  //--------------------------------------------------------\\

  public void move(float dx, float dy) {
    this.lrc.x+=dx;
    this.lrc.y+=dy;
    this.ulc.x+=dx;
    this.ulc.y+=dy;
  }

  public float area() {

    float altura = 0 , largura = 0 ;

    altura = this.ulc.distX(this.lrc);
    largura = this.ulc.distY(this.lrc);


    return altura*largura;
  }

  public float perimeter() {
    float altura = 0 , largura = 0 ;

    altura = this.ulc.distX(this.lrc);
    largura = this.ulc.distY(this.lrc);
    return 2*(altura+largura);
  }

  public boolean isInside(Point p) {

    if (p.x>this.ulc.x && p.x< this.lrc.x && p.y < this.ulc.y && p.y > this.lrc.y){

      return true;
    }
    return false;
  }

  public boolean isOutside(Point p) {

    if(!this.isInside(p)){
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Rectangle{" +
            "ulc=" + ulc +
            ", lrc=" + lrc +
            '}';
  }

  public static void main(String[] args) {
    Point point1 = new Point(4 , 5);
    Point point2 = new Point(7 , 2);
    Point point3 = new Point(3,3 );
    Rectangle rectangle = new Rectangle(point1 , point2);

    System.out.println(rectangle.toString());

    if(rectangle.isInside(point3)){
      System.out.println("Esta dentro!");
    }else {
      System.out.println("Esta fora!");
    }
  }

}