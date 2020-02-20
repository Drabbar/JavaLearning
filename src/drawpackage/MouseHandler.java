package drawpackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 4) {
			drawpackage.ClassJFrame.frame.setAlwaysOnTop(true);
			drawpackage.ClassJFrame.frame.setAlwaysOnTop(false);
		} else if (e.getButton() == 5) {
			decipher.Window.frame.setAlwaysOnTop(true);
			decipher.Window.frame.setAlwaysOnTop(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}