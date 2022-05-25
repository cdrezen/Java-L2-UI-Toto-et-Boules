import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class MonComposant extends JComponent
{
    ArrayList<ObjetGraphique> dessins = new ArrayList<ObjetGraphique>();

    public MonComposant()
    {
        dessins.add(new Cercle(new Point(200,200), 100));
        dessins.add(new Cercle(new Point(160,150), 20));
        dessins.add(new Cercle(new Point(240,150), 20));
        dessins.add(new Rectangle(new Point(150, 220), 100, 40));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        for (ObjetGraphique obj : dessins) 
        {
            obj.draw(g);
        }
    }
}