package entities;

/**
 * 
 * @author Jan
 *
 */
public class Villager {

	public static void create() {
		drawpackage.ClassJLabel1.villager = new entities.Villager[5];
		new Villager(0, 1, 11, 5);
		new Villager(1, 1, 12, 5);
		new Villager(2, 1, 24, 5);
		new Villager(3, 1, 29, 6);
		new Villager(4, 1, 39, 7);
	}

	public int worldin;
	public int typ;
	public java.awt.Point position = new java.awt.Point();

	public Villager(int type, int worldinn, int xn, int yn) {
		worldin = worldinn;
		position = new java.awt.Point(xn, yn);
		typ = type;
		for (int i = 0; i < drawpackage.ClassJLabel1.villager.length; i++) {
			if (drawpackage.ClassJLabel1.villager[i] == null) {
				drawpackage.ClassJLabel1.villager[i] = this;
				break;
			}
		}
	}

	public void interact() {
		switch (typ) {
		case 0:
			drawpackage.ClassJFrame.cjta.append("Hallo, ich handle: " + "\n");
			drawpackage.ClassJFrame.cjta.append("(1) 1 * blume1 + 1 * blume2 + 1 * blume3 => 3 * potionhealth1" + "\n");
			drawpackage.ClassJFrame.cjta.append("(2) 1 * slimeball => 1 * coin" + "\n");
			drawpackage.ClassJFrame.cjta.append("(3) 1 * slimeballred => 3 * coin" + "\n");
			drawpackage.ClassJFrame.cjta.append("(4) 1 * slimeballblue => 3 * coin" + "\n");
			drawpackage.ClassJFrame.cjta.append("(5) 1 * crystal + 1 * mushroom => 2 * potionhealth2" + "\n");
			break;
		case 1:
			drawpackage.ClassJFrame.cjta.append("Hallo, ich handle: " + "\n");
			drawpackage.ClassJFrame.cjta.append("(1) 5 * coin => 1 * helmetgold" + "\n");
			drawpackage.ClassJFrame.cjta.append("(2) 8 * coin => 1 * chestplategold" + "\n");
			drawpackage.ClassJFrame.cjta.append("(3) 7 * coin => 1 * trousersgold" + "\n");
			drawpackage.ClassJFrame.cjta.append("(4) 4 * coin => 1 * shoesgold" + "\n");
			drawpackage.ClassJFrame.cjta.append("(5) 10 * coin => 1 * swordgold" + "\n");
			break;
		case 3:
			drawpackage.ClassJFrame.cjta.append("Ich bin der explosive Enrico." + "\n");
			break;
		case 4:
			drawpackage.ClassJFrame.cjta.append("Ich bin deine Mutter Margret." + "\n");
			if (logic.Player.Stats[0] < logic.Player.Stats[1]) {
				drawpackage.ClassJFrame.cjta.append("Du musst sicher müde sein. Ruh dich doch erstmal aus." + "\n");
				logic.Player.Stats[0] = logic.Player.Stats[1];
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			} else {
				drawpackage.ClassJFrame.cjta
						.append("Du bist ja gar nicht erschöpft! Bitte überanstrenge dich nicht." + "\n");
			}
			break;
		case 5:
			drawpackage.ClassJFrame.cjta.append("Ich bin der Aaron." + "\n");
			break;
		default:
			drawpackage.ClassJFrame.cjta.append("Ich bin doof." + "\n");
			break;
		}
	}

	public void trade(int i) {
		switch (typ) {
		case 0:
			switch (i) {
			case 1:
				if (logic.Inventory.testitem(logic.Inventory.Items.blume1, 1)
						&& logic.Inventory.testitem(logic.Inventory.Items.blume2, 1)
						&& logic.Inventory.testitem(logic.Inventory.Items.blume3, 1)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.potionhealth1, 3)) {
						logic.Inventory.removeitem(logic.Inventory.Items.blume1, 1);
						logic.Inventory.removeitem(logic.Inventory.Items.blume2, 1);
						logic.Inventory.removeitem(logic.Inventory.Items.blume3, 1);
						logic.Inventory.pickup(logic.Inventory.Items.potionhealth1, 3);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 2:
				if (logic.Inventory.testitem(logic.Inventory.Items.slimeball, 1)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.coin, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.slimeball, 1);
						logic.Inventory.pickup(logic.Inventory.Items.coin, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 3:
				if (logic.Inventory.testitem(logic.Inventory.Items.slimeballred, 1)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.coin, 3)) {
						logic.Inventory.removeitem(logic.Inventory.Items.slimeballred, 1);
						logic.Inventory.pickup(logic.Inventory.Items.coin, 3);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 4:
				if (logic.Inventory.testitem(logic.Inventory.Items.slimeballblue, 1)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.coin, 3)) {
						logic.Inventory.removeitem(logic.Inventory.Items.slimeballblue, 1);
						logic.Inventory.pickup(logic.Inventory.Items.coin, 3);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 5:
				if (logic.Inventory.testitem(logic.Inventory.Items.crystal, 1)
						&& logic.Inventory.testitem(logic.Inventory.Items.mushroom, 1)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.potionhealth2, 3)) {
						logic.Inventory.removeitem(logic.Inventory.Items.mushroom, 1);
						logic.Inventory.removeitem(logic.Inventory.Items.crystal, 1);
						logic.Inventory.pickup(logic.Inventory.Items.potionhealth2, 2);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			default:
				drawpackage.ClassJFrame.cjta.append("Handel nicht gefunden." + "\n");
				break;
			}
			break;
		case 1:
			switch (i) {
			case 1:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 5)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.helmetgold, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 5);
						logic.Inventory.pickup(logic.Inventory.Items.helmetgold, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 2:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 8)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.chestplategold, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 8);
						logic.Inventory.pickup(logic.Inventory.Items.chestplategold, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 3:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 7)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.trousersgold, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 7);
						logic.Inventory.pickup(logic.Inventory.Items.trousersgold, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 4:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 4)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.shoesgold, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 4);
						logic.Inventory.pickup(logic.Inventory.Items.shoesgold, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			case 5:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 10)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.swordgold, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 10);
						logic.Inventory.pickup(logic.Inventory.Items.swordgold, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			default:
				drawpackage.ClassJFrame.cjta.append("Handel nicht gefunden." + "\n");
				break;
			}
			break;
		case 2:
			switch (i) {
			case 1:
				if (logic.Inventory.testitem(logic.Inventory.Items.coin, 3)) {
					if (logic.Inventory.testpickup(logic.Inventory.Items.apfel, 1)) {
						logic.Inventory.removeitem(logic.Inventory.Items.coin, 3);
						logic.Inventory.pickup(logic.Inventory.Items.apfel, 1);
					} else {
						drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Platz im Inventar." + "\n");
					}
				} else {
					drawpackage.ClassJFrame.cjta.append("Du hast nicht genügend Materialien im Inventar." + "\n");
				}
				break;
			default:
				drawpackage.ClassJFrame.cjta.append("Handel nicht gefunden." + "\n");
				break;
			}
			break;
		case 3:
			drawpackage.ClassJFrame.cjta.append("NEIN!!! NEIN!!! NEIN!!!" + "\n");
			break;
		case 4:
			drawpackage.ClassJFrame.cjta.append("Ich verkaufe dir nichts." + "\n");
			break;
		case 5:
			switch (i) {
			case 0:
				logic.Inventory.pickup(logic.Inventory.Items.steak, 1);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + i);
			}
		default:
			drawpackage.ClassJFrame.cjta.append("Mir wurde kein Text gegeben." + "\n");
		}
	}
}