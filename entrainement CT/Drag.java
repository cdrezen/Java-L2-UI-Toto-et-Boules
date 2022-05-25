import java.util.TimerTask;

public class Drag extends TimerTask
{
    private int x, y, dx, dy, err;
    private int speedX, speedY;
    public Dessin dessin;
    public boolean canStart = false;

    public Drag() { }

    public Drag(Dessin d, int xTarget, int yTarget) 
    {
        dessin = d;
        x = xTarget; y = yTarget;
        dx = Math.abs(x - dessin.x);
        dy = -1 * Math.abs(y - dessin.y);
        err = dx + dy;

        speedX = dessin.x < x ? 1 : -1;
        speedY = dessin.y < y ? 1 : -1;
    }

	@Override
	public void run() 
    { 
        if(dessin.x == x && dessin.y == y) { this.cancel(); return; }

        int e2 = err * 2;

        if(e2 >= dy) { err += dy; dessin.x += speedX; }
        if(e2 <= dx) { err += dx; dessin.y += speedY; }
	}
    
}
