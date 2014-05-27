package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsParty extends JPanel{

	private JFrame frame;
	
	public GraphicsParty(int typeDePartie, JFrame frame){
		this.frame = frame;
		this.frame.setContentPane(new GraphicsPlateau(this.frame));
		this.frame.getContentPane().repaint();
		this.frame.revalidate();
		if(typeDePartie == 1 ){
			//On lance la partie JCJ
		}
		else{
			//On lance la partie IAvsIA
		}
		
	}
	
}
