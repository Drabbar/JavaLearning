package logic;

/**
 * Kümmert sich um das bewegen des Players. WoW hat niemand erwartet Die Klasse
 * heißt ja nur so
 * 
 * @author Enrico
 *
 */
public class PlayerMove implements Runnable {

	private static int Delay = 12;
	public static boolean moving = false;
	public static Player.Blickrichtung nbr = Player.Blickrichtung.no;

	@Override
	public void run() {
		while (true) {
			if (nbr != Player.Blickrichtung.no) {
				Player.br = nbr;
				nbr = Player.Blickrichtung.no;
			}
			if (drawpackage.KeyHandler.move == true && Inventory.inventoryopened == false) {
				logic.PlayerMove.moving = true;
				switch (logic.Player.br) {
				case rechts:
					if (((Player.position.getX() < Main.world1.length - 1 && Player.worldin == 0)
							|| (Player.position.getX() < Main.house1.length && Player.worldin == 1))) {
						if ((Player.worldin == 0
								&& Main.world1[(int) (Player.position.getX() + 1)][(int) Player.position
										.getY()][1] == 0)
								|| (Player.worldin == 1
										&& Main.house1[(int) (Player.position.getX() + 1)][(int) Player.position
												.getY()][1] == 0)) {
							Player.position.x++;
							Player.ReversePixelsWalked = drawpackage.ClassJLabel1.pixel;
							for (int i = 0; i < drawpackage.ClassJLabel1.pixel; i++) {
								try {
									Thread.sleep(Delay);
								} catch (InterruptedException e1) {
								}
								Player.ReversePixelsWalked--;
							}
						}
					}
					break;
				case links:
					if (Player.position.getX() > 0) {
						if ((Player.worldin == 0
								&& Main.world1[(int) (Player.position.getX() - 1)][(int) Player.position
										.getY()][1] == 0)
								|| ((Player.worldin == 1)
										&& Main.house1[(int) (Player.position.getX() - 1)][(int) (Player.position
												.getY())][1] == 0)) {
							Player.position.x--;
							Player.ReversePixelsWalked = drawpackage.ClassJLabel1.pixel;
							for (int i = 0; i < drawpackage.ClassJLabel1.pixel; i++) {
								try {
									Thread.sleep(Delay);
								} catch (InterruptedException e1) {
								}
								Player.ReversePixelsWalked--;
							}
						}
					}
					break;
				case unten:
					if (((Player.position.getY() < Main.world1[0].length - 1 && Player.worldin == 0)
							|| (Player.position.getY() < Main.house1[0].length && Player.worldin == 1))) {
						if ((Player.worldin == 0
								&& Main.world1[(int) (Player.position.getX())][(int) (Player.position.getY()
										+ 1)][1] == 0)
								|| ((Player.worldin == 1)
										&& Main.house1[(int) (Player.position.getX())][(int) (Player.position.getY()
												+ 1)][1] == 0)) {
							Player.position.y++;
							Player.ReversePixelsWalked = drawpackage.ClassJLabel1.pixel;
							for (int i = 0; i < drawpackage.ClassJLabel1.pixel; i++) {
								try {
									Thread.sleep(Delay);
								} catch (InterruptedException e1) {
								}
								Player.ReversePixelsWalked--;
							}
						}
					}
					break;
				case oben:
					if (Player.position.getY() > 0) {
						if ((Player.worldin == 0
								&& Main.world1[(int) (Player.position.getX())][(int) (Player.position.getY()
										- 1)][1] == 0)
								|| ((Player.worldin == 1)
										&& Main.house1[(int) (Player.position.getX())][(int) (Player.position.getY()
												- 1)][1] == 0)) {
							Player.position.y--;
							Player.ReversePixelsWalked = drawpackage.ClassJLabel1.pixel;
							for (int i = 0; i < drawpackage.ClassJLabel1.pixel; i++) {
								try {
									Thread.sleep(Delay);
								} catch (InterruptedException e1) {
								}
								Player.ReversePixelsWalked--;
							}
						}
					}
					break;
				case no:
					break;
				}
				moving = false;
			}
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
			// Teleports
			// Haus 1 (9 / 8) & (3 / 3)
			if (Player.worldin == 0 && Player.position.getX() == 9 && Player.position.getY() == 8) {
				Player.position.setLocation(3, 14);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 3 && Player.position.getY() == 15) {
				Player.position.setLocation(9, 9);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 2 (13 / 19) & (20 / 13)
			if (Player.worldin == 0 && Player.position.getX() == 13 && Player.position.getY() == 19) {
				Player.position.setLocation(20, 14);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 20 && Player.position.getY() == 15) {
				Player.position.setLocation(13, 20);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 3 (5 / 20) & (36 / 3)
			if (Player.worldin == 0 && Player.position.getX() == 5 && Player.position.getY() == 20) {
				Player.position.setLocation(37, 14);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 37 && Player.position.getY() == 15) {
				Player.position.setLocation(5, 21);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 4 (18 / 21) & (54 / 15)
			if (Player.worldin == 0 && Player.position.getX() == 18 && Player.position.getY() == 21) {
				Player.position.setLocation(54, 14);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 54 && Player.position.getY() == 15) {
				Player.position.setLocation(18, 22);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 5 (26 / 20) & (4 / 19)
			if (Player.worldin == 0 && Player.position.getX() == 26 && Player.position.getY() == 20) {
				Player.position.setLocation(3, 33);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 3 && Player.position.getY() == 34) {
				Player.position.setLocation(26, 21);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 6 (17 / 26) & (20 / 34)
			if (Player.worldin == 0 && Player.position.getX() == 17 && Player.position.getY() == 26) {
				Player.position.setLocation(20, 33);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 20 && Player.position.getY() == 34) {
				Player.position.setLocation(17, 27);
				Player.worldin = 0;
				teleportfix();
			}
			// Haus 7 (25 / 26) & (37 / 34)
			if (Player.worldin == 0 && Player.position.getX() == 25 && Player.position.getY() == 26) {
				Player.position.setLocation(37, 33);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 37 && Player.position.getY() == 34) {
				Player.position.setLocation(25, 27);
				Player.worldin = 0;
				teleportfix();
			}
			// Höhle (6 / 2) & (39 / 41)
			if (Player.worldin == 0 && Player.position.getX() == 6 && Player.position.getY() == 2) {
				Player.position.setLocation(39, 40);
				Player.worldin = 1;
				teleportfix();
			}
			if (Player.worldin == 1 && Player.position.getX() == 39 && Player.position.getY() == 41) {
				Player.position.setLocation(6, 3);
				Player.worldin = 0;
				teleportfix();
			}
		}
	}

	public static void teleportfix() {
		drawpackage.ClassJLabel1.xV = logic.Player.position.x * drawpackage.ClassJLabel1.pixel * 3;
		drawpackage.ClassJLabel1.yV = logic.Player.position.y * drawpackage.ClassJLabel1.pixel * 3;
	}
}
