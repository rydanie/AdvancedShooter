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
	static ArrayList<GameObject> gmob;
	Player pUnit;// = Level_1.pUnit;
	BasicEnemy eUnit;
	BasicProjectile bp;
 	int levelNumber = 1;
 	int dir;
 	int pType;
 	long proStartTime;
 	long proElapseTime;
 	
 	//JComponent component = new JComponent();
 	
 	 

	public ActionPanel(){
		super();
		
		
		//this.setLayout(new GridLayout(1,2));
		
		//l = new JLabel("I Work");
		
		//this.add(l);
		
		//this.setBackground(Color.BLACK);
		
		//L1 =new Level_1();
		
		gmob = new ArrayList<GameObject>();
		
		//proTimer = new Timer(250);
		
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
			
			findEnemy(gmob);
			
			levelNumber++;
			  
			 //this.
			
			repaint();
		}
		
		//playerCollision();
		
		repaint();
		
		
		try {
			Thread.sleep((long) 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
			
			if(h.get(i).getObjectType() == "Hero"){
				
				System.out.println();
				
				pUnit = (Player) h.get(i);
				
				pUnit.setFacingDown();
				break;
			}
			
			if (pUnit == null){
				System.out.println("The player is null");
			}
		}
	}
	
	public void findEnemy(ArrayList<GameObject> h){
		
		for(int i = 0; i<h.size(); i++){
			
				System.out.println(h.get(i).getThisObjectLocation()+ "hello");
				System.out.println(Level_1.pUnit.getLocation() + "goodbye");
			
			if(h.get(i).getObjectType() == "BEnemy"){
				
				System.out.println();
				
				eUnit = (BasicEnemy) h.get(i);
				
				new Thread(eUnit).start();
				
				
				
			}
			
			if (eUnit == null){
				System.out.println("The player is null");
			}
		}
		
		
	}
	
	public void playerCollision(){
	
		for(int i =0; i < gmob.size(); i++){
			
			Rectangle r = ((GameObject) pUnit).getBounds();
			
			System.out.println("playerCollision " + pUnit.getLocation());
			System.out.println("objectCollision " +	gmob.get(i).getBounds() );//+ "\n " + gmob.get(i).getObjectType());
			System.out.println( gmob.get(i).contains(pUnit.getLocation()) );
			
				
				if(gmob.get(i).getObjectType() == "BDWall"){
					
					System.out.println("It is a wall");
					
					if(pUnit.isFacingUp()){
						System.out.println("Up");
						while (gmob.get(i).contains(pUnit.getLocation()) == true && gmob.get(i).getObjectType() != "Hero"){
						pUnit.moveDown();
						}
					}else if(pUnit.isFacingDown()){
						System.out.println("Down");
						while (gmob.get(i).contains(pUnit.getLocation()) == true && gmob.get(i).getObjectType() != "Hero"){
						pUnit.moveUp();
						}
					}else if(pUnit.isFacingLeft()){
						System.out.println("Left");
						while (gmob.get(i).contains(pUnit.getLocation()) == true && gmob.get(i).getObjectType() != "Hero"){
						pUnit.moveRight();
						}
					}else if(pUnit.isFacingRight()){
						System.out.println("Right");
						while (gmob.get(i).contains(pUnit.getLocation()) == true && gmob.get(i).getObjectType() != "Hero"){
						pUnit.moveLeft();
						}
					}else if(gmob.get(i).containsProjectile(bp.getLocation()) == true);
						bp.setCollide(true);
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
		BasicProjectile bp = new BasicProjectile(pUnit.getLocation(), 1, 1);
		bp.draw(getGraphics());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	 public void paintComponent(Graphics g){
		    
	    	super.paintComponent(g);
	    	
	    	for(int i = 1; i< gmob.size(); i++){
	    		
	    		//BasicProjectile b = (BasicProjectile) gmob.get(i);
	    		
	    		//if(gmob.get(i).getObjectType() == "BProjectile"){
	    			
	    			
	    			//if(b.collide() == true){
	    			//	gmob.remove(i);
	    			//	b = null;
	    			//	i++;
	    			//}
	    			
	    			//if(gmob.get(i) == null){
	    			//	i++;
	    			//}
	    		//}
	    		
	    		//if(b == null){
	    		//System.out.println(gmob.get(i));
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
	            pUnit.setFacingRight();
	            System.out.println("Moving Right");
            	pUnit.moveRight();
            	System.out.println("Moving Right");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            //System.out.println("Left typed.");
	            pUnit.setFacingLeft();
            	pUnit.moveLeft();
            	//System.out.println("Moving Left");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	           // System.out.println("Up typed.");
	            pUnit.setFacingUp(); 
            	pUnit.moveUp();
            	//System.out.println("Moving up");
	        } 
	        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            //System.out.println("Down typed.");
	            pUnit.setFacingDown();
            	pUnit.moveDown();
            	//System.out.println("Moving Right");
	        }
	       // else{
	       //     System.out.println("Key typed: " + e.getKeyChar());
	            
	        else if(e.getKeyChar() == 'w'){
	            	pUnit.setFacingUp();
	            	pUnit.moveUp();
	            	System.out.println("Moving up");
	            }else if(e.getKeyChar() == 'a'){
	            	pUnit.setFacingLeft();
	            	pUnit.moveLeft();
	            	System.out.println("Moving Left");
	            } else if(e.getKeyChar() == 's'){
	            	pUnit.setFacingDown();
	            	pUnit.moveDown();
	            	System.out.println("Moving Down");
	            }else if(e.getKeyChar() == 'd'){
	            	pUnit.setFacingRight();
	            	pUnit.moveRight();
	            	System.out.println("Moving Right");
	            }else if(e.getKeyChar() == 'e'){
	            	proElapseTime = System.currentTimeMillis() - proStartTime;
	            	if(proElapseTime > 250){
	            		
	        			if(pUnit.isFacingUp() == true){
	        				dir = 1;
	        				bp = new BasicProjectile(pUnit.getLocation(), dir , 1);
		            		bp.setEnemy(false);
	        				bp.fireUp();
	        			} else if(pUnit.isFacingDown() == true){
	        				dir =2;
	        				bp = new BasicProjectile(pUnit.getLocation(), dir, 1);
		            		bp.setEnemy(false);
	        				bp.fireDown();
	        			} else if(pUnit.isFacingLeft() == true){
	        				dir = 3;
	        				bp = new BasicProjectile(pUnit.getLocation(), dir, 1);
		            		bp.setEnemy(false);
	        				bp.fireRight();
	        			} else if(pUnit.isFacingRight() == true){
	        				dir = 4;
	        				bp = new BasicProjectile(pUnit.getLocation(), dir, 1);
		            		bp.setEnemy(false);
	        				bp.fireRight();
		        		}
	            	new Thread(bp).start();
	            	gmob.add(bp);
	            	proStartTime = System.currentTimeMillis();
	            	}
	        		
	            }else if(e.getKeyChar() == 'q'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }else if(e.getKeyChar() == 'a'){
	            	
	            }
	        
	        //playerCollision();
	        
	       // repaint();
	            
	        }
	    //}

	  public void keyReleased(KeyEvent e) {
	        System.out.println("Key released: " + e.getKeyChar());
	    }
	  
	  
	  
	  
	

}
