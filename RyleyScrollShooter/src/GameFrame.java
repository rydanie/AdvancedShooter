import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * 
 * @author Ryley Danielson
 *
 */
public class GameFrame extends JFrame {

	DialoguePanel dp;
	ActionPanel ap;
	HealthPanel hp;
	
	public GameFrame(){
		super();
		
		this.setLayout(new BorderLayout());
		
		dp = new DialoguePanel();
		ap = new ActionPanel();
		hp = new HealthPanel();
		
		this.add(dp, BorderLayout.NORTH);
		this.add(ap, BorderLayout.CENTER);
		this.add(hp, BorderLayout.SOUTH);
		
		this.setSize(400,400);
		this.setVisible(true);
	}
}
