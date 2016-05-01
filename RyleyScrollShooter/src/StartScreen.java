import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * Screen that pops up at the start of the game
 * @author Ryley Danielson
 *
 */
public class StartScreen extends JFrame implements ActionListener {

	 public GridBagLayout layout;
	 public JLabel title;
	
	public StartScreen(){
		super();
		
		layout =new GridBagLayout();
		
		this.setLayout( layout );
        this.setName( "Ryley's Sooter");
        this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        
        
        GridBagConstraints c = new GridBagConstraints();
        // general constraints
        /*
        c.fill = GridBagConstraints.BOTH;
        
        // label constraints
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        c.gridx = 0;
        c.gridy = 3;
        title = new JLabel( "Game Project" );
        layout.setConstraints( title, c );
        this.add( title );
        */
        
        c.weightx = 0.0;
        c.gridwidth = GridBagConstraints.RELATIVE;
        
        c.gridx = 0;
        c.gridy = 2;
        
        JButton start = new JButton("Start Game");
        start.addActionListener(this);
        start.setActionCommand("start main");
        this.add(start);
        
        //this.setForeground(Color.BLUE);//(new BufferedImage(new File("uiImage")));
        
        this.pack();
        this.setSize(400,400 );
        // Our size will be wrong, so let's fix it
        //myFrame.setSize(600, 200);
        // alternate: use pack
        //myFrame.pack();

        this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		switch (a.getActionCommand()){
		
		case("start main"):
			this.setVisible(false);
		}
	}

	
}
