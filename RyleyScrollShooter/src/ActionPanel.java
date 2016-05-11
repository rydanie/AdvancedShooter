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

//    http://staticvoidgames.com/tutorials/swing/listeners

public class ActionPanel extends JPanel implements Runnable, KeyListener, MouseListener, ActionListener {
	JLabel l;
	//Level_1 L1;
	File f;
	ArrayList<GameObject> gmob;
	Player pUnit;
 	int levelNumber = 1;
 	
 	//JComponent component = new JComponent();

	public ActionPanel(){
		super();
		
		
		//this.setLayout(new GridLayout(1,2));
		
		//l = new JLabel("I Work");
		
		//this.add(l);
		
		//this.setBackground(Color.BLACK);
		
		//L1 =new Level_1();
		
		gmob = new ArrayList<GameObject>();
		
		this.setBackground(Color.WHITE);
		
		//addKeyListener(this);
		
		this.setVisible(true);
		
		

		run();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if (levelNumber == 1){

			Level_1 L1 = new Level_1();
			
			try {
				L1.genLevel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gmob =L1.getGmob();
			
			findPlayer(gmob);
			
			repaint();
		}
		
		
	}
	
	public void setBinding(){
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke("ENTER"), "test");
		getActionMap().put("test", this); 
    	//this.addActionListener(this);
	}

	public void findPlayer(ArrayList<GameObject> h){
		
		for(int i = 0; i<h.size(); i++){
			
			if(h.get(i).getThisObjectLocation() == Level_1.pUnit.getLocation()){
				
				pUnit = (Player) h.get(i); 
				break;
			}
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

	
	
	 public void paintComponent(Graphics g){
		    
	    	super.paintComponent(g);
	    	
	    	for(int i = 1; i< gmob.size(); i++){
	    		
	    		System.out.println(gmob.get(i));
	    		gmob.get(i).draw(g);
	   
	    	}
	    }


	 public void keyTyped(KeyEvent e) {
	        System.out.println("Key typed: " + e.getKeyChar());
	    }

	  public void keyPressed(KeyEvent e) {
	        System.out.println("Key pressed: " + e.getKeyChar());
	        
	        
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
	            System.out.println("Right typed.");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            System.out.println("Left typed.");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            System.out.println("Up typed.");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            System.out.println("Down typed.");
	        }
	        else{
	            System.out.println("Key typed: " + e.getKeyChar());
	            
	            if(e.getKeyChar() == 'w'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            } else if(e.getKeyChar() == 's'){
	            	
	            }else if(e.getKeyChar() == 'd'){
	            	
	            }else if(e.getKeyChar() == 'e'){
	            	
	            }else if(e.getKeyChar() == 'q'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }
	        }
	        
	    }

	  public void keyReleased(KeyEvent e) {
	        System.out.println("Key released: " + e.getKeyChar());
	    }
		
	

}
