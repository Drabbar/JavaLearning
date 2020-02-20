package logic;

/**
 * 
 * @author Jan
 *
 */
public class Saving {

	public static java.util.Scanner sc;
	public static java.io.BufferedWriter bw;
	public static String save;
	public static java.io.File f;

	public static java.awt.Point position;
	public static int worldin;
	public static Player.Blickrichtung br;
	public static Integer inventory[][] = new Integer[Player.inventory.length][Player.inventory[0].length];
	public static int equipment[] = new int[Player.equipment.length];
	public static int world1[][][] = new int[Main.world1.length][Main.world1[0].length][Main.world1[0][0].length];
	public static int house1[][][] = new int[Main.house1.length][Main.house1[0].length][Main.house1[0][0].length];
	public static int Stats[] = new int[Player.Stats.length];

	public static void save() {
		try {
			if (save == null) {
				save = javax.swing.JOptionPane.showInputDialog("Save:");
			}
			f = new java.io.File("Saves/" + save);
			bw = new java.io.BufferedWriter(new java.io.FileWriter(f));
			position = Player.position;
			worldin = Player.worldin;
			br = Player.br;
			for (int i = 0; i < inventory.length; i++) {
				inventory[i][0] = Player.inventory[i][0];
				inventory[i][1] = Player.inventory[i][1];
			}
			for (int i = 0; i < equipment.length; i++) {
				equipment[i] = Player.equipment[i];
			}
			for (int i = 0; i < world1[0].length; i++) {
				for (int j = 0; j < world1.length; j++) {
					world1[j][i][0] = Main.world1[j][i][0];
					if (Timer.running) {
						for (int j2 = 0; j2 < Timer.actions.length; j2++) {
							if (Timer.actions[j2][1] == 0) {
								if (Timer.actions[j2][2] == j) {
									if (Timer.actions[j2][3] == i) {
										world1[j][i][0] = Timer.actions[j2][4];
									}
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < house1[0].length; i++) {
				for (int j = 0; j < house1[0].length; j++) {
					house1[j][i][0] = Main.house1[j][i][0];
					if (Timer.running) {
						for (int j2 = 0; j2 < Timer.actions.length; j2++) {
							if (Timer.actions[j2][1] == 1) {
								if (Timer.actions[j2][2] == j) {
									if (Timer.actions[j2][3] == i) {
										house1[j][i][0] = Timer.actions[j2][4];
									}
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < Stats.length; i++) {
				Stats[i] = Player.Stats[i];
			}
			f.createNewFile();
			bw.write(position.x + " " + position.y);
			bw.write(" " + worldin);
			bw.write(" " + br.toString());
			bw.write("\n");
			for (int i = 0; i < inventory.length; i++) {
				bw.write(inventory[i][0] + " ");
				bw.write(inventory[i][1] + " ");
			}
			for (int i = 0; i < equipment.length; i++) {
				bw.write(equipment[i] + " ");
			}
			bw.write("\n");
			for (int i = 0; i < world1[0].length; i++) {
				for (int j = 0; j < world1.length; j++) {
					bw.write(world1[j][i][0] + " ");
				}
			}
			bw.write("\n");
			for (int i = 0; i < house1[0].length; i++) {
				for (int j = 0; j < house1.length; j++) {
					bw.write(house1[j][i][0] + " ");
				}
			}
			bw.write("\n");
			for (int i = 0; i < Stats.length; i++) {
				bw.write(Stats[i] + " ");
			}
			bw.close();
		} catch (java.io.IOException e) {
		}
	}

	public static void load() {
		try {
			if (save == null) {
				save = javax.swing.JOptionPane.showInputDialog("Load:");
			}
			sc = new java.util.Scanner(new java.io.File("Saves/" + save));
			position = new java.awt.Point(sc.nextInt(), sc.nextInt());
			worldin = sc.nextInt();
			switch (sc.next()) {
			case "oben":
				br = Player.Blickrichtung.oben;
				break;
			case "unten":
				br = Player.Blickrichtung.unten;
				break;
			case "links":
				br = Player.Blickrichtung.links;
				break;
			case "rechts":
				br = Player.Blickrichtung.rechts;
				break;
			}
			for (int i = 0; i < inventory.length; i++) {
				inventory[i][0] = sc.nextInt();
				inventory[i][1] = sc.nextInt();
			}
			for (int i = 0; i < equipment.length; i++) {
				equipment[i] = sc.nextInt();
			}
			for (int i = 0; i < world1[0].length; i++) {
				for (int j = 0; j < world1[0].length; j++) {
					world1[j][i][0] = sc.nextInt();
				}
			}
			for (int i = 0; i < house1[0].length; i++) {
				for (int j = 0; j < house1.length; j++) {
					house1[j][i][0] = sc.nextInt();
				}
			}
			for (int i = 0; i < Stats.length; i++) {
				Stats[i] = sc.nextInt();
			}
		} catch (java.awt.HeadlessException e) {
		} catch (java.io.FileNotFoundException e) {
			drawpackage.ClassJFrame.cjta.append("File not Found." + "\n");
		}
		for (int y = 0; y < world1[0].length; y++) {
			for (int x = 0; x < world1.length; x++) {
				world1[x][y][1] = logic.Main.tangibel(world1[x][y][0]);
			}
		}

		for (int y = 0; y < house1[0].length; y++) {
			for (int x = 0; x < house1.length; x++) {
				house1[x][y][1] = logic.Main.tangibel(house1[x][y][0]);
			}
		}
		if (save != null) {
			overwrite();
		}
	}

	public static void overwrite() {
		Player.position.setLocation(position.x, position.y);
		Player.worldin = worldin;
		Player.br = br;
		for (int i = 0; i < inventory.length; i++) {
			Player.inventory[i][0] = inventory[i][0];
			Player.inventory[i][1] = inventory[i][1];
		}
		for (int i = 0; i < equipment.length; i++) {
			Player.equipment[i] = equipment[i];
		}
		for (int i = 0; i < world1[0].length; i++) {
			for (int j = 0; j < world1.length; j++) {
				Main.world1[j][i][0] = world1[j][i][0];
			}
		}
		for (int i = 0; i < house1[0].length; i++) {
			for (int j = 0; j < house1.length; j++) {
				Main.house1[j][i][0] = house1[j][i][0];
			}
		}
		for (int i = 0; i < Stats.length; i++) {
			Player.Stats[i] = Stats[i];
		}
	}
}