import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Panel where levels and players are displayed
 * @author Ryley Danielson
 *
 */
public class ActionPanel extends JPanel implements Runnable, KeyListener, MouseListener, ActionListener {
JLabel l;
	
	Level_1 L1;
	File f;
	ArrayList<GameObject> gmob;
 	int levelNumber = 1;

	public ActionPanel(){
		super();
		
		this.setLayout(new GridLayout(1,2));
		
		//l = new JLabel("I Work");
		
		//this.add(l);
		
		//this.setBackground(Color.BLACK);
		
		L1 =new Level_1();
		
		this.setVisible(true);
		
		run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if (levelNumber == 1){

			try {
				L1.genLevel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gmob =L1.getGmob();
			
			repaint();
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	 public void paintComponent(Graphics g){
		    
	    	super.paintComponent(g);
	    	
	    	for(int i = 0; i<gmob.size(); i++){
	    		
	    		gmob.get(i).draw(g);
	    	}
	    }

}
