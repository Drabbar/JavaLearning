package decipher;

import logic.Inventory.Items;
import logic.Player;
import logic.Player.Blickrichtung;

public class MethodClass {

	/**
	 * allowed[count of all commands]
	 */
	public static boolean[] allowed = new boolean[40];

	// Methoden

	public static void interact() {
		if (allowed[0])
			logic.PlayerCommands.interact();
		else
			log("interact();" + " not availble");
	}

	public static void trade(int i) {
		if (allowed[1])
			logic.PlayerCommands.trade(i);
		else
			log("trade(int);" + " not availble");
	}

	public static void loginventory() {
		if (allowed[2])
			logic.PlayerCommands.loginventory();
		else
			log("logininventory();" + " not availble");
	}

	public static void logequipement() {
		if (allowed[3])
			logic.PlayerCommands.logequipement();
		else
			log("logequipement();" + " not availble");
	}

	public static void attack() {
		if (allowed[4])
			logic.PlayerCommands.attack();
		else
			log("attack();" + " not availble");
	}

	public static void unequip(int i) {
		if (allowed[5])
			logic.PlayerCommands.unequip(i);
		else
			log("unequip(int);" + " not availble");
	}

	public static void equip(int i) {
		if (allowed[6])
			logic.PlayerCommands.equip(i);
		else
			log("equip(int);" + " not availble");
	}

	public static void turn(Blickrichtung br) {
		if (allowed[7]) {
			switch (br) {
			case links:
				logic.PlayerCommands.turn(Blickrichtung.links);
				break;
			case oben:
				logic.PlayerCommands.turn(Blickrichtung.oben);
				break;
			case rechts:
				logic.PlayerCommands.turn(Blickrichtung.rechts);
				break;
			case unten:
				logic.PlayerCommands.turn(Blickrichtung.unten);
				break;
			case no:
				logic.PlayerCommands.turn(Blickrichtung.rechts);
				break;
			}
		} else
			log("turn(Blickrichtung);" + " not availble");
	}

	public static void turn(char br) {
		if (allowed[8]) {
			char blr = Character.toLowerCase(br);
			switch (blr) {
			case 'l':
				turn(Blickrichtung.links);
				break;
			case 'o':
				turn(Blickrichtung.oben);
				break;
			case 'r':
				turn(Blickrichtung.rechts);
				break;
			case 'u':
				turn(Blickrichtung.unten);
				break;
			}
		} else
			log("turn(char);" + " not availble");
	}

	public static void walk() {
		if (allowed[9])
			logic.PlayerCommands.walk();
		else
			log("walk();" + " not availble");
	}

	public static void walk(int i) {
		if (allowed[10])
			logic.PlayerCommands.walk(i);
		else
			log("walk(int);" + " not availble");
	}

	public static void use(int i) {
		if (allowed[11])
			logic.PlayerCommands.use(i);
		else
			log("use(int);" + " not availble");
	}

	public static void save() {
		if (allowed[12])
			logic.PlayerCommands.save();
		else
			log("save();" + " not availble");
	}

	public static void load() {
		if (allowed[13])
			logic.PlayerCommands.load();
		else
			log("load();" + " not availble");
	}

	public static void log(String s) {
		if (allowed[14])
			drawpackage.ClassJFrame.cjta.append(s + "\n");
		else
			log("log(String);" + " not availble");
	}

	public static void log(int s) {
		if (allowed[15])
			drawpackage.ClassJFrame.cjta.append(s + "\n");
		else
			log("turn(char);" + " not availble");
	}

	public static void wait(int Time) {
		if (allowed[16]) {
			try {
				Thread.sleep(Time);
			} catch (InterruptedException e) {
			}
		} else
			log("wait(int);" + " not availble");
	}

	public static void removeItem(logic.Inventory.Items i, int n) {
		if (allowed[17]) {
			logic.Inventory.removeitem(i, n);
		} else
			log("removeItem(Item,int);" + " not availble");
	}

	public static void clearLog() {
		if (allowed[18]) {
			logic.PlayerCommands.clearLog();
		} else
			log("clearLog();" + " not availble");
	}

	public static void goTo(int x, int y) {
		if (allowed[19]) {
			logic.PlayerCommands.goTo(x, y);
		} else
			log("help();" + " not availble");
	}

	public static void help() {
		drawpackage.ClassJFrame.cjta.append("Hilfe: " + "\n" + "		interact();" + "\n" + "		trade(int);" + "\n"
				+ "		loginventory();" + "\n" + "		logequipement();" + "\n" + "		attack();" + "\n"
				+ "		unequip();" + "\n" + "		equip();" + "\n" + "		turn(Blickrichtung);" + "\n"
				+ "		turn(char);" + "\n" + "		walk();" + "\n" + "		walk(int);" + "\n" + "		use(int);"
				+ "\n" + "		save();" + "\n" + "		load();" + "\n" + "		log(String);" + "\n"
				+ "		log(int);" + "\n" + "		wait(int);" + "\n" + "		removeItem(Items, int);" + "\n"
				+ "		help();" + "\n" + "		getHealth();" + "\n" + "		getMaxHealth();" + "\n"
				+ "		getMana();" + "\n" + "		getMaxMana();" + "\n" + "		getXP();" + "\n"
				+ "		getXPNeeeded();" + "\n" + "		getX();" + "\n" + "		getY();" + "\n" + "		getWorldin();"
				+ "\n" + "		getBlickrichtung();" + "\n" + "		testenemy();" + "\n" + "		getItemSlot(Items);"
				+ "\n" + "		getItemCount(Items);" + "\n" + "		testItems(Items, int);" + "\n");
	}

	// Variablen

	public static int getHealth() {
		if (allowed[20])
			return logic.Player.Stats[0];
		else
			log("getHealth();" + " not availble");
		return 0;
	}

	public static int getMaxHealth() {
		if (allowed[21])
			return logic.Player.Stats[1];
		else
			log("getMaxHealth();" + " not availble");
		return 0;
	}

	public static int getMana() {
		if (allowed[22])
			return logic.Player.Stats[5];
		else
			log("getMana()();" + " not availble");
		return 0;
	}

	public static int getMaxMana() {
		if (allowed[23])
			return logic.Player.Stats[6];
		else
			log("getMaxMana();" + " not availble");
		return 0;
	}

	public static int getXP() {
		if (allowed[24])
			return logic.Player.Stats[7];
		else
			log("getXP()();" + " not availble");
		return 0;
	}

	public static int getXPNeeded() {
		if (allowed[25])
			return logic.Player.Stats[8];
		else
			log("getXPNeeded();" + " not availble");
		return 0;
	}

	public static int getX() {
		if (allowed[26])
			return logic.Player.position.x;
		else
			log("getX();" + " not availble");
		return 0;
	}

	public static int getY() {
		if (allowed[27])
			return logic.Player.position.y;
		else
			log("getY();" + " not availble");
		return 0;
	}

	public static int getWorldin() {
		if (allowed[28])
			return logic.Player.worldin;
		else
			log("getWorldin();" + " not availble");
		return 0;
	}

	public static Blickrichtung getBlickrichtung() {
		if (allowed[29]) {
			if (logic.Player.br == logic.Player.Blickrichtung.no) {
				return Blickrichtung.rechts;
			} else {
				return logic.Player.br;
			}
		} else
			log("getBlickrichtung();" + " not availble");
		return Blickrichtung.no;
	}

	public static char getcharBlickrichtung() {
		if (allowed[30]) {
			switch (getBlickrichtung()) {
			case oben:
				return 'O';
			case rechts:
				return 'R';
			case unten:
				return 'U';
			case links:
				return 'L';
			case no:
				return 'R';
			}
			return 'N';
		} else
			log("getcharBlickrichtung();" + " not availble");
		return 0;
	}

	public static boolean testenemy() {
		if (allowed[31]) {
			if (Player.getEnemy(getWorldin(), getX(), getY())) {
				return true;
			} else {
				return false;
			}
		} else
			log("testenemy();" + " not availble");
		return false;
	}

	/**
	 * Gibt den Slot aus, in dem das Item gefunden wurde. (Wenn kein Item vorhanden,
	 * -1)
	 * 
	 * @param i
	 * @return
	 */
	public static int getItemSlot(logic.Inventory.Items i) {
		if (allowed[32]) {
			if (logic.Inventory.testitem(i, 1)) {
				for (int j = 0; j < logic.Player.inventory.length; j++) {
					if (logic.Player.inventory[j][0] == logic.Inventory.intconverter(i)) {
						return j;
					}
				}
			} else {
				return -1;
			}
			return -1;
		} else
			log("getItemSlot(Item);" + " not availble");
		return 0;
	}
	/**
	 * Gibt an, wie viele eines Items im Inventar sind.
	 * 
	 * @param i
	 * @return
	 */
	public static int getItemCount(logic.Inventory.Items i) {
		if (allowed[33]) {
			int n = 0;
			for (int j = 0; j < logic.Player.inventory.length; j++) {
				if (logic.Player.inventory[j][0] == logic.Inventory.intconverter(i)) {
					n += logic.Player.inventory[j][1];
				}
			}
			return n;
		} else
			log("getItemCount(Item);" + " not availble");
		return 0;
	}

	public static boolean testItems(logic.Inventory.Items i, int n) {
		if (allowed[34]) {
			return logic.Inventory.testitem(i, n);
		} else
			log("testItems(Item,int);" + " not availble");
		return false;
	}
	
	public static void duuud() {
	logic.Inventory.pickup(Items.potionhealth1,2);
	turn('U');
	walk(11);
	turn('L');
	walk();
	goTo(6,2);
	goTo(14,44);
	turn('L');
	walk();
	for(int i = 0;i < 5;i++)
	{
	    attack();
	    wait(1050);	
	}
	turn('o');
	walk();
	log("escape");
	log("health before:");
	log(getHealth());
	wait(1050);	
	use(getItemSlot(Items.potionhealth1));
	wait(2000);	
	use(getItemSlot(Items.potionhealth1));

	log("health now:");
	log(getHealth());

	turn('u');
	walk();
	turn('l');
	for(int y = 0;y < 5;y++)
	{
	    attack();
	    wait(1050);	
	}
	log("win");
	}
}