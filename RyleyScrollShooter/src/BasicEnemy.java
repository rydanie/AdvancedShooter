import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BasicEnemy implements Runnable, Enemy, GameObject, Serializable{
	

	Random rnd;
	String name1 = "BasicEnemy_Front.jpg";
	String name2 = "BasicEnemy_Back.jpg";
	String name3 = "BasicEnemy_Lect.jpg";
	String name4 = "BaiscEnemy_Right.jpg";
	String characterName;
	String type = "BEnemy";
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean collide = false;
	BufferedImage img;
	int sizeP =75;
	int originX;
	int originY;
	int sizeX = 50;
	int sizeY = 50;
	int inc;
	int i;
	int num;
	double proElapseTime;
	double proStartTime;
	ArrayList<Integer> dList = new ArrayList<Integer>();
	ArrayList<GameObject> gmob;
	Rectangle bounds = new Rectangle();
	
	
	public BasicEnemy(Point p) {
		// TODO Auto-generated constructor stub
		setThisObjectLocation(p);
		setBounds(bounds);
		loadImage(name1);
		dList.add(1); dList.add(2); dList.add(3); dList.add(4); 
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
        
        //fillout = ColorPanel.fo;
        /*
        if(c != null){
	        g2d.setColor( c );
		 }else{
			 g2d.setColor( Color.BLACK );
		 }
		 */
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        /*
        if(fillout == 2){
			g.drawRect(originX, originY, sizeX, sizeY );
		}else if(fillout == 1){
			g.fillRect(originX, originY, sizeX, sizeY);
		}
        */
       //R = new Rectangle(originX, originY, sizeX, sizeY);
       g.drawImage(img, originX, originY, sizeX, sizeY, null);
        
        
        //System.out.println( "Redrawing Image @" + originX + ", " + originY + "; " + sizeX + " sizeY " + 20);
        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void setThisObjectLocation(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
		originY = p.y;
				
	}

	@Override
	public Point getThisObjectLocation() {
		// TODO Auto-generated method stub
		Point p = new Point(originX, originY);
		return p;
	}

	@Override
	public void setSize(int height, int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void idle() {
		// TODO Auto-generated method stub
		rnd = new Random();
			inc = 0;
			int index = rnd.nextInt(dList.size());
		    dList.get(index);
		    i = 0;
		 
			
			inc = 0;
			
		    while(dList.get(index)== 1){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num);
		    	moveUp();
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveUp();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		    	
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 2){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num);
		    	moveDown();
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveDown();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 3){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num);
		    	moveLeft();
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveLeft();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 4){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num);
		    	moveRight();
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveRight();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		    	if(i>20){
		    		break;
		    	}
		    }
		}
		
	
		
	

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		originY -= 2;
		setFacingUp();
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		originY += 2;
		setFacingDown();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		originX += 2;
		setFacingLeft();
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		originX -= 2;
		setFacingRight();
	}

	@Override
	public void setSpawn(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		
		Point p =new Point(originX,originY);
		
		return p;
	}

	@Override
	public void attackRanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackMelee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackSpecial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealth(Double health) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getHealth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void looseHealth(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gainHealth(Double gain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRangeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getRangedAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeleeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getMeleeAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpecialAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getSpecialAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDamaged() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean wallCollision() {
		// TODO Auto-generated method stub
		return collide;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingUp() {
		// TODO Auto-generated method stub
		return up;
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		return down;
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public boolean playerNear(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
			
			idle();
		}	
		
		
		
	}

	public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        //lastX = p.x;
        //lastY = p.y;
        
        setBounds(bounds);
    }
    
    /**
     * Called repeatedly while dragging an object to size (usually in a 
     * mouseDragged() MouseMotionListener).
     * 
     * @param p 
     */
    public void drag( Point p ) {
        //sizeX = p.x - originX;
        //sizeY = p.y  - originY;
    	
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p 
     */
    public void move( Point p ) {
        originX = p.x ;
        originY = p.y ;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b 
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY );
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p
     * @return 
     */
    public boolean contains( Point p ) {
    	return bounds.contains(p);
    }

	@Override
	public void loadImage(String s) {
		// TODO Auto-generated method stub
		img = null;
		try {
		    img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setObjectType(String s) {
		// TODO Auto-generated method stub
		type = s;
	}

	@Override
	public String getObjectType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return bounds;
	}

	@Override
	public boolean contains(Rectangle p) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
	}

	@Override
	public boolean containsProjectile(Point p) {
		return true;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void containsPoint(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFacingUp() {
		// TODO Auto-generated method stub
		up = true;
		down = false;
		left = false;
		right = false;
	}

	@Override
	public void setFacingDown() {
		// TODO Auto-generated method stub
		up = false;
		down = true;
		left = false;
		right = false;
	}

	@Override
	public void setFacingLeft() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = true;
		right = false;
	}

	@Override
	public void setFacingRight() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = false;
		right = true;
	}

	@Override
	public void setWallCollision(boolean b) {
		// TODO Auto-generated method stub
		collide = b;
		
	}
	
public void enemyCollide(ArrayList<GameObject> mob, int n){
		
		gmob = mob;
		BasicEnemy eUnit = (BasicEnemy) gmob.get(n);
	
		for(int i =0; i < gmob.size(); i++){
			
			if(gmob.get(i).getObjectType() == "BDWall"){
				
				System.out.println("It is a wall");
				
				for(int r = 1; r<gmob.size(); r++){
					
					
					
					if(eUnit.isFacingUp()){
						//System.out.println("Up");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveDown();
						}
						eUnit.setWallCollision(false);
					}else if(eUnit.isFacingDown()){
						//System.out.println("Down");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveUp();
						}
						eUnit.setWallCollision(false);
					}else if(eUnit.isFacingLeft()){
						//System.out.println("Left");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveRight();
						}
						//eUnit.setWallCollision(false);
					}else if(eUnit.isFacingRight()){
						//System.out.println("Right");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveLeft();
						}
						eUnit.setWallCollision(false);
					}
					//}else if(gmob.get(i).containsProjectile(eUnit.getLocation()) == true){
					//	bp.setCollide(true);
				//}
					}
			}
		}
	}

public void setGmob(ArrayList<GameObject> gmob2) {
	// TODO Auto-generated method stub
	gmob = gmob2;
}

public void setNum(int i2) {
	// TODO Auto-generated method stub
	num = i2;
}
	
}
