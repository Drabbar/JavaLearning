package decipher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseLisstener0 implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (Window.inorout == 1) {
			if (Window.Label2move == true) {
				Window.Label2move = false;
				Thread aThread = new Thread(new Label2moveThread(1));
				aThread.start();
			}
		} else {
			if (Window.Label2move == true) {
				Window.Label2move = false;
				Thread aThread = new Thread(new Label2moveThread(2));
				aThread.start();
			}
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

};
