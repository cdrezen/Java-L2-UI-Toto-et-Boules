import java.awt.*;
import java.util.Vector;
import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canvas extends JComponent implements MouseListener {
    
    Vector<Dessin> dessins;
    Vector<ClickMouseListener> listeners;

    public Canvas() 
    {
        dessins = new Vector<Dessin>();
        listeners = new Vector<ClickMouseListener>();
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (Dessin dessin : dessins) {
            dessin.draw((Graphics2D) g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        for (ClickMouseListener l: listeners) 
        {
            l.mouseClicked(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        for (ClickMouseListener l: listeners) 
        {
            l.mousePressed(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        
        for (ClickMouseListener l: listeners) 
        {
            l.mouseReleased(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}