package drawpackage;

@SuppressWarnings("serial")
public class ClassJTextArea extends javax.swing.JTextArea {

	public ClassJTextArea() {
		this.setEditable(false);
		this.setBackground(java.awt.Color.WHITE);
		// Bei den Bounds Versetzung von +5 , damit es besser aussieht
		this.setBounds(646, 0, ClassJFrame.width - 646,
				ClassJFrame.height - 16);
	}
}