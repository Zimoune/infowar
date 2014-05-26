package graphics;

import java.awt.CardLayout;

import javax.swing.*;

public class MainGraphics extends JFrame {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		JFrame f = new JFrame();
		f.setTitle("VirtualWar");
		f.pack();
		f.setSize(500,500);
		//f.setContentPane(new MenuP(f));
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
