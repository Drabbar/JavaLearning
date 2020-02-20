package decipher;
import java.awt.Font;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ClassJTextArea extends JTextArea {
	
	public ClassJTextArea() 
	{
		this.setFont(new Font("Serif", Font.BOLD, 20));
		this.setEditable(true);
		this.requestFocus();
	}
}