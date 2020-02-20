package drawpackage;

import logic.Player;

@SuppressWarnings("serial")
public class ClassJLabel1 extends javax.swing.JLabel {

	/**
	 * Die einzelnen Tiles, die benötigt werden
	 */
	public static java.awt.image.BufferedImage grass, blume1, blume2, blume3, rock, wall, player, floor, hole, treema,
			treeoa, slimev, slimevn, slimered, slimeblue, inventorybackground, appel, potionemty, potionhealth1,
			potionhealth2, potionhealth3, villager1, villager2, villager3, villager4, slimeball, slimeballblue,
			slimeballred, swordno, helmetno, chestplateno, trousersno, shoesno, swordgold, helmetgold, chestplategold,
			trousersgold, shoesgold, coin, house1, pathud, pathlr, pathlu, pathru, pathrd, pathld, pathtu, pathtd,
			tablele, tablere, tablem, chair, table, cavefloor, doormat, FirePitBlueFire, FirePitRedFire, Torch,
			cavewall, cavewalltop, cavewalltoprightup, cavewalltopleftup, cavewallcornerleftdown,
			cavewallcornerrightdown, cavewallleft, cavewallright, cavewallcornerleftup, cavewallcornerrightup,
			cavewalldown, cavewalldownrightdown, cavewalldownleftdown, door, entrance, tanggrass, mushroom, crystal,
			rockwo, rockwc, rockwm, commode, littlecommode, littlecommodeleft, littlecommoderight, mirrorright, bed,
			paperwall, kamin;

	/**
	 * Größe der einzelnen Tiles in Pixels
	 */
	public static int pixel = 48;

	/**
	 * xVerschiebung & yVerschiebung
	 */
	public static int xV, yV;

	public static entities.Slime[] slimes;
	public static entities.Villager[] villager;

	@Override
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		this.setBounds(0, 0, 641, ClassJFrame.height);

		// Intialisierung der Zeichenobjekte
		try {
			switch (logic.Player.br) {
			case links:
				if (logic.Player.attackcooldown >= 7 || logic.Player.attackcooldown <= 2) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerl.png"));
					} else if (logic.Player.ReversePixelsWalked > 0 && logic.Player.ReversePixelsWalked < 6) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerlwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 6 && logic.Player.ReversePixelsWalked < 12) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerlwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 12 && logic.Player.ReversePixelsWalked < 18) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 18 && logic.Player.ReversePixelsWalked < 24) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerlwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 24 && logic.Player.ReversePixelsWalked < 30) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerlwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 30 && logic.Player.ReversePixelsWalked < 36) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 36 && logic.Player.ReversePixelsWalked < 42) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerlwr.png"));
					} else if (logic.Player.ReversePixelsWalked < 48) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerl.png"));
					}
				} else {
					player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerls.png"));
				}
				break;
			case oben:
				if (logic.Player.attackcooldown >= 7 || logic.Player.attackcooldown <= 2) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerh.png"));
					} else if (logic.Player.ReversePixelsWalked > 0 && logic.Player.ReversePixelsWalked < 6) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 6 && logic.Player.ReversePixelsWalked < 12) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 12 && logic.Player.ReversePixelsWalked < 18) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerh.png"));
					} else if (logic.Player.ReversePixelsWalked >= 18 && logic.Player.ReversePixelsWalked < 24) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 24 && logic.Player.ReversePixelsWalked < 30) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 30 && logic.Player.ReversePixelsWalked < 36) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerh.png"));
					} else if (logic.Player.ReversePixelsWalked >= 36 && logic.Player.ReversePixelsWalked < 42) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhwr.png"));
					} else if (logic.Player.ReversePixelsWalked < 48) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerh.png"));
					}
				} else {
					player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerhs.png"));
				}
				break;
			case rechts:
				if (logic.Player.attackcooldown >= 7 || logic.Player.attackcooldown <= 2) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerr.png"));
					} else if (logic.Player.ReversePixelsWalked > 0 && logic.Player.ReversePixelsWalked < 6) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 6 && logic.Player.ReversePixelsWalked < 12) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 12 && logic.Player.ReversePixelsWalked < 18) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 18 && logic.Player.ReversePixelsWalked < 24) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 24 && logic.Player.ReversePixelsWalked < 30) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 30 && logic.Player.ReversePixelsWalked < 36) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 36 && logic.Player.ReversePixelsWalked < 42) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrwr.png"));
					} else if (logic.Player.ReversePixelsWalked < 48) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerr.png"));
					}
				} else {
					player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerrs.png"));
				}
				break;
			case unten:
				if (logic.Player.attackcooldown >= 7 || logic.Player.attackcooldown <= 2) {
					if (logic.Player.ReversePixelsWalked <= 0) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerv.png"));
					} else if (logic.Player.ReversePixelsWalked > 0 && logic.Player.ReversePixelsWalked < 6) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 6 && logic.Player.ReversePixelsWalked < 12) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 12 && logic.Player.ReversePixelsWalked < 18) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerv.png"));
					} else if (logic.Player.ReversePixelsWalked >= 18 && logic.Player.ReversePixelsWalked < 24) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervwr.png"));
					} else if (logic.Player.ReversePixelsWalked >= 24 && logic.Player.ReversePixelsWalked < 30) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervwl.png"));
					} else if (logic.Player.ReversePixelsWalked >= 30 && logic.Player.ReversePixelsWalked < 36) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerv.png"));
					} else if (logic.Player.ReversePixelsWalked >= 36 && logic.Player.ReversePixelsWalked < 42) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervwr.png"));
					} else if (logic.Player.ReversePixelsWalked < 48) {
						player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playerv.png"));
					}
				} else {
					player = javax.imageio.ImageIO.read(new java.io.File("textures/player/playervS.png"));
				}
				break;
			case no:
				break;
			}
		} catch (java.io.IOException e) {
		}

		// Hintergrund
		g.setColor(java.awt.Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Draw Tiles
		switch (logic.Player.worldin) {
		case 0:
			for (int x = 0; x < logic.Main.world1.length; x++) {
				for (int y = 0; y < logic.Main.world1[0].length; y++) {
					draw1(g, x, y, logic.Main.world1[x][y][0]);
				}
			}
			break;
		case 1:
			for (int x = 0; x < logic.Main.house1.length; x++) {
				for (int y = 0; y < logic.Main.house1[0].length; y++) {
					draw1(g, x, y, logic.Main.house1[x][y][0]);
				}
			}
			break;
		}

		switch (Player.br) {
		case links:
			g.drawImage(player, (logic.Player.position.x * pixel) + Player.ReversePixelsWalked - xV,
					(logic.Player.position.y * pixel) - yV - 8, pixel, pixel, null);
			break;
		case oben:
			g.drawImage(player, (logic.Player.position.x * pixel) - xV,
					(logic.Player.position.y * pixel) + Player.ReversePixelsWalked - yV - 8, pixel, pixel, null);
			break;
		case rechts:
			g.drawImage(player, (logic.Player.position.x * pixel) - Player.ReversePixelsWalked - xV,
					(logic.Player.position.y * pixel) - yV - 8, pixel, pixel, null);
			break;
		case unten:
			g.drawImage(player, (logic.Player.position.x * pixel) - xV,
					(logic.Player.position.y * pixel) - Player.ReversePixelsWalked - yV - 8, pixel, pixel, null);
			break;
		case no:
			break;
		}

		// entities
		for (int i = 0; i < slimes.length; i++) {
			if (drawpackage.ClassJLabel1.slimes[i] != null) {
				if (slimes[i].health > 0) {
					if (slimes[i].noticed && slimes[i].worldin == logic.Player.worldin && slimes[i].level <= 1) {
						g.drawImage(slimevn, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel, pixel, null);
					} else if (slimes[i].noticed == false && slimes[i].worldin == logic.Player.worldin
							&& slimes[i].level <= 1) {
						g.drawImage(slimev, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel, pixel, null);
					} else if (slimes[i].worldin == logic.Player.worldin && slimes[i].level == 2) {
						g.drawImage(slimered, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel, pixel, null);
					} else if (slimes[i].worldin == logic.Player.worldin && slimes[i].level == 3) {
						g.drawImage(slimeblue, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel, pixel, null);
					} else if (slimes[i].worldin == logic.Player.worldin && slimes[i].level == 4) {
						g.drawImage(slimev, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel * 2, pixel * 2, null);
					} else if (slimes[i].worldin == logic.Player.worldin && slimes[i].level == 5) {
						g.drawImage(slimev, slimes[i].position.x * pixel - xV, slimes[i].position.y * pixel - yV - 8,
								pixel, pixel, null);
					}
				}
			}
		}
		if (drawpackage.ClassJLabel1.villager != null) {
			for (int i = 0; i < villager.length; i++) {
				if (drawpackage.ClassJLabel1.villager[i] != null) {
					if (villager[i].worldin == Player.worldin) {
						if (villager[i].typ == 0 || villager[i].typ == 2) {
							g.drawImage(villager1, villager[i].position.x * pixel - xV,
									villager[i].position.y * pixel - yV - 8, pixel, pixel, null);
						} else if (villager[i].typ == 1) {
							g.drawImage(villager2, villager[i].position.x * pixel - xV,
									villager[i].position.y * pixel - yV - 8, pixel, pixel, null);
						} else if (villager[i].typ == 3) {
							g.drawImage(villager3, villager[i].position.x * pixel - xV,
									villager[i].position.y * pixel - yV - 8, pixel, pixel, null);
						} else if (villager[i].typ == 4) {
							g.drawImage(villager4, villager[i].position.x * pixel - xV,
									villager[i].position.y * pixel - yV - 8, pixel, pixel, null);
						}
					}
				}
			}
		}

		// Tiles - Layer 2
		switch (logic.Player.worldin) {
		case 0:
			for (int x = 0; x < logic.Main.world1.length; x++) {
				for (int y = 0; y < logic.Main.world1[0].length; y++) {
					draw2(g, x, y, logic.Main.world1[x][y][0]);
				}
			}
			break;
		case 1:
			for (int x = 0; x < logic.Main.house1.length; x++) {
				for (int y = 0; y < logic.Main.house1[0].length; y++) {
					draw2(g, x, y, logic.Main.house1[x][y][0]);
				}
			}
			break;
		}

		// Tag- Nacht Zyklen
		/*
		 * Insgesamt: 5 min (3000) Nacht: 0 - 1_10 (0 - 700) Übergang: 1_10 - 1_20 (700
		 * - 850) Tag: 1_20 - 3_40 (850 - 2200) Übergang: 3_40 - 3_50 (2200 - 2350)
		 * Nacht: 3_50 - 5 (2350 - 3000)
		 */
		if (logic.Player.worldin == 0) {
			if ((logic.Timer.time >= 0 && logic.Timer.time <= 700)
					|| (logic.Timer.time >= 2350 && logic.Timer.time <= 3000)) {
				g.setColor(new java.awt.Color(0, 0, 0, 150));
			} else if (logic.Timer.time >= 700 && logic.Timer.time <= 850) {
				g.setColor(new java.awt.Color(0, 0, 0, 150 - (logic.Timer.time - 700)));
			} else if (logic.Timer.time >= 850 && logic.Timer.time <= 2200) {
				g.setColor(new java.awt.Color(0, 0, 0, 0));
			} else if (logic.Timer.time >= 2200 && logic.Timer.time <= 2350) {
				g.setColor(new java.awt.Color(0, 0, 0, logic.Timer.time - 2200));
			}
			g.fillRect(0, 0, 2000, 2000);
		}

		// Inventory
		if (logic.Inventory.inventoryopened == true) {
			// Verdunkelug des Hintergrunds
			g.drawImage(inventorybackground, 0, 0, 10000, 10000, null);
			// Felder für Items
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					g.setColor(java.awt.Color.LIGHT_GRAY);
					g.fillRect(pixel + (x * (2 * pixel / 3)), (pixel / 6) + (y * (2 * pixel / 3)), (2 * pixel / 3),
							(2 * pixel / 3));
					g.setColor(java.awt.Color.BLACK);
					g.drawRect(pixel + (x * (2 * pixel / 3)), (pixel / 6) + (y * (2 * pixel / 3)), (2 * pixel / 3),
							(2 * pixel / 3));
				}
			}
			for (int y = 0; y < 5; y++) {
				g.setColor(java.awt.Color.LIGHT_GRAY);
				g.fillRect((pixel / 6), (pixel / 6) + (y * (2 * pixel / 3)), (2 * pixel / 3), (2 * pixel / 3));
				g.setColor(java.awt.Color.BLACK);
				g.drawRect((pixel / 6), (pixel / 6) + (y * (2 * pixel / 3)), (2 * pixel / 3), (2 * pixel / 3));
			}
			// Zeichnung der Items
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					drawitems(g, pixel + (x * (2 * pixel / 3)), (pixel / 6) + (y * (2 * pixel / 3)),
							logic.Player.inventory[(y * 5) + x][0], logic.Player.inventory[(y * 5) + x][1]);
				}
			}
			for (int i = 0; i < 5; i++) {
				drawitems(g, 8, 8 + (i * 32), logic.Player.equipment[i], 1);
			}
			// Healthbar
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(pixel + 190, 8, 304, 32);
			g.setColor(java.awt.Color.DARK_GRAY);
			g.fillRect(pixel + 192, 10, 300, 28);
			g.setColor(java.awt.Color.RED);
			g.fillRect(pixel + 192, 10, (300 * logic.Player.Stats[0]) / logic.Player.Stats[1], 28);
			g.setColor(java.awt.Color.BLACK);
			g.setFont(g.getFont().deriveFont(16f));
			g.drawString("Leben: " + logic.Player.Stats[0] + " / " + logic.Player.Stats[1], pixel + 194, 36);
			// Manabar
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(pixel + 190, 48, 304, 32);
			g.setColor(java.awt.Color.DARK_GRAY);
			g.fillRect(pixel + 192, 50, 300, 28);
			g.setColor(java.awt.Color.CYAN);
			g.fillRect(pixel + 192, 50, (300 * logic.Player.Stats[5]) / logic.Player.Stats[6], 28);
			g.setColor(java.awt.Color.BLACK);
			g.setFont(g.getFont().deriveFont(16f));
			g.drawString("Mana: " + logic.Player.Stats[5] + " / " + logic.Player.Stats[6], pixel + 194, 76);
			// XP-bar
			g.setColor(java.awt.Color.BLACK);
			g.fillRect(pixel + 190, 88, 304, 32);
			g.setColor(java.awt.Color.DARK_GRAY);
			g.fillRect(pixel + 192, 90, 300, 28);
			g.setColor(java.awt.Color.BLUE);
			g.fillRect(pixel + 192, 90, (300 * logic.Player.Stats[7]) / logic.Player.Stats[8], 28);
			g.setColor(java.awt.Color.BLACK);
			g.setFont(g.getFont().deriveFont(16f));
			g.drawString("Erfahrung: " + logic.Player.Stats[7] + " / " + logic.Player.Stats[8], pixel + 194, 116);
			g.drawString("Level: " + logic.Player.Stats[9], pixel + 500, 116);
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}

		repaint();
	}

	private static java.awt.Graphics draw1(java.awt.Graphics g, int x, int y, int a) {
		switch (a) {
		case 0:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 1:
			// TODO
			// g.drawImage(rock, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			break;
		case 2:
			g.drawImage(wall, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 3:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(blume1, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 4:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(blume2, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 5:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(blume3, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 6:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 7:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(hole, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 8:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(hole, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 9:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 10:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 11:
			// House Missing
			break;
		case 12:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(doormat, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 13:
			// TODO FREI
			break;
		case 14:
			g.drawImage(tanggrass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 15:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 16:
			// TODO FREI
			break;
		case 17:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathud, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 18:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathlr, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 19:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathld, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 20:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathlu, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 21:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathrd, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 22:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathru, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 23:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathtu, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 24:
			g.drawImage(grass, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(pathtd, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 25:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(tablele, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 26:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(tablem, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 27:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(tablere, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 28:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(chair, (x * pixel) - xV, (y * pixel) - yV - pixel / 2, pixel, pixel, null);
			break;
		case 29:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(chair, (x * pixel) - xV, (y * pixel) - yV + pixel / 2, pixel, pixel, null);
			break;
		case 30:
			g.fillRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 31:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(FirePitRedFire, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 32:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(FirePitBlueFire, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 33:
			g.drawImage(cavewall, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(Torch, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 34:
			g.drawImage(cavewall, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 35:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalltop, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 36:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalltopleftup, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 37:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalltoprightup, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 38:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallleft, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 39:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallright, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 41:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalldown, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 42:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalldownleftdown, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 43:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewalldownrightdown, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 44:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallcornerleftdown, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 45:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallcornerleftup, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 46:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallcornerrightdown, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 47:
			g.drawRect((x * pixel) - xV, (y * pixel) - yV, pixel, pixel);
			g.drawImage(cavewallcornerrightup, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 48:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 49:
			g.drawImage(rock, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(entrance, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 50:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(rockwo, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 51:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(rockwc, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 52:
			g.drawImage(cavefloor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(rockwm, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 53:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(commode, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 54:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(littlecommode, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 55:
			// Undurchgehbarer Bodem im Haus
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 56:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(littlecommodeleft, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 57:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(littlecommoderight, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 58:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(mirrorright, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 59:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(bed, (x * pixel) - xV, (y * pixel) - yV - pixel, pixel, pixel * 2, null);
			break;
		case 60:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(paperwall, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		case 61:
			g.drawImage(floor, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			g.drawImage(kamin, (x * pixel) - xV, (y * pixel) - yV, pixel, pixel, null);
			break;
		}
		return g;
	}

	private static java.awt.Graphics draw2(java.awt.Graphics g, int x, int y, int a) {
		switch (a) {
		case 9:
			g.drawImage(treeoa, (x * pixel) - xV, ((y - 1) * pixel) - yV, pixel, pixel * 2, null);
			break;
		case 10:
			g.drawImage(treema, (x * pixel) - xV, ((y - 1) * pixel) - yV, pixel, pixel * 2, null);
			break;
		case 15:
			g.drawImage(house1, (x * pixel) - xV, (y * pixel) - yV - 2 * pixel, null);
			break;
		case 48:
			// g.drawImage(door, (x * pixel) - xV, (y * pixel) - yV, pixel * 3, pixel * 3,
			// null);
			break;
		default:
			break;
		}
		return g;
	}

	private static java.awt.Graphics drawitems(java.awt.Graphics g, int x, int y, int a, Integer n) {
		switch (a) {
		case 0:
			break;
		case 1:
			// Missing
			break;
		case 2:
			g.drawImage(blume1, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 3:
			g.drawImage(blume2, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 4:
			g.drawImage(blume3, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 5:
			g.drawImage(appel, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 6:
			g.drawImage(slimeball, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 7:
			g.drawImage(potionemty, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 8:
			g.drawImage(potionhealth1, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 9:
			g.drawImage(potionhealth2, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 10:
			g.drawImage(potionhealth3, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 11:
			g.drawImage(swordno, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 12:
			g.drawImage(helmetno, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 13:
			g.drawImage(chestplateno, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 14:
			g.drawImage(trousersno, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 15:
			g.drawImage(shoesno, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 16:
			g.drawImage(swordgold, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 17:
			g.drawImage(helmetgold, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 18:
			g.drawImage(chestplategold, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 19:
			g.drawImage(trousersgold, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 20:
			g.drawImage(shoesgold, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 21:
			g.drawImage(coin, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 22:
			g.drawImage(slimeballblue, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 23:
			g.drawImage(slimeballred, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 24:
			g.drawImage(crystal, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		case 25:
			g.drawImage(mushroom, x, y, (2 * pixel / 3), (2 * pixel / 3), null);
			g.drawString(n.toString(), x + 2, y + 30);
			break;
		}
		return g;
	}
}