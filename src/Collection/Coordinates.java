package Collection;

public class Coordinates {
    private long x;
    private float y;

    public Coordinates(double x, double y) {
        this.x = (long) x;
        this.y = (float) y;
    }
    public long getX() {
        return x;
    }
    public float getY() {
        return y;
    }
}
