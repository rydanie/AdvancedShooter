import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author Ryley Danielson
 *
 */

public class MetalGameHero implements Runnable, Player, GameObject, Serializable {


	String name1 = "MHero_Front.jpg";
	String name2 = "MHero_Back.jpg";
	String name3 = "MHero_Left.jpg";
	String name4 = "MHero_Right.jpg";
	String characterName;
	String type = "Hero";
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
	double health = 100;
	double rat = 25;
	double mat = 100;
	private final double limit = 100; 
	//Rectangle hitBox = new Rectangle();
	Rectangle bounds = new Rectangle();
	BasicProjectile bp;
	
	
	public MetalGameHero(Point p){
		
		setThisObjectLocation(p);
		//File name = new File("MHero_Front.jpg");
		//name1 = name;
		
		loadImage(name1);
		
		setBounds( bounds );
		
		System.out.println("I Loaded");
		
		//run();
		
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
		Point p = new Point(originX, originY);
		return p;
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
	public void setSize(int x, int y) {
		// TODO Auto-generated method stub
		sizeX = x;
		sizeY =y;
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		originY -= 15;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		originY += 15;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		originX -= 15;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		originX += 15;
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
		Point p = new Point(originX, originY);
		
		return p;
	}

	@Override
	public void attackRanged() {
		// TODO Auto-generated method stub
		bp = new BasicProjectile(getLocation(), 1, 1);
		bp.setEnemy(false);
		if(isFacingUp() == true){
			bp.fireUp();
		} else if(isFacingDown() == true){
			bp.fireDown();
		} else if(isFacingLeft() == true){
			bp.fireRight();
		} else if(isFacingRight() == true){
			bp.fireRight();
		}
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
	public void setHealth(Double health1) {
		// TODO Auto-generated method stub
		health = health1;
	}

	@Override
	public Double getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public void looseHealth(Double damage) {
		// TODO Auto-generated method stub
		health -= damage;
	}

	@Override
	public void gainHealth(Double gain) {
		// TODO Auto-generated method stub
		health += gain;
		
		if (health > limit){
			health = 100;
		}
	}

	@Override
	public void setRangeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		rat = damage;
		bp.setDamge(rat);
	}

	@Override
	public Double getRangedAttackDamage() {
		// TODO Auto-generated method stub
		return rat;
	}

	@Override
	public void setMeleeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		mat = damage;
	}

	@Override
	public Double getMeleeAttackDamage() {
		// TODO Auto-generated method stub
		return mat;
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
		
			return true;
		
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
		for(int i =0; i < ActionPanel.gmob.size(); i++){
			
			Rectangle r = this.getBounds();
			
			System.out.println("playerCollision " + this.getLocation());
			System.out.println("objectCollision " +	ActionPanel.gmob.get(i).getBounds() );//+ "\n " + gmob.get(i).getObjectType());
			System.out.println( ActionPanel.gmob.get(i).contains(this.getLocation()) );
			
				
				if(ActionPanel.gmob.get(i).getObjectType() == "BDWall"){
					
					System.out.println("It is a wall");
					
					if(this.isFacingUp()){
						System.out.println("Up");
						while (this.contains(ActionPanel.gmob.get(i).getThisObjectLocation()) == true && ActionPanel.gmob.get(i).getObjectType() != "Hero"){
						this.moveDown();
						}
					}else if(this.isFacingDown()){
						System.out.println("Down");
						while (this.contains(ActionPanel.gmob.get(i).getThisObjectLocation()) == true && ActionPanel.gmob.get(i).getObjectType() != "Hero"){
							this.moveUp();
						}
					}else if(this.isFacingLeft()){
						System.out.println("Left");
						while (this.contains(ActionPanel.gmob.get(i).getThisObjectLocation()) == true && ActionPanel.gmob.get(i).getObjectType() != "Hero"){
							this.moveDown();						this.moveRight();
						}
					}else if(this.isFacingRight()){
						System.out.println("Right");
						while (this.contains(ActionPanel.gmob.get(i).getThisObjectLocation()) == true && ActionPanel.gmob.get(i).getObjectType() != "Hero"){
							this.moveLeft();
						}
					}
				}
			}
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
        setBounds(bounds);
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
        System.out.println("Bounds                                                Set");
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
	public void setObjectType(String s) {
		// TODO Auto-generated method stub
		type =s;
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
