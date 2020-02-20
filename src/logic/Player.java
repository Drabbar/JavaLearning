package logic;

/**
 * Der Spieler.
 * 
 * @author Jan
 *
 */
public class Player {

	public static Integer ReversePixelsWalked = 0;
	public static int attackcooldown = 0;
	/**
	 * The World you're in.
	 */
	public static Integer worldin;

	/**
	 * The Position you're at
	 */
	public static java.awt.Point position;

	/**
	 * Blickrichtung
	 */
	public static enum Blickrichtung {
		oben, unten, links, rechts, no
	}

	public static Blickrichtung br = Blickrichtung.rechts;

	/**
	 * The Inventory[place][iteminfo] iteminfo: 0: Type of Item 1: Amount
	 */
	public static Integer inventory[][] = new Integer[25][2];

	/**
	 * 0: Sword; 1: Helmet; 2: Chestplate; 3: Leggins; 4: Shoes
	 */
	public static Integer equipment[] = new Integer[5];

	/**
	 * 0: Health; 1: MaxHealth; 2: Attack; 3: Defense; 4: Speed; 5: Mana; 6:
	 * MaxMana; 7: XP; 8: XP für nächstes Level; 9: Level
	 */
	public static int Stats[] = new int[10];

	public Player() {
		position = new java.awt.Point(45, 6);
		worldin = 1;
		// Füllt das Inventar mit nichts
		for (int i = 0; i < inventory.length; i++) {
			inventory[i][0] = Inventory.intconverter(logic.Inventory.Items.nothing);
			inventory[i][1] = 0;
		}
		equipment[0] = Inventory.intconverter(Inventory.Items.swordno);
		equipment[1] = Inventory.intconverter(Inventory.Items.helmetno);
		equipment[2] = Inventory.intconverter(Inventory.Items.chestplateno);
		equipment[3] = Inventory.intconverter(Inventory.Items.trousersno);
		equipment[4] = Inventory.intconverter(Inventory.Items.shoesno);
		// Stats
		Stats[1] = 20; // MaxHealth
		Stats[0] = Stats[1]; // Health
		Stats[2] = 1; // Attack
		Stats[3] = 1; // Defense
		Stats[4] = 1; // Speed
		Stats[6] = 10; // MaxMana
		Stats[5] = Stats[6]; // Mana
		Stats[7] = 0; // XP
		Stats[8] = 20; // XP für nächstes Level
		Stats[9] = 1; // Level
	}

	public static void interact() {
		switch (br) {
		case links:
			if (position.x != 0) {
				interactwith(position.x - 1, position.y);
			}
			break;
		case oben:
			if (position.y != 0) {
				interactwith(position.x, position.y - 1);
			}
			break;
		case rechts:
			switch (worldin) {
			case 0:
				if (position.x != Main.world1.length) {
					interactwith(position.x + 1, position.y);
				}
				break;
			case 1:
				if (position.x != Main.house1.length) {
					interactwith(position.x + 1, position.y);
				}
				break;
			}
			break;
		case unten:
			switch (worldin) {
			case 0:
				if (position.y != Main.world1[0].length) {
					interactwith(position.x, position.y + 1);
				}
				break;
			case 1:
				if (position.y != Main.house1[0].length) {
					interactwith(position.x, position.y + 1);
				}
				break;
			}
			break;
		case no:
			break;
		}
	}

	public static void interactwith(int x, int y) {
		switch (worldin) {
		case 0:
			Main.world1[x][y][0] = interactwithblock(Main.world1[x][y][0], x, y);
			break;

		case 1:
			Main.house1[x][y][0] = interactwithblock(Main.house1[x][y][0], x, y);
			break;
		}
	}

	public static int interactwithblock(int a, int x, int y) {
		int b = a;
		switch (a) {
		case 3:
			if (Inventory.pickup(logic.Inventory.Items.blume1, 1)) {
				Timer.actions[Timer.cf][0] = Timer.it + 50;
				Timer.actions[Timer.cf][1] = Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 3;
				Timer.cf++;
				return 0;
			}
			break;
		case 4:
			if (Inventory.pickup(logic.Inventory.Items.blume2, 1)) {
				Timer.actions[Timer.cf][0] = Timer.it + 50;
				Timer.actions[Timer.cf][1] = Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 4;
				Timer.cf++;
				return 0;
			}
			break;
		case 5:
			if (Inventory.pickup(logic.Inventory.Items.blume3, 1)) {
				Timer.actions[Timer.cf][0] = Timer.it + 50;
				Timer.actions[Timer.cf][1] = Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 5;
				Timer.cf++;
				return 0;
			}
			break;
		case 10:
			if (Inventory.pickup(logic.Inventory.Items.apfel, 1)) {
				Timer.actions[Timer.cf][0] = logic.Timer.it + 100;
				Timer.actions[Timer.cf][1] = logic.Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 10;
				Timer.cf++;
				return 9;
			}
		case 51:
			if (Inventory.pickup(logic.Inventory.Items.crystal, 1)) {
				Timer.actions[Timer.cf][0] = logic.Timer.it + 150;
				Timer.actions[Timer.cf][1] = logic.Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 51;
				Timer.cf++;
				return 50;
			}
		case 52:
			if (Inventory.pickup(logic.Inventory.Items.mushroom, 1)) {
				Timer.actions[Timer.cf][0] = logic.Timer.it + 150;
				Timer.actions[Timer.cf][1] = logic.Player.worldin;
				Timer.actions[Timer.cf][2] = x;
				Timer.actions[Timer.cf][3] = y;
				Timer.actions[Timer.cf][4] = 52;
				Timer.cf++;
				return 50;
			}
		default:
			break;
		}
		for (int i = 0; i < drawpackage.ClassJLabel1.villager.length; i++) {
			if (drawpackage.ClassJLabel1.villager[i].worldin == Player.worldin) {
				if (drawpackage.ClassJLabel1.villager[i].position.x == x) {
					if (drawpackage.ClassJLabel1.villager[i].position.y == y) {
						drawpackage.ClassJLabel1.villager[i].interact();
					}
				}
			}
		}
		return b;
	}

	public static void showinventory() {
		for (int i = 0; i < inventory.length; i++) {
			if (Inventory.itemconverter(inventory[i][0]) != Inventory.Items.nothing) {
				drawpackage.ClassJFrame.cjta
						.append(i + " - " + Inventory.itemconverter(inventory[i][0]) + " * " + inventory[i][1] + "\n");
			}
		}
	}

	public static void attack() {
		int damage = Stats[2];
		if (attackcooldown <= 0) {
			attackcooldown += 10;
			switch (br) {
			case links:
				damage(worldin, position.x - 1, position.y, damage);
				break;
			case oben:
				damage(worldin, position.x, position.y - 1, damage);
				break;
			case rechts:
				damage(worldin, position.x + 1, position.y, damage);
				break;
			case unten:
				damage(worldin, position.x, position.y + 1, damage);
				break;
			default:
				break;
			}
		}
	}

	public static void damage(int worldin, int x, int y, int amount) {
		for (int i = 0; i < drawpackage.ClassJLabel1.slimes.length; i++) {
			if (drawpackage.ClassJLabel1.slimes[i].worldin == worldin) {
				if (drawpackage.ClassJLabel1.slimes[i].position.x == x) {
					if (drawpackage.ClassJLabel1.slimes[i].position.y == y) {
						drawpackage.ClassJLabel1.slimes[i].health -= amount;
						drawpackage.ClassJFrame.cjta
								.append("Slime: " + drawpackage.ClassJLabel1.slimes[i].health + "\n");
					}
				}
			}
		}
	}

	public static boolean getEnemy(int worldin, int x, int y) {
		for (int i = 0; i < drawpackage.ClassJLabel1.slimes.length; i++) {
			if (drawpackage.ClassJLabel1.slimes[i].worldin == worldin) {
				if (drawpackage.ClassJLabel1.slimes[i].position.x == x) {
					if (drawpackage.ClassJLabel1.slimes[i].position.y == y) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void unequip(int x) {
		switch (x) {
		case 0:
			if (Player.equipment[x] != Inventory.intconverter(Inventory.Items.swordno)) {
				if (Inventory.testpickup(Inventory.itemconverter(Player.equipment[x]), 1)) {
					Inventory.pickup(Inventory.itemconverter(Player.equipment[x]), 1);
					Player.equipment[x] = Inventory.intconverter(Inventory.Items.swordno);
				} else {
					drawpackage.ClassJFrame.cjta.append("Nicht genügend platz im Inventar." + "\n");
				}
			}
			break;
		case 1:
			if (Player.equipment[x] != Inventory.intconverter(Inventory.Items.helmetno)) {
				if (Inventory.testpickup(Inventory.itemconverter(Player.equipment[x]), 1)) {
					Inventory.pickup(Inventory.itemconverter(Player.equipment[x]), 1);
					Player.equipment[x] = Inventory.intconverter(Inventory.Items.helmetno);
				} else {
					drawpackage.ClassJFrame.cjta.append("Nicht genügend platz im Inventar." + "\n");
				}
			}
			break;
		case 2:
			if (Player.equipment[x] != Inventory.intconverter(Inventory.Items.chestplateno)) {
				if (Inventory.testpickup(Inventory.itemconverter(Player.equipment[x]), 1)) {
					Inventory.pickup(Inventory.itemconverter(Player.equipment[x]), 1);
					Player.equipment[x] = Inventory.intconverter(Inventory.Items.chestplateno);
				} else {
					drawpackage.ClassJFrame.cjta.append("Nicht genügend platz im Inventar." + "\n");
				}
			}
			break;
		case 3:
			if (Player.equipment[x] != Inventory.intconverter(Inventory.Items.trousersno)) {
				if (Inventory.testpickup(Inventory.itemconverter(Player.equipment[x]), 1)) {
					Inventory.pickup(Inventory.itemconverter(Player.equipment[x]), 1);
					Player.equipment[x] = Inventory.intconverter(Inventory.Items.trousersno);
				} else {
					drawpackage.ClassJFrame.cjta.append("Nicht genügend platz im Inventar." + "\n");
				}
			}
			break;
		case 4:
			if (Player.equipment[x] != Inventory.intconverter(Inventory.Items.shoesno)) {
				if (Inventory.testpickup(Inventory.itemconverter(Player.equipment[x]), 1)) {
					Inventory.pickup(Inventory.itemconverter(Player.equipment[x]), 1);
					Player.equipment[x] = Inventory.intconverter(Inventory.Items.shoesno);
				} else {
					drawpackage.ClassJFrame.cjta.append("Nicht genügend platz im Inventar." + "\n");
				}
			}
			break;
		}
	}

	public static void equip(int x) {
		int y;
		switch (Inventory.itemconverter(inventory[x][0])) {
		case swordgold:
			y = 0;
			if (equipment[y] == Inventory.intconverter(Inventory.Items.swordno)) {
				equipment[y] = inventory[x][0];
				Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
			} else {
				if (Inventory.pickup(Inventory.itemconverter(equipment[y]), 1)) {
					Inventory.pickup(Inventory.itemconverter(equipment[y]), 1);
					equipment[y] = inventory[x][0];
					Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
				}
			}
			break;
		case helmetgold:
			y = 1;
			if (equipment[y] == Inventory.intconverter(Inventory.Items.helmetno)) {
				equipment[y] = inventory[x][0];
				Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
			} else {
				if (Inventory.pickup(Inventory.itemconverter(equipment[y]), 1)) {
					Inventory.pickup(Inventory.itemconverter(equipment[y]), 1);
					equipment[y] = inventory[x][0];
					Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
				}
			}
			break;
		case chestplategold:
			y = 2;
			if (equipment[y] == Inventory.intconverter(Inventory.Items.chestplateno)) {
				equipment[y] = inventory[x][0];
				Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
			} else {
				if (Inventory.pickup(Inventory.itemconverter(equipment[y]), 1)) {
					Inventory.pickup(Inventory.itemconverter(equipment[y]), 1);
					equipment[y] = inventory[x][0];
					Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
				}
			}
			break;
		case trousersgold:
			y = 3;
			if (equipment[y] == Inventory.intconverter(Inventory.Items.trousersno)) {
				equipment[y] = inventory[x][0];
				Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
			} else {
				if (Inventory.pickup(Inventory.itemconverter(equipment[y]), 1)) {
					Inventory.pickup(Inventory.itemconverter(equipment[y]), 1);
					equipment[y] = inventory[x][0];
					Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
				}
			}
			break;
		case shoesgold:
			y = 4;
			if (equipment[y] == Inventory.intconverter(Inventory.Items.shoesno)) {
				equipment[y] = inventory[x][0];
				Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
			} else {
				if (Inventory.pickup(Inventory.itemconverter(equipment[y]), 1)) {
					Inventory.pickup(Inventory.itemconverter(equipment[y]), 1);
					equipment[y] = inventory[x][0];
					Inventory.removeitem(Inventory.itemconverter(inventory[x][0]), 1);
				}
			}
			break;
		default:
			drawpackage.ClassJFrame.cjta.append("Kann nicht ausgerüstet werden." + "\n");
			break;
		}
	}

	public static void teleport(int nx, int ny, int nworldin) {
		position.x = nx;
		position.y = ny;
		worldin = nworldin;
	}
}