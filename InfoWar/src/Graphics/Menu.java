package Graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class Menu extends JPanel implements ActionListener {
	
	JButton jcj = new JButton("Joueur contre Joueur");
	JButton jco = new JButton("Joueur contre Ordinateur");
	JButton options = new JButton ("Options");
	JButton quitter = new JButton ("Quitter");
	JPanel panelButton = new JPanel();
	JLabel titre = new JLabel("VirtualWar");
	
	public Menu(){
		this.setLayout(null);
		panelButton.setLayout(new GridLayout(4,1));
		
		jcj.addActionListener(this);
		jco.addActionListener(this);
		options.addActionListener(this);
		quitter.addActionListener(this);
		
		panelButton.add(jcj);
		panelButton.add(jco);
		panelButton.add(options);
		panelButton.add(quitter);
		
		this.add(titre);
		titre.setBounds(200, 10, 100, 10);
		this.add(panelButton);
		panelButton.setBounds(150,150,200,200);

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Stub de la méthode généré automatiquement
		this.removeAll();
		JPanel option = new Options();
		this.add(option);
		option.setBounds(this.getBounds());
		repaint();
	}

}
