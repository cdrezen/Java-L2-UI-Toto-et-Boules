import java.awt.Color;
import javax.swing.JFrame;

public class Puissance4 extends JFrame
{
    DrawComponent dc;
    ClickMouseListener lClick;

    Rectangle[] collones;
    Cercle[][] cases;

    Cercle curPlayer;

    public Puissance4() {

        super("Puissance 4");

        setBounds(100, 80, 700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dc = new DrawComponent();
        collones = new Rectangle[7];
        cases = new Cercle[7][6];

        dc.AddDessin(new Rectangle(new Point(10, 10), 560, 480));

        for(int i = 0; i < 7; i++)
        {
            collones[i] = new Rectangle(new Point(10+i*80, 10), 80, 480);
            dc.AddDessin(collones[i]);//

            for(int j = 0; j < 6; j++)
            {
                cases[i][j] = new Cercle(new Point(50+i*80, 50+j*80), 35);
                dc.AddDessin(cases[i][j]);//
            }
        }

        curPlayer = new Cercle(new Point(630, 80), 35);
        curPlayer.color = Color.yellow;
        curPlayer.fill = true;

        dc.AddDessin(curPlayer);
        
        this.add(dc);

        lClick = new ClickMouseListener() 
        {
            @Override
            public void mouseClicked(int x, int y) 
            {    
                for(int i = 0; i < 7; i++)
                {
                    if(!collones[i].contain(x, y)) continue;

                    for(int j = 0; j < 6; j++)
                    {
                        if(!cases[i][j].contain(x, y)) continue;
                        
                        cases[i][j].setColor(curPlayer.color);
                        cases[i][j].fill = true;

                        if(curPlayer.color == Color.yellow) curPlayer.color = Color.red;
                        else curPlayer.color = Color.yellow;
                        dc.repaint();
                        return;
                    }
                }      
            }
            
        };
        
        dc.addClickMouseListener(lClick);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Puissance4();  
    }
}

