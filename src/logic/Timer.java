package logic;

/**
 * Für alles, das Wiederholungen braucht.
 * 
 * @author Jan
 *
 */
public class Timer implements Runnable {

	/**
	 * Die Wiederholung.
	 */
	public static int it = 0;

	/**
	 * Derzeitiger Platz im Array, in den die nächste Variable eingefügt werden
	 * sollte
	 */
	public static int cf = 0;

	/**
	 * actions[number][action] 0: wann der task ausgeführt werden sollte 1: worldin
	 * 2: x-Pos 3: y-Pos 4: transform to (Tile-number)
	 */
	public static int[][] actions = new int[1000][5];

	/**
	 * boolean die für die zurücksetzung des arrays benötigt wird
	 */
	public static boolean running = false;
	private static int regen = 50, autosave = 3000, slimeticker = 5;
	public static int time = 0;

	@Override
	public void run() {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
		}

		reset();

		while (true) {
			// running prüft ob noch was am laufen ist, und wenn nein, resettet es das Array
			running = false;
			logic.Quests.trigger();
			for (int i = 0; i < actions.length; i++) {
				if (actions[i][0] >= it) {
					running = true;
				}
			}
			if (slimeticker <= 0) {
				for (int i = 0; i < drawpackage.ClassJLabel1.slimes.length; i++) {
					if (drawpackage.ClassJLabel1.slimes[i] != null) {
						drawpackage.ClassJLabel1.slimes[i].trigger();
						slimeticker = 10;
					}
				}
			} else {
				slimeticker--;
			}
			// Für den AttackCoolDown zuständig ...
			if (Player.attackcooldown > 0) {
				Player.attackcooldown--;
			}
			// Verschiebung
			try {
				if ((Player.position.x * drawpackage.ClassJLabel1.pixel - drawpackage.ClassJLabel1.xV) < (4
						* drawpackage.ClassJLabel1.pixel)) {
					drawpackage.ClassJLabel1.xV -= 16;
				} else if ((logic.Player.position.x * drawpackage.ClassJLabel1.pixel
						- drawpackage.ClassJLabel1.xV) > (drawpackage.ClassJFrame.cjl1.getWidth()
								- drawpackage.ClassJLabel1.pixel * 5)) {
					drawpackage.ClassJLabel1.xV += 16;
				}
				if ((Player.position.y * drawpackage.ClassJLabel1.pixel - drawpackage.ClassJLabel1.yV) < (4
						* drawpackage.ClassJLabel1.pixel)) {
					drawpackage.ClassJLabel1.yV -= 16;
				} else if ((logic.Player.position.y * drawpackage.ClassJLabel1.pixel
						- drawpackage.ClassJLabel1.yV) > (drawpackage.ClassJFrame.cjl1.getHeight()
								- drawpackage.ClassJLabel1.pixel * 5)) {
					drawpackage.ClassJLabel1.yV += 16;
				}
				if ((Player.position.x * drawpackage.ClassJLabel1.pixel - drawpackage.ClassJLabel1.xV) < (3
						* drawpackage.ClassJLabel1.pixel)) {
					drawpackage.ClassJLabel1.xV = (logic.Player.position.x - 3) * drawpackage.ClassJLabel1.pixel;
				} else if ((logic.Player.position.x * drawpackage.ClassJLabel1.pixel
						- drawpackage.ClassJLabel1.xV) > (drawpackage.ClassJFrame.cjl1.getWidth())) {
					drawpackage.ClassJLabel1.xV = (logic.Player.position.x - 3) * drawpackage.ClassJLabel1.pixel;
				}
				if ((Player.position.y * drawpackage.ClassJLabel1.pixel - drawpackage.ClassJLabel1.yV) < (3
						* drawpackage.ClassJLabel1.pixel)) {
					drawpackage.ClassJLabel1.yV = (logic.Player.position.y - 3) * drawpackage.ClassJLabel1.pixel;
				} else if ((logic.Player.position.y * drawpackage.ClassJLabel1.pixel
						- drawpackage.ClassJLabel1.yV) > (drawpackage.ClassJFrame.cjl1.getWidth())) {
					drawpackage.ClassJLabel1.yV = (logic.Player.position.y - 3) * drawpackage.ClassJLabel1.pixel;
				}
			} catch (Exception e) {
			}
			// Tötet dich, wenn dein leben unter oder gleich 0 ist
			if (Player.Stats[0] <= 0) {
				drawpackage.ClassJFrame.cjta.append("Du bist Gestorben." + "\n");
				Saving.load();
			}
			// Level-Up
			if (Player.Stats[7] == Player.Stats[8]) {
				Player.Stats[7] = 0;
				Player.Stats[8] *= 1.5;
				Player.Stats[9]++;
				Player.Stats[1] += 20;
				Player.Stats[0] = Player.Stats[1];
				Player.Stats[6] += 10;
				Player.Stats[5] = Player.Stats[6];
				Player.Stats[2]++;
			} else if (Player.Stats[7] >= Player.Stats[8]) {
				Player.Stats[7] -= Player.Stats[8];
				Player.Stats[8] *= 1.5;
				Player.Stats[9]++;
				Player.Stats[1] += 20;
				Player.Stats[0] = Player.Stats[1];
				Player.Stats[6] += 10;
				Player.Stats[5] = Player.Stats[6];
				Player.Stats[2]++;
			}
			// Auto-Regeneration, 50 * 100ms = 5s (Leben & Mana)
			if (logic.Options.options[1]) {
				regen--;
				if (regen <= 0) {
					if (Player.Stats[0] < Player.Stats[1]) {
						Player.Stats[0]++;
					}
					if (Player.Stats[5] < Player.Stats[6]) {
						Player.Stats[5]++;
					}
					regen = 50;
				}
			}
			// Auto-Save, 3000 * 100ms = 3min
			if (logic.Options.options[2]) {
				autosave--;
				if (autosave <= 0) {
					if (Saving.save != null) {
						Saving.save();
					}
					autosave = 3000;
				}
			}
			// Für die zurücksetzung von Aufhebbaren Objekten
			if (running == true) {
				for (int i = 0; i < actions.length; i++) {
					if (actions[i][0] == it) {
						switch (actions[i][1]) {
						case 0:
							Main.world1[actions[i][2]][actions[i][3]][0] = actions[i][4];
							break;
						case 1:
							Main.house1[actions[i][2]][actions[i][3]][0] = actions[i][4];
							break;
						}
					}
				}
			}
			// Part 2 des Arrayresets
			if (running == false) {
				reset();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			it++;
			if (time < 3000) {
				time++;
			} else {
				time = 0;
			}
		}
	}

	public static void reset() {
		for (int i = 0; i < actions.length; i++) {
			for (int j = 0; j < actions[i].length; j++) {
				Timer.actions[i][j] = 0;
			}
		}
		cf = 0;
		it = 0;
	}
}