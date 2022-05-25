import java.awt.*;
import javax.swing.*;

class Entrainement extends JFrame
{

    public Entrainement()
    {
        super("Entrainement");
        setBounds(100, 80, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Canvas canvas = new Canvas();
        Container pane = getContentPane();

        pane.setLayout(new BorderLayout());
        pane.add(canvas, BorderLayout.CENTER);
        canvas.dessins.add(new Cercle(200, 200, 23, Color.GREEN, true));

        Engine engine = new Engine(canvas);
        engine.start();

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Entrainement();
    }
}