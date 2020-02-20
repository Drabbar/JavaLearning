package decipher;

public class Label2moveThread implements Runnable {

	int direction;

	public Label2moveThread(int dir) {
		direction = dir;
	}

	@Override
	public void run() {
		
		Window.select_rename = false;
		Window.select_Load = false;
		Window.select_Save = false;
		Window.select_clear = false;

		Window.cancelb = true;
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
		}
		Window.cancelb = false;
		Window.confirmb = false;

		if (direction == 2 && Window.inorout == 2) {
			Window.inorout = 1;
			for (int i = 0; i < 70; i++) {
				// System.out.println("in ++ way" + Window.Verschiebung);
				Window.Verschiebung1 +=2;
				Window.pane2.setBounds(Window.Verschiebung1, Window.pane2.getY(), Window.pane2.getWidth(),
						Window.pane2.getHeight());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}

		} else if (direction == 1 && Window.inorout == 1) {
			Window.inorout = 2;
			for (int i = 0; i < 70; i++) {
				// System.out.println("in -- way" + Window.Verschiebung);
				Window.Verschiebung1 -= 2;
				Window.pane2.setBounds(Window.Verschiebung1, Window.pane2.getY(), Window.pane2.getWidth(),
						Window.pane2.getHeight());
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
				}
			}
		}

		Window.Label2move = true;
	}

}
