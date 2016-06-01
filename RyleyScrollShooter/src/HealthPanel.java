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
		
		l =new JLabel();
		
		this.add(l);
		
		l = new JLabel(Double.toString(ActionPanel.playerHealth));
		
		this.add(l);
		
		this.setBackground(Color.GREEN);
		
		this.setVisible(true);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		HealthPanel p;
		p = this;
		ActionPanel.playerHealth = 100;
		
		while (GameFrame.endAll == false){
			l.setText(Double.toString(ActionPanel.playerHealth));
			
			if(ActionPanel.playerHealth == 100){
				p.setBackground(Color.GREEN);
				repaint();
			}
			
			if(ActionPanel.playerHealth == 70){
				p.setBackground(Color.YELLOW);
				repaint();
			}
			if(ActionPanel.playerHealth == 55 || ActionPanel.playerHealth == 50 ){
				p.setBackground(Color.ORANGE);
				repaint();
			}
			if(ActionPanel.playerHealth == 25){
				p.setBackground(Color.RED);
				repaint();
			}
		}
	}


}
