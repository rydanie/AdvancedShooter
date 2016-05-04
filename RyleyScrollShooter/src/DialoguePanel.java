import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * Dialogue that shows up during gameplay is displayed here
 * @author Ryley Danielson
 *
 */
public class DialoguePanel extends JPanel implements Runnable {
	
	JLabel l;
	
	public DialoguePanel(){
		super();
		
		this.setLayout(new GridLayout(1,2));
		
		l = new JLabel("I Work to Talk");
		
		this.add(l);
		
		
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
