package Graphics;

import java.awt.CardLayout;

import javax.swing.*;

public class MainGraphics extends JFrame {
	
	static CardLayout carte = new CardLayout();
	static String[] listePanel = new String[]{"Menu","Options"};
	static JPanel content = new JPanel();
	static JPanel menu;
	static JPanel option;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		content.setLayout(carte);
		// TODO Stub de la méthode généré automatiquement
		JFrame f = new JFrame();
		f.setTitle("VirtualWar");
		f.pack();
		f.setSize(500,500);
		f.getContentPane().add(new Menu(carte,listePanel,content));
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
