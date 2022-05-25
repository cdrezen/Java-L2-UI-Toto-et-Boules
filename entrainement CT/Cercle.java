import java.awt.*;

public class Cercle extends Dessin
{
    int radius = 0;

    public Cercle(int xCenter, int yCenter, int r, Color c, boolean bFill)
    {
        x = xCenter;
        y = yCenter;
        radius = r;
        color = c;
        stroke = 2;
        fill = bFill;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setStroke(new BasicStroke(stroke));
        g.setColor(color);

        if(fill)
        {
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
            g.setColor(color.darker());
        }
        
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean contains(int xPos, int yPos) {
        int c1 = x - xPos;
        int c2 = y - yPos;
        return ((c1 * c1 + c2 * c2) <= (radius * radius));
    }



}
