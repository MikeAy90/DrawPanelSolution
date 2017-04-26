import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class DrawPanel implements Runnable
{
    static int width = 250;
    static int height = 250;
    JFrame application;
    public void run()
    {
        application = new JFrame();
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(new TextPanel());
        application.setSize(width, height);
        application.setVisible(true);
    }
    public static void main(String[] args)
    {
        DrawPanel dp = new DrawPanel();
        SwingUtilities.invokeLater(dp);
    }
}

class TextPanel extends JPanel implements ComponentListener
{
    int steps = 16;
    boolean fFlag = false;
    Font font;
    Color clr = new Color(0, 192, 0);
    JLabel lable;
    public TextPanel() {
        lable = new JLabel("BCS 345");
        lable.setBackground(Color.green);
        this.add(lable);
        this.setLayout(null);
        //lable.setBounds(1, 1, 100, 50);
    }
    public void paint(Graphics gr)
    {
        int hgt, wid, x1, y1, x2, y2, x3, y3, hst, vst;
        Graphics2D g2 = (Graphics2D)gr;
        if(fFlag){
            g2.setColor(clr);
            font = gr.getFont();
            font.deriveFont(42);
            g2.setFont(font);
            gr.setFont(font);
        }
        //font.deriveFont(Font.SANS_SERIF);
        wid = getWidth();
        hgt = getHeight();

        gr.drawString("BCS 345", wid/2, hgt/2);
    }
    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void componentMoved(ComponentEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void componentResized(ComponentEvent e) {
        fFlag = true;

    }
    @Override
    public void componentShown(ComponentEvent e) {
    }
}