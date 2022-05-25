import javax.swing.*;
import java.awt.Graphics;
import java.util.Vector;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawComponent extends JComponent implements MouseListener
{
    Vector<ObjetGraphique> dessins;
    Vector<ClickMouseListener> ecouteurs;

    public DrawComponent()
    {
        dessins = new Vector<ObjetGraphique>();
        ecouteurs = new Vector<ClickMouseListener>();

        this.addMouseListener(this);
    }

    public void AddDessin(ObjetGraphique o)
    {
        dessins.add(o);
        repaint();
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

    public void addClickMouseListener(ClickMouseListener l)
    {
        ecouteurs.add(l);
    }

    public void removeClickMouseListener(ClickMouseListener l)
    {
        ecouteurs.remove(l);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        for (ClickMouseListener lClick : ecouteurs) 
        {
            lClick.mouseClicked(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}