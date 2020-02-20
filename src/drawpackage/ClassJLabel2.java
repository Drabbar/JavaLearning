package drawpackage;

@SuppressWarnings("serial")
/**
 * Konsole TODO
 * 
 * @author Enrico
 */
public class ClassJLabel2 extends javax.swing.JLabel {

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
		this.setBounds(ClassJLabel1.pixel * 20 + 1, 0, ClassJFrame.width - ClassJLabel1.pixel * 20 + 1,
				ClassJFrame.height);

		g2.setColor(java.awt.Color.WHITE);
		g2.fillRect(5, 0, 1000, 1000);

		g2.setColor(java.awt.Color.BLACK);
		g2.fillRect(0, 0, 4, this.getHeight());

		repaint();
	}
}