package graphics;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPanel extends JPanel implements ActionListener{

	private JLabel titre = new JLabel("VirtualWar");
	private JButton jcj = new JButton("Joueur contre Joueur");
	private JButton jco = new JButton("Joueur contre Ordinateur");
	private JButton options = new JButton("Options");
	private JButton quitter = new JButton("Quitter");
	private JFrame frame;
	JPanel panelButton = new JPanel();
	
	public MenuPanel(JFrame frame){
		this.frame = frame;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.titre.setFont(new Font("Serif", Font.BOLD, 48));
		this.add(titre);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		/*this.add(Box.createRigidArea(new Dimension(0, 30)));
		this.add(Box.createRigidArea(new Dimension(0, 60)));
		this.add(Box.createRigidArea(new Dimension(0, 100)));*/
		
		this.jcj.addActionListener(this);
		this.jco.addActionListener(this);
		this.options.addActionListener(this);
		this.quitter.addActionListener(this);
		
		this.panelButton.setLayout(new GridLayout(4, 3, 50, 50));
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(jcj);
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(jco);
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(options);
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		this.panelButton.add(quitter);
		this.panelButton.add(Box.createRigidArea(new Dimension(30, 0)));
		
		this.add(panelButton);
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.jcj.setAlignmentX(CENTER_ALIGNMENT);
		this.jco.setAlignmentX(CENTER_ALIGNMENT);
		this.options.setAlignmentX(CENTER_ALIGNMENT);
		this.quitter.setAlignmentX(CENTER_ALIGNMENT);
		this.titre.setAlignmentX(CENTER_ALIGNMENT);
		this.add(Box.createRigidArea(new Dimension(0,50)));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jcj){
			this.frame.setContentPane(new GraphicsParty(1, this.frame));
			this.frame.revalidate();
		}
		else if(e.getSource() == jco){
			this.frame.setContentPane(new GraphicsParty(2, this.frame));
			this.frame.revalidate();
		}
		else if(e.getSource() == options){
			this.frame.setContentPane(new Options(this.frame));
			this.frame.revalidate();
		}
		else if(e.getSource() == quitter)
			System.exit(0);

			
	}
	
}
