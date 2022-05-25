import javax.swing.JFrame;

public class TestDC extends JFrame
{
    DrawComponent dc;
    ClickMouseListener lClick;

    public TestDC() {

        super("TestDC");
        setBounds(100, 80, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dc = new DrawComponent();
        dc.AddDessin(new Cercle(new Point(200,200), 100));
        dc.AddDessin(new Rectangle(new Point(180, 150), 40, 100));
        this.add(dc);

        lClick = new ClickMouseListener() 
        {
            @Override
            public void mouseClicked(int x, int y) 
            {    
                System.out.println("x: " + x + " y: " + y);     
            }
            
        };
        
        dc.addClickMouseListener(lClick);

        setVisible(true);
    }

/*    public static void main(String[] args) {
        new TestDC();  
    } */
}
