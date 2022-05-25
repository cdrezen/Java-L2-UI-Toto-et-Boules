import java.awt.*;

public abstract class ObjetGraphique {
    String name;
    Color color;
    byte iCouleur = 0;

    public ObjetGraphique() {
        name = "";
        color = Color.BLACK;
    }

    public void setName(String n) {
        name = n;
    }

    public void setColor(Color c) {
        color = c;
    }

    public String getName() {
        return (name);
    }

    public Color getColor() {
        return (color);
    }

    public abstract void draw(Graphics g);

    public abstract boolean contain(int x, int y);

}