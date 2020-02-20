package logic;

import decipher.MethodClass;

public class Options {

	/**
	 * 0: Tastatursteuerung; 1: Regeneration (Mana & Health); 2: Autosave
	 */
	public static boolean options[] = new boolean[3];
	public static int programminglevel = 0;

	public static void initialize() {
		options[0] = true;
		options[1] = true;
		options[2] = true;
	}

	public static void update() {
		switch (programminglevel) {
		case 0:
			allow(18);
			allow(19);
			allow(14);
			allow(15);
		case 1:
			allow(0);
			allow(8);
			allow(7);
			allow(9);
			allow(10);
			allow(26);
			allow(27);
			allow(28);
		case 2:
		case 3:
		}
	}

	public static void allow(int i) {
		MethodClass.allowed[i] = true;
	}

	public static void restrict(int i) {
		MethodClass.allowed[i] = false;
	}
}