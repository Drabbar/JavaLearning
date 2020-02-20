package decipher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class Window {

	public static JLabel label1, label2, label3, label4;
	public static JFrame frame;
	public static JTextArea textArea;
	public static JButton remove, stop, run, useless;
	public static JButton save0, save1, save2, save3, save4, save5, save6, save7;
	public static JButton confirm, cancel, rename, save, load, clear, right, left;
	public static JScrollPane scrollPane;
	public static JLayeredPane pane1, pane2, pane3, allpane;
	public static boolean select_Save = false;
	public static boolean select_Load = false;
	public static boolean select_rename = false;
	public static boolean select_clear = false;
	public static boolean cancelb = false;
	public static boolean confirmb = false;
	public static int programming_Field_Xabs = 30; // 8
	public static int programming_Field_Yabs = 80; // 5
	public static int programming_Field_Width = 415; // 4
	public static int programming_Field_Height = 660; // 7
	public static int Verschiebung1 = 470;
	public static boolean Label2move = true;
	public static int Verschiebung2 = 0;
	public static boolean saveButtonmove = true;
	public static int inorout = 1;
	public static int page = 0;

	public Window() // constructor
	{
		build_Window();

		for (int h = 0; h < MethodClass.allowed.length; h++) {
			MethodClass.allowed[h] = true;
		}
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Window wind = new Window();
	}

	public static void build_Window() {
		frame = new JFrame();

		ImageIcon savepic = new ImageIcon("textures/decipher/File.png");
		ImageIcon conf = new ImageIcon("textures/decipher/Haken.png");
		ImageIcon canc = new ImageIcon("textures/decipher/Nein.png");

		handler0 handler0 = new handler0();
		handler1 handler1 = new handler1();
		handler2 handler2 = new handler2();

		frame.setSize(540, 800);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Programmierfenster");
		frame.setResizable(false);
		frame.setVisible(true);

		pane1 = new JLayeredPane(); // normal pane
		pane1.setBounds(0, 0, 1000, frame.getHeight());

		pane2 = new JLayeredPane(); // movable pane
		pane2.setBounds(470, 53, 200, frame.getHeight());
		pane2.addMouseListener(new MouseLisstener0());

		pane3 = new JLayeredPane(); // normal pane
		pane3.setBounds(0, 0, 1000, frame.getHeight());
		pane2.add(pane3, JLayeredPane.POPUP_LAYER);

		allpane = new JLayeredPane(); // normal pane
		allpane.setBounds(0, 0, 2000, frame.getHeight());

		label1 = new Label1(); // main label
		label1.setVisible(true);
		label1.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		pane1.add(label1, JLayeredPane.DEFAULT_LAYER);

		label2 = new Label2(); // move label
		label2.setVisible(true);
		label2.setBounds(0, 0, 200, frame.getHeight());
		pane2.add(label2, JLayeredPane.MODAL_LAYER);

		label3 = new Label3(); // surround label
		label3.setVisible(true);
		label3.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		allpane.add(label3, JLayeredPane.MODAL_LAYER);
		
		label4 = new Label4(); // savefile description label
		label4.setVisible(true);
		label4.setBounds(0,140,pane3.getWidth(),pane3.getHeight());
		pane3.add(label4, JLayeredPane.POPUP_LAYER);

		textArea = new ClassJTextArea();
		textArea.setVisible(true);
		textArea.setBounds(programming_Field_Xabs, programming_Field_Yabs, programming_Field_Width,
				programming_Field_Height);

		scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		scrollPane.setBounds(programming_Field_Xabs, programming_Field_Yabs, programming_Field_Width,
				programming_Field_Height);
		pane1.add(scrollPane, JLayeredPane.PALETTE_LAYER);

		remove = new JButton("clear");
		remove.setBounds(15, 15, 70, 30);
		remove.setBackground(Color.WHITE);
		remove.setFocusPainted(false);
		remove.addActionListener(handler0);
		remove.setToolTipText("Click to delete all code");
		pane1.add(remove, JLayeredPane.PALETTE_LAYER);

		useless = new JButton("not used");
		useless.setBounds(170, 15, 85, 30);
		useless.setBackground(Color.WHITE);
		useless.setFocusPainted(false);
		useless.addActionListener(handler0);
		useless.setToolTipText("no use");
		pane1.add(useless, JLayeredPane.PALETTE_LAYER);

		stop = new JButton("stop");
		stop.setBounds(270, 15, 60, 30);
		stop.setBackground(Color.WHITE);
		stop.setFocusPainted(false);
		stop.addActionListener(handler0);
		stop.setToolTipText("Click to stop running programm");
		pane1.add(stop, JLayeredPane.PALETTE_LAYER);

		run = new JButton("run");
		run.setBounds(100, 15, 60, 30);
		run.setBackground(Color.WHITE);
		run.setFocusPainted(false);
		run.addActionListener(handler0);
		run.setToolTipText("Click to run code and save to file_1");
		pane1.add(run, JLayeredPane.PALETTE_LAYER);

		// savebuttons

		save0 = new JButton(savepic);
		save0.setBounds(20, 200 - 55 + 20, 100, 100);
		save0.setBackground(Color.DARK_GRAY);
		save0.setFocusPainted(false);
		save0.addActionListener(handler1);
		save0.setToolTipText("File 1 (auto save when run)");
		pane3.add(save0, JLayeredPane.POPUP_LAYER);

		save1 = new JButton(savepic);
		save1.setBounds(20, 330 - 55 + 20, 100, 100);
		save1.setBackground(Color.DARK_GRAY);
		save1.setFocusPainted(false);
		save1.addActionListener(handler1);
		save1.setToolTipText("File 2");
		pane3.add(save1, JLayeredPane.DEFAULT_LAYER);

		save2 = new JButton(savepic);
		save2.setBounds(20, 460 - 55 + 20, 100, 100);
		save2.setBackground(Color.DARK_GRAY);
		save2.setFocusPainted(false);
		save2.addActionListener(handler1);
		save2.setToolTipText("File 3");
		pane3.add(save2, JLayeredPane.DEFAULT_LAYER);

		save3 = new JButton(savepic);
		save3.setBounds(20, 590 - 55 + 20, 100, 100);
		save3.setBackground(Color.DARK_GRAY);
		save3.setFocusPainted(false);
		save3.addActionListener(handler1);
		save3.setToolTipText("File 4");
		pane3.add(save3, JLayeredPane.DEFAULT_LAYER);

		save4 = new JButton(savepic);
		save4.setBounds(20 + 180, 200 - 55 + 20, 100, 100);
		save4.setBackground(Color.DARK_GRAY);
		save4.setFocusPainted(false);
		save4.addActionListener(handler1);
		save4.setToolTipText("File 5");
		pane3.add(save4, JLayeredPane.DEFAULT_LAYER);

		save5 = new JButton(savepic);
		save5.setBounds(20 + 180, 330 - 55 + 20, 100, 100);
		save5.setBackground(Color.DARK_GRAY);
		save5.setFocusPainted(false);
		save5.addActionListener(handler1);
		save5.setToolTipText("File 6");
		pane3.add(save5, JLayeredPane.DEFAULT_LAYER);

		save6 = new JButton(savepic);
		save6.setBounds(20 + 180, 460 - 55 + 20, 100, 100);
		save6.setBackground(Color.DARK_GRAY);
		save6.setFocusPainted(false);
		save6.addActionListener(handler1);
		save6.setToolTipText("File 7");
		pane3.add(save6, JLayeredPane.DEFAULT_LAYER);

		save7 = new JButton(savepic);
		save7.setBounds(20 + 180, 590 - 55 + 20, 100, 100);
		save7.setBackground(Color.DARK_GRAY);
		save7.setFocusPainted(false);
		save7.addActionListener(handler1);
		save7.setToolTipText("File 8");
		pane3.add(save7, JLayeredPane.DEFAULT_LAYER);

		confirm = new JButton(conf);
		confirm.setBackground(Color.GRAY);
		confirm.setFocusPainted(false);
		confirm.addActionListener(handler2);
		confirm.setToolTipText("confirm");
		confirm.setVisible(false);
		confirm.setBounds(130, 0, 45, 45);
		pane2.add(confirm, JLayeredPane.POPUP_LAYER);

		cancel = new JButton(canc);
		cancel.setBackground(Color.GRAY);
		cancel.setFocusPainted(false);
		cancel.addActionListener(handler2);
		cancel.setToolTipText("cancel");
		cancel.setVisible(false);
		cancel.setBounds(130, 0, 45, 45);
		pane2.add(cancel, JLayeredPane.POPUP_LAYER);

		rename = new JButton("rename");
		rename.setBounds(10, 70 - 55, 80, 30);
		rename.setBackground(Color.WHITE);
		rename.setFocusPainted(false);
		rename.addActionListener(handler2);
		rename.setToolTipText("rename a file");
		pane2.add(rename, JLayeredPane.POPUP_LAYER);

		save = new JButton("save");
		save.setBounds(10, 110 - 55, 80, 30);
		save.setBackground(Color.WHITE);
		save.setFocusPainted(false);
		save.addActionListener(handler2);
		save.setToolTipText("save text to a file");
		pane2.add(save, JLayeredPane.POPUP_LAYER);

		load = new JButton("load");
		load.setBounds(105, 110 - 55, 80, 30);
		load.setBackground(Color.WHITE);
		load.setFocusPainted(false);
		load.addActionListener(handler2);
		load.setToolTipText("load text to a file");
		pane2.add(load, JLayeredPane.POPUP_LAYER);

		clear = new JButton("clear");
		clear.setBounds(105, 70 - 55, 80, 30);
		clear.setBackground(Color.WHITE);
		clear.setFocusPainted(false);
		clear.addActionListener(handler2);
		clear.setToolTipText("clear textfile");
		pane2.add(clear, JLayeredPane.POPUP_LAYER);

		right = new JButton("--)");
		right.setBackground(Color.WHITE);
		right.setFocusPainted(false);
		right.addActionListener(handler2);
		right.setToolTipText("right");
		right.setBounds(105, 100, 80, 30);
		pane2.add(right, JLayeredPane.POPUP_LAYER);

		left = new JButton("(--");
		left.setBackground(Color.WHITE);
		left.setFocusPainted(false);
		left.addActionListener(handler2);
		left.setToolTipText("left");
		left.setBounds(10, 100, 80, 30);
		pane2.add(left, JLayeredPane.POPUP_LAYER);

		allpane.add(pane1, JLayeredPane.DEFAULT_LAYER);
		pane1.setVisible(true);
		allpane.add(pane2, JLayeredPane.PALETTE_LAYER);
		pane2.setVisible(true);
		frame.add(allpane);
		allpane.setVisible(true);

		new Thread() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					if (Window.select_Load == true) {
						Window.load.setBackground(Color.CYAN);
					} else {
						Window.load.setBackground(Color.WHITE);
					}

					if (Window.select_Save == true) {
						Window.save.setBackground(Color.CYAN);
					} else {
						Window.save.setBackground(Color.WHITE);
					}

					if (Window.select_rename == true) {
						Window.rename.setBackground(Color.CYAN);
					} else {
						Window.rename.setBackground(Color.WHITE);
					}

					if (Window.select_clear == true) {
						Window.clear.setBackground(Color.CYAN);
					} else {
						Window.clear.setBackground(Color.WHITE);
					}
				}
			}

		}.start();

		repaintall();

		try {
			File file = new File("Code/Last Used.txt");
			FileInputStream fis;
			fis = new FileInputStream(file);
			byte[] data1 = new byte[(int) file.length()];
			fis.read(data1);
			fis.close();
			textArea.setText(new String(data1, "UTF-8"));
		} catch (IOException e) {
			System.out.println("not loaded");
		}

		repaintall();
	}

	public static void repaintall() {
		label1.repaint();
		label2.repaint();
		textArea.repaint();
		scrollPane.repaint();
		remove.repaint();
		cancel.repaint();
		confirm.repaint();
		pane1.repaint();
		pane2.repaint();
		allpane.repaint();
		// textArea.setFont(new Font("Courier", Font.BOLD,12));
	}
}

class handler0 implements ActionListener {

	String text;

	@Override

	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == Window.remove) // remove
		{
			Window.textArea.setText("");
			Window.repaintall();
		}
		if (event.getSource() == Window.run && Encoder.stop == false) // run
		{
			text = Window.textArea.getText();
			PrintWriter printer = null;
			try {
				printer = new PrintWriter("Code/Last Used.txt");
			} catch (IOException e) {
			}
			printer.printf("%s" + "%n", text);
			printer.close();
			Window.stop.setBackground(Color.CYAN);
			Encoder.stop = false;

			Encoder.Encode(text);
		}
		if (event.getSource() == Window.useless) // useless
		{
			System.out.println("useless");
		}

		if (event.getSource() == Window.stop) // stop
		{
			Encoder.stop = true;
			System.out.println("Window stop");
			Window.stop.setBackground(Color.WHITE);
		}

	}
}

class handler1 implements ActionListener {

	String text;

	@Override

	public void actionPerformed(ActionEvent event) {
		Window.cancelb = true;

		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
		}

		Window.cancelb = false;
		Window.confirmb = false;
		if (Window.inorout == 2) {
			if (Window.select_Save == true) // save to file
			{
				new Thread() {
					@Override
					public void run() {

						text = "";
						text = Window.textArea.getText();

						PrintWriter printer = null;

						if (event.getSource() == Window.save0) // save lastUsed
						{
							locate_buttons(1);
							try {
								printer = new PrintWriter("Code/Last Used.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save1) // save save1
						{
							locate_buttons(2);
							try {
								printer = new PrintWriter("Code/Save1.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save2) // save save2
						{
							locate_buttons(3);
							try {
								printer = new PrintWriter("Code/Save2.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save3) // save save3
						{
							locate_buttons(4);
							try {
								printer = new PrintWriter("Code/Save3.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save4) // save save4
						{
							locate_buttons(1);
							try {
								printer = new PrintWriter("Code/Save4.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save5) // save save5
						{
							locate_buttons(2);
							try {
								printer = new PrintWriter("Code/Save5.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save6) // save save6
						{
							locate_buttons(3);
							try {
								printer = new PrintWriter("Code/Save6.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save7) // save save7
						{
							locate_buttons(4);
							try {
								printer = new PrintWriter("Code/Save7.txt");
							} catch (IOException e) {
							}
						}

						for (int t = 0; t < 200; t++) {
							// System.out.println("cancel: " + Window.cancelb + " confirm: " +
							// Window.confirmb + " int: " + t);
							if (Window.cancelb == true) {
								// System.out.println("canceled");
								break;
							}
							if (Window.confirmb == true) {
								// System.out.println("confirmed");
								printer.printf("%s" + "%n", text);
								break;
							}

							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
							}

						}

						locate_buttons(0);

						printer.close();
						
						Window.select_Load = false;
						Window.select_Save = false;
						Window.select_rename = false;
						Window.select_clear = false;

					}
				}.start();
			} else if (Window.select_Load == true) // load
			{

				text = "";

				new Thread() {

					@Override
					public void run() {

						File file = null;

						if (event.getSource() == Window.save0) // load lastUsed
						{
							file = new File("Code/Last Used.txt");
							locate_buttons(1);
						}

						if (event.getSource() == Window.save1) // load Save1
						{
							file = new File("Code/Save1.txt");
							locate_buttons(2);
						}

						if (event.getSource() == Window.save2) // load Save2
						{
							file = new File("Code/Save2.txt");
							locate_buttons(3);
						}

						if (event.getSource() == Window.save3) // load Save3
						{
							file = new File("Code/Save3.txt");
							locate_buttons(4);
						}
						if (event.getSource() == Window.save4) // load Save4
						{
							file = new File("Code/Save4.txt");
							locate_buttons(1);
						}

						if (event.getSource() == Window.save5) // load Save5
						{
							file = new File("Code/Save5.txt");
							locate_buttons(2);
						}

						if (event.getSource() == Window.save6) // load Save6
						{
							file = new File("Code/Save6.txt");
							locate_buttons(3);
						}

						if (event.getSource() == Window.save7) // load Save7
						{
							file = new File("Code/Save7.txt");
							locate_buttons(4);
						}

						for (int t = 0; t < 200; t++) {
							// System.out.println("cancel: " + Window.cancelb + " confirm: " +
							// Window.confirmb + " int: " + t);
							if (Window.cancelb == true) {
								// System.out.println("canceled");
								break;
							}
							if (Window.confirmb == true) {
								// System.out.println("cofirmed");
								FileInputStream fis;
								try {
									fis = new FileInputStream(file);
									byte[] data = new byte[(int) file.length()];
									fis.read(data);
									fis.close();
									text = new String(data, "UTF-8");
								} catch (IOException e) {
								}
								Window.textArea.setText(text);
								break;
							}
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
							}
						}
						locate_buttons(0);
						
						Window.select_Load = false;
						Window.select_Save = false;
						Window.select_rename = false;
						Window.select_clear = false;

					}

				}.start();

			} else if (Window.select_rename == true) // rename
			{
				text = "";

				new Thread() {

					@Override
					public void run() {

						PrintWriter printer = null;
						File file = new File("Code/Names.txt"); // read
						FileInputStream fis = null; // read
						String namebef, nameaft, print;
						print = "";
						String[] input = new String[4];

						try {
							fis = new FileInputStream(file);
							byte[] data = new byte[(int) file.length()];
							fis.read(data);
							fis.close();
							text = new String(data, "UTF-8");
						} catch (IOException e) {
							System.out.println("reader kaputt");
						}

						input = text.split("#");
						/*
						 * for (String element : input) { System.out.print("element: " + element);
						 * System.out.println(""); }
						 */

						try {
							printer = new PrintWriter("Code/Names.txt");
						} catch (FileNotFoundException e) {
						} // print

						if (event.getSource() == Window.save0) // rename lastUsed
						{
							System.out.println("rename 1.");

							namebef = input[0];
							nameaft = JOptionPane.showInputDialog("Rename File_1 / " + namebef + " :");
							
							if (nameaft == null) {nameaft = namebef;}
							print = nameaft + "#" + input[1] + "#" + input[2] + "#" + input[3] + "#" + input[4] + "#" + input[5] + "#" + input[6] + "#" + nameaft + "#";

						}

						if (event.getSource() == Window.save1) // rename Save1
						{
							System.out.println("rename 2.");

							namebef = input[1];
							nameaft = JOptionPane.showInputDialog("Rename File_2 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + nameaft + "#" + input[2] + "#" + input[3] + "#" + input[4] + "#" + input[5] + "#" + input[6] + "#" + input[7] + "#";
						}

						if (event.getSource() == Window.save2) // rename Save2
						{
							System.out.println("rename 3.");

							namebef = input[2];
							nameaft = JOptionPane.showInputDialog("Rename File_3 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + nameaft + "#" + input[3] + "#" + input[4] + "#" + input[5] + "#" + input[6] + "#" + input[7] + "#";
						}

						if (event.getSource() == Window.save3) // rename Save3
						{
							System.out.println("rename 4.");

							namebef = input[3];
							nameaft = JOptionPane.showInputDialog("Rename File_4 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + input[2] + "#" + nameaft + "#" + input[4] + "#" + input[5] + "#" + input[6] + "#" + input[7] + "#";
						}
						if (event.getSource() == Window.save4) // rename Save4
						{
							System.out.println("rename 5.");

							namebef = input[4];
							nameaft = JOptionPane.showInputDialog("Rename File_5 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + input[2] + "#" + input[3] + "#" + nameaft + "#" + input[5] + "#" + input[6] + "#" + input[7] + "#";

						}

						if (event.getSource() == Window.save5) // rename Save5
						{
							System.out.println("rename 6.");

							namebef = input[5];
							nameaft = JOptionPane.showInputDialog("Rename File_6 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + input[2] + "#" + input[3] + "#" + input[4] + "#" + nameaft + "#" + input[6] + "#" + input[7] + "#";
						}

						if (event.getSource() == Window.save6) // rename Save6
						{
							System.out.println("rename 7.");

							namebef = input[6];
							nameaft = JOptionPane.showInputDialog("Rename File_7 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + input[2] + "#" + input[3] + "#" + input[4] + "#" + input[5] + "#" + nameaft + "#" + input[7] + "#";
						}

						if (event.getSource() == Window.save7) // rename Save7
						{
							System.out.println("rename 8.");

							namebef = input[7];
							nameaft = JOptionPane.showInputDialog("Rename File_8 / " + namebef + " :");
							if (nameaft == null) {nameaft = namebef;}
							print = input[0] + "#" + input[1] + "#" + input[2] + "#" + input[3] + "#" + input[4] + "#" + input[5] + "#" + input[6] + "#" + nameaft + "#";
						}

						printer.printf("%s" + "%n", print);

						printer.close();
						
						Window.select_Load = false;
						Window.select_Save = false;
						Window.select_rename = false;
						Window.select_clear = false;

					}
				}.start();

			} else if (Window.select_clear == true) // clear
			{
				text = "";

				new Thread() {

					@Override
					public void run() {

						PrintWriter printer = null;

						if (event.getSource() == Window.save0) // clear lastUsed
						{
							locate_buttons(1);
							try {
								printer = new PrintWriter("Code/Last Used.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save1) // clear save1
						{
							locate_buttons(2);
							try {
								printer = new PrintWriter("Code/Save1.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save2) // clear save2
						{
							locate_buttons(3);
							try {
								printer = new PrintWriter("Code/Save2.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save3) // clear save3
						{
							locate_buttons(4);
							try {
								printer = new PrintWriter("Code/Save3.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save4) // clear save4
						{
							locate_buttons(1);
							try {
								printer = new PrintWriter("Code/Save4.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save5) // clear save5
						{
							locate_buttons(2);
							try {
								printer = new PrintWriter("Code/Save5.txt");
							} catch (IOException e) {
							}
						}

						if (event.getSource() == Window.save6) // clear save6
						{
							locate_buttons(3);
							try {
								printer = new PrintWriter("Code/Save6.txt");
							} catch (IOException e) {
							}
						}
						if (event.getSource() == Window.save7) // clear save7
						{
							locate_buttons(4);
							try {
								printer = new PrintWriter("Code/Save7.txt");
							} catch (IOException e) {
							}
						}

						for (int t = 0; t < 200; t++) {
							if (Window.cancelb == true) {
								break;
							}
							if (Window.confirmb == true) {
								printer.printf("%s" + "%n", "");
								break;
							}
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
							}

						}

						printer.close();

						locate_buttons(0);

						Window.select_Load = false;
						Window.select_Save = false;
						Window.select_rename = false;
						Window.select_clear = false;
					}
				}.start();
			}
		}
	}

	public static void locate_buttons(int but) {
		if (but == 0) {
			Window.cancel.setVisible(false);
			Window.confirm.setVisible(false);
		} else {
			int y = 0;
			switch (but) {
			case 1:
				y = 205 - 55;
				break;
			case 2:
				y = 335 - 55;
				break;
			case 3:
				y = 465 - 55;
				break;
			case 4:
				y = 595 - 55;
				break;
			}

			y += 15;

			Window.cancel.setBounds(Window.cancel.getX(), y, Window.cancel.getWidth(), Window.cancel.getHeight());
			Window.confirm.setBounds(Window.confirm.getX(), y + 55, Window.confirm.getWidth(),
					Window.confirm.getHeight());

			Window.cancel.setVisible(true);
			Window.confirm.setVisible(true);

			Window.repaintall();
		}

	}

}

class handler2 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		if (Window.inorout == 2) {
			if (event.getSource() == Window.cancel) {
				Window.cancelb = true;
			}
			if (event.getSource() == Window.confirm) {
				Window.confirmb = true;
			}
			if (event.getSource() == Window.rename) {
				if (Window.select_rename == true) {
					System.out.println("rename false");
					Window.select_rename = false;
				} else {
					System.out.println("rename true");
					Window.select_rename = true;
				}
				Window.select_Load = false;
				Window.select_Save = false;
				Window.select_clear = false;
			}
			if (event.getSource() == Window.save) {
				if (Window.select_Save == true) {
					System.out.println("save false");
					Window.select_Save = false;
				} else {
					System.out.println("save true");
					Window.select_Save = true;
				}
				Window.select_Load = false;
				Window.select_rename = false;
				Window.select_clear = false;
			}
			if (event.getSource() == Window.clear) {
				if (Window.select_clear == true) {
					System.out.println("clear false");
					Window.select_clear = false;
				} else {
					System.out.println("clear true");
					Window.select_clear = true;
				}
				Window.select_Load = false;
				Window.select_rename = false;
				Window.select_Save = false;
			}
			if (event.getSource() == Window.load) {
				if (Window.select_Load == true) {
					System.out.println("load false");
					Window.select_Load = false;
				} else {
					System.out.println("load true");
					Window.select_Load = true;
				}
				Window.select_Save = false;
				Window.select_rename = false;
				Window.select_clear = false;
			}
			if (event.getSource() == Window.right) {
				System.out.println("right");
				if (Window.page < 1) {
					Thread aThread = new Thread(new saveButtonsmoveThread(1));
					aThread.start();
				}
			}
			if (event.getSource() == Window.left) {
				System.out.println("left");
				if (Window.page > 0) {
					Thread aThread = new Thread(new saveButtonsmoveThread(2));
					aThread.start();
				}
			}
		}
	}
}