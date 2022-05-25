import java.awt.Graphics;

public class Rectangle extends ObjetGraphique {
    int width;
    int height;
    Point pos;

    public Rectangle() {
        pos = new Point();
        width = 0;
        height = 0;
    }

    public Rectangle(Point pos, int w, int h) {
        this.pos = pos;
        width = w;
        height = h;
    }

    public void setLocation(Point p) {
        pos = p;
    }

    public void setDimension(int w, int h) {
        width = w;
        height = h;
    }

    public Point getLocation() {
        return pos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawRect(pos.getX(), pos.getY(), width, height);
    }

    @Override
    public boolean contain(int x, int y) {
        return (x >= pos.getX() && x <= pos.getX() + width) &&
                (y >= pos.getY() && y <= pos.getY() + height);
    }
}