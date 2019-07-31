import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Gamepanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(int i=0;i<=225;i+=15)
            for(int j=10;j<=225;j+=15)
            {
                g2d.drawLine(i,j,225,225);
            }
        g2d.drawString("i love you ",500,200);
    }
}
public class singlegame {
    protected static void modeSelect(JFrame frame){
        frame.add(new Gamepanel());
        frame.setVisible(true);
        frame.repaint();
    }
}
