package entities;

/**
 * 
 * @author Jan
 *
 */
public class Slime {

	public static void create() {
		drawpackage.ClassJLabel1.slimes = new entities.Slime[11];
		for (int i = 0; i < drawpackage.ClassJLabel1.slimes.length; i++) {
			new entities.Slime(i);
		}
	}

	public int level;
	public int health;
	public int worldin;
	public int id;
	public int damage;
	public java.awt.Point position = new java.awt.Point();
	public boolean noticed = false;

	public Slime(int i) {
		drawpackage.ClassJLabel1.slimes[i] = this;
		if (i <= 1) {
			level = 0;
			damage = 0;
		} else if (i <= 3) {
			level = 1;
			damage = 1;
		} else if (i == 4) {
			level = 2;
			damage = 2;
		} else if (i == 5) {
			level = 3;
			damage = 2;
		} else if (i == 6) {
			level = 4;
			damage = 2;
		} else if (i >= 7 && i <= 12) {
			level = 5;
			damage = 1;
		}
		newslime();
	}

	public void newslime() {
		// Spawnarea
		while (true) {
			if (level <= 1) {
				do {
					worldin = 0;
					if (level == 0) {
						position.setLocation((java.lang.Math.random() * 13) + 2, (java.lang.Math.random() * 3) + 24);
						health = 2;
						noticed = false;
					} else if (level == 1) {
						position.setLocation((java.lang.Math.random() * 15) + 13, (java.lang.Math.random() * 7) + 2);
						health = 3;
						noticed = false;
					}
				} while (logic.Main.world1[position.x][position.y][1] == 1);
			} else if (level == 2 || level == 3 || level == 4 || level == 5) {
				do {
					worldin = 1;
					if (level == 2) {
						position.setLocation((java.lang.Math.random() * 10) + 9, (java.lang.Math.random() * 6) + 49);
						health = 5;
					} else if (level == 3) {
						position.setLocation((java.lang.Math.random() * 10) + 9, (java.lang.Math.random() * 6) + 49);
						health = 6;
					} else if (level == 4) {
						position.setLocation(12, 44);
						health = 9;
					} else if (level == 5) {
						position.setLocation((java.lang.Math.random() * 23) + 27, (java.lang.Math.random() * 17) + 39);
						health = 4;
					}
				} while (logic.Main.house1[position.x][position.y][1] == 1);
			}
			for (int i = 0; i < drawpackage.ClassJLabel1.slimes.length; i++) {
				if (drawpackage.ClassJLabel1.slimes[i] != null) {
					if (this.position.getLocation().equals(drawpackage.ClassJLabel1.slimes[i].position.getLocation())
							&& this.worldin == drawpackage.ClassJLabel1.slimes[i].worldin) {
						continue;
					}
				}
			}
			break;
		}
	}

	public void trigger() {
		// Noticed & Unnoticed einstellung
		if (java.lang.Math.abs(logic.Player.position.x - position.x) < 3
				&& java.lang.Math.abs(logic.Player.position.y - position.y) < 3 && noticed == false
				&& logic.Player.worldin == worldin) {
			noticed = true;
		}
		if (java.lang.Math.abs(logic.Player.position.x - position.x) > 6
				|| java.lang.Math.abs(logic.Player.position.y - position.y) > 6) {
			noticed = false;
		}
		// wenn tot, droppt slimeball
		if (health <= 0) {
			if (level <= 1) {
				logic.Inventory.pickup(logic.Inventory.Items.slimeball, 1);
				logic.Player.Stats[7] += 1;
			} else if (level == 2) {
				logic.Inventory.pickup(logic.Inventory.Items.slimeballred, 1);
				logic.Player.Stats[7] += 3;
			} else if (level == 3) {
				logic.Inventory.pickup(logic.Inventory.Items.slimeballblue, 1);
				logic.Player.Stats[7] += 4;
			} else if (level == 4) {
				logic.Inventory.pickup(logic.Inventory.Items.potionhealth2, 4);
				logic.Player.Stats[7] += 12;
				health = 1;
				position.setLocation(0, 0);
				worldin = -1;
			} else if (level == 5) {
				logic.Inventory.pickup(logic.Inventory.Items.slimeball, 1);
				logic.Player.Stats[7] += 1;
			}
			if (level != 4) {
				newslime();
			}
		} else {
			if (noticed) {
				if (logic.Player.position.x == position.x
						&& java.lang.Math.abs(logic.Player.position.y - position.y) <= 1) {
					if (logic.Player.Stats[0] > 0) {
						logic.Player.Stats[0] -= damage;
						drawpackage.ClassJFrame.cjta.append("Player: " + logic.Player.Stats[0] + "\n");
					}
				}
				if (logic.Player.position.y == position.y
						&& java.lang.Math.abs(logic.Player.position.x - position.x) <= 1) {
					if (logic.Player.Stats[0] > 0) {
						logic.Player.Stats[0] -= damage;
						drawpackage.ClassJFrame.cjta.append("Player: " + logic.Player.Stats[0] + "\n");
					}
				}
			}
		}
	}

	public void move(logic.Player.Blickrichtung richtung) {
		switch (richtung) {
		case links:
			this.position.x--;
			break;
		case oben:
			this.position.y--;
			break;
		case rechts:
			this.position.x++;
			break;
		case unten:
			this.position.y++;
			break;
		case no:
			break;
		}
	}
}