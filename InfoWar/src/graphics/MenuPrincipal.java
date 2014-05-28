package graphics;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import plateau.Plateau;

import main.Main;

public class MenuPrincipal extends JFrame{

	Map map;
	MenuPanel menu = new MenuPanel(this);
	public MenuPrincipal(Plateau p) {
		this.map = new Map(p);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("VirtualWar");
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultLookAndFeelDecorated(false);
		this.setContentPane(map);
		this.setPreferredSize(new Dimension(1024,768));
		this.pack();
	}

}