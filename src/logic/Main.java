package logic;

/**
 * Die Startmethode, von der alles ausgeht.
 * 
 * @author Jan
 *
 */
public class Main {

	/**
	 * world1[x][y][information] information: 0: Bild 1: Durchgehbar
	 */
	public static int world1[][][] = new int[30][30][2];
	public static int house1[][][] = new int[67][62][2];
	public static Player p = new Player();
	static Thread plmMovet = new Thread(new PlayerMove());
	public static int Pathlength = 200;

	static drawpackage.ClassJFrame cjf = new drawpackage.ClassJFrame(1000, 700, "Fenster");
	static Thread cjft = new Thread(cjf);
	static Thread tt = new Thread(new Timer());

	public static void main(String[] args) {
		drawpackage.Images.initialize();

		java.util.Scanner scanner;

		// Einlesen der world1, zunächst die tiles und dann, ob man durchgehen kann
		// in @ClassJFrame wird da noch was gefixt, warum auch immer das nicht
		// funktioniert
		try {
			scanner = new java.util.Scanner(new java.io.File("worlds/world1/tile.txt"));
			for (int y = 0; y < world1[0].length; y++) {
				for (int x = 0; x < world1.length; x++) {
					world1[x][y][0] = scanner.nextInt();
				}
			}
		} catch (java.io.FileNotFoundException e) {
		}

		for (int y = 0; y < world1[0].length; y++) {
			for (int x = 0; x < world1.length; x++) {
				world1[x][y][1] = tangibel(world1[x][y][0]);
			}
		}

		// Einlesen des house1, zunächst die tiles und dann, ob man durchgehen kann

		try {
			scanner = new java.util.Scanner(new java.io.File("worlds/house1/tile.txt"));
			for (int y = 0; y < house1[0].length; y++) {
				for (int x = 0; x < house1.length; x++) {
					house1[x][y][0] = scanner.nextInt();
				}
			}
		} catch (java.io.FileNotFoundException e) {
		}

		for (int y = 0; y < house1[0].length; y++) {
			for (int x = 0; x < house1.length; x++) {
				house1[x][y][1] = tangibel(house1[x][y][0]);
			}
		}

		cjft.start();
		plmMovet.start();
		tt.start();
		logic.Options.initialize();
		entities.Slime.create();
		entities.Villager.create();
		new pathfinder.Interface();
		decipher.Encoder.window = new decipher.Window();
		drawpackage.ClassJFrame.cjta.append("Mutter: Guten Morgen! Komm her, ich habe dir etwas wichtiges zu verkünden!"
				+ "\n" + "(gehe mit walk(int); int schritte," + "\n" + " und drehe dich mit turn('u/o/r/l');)" + "\n"
				+ "Tipp: Sie ist links von dir");
	}

	static int tang[] = { 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0,
			1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	public static int tangibel(int x) {
		return tang[x];
	}

}