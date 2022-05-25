import java.awt.Graphics;

public class Point extends ObjetGraphique {
    int x, y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x, y);
    }

    @Override
    public boolean contain(int x, int y) {
        return (this.x == x && this.y == y);
    }
}