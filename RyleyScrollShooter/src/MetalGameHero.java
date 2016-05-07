import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Ryley Danielson
 *
 */

public class MetalGameHero implements Runnable, Player, GameObject {

	String name1 = "MHero_Front.jpg";
	String name2 = "MHero_Back.jpg";
	String name3 = "MHero_Left.jpg";
	String name4 = "MHero_Right.jpg";
	String characterName;
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
	Rectangle hitBox = new Rectangle();
	Rectangle bounds = new Rectangle();
	
	
	public MetalGameHero(){
		setBounds(bounds);
		//File name = new File("MHero_Front.jpg");
		//name1 = name;
		
		loadImage(name1);
		
		setBounds( hitBox );
		
		System.out.println("I Loaded");
	}
	
	public void loadImage(String s){
		img = null;
		try {
		    img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setImage(String s){
		
		name1 = s;
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
		return null;
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
	public void setSize(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
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
		if(up == true){
			return up;
		}else{
		
		return false;
		}
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		if(down == true){
			return down;
		}else{
		
		return false;
		}
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		if(left == true){
			return left;
		}else{
		
		return false;
		}
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		if(right == true){
			return right;
		}else{
		
		return false;
		}
	}


	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		characterName = name;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return characterName;
	}
	

	@Override
	public void run() {
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

	public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        //lastX = p.x;
        //lastY = p.y;
    }
    
    /**
     * Called repeatedly while dragging an object to size (usually in a 
     * mouseDragged() MouseMotionListener).
     * 
     * @param p 
     */
    public void drag( Point p ) {
       // sizeX = p.x - originX;
       // sizeY = p.y  - originY;
    	
        //setBounds( bounds );
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

}
