package decipher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Label4 extends JLabel {

	String a, b, c, d, e, f, h, i = " fg ";
	String[] input = new String[4];
	
	public Label4() {
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.CYAN);
		
		if (Window.select_rename == false) {
			input = refresh();
			a = input[0];b = input[1];c = input[2];d = input[3];e = input[4];f = input[5];h = input[6];i = input[7];
		}
		g2.drawString(a, 20, 15);
		g2.drawString(b, 20, 145);
		g2.drawString(c, 20, 275);
		g2.drawString(d, 20, 405);
		g2.drawString(e, 200, 15);
		g2.drawString(f, 200, 145);
		g2.drawString(h, 200, 275);
		g2.drawString(i, 200, 405);
	}
	
	private String[] refresh() {
		 
		File file = new File("Code/Names.txt");
		FileInputStream fis = null;
		String inp = "";

		try {
			fis = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			inp = new String(data, "UTF-8");
		} catch (IOException e) {
			System.out.println("label reader kaputt");
		}
		return inp.split("#");
	}
}
