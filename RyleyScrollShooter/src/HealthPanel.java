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
		while (true){
			l.setText(Double.toString(ActionPanel.playerHealth));
			
			if(Double.toString(ActionPanel.playerHealth) == "70"){
				this.setBackground(Color.YELLOW);
			}else if(Double.toString(ActionPanel.playerHealth) == "55"){
				this.setBackground(Color.ORANGE);
			}else if(Double.toString(ActionPanel.playerHealth) == "30"){
				this.setBackground(Color.RED);
			}
		}
	}


}
