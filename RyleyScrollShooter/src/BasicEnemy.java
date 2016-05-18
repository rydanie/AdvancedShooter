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
	BufferedImage img;
	int sizeP =75;
	int originX;
	int originY;
	int sizeX = 50;
	int sizeY = 50;
	int inc;
	double proElapseTime;
	double proStartTime;
	ArrayList<Integer> dList = new ArrayList<Integer>();
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
        
        
        System.out.println( "Redrawing Image @" + originX + ", " + originY + "; " + sizeX + " sizeY " + 20);
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
		    int i = 0;
		 
			
			inc = 0;
			
		    while(dList.get(index)== 1){
		    	moveUp();
		    	i++;
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(i>10){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 2){
		    	moveDown();
		    	i++;
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(i>10){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 3){
		    	moveLeft();
		    	i++;
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(i>10){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 4){
		    	moveRight();
		    	i++;
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(i>10){
		    		break;
		    	}
		    }
		}
		
	
		
	

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		originY -= 2;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		originY += 2;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		originX += 2;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		originX -= 2;
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
		return null;
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
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return false;
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
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
