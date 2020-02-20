package decipher;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Label2 extends JLabel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(4));
		g2.setColor(new Color(120, 120, 120, 240));
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2.drawRect(Window.programming_Field_Width + Window.programming_Field_Xabs * 2 + 2, 56,
				Window.frame.getWidth() - Window.programming_Field_Xabs + Window.programming_Field_Xabs * 2,
				Window.frame.getHeight() - 40);
		g2.setColor(Color.DARK_GRAY);
		g2.drawRect(2, 2, this.getWidth(), this.getHeight());
		repaint();
	}
}