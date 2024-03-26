package edu.ufp.inf.lp2._01_intro;


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
        this.lrc.x += dx;
        this.lrc.y += dy;
        this.ulc.x += dx;
        this.ulc.y += dy;
    }

    public float area() {

        float altura = 0, largura = 0;

        altura = this.ulc.distX(this.lrc);
        largura = this.ulc.distY(this.lrc);


        return altura * largura;
    }

    public boolean isInside(Point point) {
        return false;
    }
}
