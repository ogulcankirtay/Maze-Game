package newpackage;

public class Point {

    public int a, b;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Point(Point other) {
        this.a = other.a;
        this.b = other.b;
    }

    public boolean disardakiNokta(int width, int height) {
        if (a < 0 || b < 0 || b >= width || a >= height) {
            return true;
        }
        return false;
    }

    public int mesafe(Point other) {
        return Math.abs(a - other.a) + Math.abs(b - other.b);
    }

    public Point getRight() {
        return new Point(b, -a);
    }

    public Point getLeft() {
        return new Point(-b, a);
    }

    public Point add(Point other) {
        return new Point(a + other.a, b + other.b);
    }

    @Override
    public int hashCode() {
        final int ilk = 31;
        int sonuc = 1;
        sonuc = ilk * sonuc + b;
        sonuc = ilk * sonuc + a;
        return sonuc;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (b != other.b) {
            return false;
        }
        if (a != other.a) {
            return false;
        }
        return true;
    }
}
