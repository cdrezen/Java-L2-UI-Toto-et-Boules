import java.awt.Graphics;

public class Cercle extends ObjetGraphique {
    Point centre;
    int rayon;
    boolean fill = false;

    public Cercle() {
        centre = new Point();
        rayon = 0;
    }

    public Cercle(Point c, int r) {
        centre = c;
        rayon = r;
    }

    public void setLocation(Point p) {
        centre = p;
    }

    public void setRayon(int r) {
        rayon = r;
    }

    public Point getLocation() {
        return (centre);
    }

    public int getRayon() {
        return (rayon);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawOval(centre.getX() - rayon, centre.getY() - rayon, rayon * 2, rayon * 2);
        if(fill) g.fillOval(centre.getX() - rayon, centre.getY() - rayon, rayon * 2, rayon * 2);
    }


    @Override
    public boolean contain(int x, int y) {
        int c1 = centre.getX() - x;
        int c2 = centre.getY() - y;
        return ((c1 * c1 + c2 * c2) <= (rayon * rayon));
    }
}