import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;

public class Engine extends Thread implements ClickMouseListener
{
    Random r = new Random();
    Timer timer = new Timer();
    Canvas canvas;

    public Engine(Canvas arg)
    {
        canvas = arg;
        canvas.listeners.add(this);
    }

    public void run()
    {
        while(!interrupted())
        {
            try 
            {
                sleep(16);
                canvas.repaint();
            } 
            catch (Exception e) { }      
        }
    }

	@Override
	public void mouseClicked(int x, int y) { }

	@Override
	public void mousePressed(int x, int y) {
		for (Dessin dessin : canvas.dessins) 
        {
            if (dessin.contains(x, y)) 
            {
                dessin.drag.canStart = true;
                System.out.println("can start.");
            }
            else dessin.drag.canStart = false;
        }
	}

	@Override
	public void mouseReleased(int x, int y) 
    {
        boolean createParticule = false;

		for (Dessin dessin : canvas.dessins) 
        {
            if (!dessin.contains(x, y) && dessin.drag.canStart) 
            {
                dessin.drag.cancel();
                dessin.drag = new Drag(dessin, x, y);
                timer.schedule(dessin.drag, 0, 4);
                System.out.println("drag");
                createParticule = true;
            } 
            else dessin.drag.canStart = false;
        }

        if(createParticule)
        {
            Cercle particule = new Cercle(x, y, 8, Color.RED, false);
            canvas.dessins.add(particule);

            timer.schedule(new TimerTask() 
            {
                @Override
                public void run() 
                {
                    if(particule.radius > 0) particule.radius--;
                    else 
                    {
                        canvas.dessins.remove(particule);
                        cancel();
                    }
                }
                
            }, 200, 40);
        }
	}
}
