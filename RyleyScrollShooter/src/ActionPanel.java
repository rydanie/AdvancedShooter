import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;

import javax.swing.*;


/**
 * Panel where levels and players are displayed
 * @author Ryley Danielson
 *
 */

//    http://staticvoidgames.com/tutorials/swing/listeners

public class ActionPanel extends JPanel implements Runnable, KeyListener, MouseListener, ActionListener {
	JLabel l;
	GameLevel L1;
	File f;
	ArrayList<GameObject> gmob;
	Player pUnit;// = Level_1.pUnit;
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
		
		//KeyListener k = new kb();
		this.addKeyListener(this);
		
		this.setVisible(true);
		
		
		//Level_1 L1 = new Level_1();
		/*
		try {
			L1.genLevel(new File("ambush"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gmob =L1.getGmob();
		
		findPlayer(gmob);
		
		//levelNumber++;
		
		this.addKeyListener(this);
		*/
		repaint();

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
			
			levelNumber++;
			  
			 //this.
			
			repaint();
		}
		
		repaint();
		
		/*
		try {
			Thread.sleep((long) 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
	/*
	public void setBinding(){
		getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke("ENTER"), "test");
		getActionMap().put("test", this); 
    	//this.addActionListener(this);
	}
	*/

	public void findPlayer(ArrayList<GameObject> h){
		
		for(int i = 0; i<h.size(); i++){
			
			System.out.println(h.get(i).getThisObjectLocation()+ "hello");
			System.out.println(Level_1.pUnit.getLocation() + "goodbye");
			
			if(h.get(i).getThisObjectLocation().getX() == Level_1.pUnit.getLocation().getX()){
				
				System.out.println();
				
				pUnit = (Player) h.get(i);
				
				
				
				break;
			}
			
			if (pUnit == null){
				System.out.println("The player is null");
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
	            System.out.println("Moving Right");
	            pUnit.isFacingRight();
	            System.out.println("Moving Right");
            	pUnit.moveRight();
            	System.out.println("Moving Right");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            System.out.println("Left typed.");
	            pUnit.isFacingLeft();
            	pUnit.moveLeft();
            	System.out.println("Moving Left");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            System.out.println("Up typed.");
	            pUnit.isFacingUp();
            	pUnit.moveUp();
            	System.out.println("Moving up");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            System.out.println("Down typed.");
	            pUnit.isFacingRight();
            	pUnit.moveRight();
            	System.out.println("Moving Right");
	        }
	       // else{
	       //     System.out.println("Key typed: " + e.getKeyChar());
	            
	        else if(e.getKeyChar() == 'w'){
	            	pUnit.isFacingUp();
	            	pUnit.moveUp();
	            	System.out.println("Moving up");
	            }else if(e.getKeyChar() == 'a'){
	            	pUnit.isFacingLeft();
	            	pUnit.moveLeft();
	            	System.out.println("Moving Left");
	            } else if(e.getKeyChar() == 's'){
	            	pUnit.isFacingDown();
	            	pUnit.moveDown();
	            	System.out.println("Moving Down");
	            }else if(e.getKeyChar() == 'd'){
	            	pUnit.isFacingRight();
	            	pUnit.moveRight();
	            	System.out.println("Moving Right");
	            }else if(e.getKeyChar() == 'e'){
	            	
	            }else if(e.getKeyChar() == 'q'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }
	        
	        repaint();
	            
	        }
	    //}

	  public void keyReleased(KeyEvent e) {
	        System.out.println("Key released: " + e.getKeyChar());
	    }
	  
	  
	  
	  public class kb implements KeyListener{
	    	
	    	
	    	
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				//(Property change listener/ key listener
				 
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
		            	pUnit.isFacingUp();
		            	pUnit.moveUp();
		            }else if(e.getKeyChar() == 'a'){
		            	pUnit.isFacingLeft();
		            	pUnit.moveLeft();
		            } else if(e.getKeyChar() == 's'){
		            	pUnit.isFacingDown();
		            	pUnit.moveDown();
		            }else if(e.getKeyChar() == 'd'){
		            	pUnit.isFacingRight();
		            	pUnit.moveRight();
		            }else if(e.getKeyChar() == 'e'){
		            	
		            }else if(e.getKeyChar() == 'q'){
		            	
		            }else if(e.getKeyChar() == 'a'){
		            	
		            }else if(e.getKeyChar() == 'a'){
		            	
		            }
		        }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    }
		
	

}
