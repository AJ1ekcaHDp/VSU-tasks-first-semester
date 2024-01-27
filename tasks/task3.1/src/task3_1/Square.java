package task3_1;

public class Square {
    public double x0;
    public double x01;
    public double y0;
    public double y01;

    public Square(double x0, double x01, double y0, double y01) {
        this.x0 = x0;
        this.x01 = x01;
        this.y0 = y0;
        this.y01 = y01;
    }

    public boolean isPointInSquare(double x, double y) {
        return x >= Math.min(x0, x01) && x <= Math.max(x0, x01) && y >= Math.min(y0, y01) && y <= Math.max(y0, y01);
    }
}
