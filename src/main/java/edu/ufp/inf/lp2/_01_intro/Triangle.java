package edu.ufp.inf.lp2._01_intro;


public class Triangle {

    private Point upperPt;

    private Point lowerLeftPt;

    private Point lowerRightPt;

    public void move(float dx, float dy) {
        this.upperPt.x += dx;
        this.upperPt.y += dy;

        this.lowerLeftPt.x += dx;
        this.lowerLeftPt.y += dy;

        this.lowerRightPt.x += dx;
        this.lowerRightPt.y += dy;

    }

    public double area() {
        return 0.0;
    }

    public float perimeter() {
        return 0.0f;
    }

    public boolean isInside(Point p) {
        if(this.upperPt.x < p.x && this.upperPt.y < p.y || this.lowerLeftPt.x < p.x && this.lowerLeftPt.y < p.y
                || this.lowerRightPt.x < p.x && this.lowerRightPt.y < p.y){
            return true;
        } else{
            return false;
        }
    }

    public boolean isOutside(Point p) {
        return isOutside(p);
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
