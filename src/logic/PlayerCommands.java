package logic;

/**
 * 
 * @author Jan
 *
 */
public class PlayerCommands {

	public static void interact() {
		Player.interact();
	}

	public static void trade(int i) {
		int x = Player.position.x, y = Player.position.y, worldin = Player.worldin;
		switch (logic.Player.br) {
		case links:
			x--;
			break;
		case oben:
			y--;
			break;
		case rechts:
			x++;
			break;
		case unten:
			y++;
			break;
		case no:
			break;
		}
		for (int j = 0; j < drawpackage.ClassJLabel1.villager.length; j++) {
			if (drawpackage.ClassJLabel1.villager[j].worldin == worldin) {
				if (drawpackage.ClassJLabel1.villager[j].position.x == x
						&& drawpackage.ClassJLabel1.villager[j].position.y == y) {
					drawpackage.ClassJLabel1.villager[j].trade(i);
				}
			}
		}
	}

	public static void loginventory() {
		Player.showinventory();
	}

	public static void logequipement() {
		for (int i = 0; i < Player.equipment.length; i++) {
			drawpackage.ClassJFrame.cjta.append(i + "\n");
		}
	}

	public static void attack() {
		Player.attack();
	}

	public static void unequip(int i) {
		Player.unequip(i);
	}

	public static void equip(int i) {
		Player.equip(i);
	}

	public static void turn(Player.Blickrichtung bl) {
		if (Inventory.inventoryopened == false) {
			if (logic.Player.ReversePixelsWalked <= 0) {
				Player.br = bl;
			}
		}
	}

	public static void walk() {
		drawpackage.KeyHandler.move = true;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		drawpackage.KeyHandler.move = false;
		while (PlayerMove.moving) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}

	public static void walk(int i) {
		for (int x = 0; x < i; x++) {
			walk();
		}
	}

	public static void use(int i) {
		logic.Inventory.use(i);
	}

	public static void save() {
		logic.Saving.save();
	}

	public static void load() {
		logic.Saving.load();
	}

	public static void clearLog() {
		drawpackage.ClassJFrame.cjta.setText("");
	}

	public static void goTo(int x, int y) {
		logic.Player.Blickrichtung[] br = pathfinder.Interface.findpath(logic.Player.worldin, logic.Player.position.x,
				logic.Player.position.y, x, y);
		if (br != null) {
			for (int i = 0; i < br.length; i++) {
				turn(br[i]);
				walk();
			}
		}
	}

	public static int getTile() {
		int x = Player.position.x, y = Player.position.y, worldin = Player.worldin;
		switch (logic.Player.br) {
		case links:
			x--;
			break;
		case oben:
			y--;
			break;
		case rechts:
			x++;
			break;
		case unten:
			y++;
			break;
		case no:
			break;
		}
		switch (worldin) {
		case 0:
			return Main.world1[x][y][0];
		case 1:
			return Main.house1[x][y][0];
		}
		return -1;
	}

	public static boolean getTangibel() {
		int x = Player.position.x, y = Player.position.y, worldin = Player.worldin;
		switch (logic.Player.br) {
		case links:
			x--;
			break;
		case oben:
			y--;
			break;
		case rechts:
			x++;
			break;
		case unten:
			y++;
			break;
		case no:
			break;
		}
		switch (worldin) {
		case 0:
			if (Main.world1[x][y][1] == 0) {
				return false;
			} else if (Main.world1[x][y][1] == 1) {
				return true;
			}
		case 1:
			if (Main.house1[x][y][1] == 0) {
				return false;
			} else if (Main.house1[x][y][1] == 1) {
				return true;
			}
		}
		return false;
	}
}