package decipher;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Label1 extends JLabel{

    public Label1() {}

    @Override
    protected void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(4));
        g2.drawRect(Window.programming_Field_Xabs - 1,Window.programming_Field_Yabs - 1,Window.programming_Field_Width + 1,Window.programming_Field_Height + 1);//textdeld umrandung
        g2.drawRect(0,0,Window.frame.getWidth(),54);								//oben umrandung
    }
}