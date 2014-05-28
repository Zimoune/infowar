package graphics;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.Main;

public class MenuPrincipal extends JFrame{

	MenuPanel menu = new MenuPanel(this);
	public MenuPrincipal() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("VirtualWar");
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultLookAndFeelDecorated(false);
		this.setContentPane(menu);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		this.setPreferredSize(d);
		this.pack();
	}

}