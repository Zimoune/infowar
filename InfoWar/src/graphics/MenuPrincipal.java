package graphics;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPrincipal extends JFrame implements ActionListener {

	JButton jcj;
	JButton jco;
	JButton options;
	JButton quitter;
	JPanel panelButton;
	JLabel titre;
	JPanel menu;

	public MenuPrincipal() {
		jcj = new JButton("Joueur contre Joueur");
		jco = new JButton("Joueur contre Ordinateur");
		options = new JButton("Options");
		quitter = new JButton("Quitter");
		panelButton = new JPanel();
		titre = new JLabel("VirtualWar");
		menu = new JPanel();

		titre.setFont(new Font("Serif", Font.BOLD, 48));

		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));

		panelButton.setLayout(new GridLayout(4, 3, 50, 50));

		jcj.addActionListener(this);
		jco.addActionListener(this);
		options.addActionListener(this);
		quitter.addActionListener(this);

		menu.add(titre);
		menu.add(Box.createRigidArea(new Dimension(0, 30)));

		panelButton.add(Box.createRigidArea(new Dimension(0, 0)));
		panelButton.add(jcj);
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(jco);
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(options);
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		panelButton.add(quitter);
		panelButton.add(Box.createRigidArea(new Dimension(30, 0)));

		menu.add(Box.createRigidArea(new Dimension(0, 60)));
		menu.add(panelButton);
		menu.add(Box.createRigidArea(new Dimension(0, 100)));

		panelButton.setAlignmentX(CENTER_ALIGNMENT);
		jcj.setAlignmentX(CENTER_ALIGNMENT);
		jco.setAlignmentX(CENTER_ALIGNMENT);
		options.setAlignmentX(CENTER_ALIGNMENT);
		quitter.setAlignmentX(CENTER_ALIGNMENT);
		titre.setAlignmentX(CENTER_ALIGNMENT);

		this.setContentPane(menu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Stub de la méthode généré automatiquement
		if (e.getSource() == options) {
			this.setContentPane(new Options());
			this.revalidate();
		} else if (e.getSource() == quitter) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Stub de la méthode généré automatiquement
		JFrame f = new MenuPrincipal();
		f.setTitle("VirtualWar");
		f.pack();
		f.setDefaultLookAndFeelDecorated(false);
		f.setExtendedState(MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
