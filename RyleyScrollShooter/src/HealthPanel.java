import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * Panel where health, energy, and gear are displayed
 * @author melissa
 *
 */
public class HealthPanel extends JPanel implements Runnable {

	JLabel l;
	
	public HealthPanel(){
		super();
		
		this.setLayout(new GridLayout(1,2));
		
		l = new JLabel("I Work TOO");
		
		this.add(l);
		
		this.setBackground(Color.GREEN);
		
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
