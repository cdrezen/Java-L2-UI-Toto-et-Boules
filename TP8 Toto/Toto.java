import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Toto extends JFrame implements MouseListener {
    
    MonComposant mc;
    Color[] COULEURS = { Color.black, Color.blue , Color.cyan, Color.red, Color.green, Color.magenta, Color.orange, Color.yellow };

    public Toto() {

        super("Toto");
        setBounds(100, 80, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mc = new MonComposant();
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(mc, BorderLayout.CENTER);

        mc.addMouseListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Toto();  
    }
    
    public void changeColor(ObjetGraphique o){
        
        Color curColor = o.getColor();

        if(curColor != COULEURS[o.iCouleur])
        {
            for(int i = 0; i < 8; i++) {
                if(COULEURS[i] == curColor) {
                    o.iCouleur = (byte)i; 
                    break;
                }
            }
        }

        if(o.iCouleur == 7) o.iCouleur = -1;
        
        o.setColor(COULEURS[++o.iCouleur]);
        mc.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        for (ObjetGraphique obj : mc.dessins) 
        {
            if(obj.contain(e.getX(), e.getY())) { 
                changeColor(obj);
            }
        }    
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

}