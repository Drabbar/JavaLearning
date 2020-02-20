package logic;

import drawpackage.ClassJFrame;

/**
 * Beinhaltet ein Enum "Items" mit allen möglichen Items sowie die Konverter zu
 * Zahlen und zurück. Zusätzlich ist hier die Aufheb-Engine.
 * 
 * @author Jan
 *
 */
public class Inventory {

	/**
	 * Alle Items
	 */
	public static int maxstacksize = 50;
	public static boolean inventoryopened = false;

	public static enum Items {
		nothing, steak, blume1, blume2, blume3, apfel, slimeball, potionemty, potionhealth1, potionhealth2,
		potionhealth3, swordno, helmetno, chestplateno, trousersno, shoesno, swordgold, helmetgold, chestplategold,
		trousersgold, shoesgold, coin, slimeballred, slimeballblue, crystal, mushroom
	}

	/**
	 * Returns the id of the inputted Item, nothing found == null
	 * 
	 * @param i
	 * @return
	 */
	public static Integer intconverter(Items i) {
		switch (i) {
		case nothing:
			return 0;
		case steak:
			return 1;
		case blume1:
			return 2;
		case blume2:
			return 3;
		case blume3:
			return 4;
		case apfel:
			return 5;
		case slimeball:
			return 6;
		case potionemty:
			return 7;
		case potionhealth1:
			return 8;
		case potionhealth2:
			return 9;
		case potionhealth3:
			return 10;
		case swordno:
			return 11;
		case helmetno:
			return 12;
		case chestplateno:
			return 13;
		case trousersno:
			return 14;
		case shoesno:
			return 15;
		case swordgold:
			return 16;
		case helmetgold:
			return 17;
		case chestplategold:
			return 18;
		case trousersgold:
			return 19;
		case shoesgold:
			return 20;
		case coin:
			return 21;
		case slimeballblue:
			return 22;
		case slimeballred:
			return 23;
		case crystal:
			return 24;
		case mushroom:
			return 25;
		}
		return null;
	}

	/**
	 * Returns the Item of the inputted id, nothing found == null
	 * 
	 * @param i
	 * @return
	 */
	public static Items itemconverter(int i) {
		switch (i) {
		case 0:
			return Items.nothing;
		case 1:
			return Items.steak;
		case 2:
			return Items.blume1;
		case 3:
			return Items.blume2;
		case 4:
			return Items.blume3;
		case 5:
			return Items.apfel;
		case 6:
			return Items.slimeball;
		case 7:
			return Items.potionemty;
		case 8:
			return Items.potionhealth1;
		case 9:
			return Items.potionhealth2;
		case 10:
			return Items.potionhealth3;
		case 11:
			return Items.swordno;
		case 12:
			return Items.helmetno;
		case 13:
			return Items.chestplateno;
		case 14:
			return Items.trousersno;
		case 15:
			return Items.shoesno;
		case 16:
			return Items.swordgold;
		case 17:
			return Items.helmetgold;
		case 18:
			return Items.chestplategold;
		case 19:
			return Items.trousersgold;
		case 20:
			return Items.shoesgold;
		case 21:
			return Items.coin;
		case 22:
			return Items.slimeballblue;
		case 23:
			return Items.slimeballred;
		case 24:
			return Items.crystal;
		case 25:
			return Items.mushroom;
		}
		return null;
	}

	/**
	 * Hebt Items auf, Return gibt den Erfolg der operation an
	 * 
	 * @return boolean
	 * @param i Item
	 * @param n Anzahl
	 */
	public static boolean pickup(Items i, int n) {
		for (int j = 0; j < Player.inventory.length; j++) {
			if (Player.inventory[j][0] == intconverter(i)) {
				if (Player.inventory[j][1] + n <= maxstacksize) {
					Player.inventory[j][1] += n;
					drawpackage.ClassJFrame.cjta.append("Hinzugefügt: " + n + " * " + i + "\n");
					return true;
				} else {
					drawpackage.ClassJFrame.cjta
							.append("Hinzugefügt: " + (maxstacksize - Player.inventory[j][1]) + " * " + i + "\n");
					n -= maxstacksize - Player.inventory[j][1];
					Player.inventory[j][1] = maxstacksize;
				}
			}
		}
		for (int j = 0; j < Player.inventory.length; j++) {
			if (Player.inventory[j][0] == intconverter(Items.nothing)) {
				Player.inventory[j][0] = intconverter(i);
				Player.inventory[j][1] = n;
				drawpackage.ClassJFrame.cjta.append("Hinzugefügt: " + n + " * " + i + "\n");
				return true;
			}
		}
		return false;
	}

	public static boolean testpickup(Items i, int n) {
		for (int j = 0; j < Player.inventory.length; j++) {
			if (Player.inventory[j][0] == intconverter(i)) {
				if (Player.inventory[j][1] + n <= maxstacksize) {
					return true;
				} else {
					n -= maxstacksize - Player.inventory[j][1];
				}
			}
		}
		for (int j = 0; j < Player.inventory.length; j++) {
			if (Player.inventory[j][0] == intconverter(Items.nothing)) {
				return true;
			}
		}
		return false;
	}

	public static boolean testitem(Items i, int n) {
		int nt = 0;
		for (int j = 0; j < Player.inventory.length; j++) {
			if (Player.inventory[j][0] == intconverter(i) && Player.inventory[j][1] > n) {
				return true;
			} else if (Player.inventory[j][0] == intconverter(i)) {
				nt += Player.inventory[j][1];
			}
		}
		if (nt >= n) {
			return true;
		}
		return false;
	}

	public static void removeitem(Items i, int n) {
		if (testitem(i, n) == true) {
			drawpackage.ClassJFrame.cjta.append("Entfernt: " + n + " * " + i + "\n");
			for (int j = 0; j < Player.inventory.length; j++) {
				if (Player.inventory[j][0] == intconverter(i) && Player.inventory[j][1] > n) {
					Player.inventory[j][1] -= n;
				} else if (Player.inventory[j][0] == intconverter(i)) {
					n -= Player.inventory[j][1];
					Player.inventory[j][1] = 0;
					Player.inventory[j][0] = 0;
				}
			}
		}
	}

	public static void use(int field) {
		switch (itemconverter(Player.inventory[field][0])) {
		case apfel:
			Inventory.removeitem(Items.apfel, 1);
			drawpackage.ClassJFrame.cjta.append("XP + 1" + "\n");
			Player.Stats[7]++;
			if (Player.inventory[field][1] <= 0) {
				Player.inventory[field][0] = intconverter(Items.nothing);
				Player.inventory[field][0] = 0;
			}
			break;
		case potionhealth1:
			if ((Player.Stats[0] + 5) > Player.Stats[1]) {
				Player.Stats[0] = Player.Stats[1];
			} else if ((Player.Stats[0] + 5) <= Player.Stats[1]) {
				Player.Stats[0] += 5;
			}
			Inventory.removeitem(Items.potionhealth1, 1);
			ClassJFrame.cjta.append("Geheilt: +5, nun " + Player.Stats[0] + "\n");
			Inventory.pickup(Items.potionemty, 1);
			if (Player.inventory[field][1] <= 0) {
				Player.inventory[field][0] = intconverter(Items.nothing);
				Player.inventory[field][0] = 0;
			}
			break;
		case potionhealth2:
			if ((Player.Stats[0] + 20) > Player.Stats[1]) {
				Player.Stats[0] = Player.Stats[1];
			} else if ((Player.Stats[0] + 20) <= Player.Stats[1]) {
				Player.Stats[0] += 20;
			}
			Inventory.removeitem(Items.potionhealth2, 1);
			ClassJFrame.cjta.append("Geheilt: +20, nun " + Player.Stats[0] + "\n");
			Inventory.pickup(Items.potionemty, 1);
			if (Player.inventory[field][1] <= 0) {
				Player.inventory[field][0] = intconverter(Items.nothing);
				Player.inventory[field][0] = 0;
			}
			break;
		case potionhealth3:
			if ((Player.Stats[0] + 50) > Player.Stats[1]) {
				Player.Stats[0] = Player.Stats[1];
			} else if ((Player.Stats[0] + 50) <= Player.Stats[1]) {
				Player.Stats[0] += 50;
			}
			Inventory.removeitem(Items.potionhealth3, 1);
			ClassJFrame.cjta.append("Geheilt: +50, nun " + Player.Stats[0] + "\n");
			Inventory.pickup(Items.potionemty, 1);
			if (Player.inventory[field][1] <= 0) {
				Player.inventory[field][0] = intconverter(Items.nothing);
				Player.inventory[field][0] = 0;
			}
			break;
		default:
			break;
		}
	}
}