import java.awt.*;

public abstract class Dessin 
{
    public int x;
    public int y;
    public Color color;
    public int stroke;
    public boolean fill = true;
    public Drag drag = new Drag();

    public abstract void draw(Graphics2D g);
    public abstract boolean contains(int x, int y);
}
