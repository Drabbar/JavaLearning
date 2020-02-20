package drawpackage;

/**
 * Das Fenster, in dem alles Angezeigt wird
 * 
 * @author Jana
 *
 */
public class ClassJFrame implements Runnable {

	public static javax.swing.JFrame frame;
	private static String name = "Fenster";
	public static ClassJLabel1 cjl1;
	public static ClassJLabel2 cjl2;
	public static ClassJTextArea cjta;
	public static KeyHandler kh = new KeyHandler();
	public static MouseHandler mh = new MouseHandler();

	public static Integer height;
	public static Integer width;
	public static java.awt.Cursor c = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);

	public ClassJFrame(Integer newwidth, Integer newheight, String newname) {
		width = newwidth;
		height = newheight;
		name = newname;
	}

	@Override
	public void run() {
		frame = new javax.swing.JFrame(name);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.requestFocus();
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setCursor(c);
		frame.addKeyListener(kh);
		frame.addMouseListener(mh);
		// frame.setAlwaysOnTop(true);
		frame.requestFocus();
		
		cjl1 = new ClassJLabel1();
		frame.add(cjl1);
		cjl1.repaint();
		cjl1.setBounds(0, 0, 641, ClassJFrame.height);

		cjta = new ClassJTextArea();
		cjta.setVisible(true);

		javax.swing.JScrollPane jsp = new javax.swing.JScrollPane(cjta);
		jsp.setBounds(646, 0, ClassJFrame.width - 665, ClassJFrame.height - 38);
		frame.add(jsp);

		cjl2 = new ClassJLabel2();
		frame.add(cjl2);
		cjl2.repaint();
		cjl2.setBounds(641, 0, ClassJFrame.width - 641, ClassJFrame.height);

		cjl1.setVisible(true);
		cjl2.setVisible(true);
		cjta.setVisible(true);
		jsp.setVisible(true);
		frame.setVisible(true);

		// Zum Fixen, warum auch immer das nicht funktioniert...
		logic.Main.world1[0][0][0] = 1;
		logic.Main.world1[0][0][1] = 1;
	}
}