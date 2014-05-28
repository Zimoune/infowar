package outilsGraphic;

import javax.swing.Icon;
import javax.swing.JButton;


public class MyJButton extends JButton {
	private int id;
	
	public MyJButton(String text, int id) {
		super(text);
		this.id = id;
	}

	public MyJButton(String text, Icon icon) {
		super(text, icon);

	}

	public MyJButton(String text) {
		super(text);

	}
	
	public int getId(){
		return this.id;
	}

	

}
