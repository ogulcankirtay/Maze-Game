package newpackage;


public class Lokasyon {
    private int lx, ly;

    public Lokasyon(int lx, int ly) {
        this.lx = lx;
        this.ly = ly;
    }

    public Lokasyon() {
    }

    public int getLx() {
        return lx;
    }

    public void setLx(int lx) {
        this.lx = lx;
    }

    public int getLy() {
        return ly;
    }

    public void setLy(int ly) {
        this.ly = ly;
    }

}