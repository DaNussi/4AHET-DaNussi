package net.nussi;

public class Arrow {

    double x1;
    double y1;
    double x2;
    double y2;

    public Arrow(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public Arrow(double m, double g) {

        g = Math.toRadians(g);

        this.x1 = 0;
        this.y1 = 0;

        this.x2 = Math.cos(g)*m;
        this.y2 = Math.sin(g)*m;
    }

    public Arrow offset(double x, double y) {
        this.x1 += x;
        this.y1 += y;
        this.x2 += x;
        this.y2 += y;
        return this;
    }



}
