package drawpackage;

public class KeyHandler implements java.awt.event.KeyListener {

	public static boolean move = false;

	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'w':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						logic.Player.br = logic.Player.Blickrichtung.oben;
					} else {
						logic.PlayerMove.nbr = logic.Player.Blickrichtung.oben;
					}
				}
			}
			break;
		case 'a':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						logic.Player.br = logic.Player.Blickrichtung.links;
					} else {
						logic.PlayerMove.nbr = logic.Player.Blickrichtung.links;
					}
				}
			}
			break;
		case 's':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						logic.Player.br = logic.Player.Blickrichtung.unten;
					} else {
						logic.PlayerMove.nbr = logic.Player.Blickrichtung.unten;
					}
				}
			}
			break;
		case 'd':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						logic.Player.br = logic.Player.Blickrichtung.rechts;
					} else {
						logic.PlayerMove.nbr = logic.Player.Blickrichtung.rechts;
					}
				}
			}
			break;
		case 'q':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					logic.Player.interact();
				}
			}
			break;
		case 'p':
			if (logic.Player.ReversePixelsWalked == 0) {
				logic.Saving.save();
			}
			break;
		case 'o':
			if (logic.Player.ReversePixelsWalked == 0) {
				logic.Saving.load();
			}
			break;
		case 'r':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened == false) {
					logic.Player.attack();
				}
			}
			break;
		case 'e':
			if (logic.Options.options[0]) {
				if (logic.Inventory.inventoryopened) {
					logic.Inventory.inventoryopened = false;
				} else {
					logic.Inventory.inventoryopened = true;
					logic.Player.showinventory();
				}
			}
			break;
		}
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		if (logic.Options.options[0]) {
			if (e.getKeyChar() == ' ') {
				move = true;
			}
		}
		if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ESCAPE) {
			logic.Inventory.inventoryopened = false;
		}
	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		if (logic.Options.options[0]) {
			if (e.getKeyChar() == ' ') {
				move = false;
			}
		}
	}
}