package decipher;

public class saveButtonsmoveThread implements Runnable {

	int direction;

	public saveButtonsmoveThread(int dir) {
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
		if(Window.saveButtonmove == true) {
			Window.saveButtonmove = false;
			if (direction == 2) {
				Window.page--;
				for (int i = 0; i < 60; i++) {
					// System.out.println("in ++ way" + Window.Verschiebung);
					Window.Verschiebung2 += 3;
					Window.pane3.setBounds(Window.Verschiebung2, Window.pane3.getY(), Window.pane3.getWidth(),
							Window.pane3.getHeight());
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}
	
			} else if (direction == 1) {
				Window.page++;
				for (int i = 0; i < 60; i++) {
					// System.out.println("in -- way" + Window.Verschiebung);
					Window.Verschiebung2 -= 3;
					Window.pane3.setBounds(Window.Verschiebung2, Window.pane3.getY(), Window.pane3.getWidth(),
							Window.pane3.getHeight());
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}
			}
			
			Window.saveButtonmove = true;
			
		}
		
	}

}
