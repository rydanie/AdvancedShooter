import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BasicProjectile implements Runnable, Projectile, GameObject, Serializable{

	String name1 = "EnemyProjectile.jpg";
	String name2 = "HeroProjectile.jpg";
	String characterName;
	String type = "BProjectile";
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean enemy;
	boolean collide;
	BufferedImage img;
	int sizeP =75;
	int originX;
	int originY;
	int sizeX = 50;
	int sizeY = 50;
	int dir;
	int pType;
	double damage;
	Timer proTimer;
	Rectangle bounds = new Rectangle();
	
	public BasicProjectile(Point p, int direction, int projectileType ){
		setBounds(bounds);
		loadImage(name1);
		dir = direction;
		setThisObjectLocation(p);
		
		//proTimer = new Timer(250)
		
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
        
        
        System.out.println( "Redrawing Projectile@" + originX + ", " + originY + "; " + sizeX + " sizeY " + 20);
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
		Point p = new Point(originX,originY);
		return p;
	}

	@Override
	public void setSize(int x, int y) {
		// TODO Auto-generated method stub
		sizeX =x;
		sizeY =y;
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
	public void fireUp() {
		// TODO Auto-generated method stub
		originY -=2;
	}

	@Override
	public void fireDown() {
		// TODO Auto-generated method stub
		originY +=2;
	}

	@Override
	public void fireLeft() {
		// TODO Auto-generated method stub
		originX -=2;
	}

	@Override
	public void fireRight() {
		// TODO Auto-generated method stub
		originX +=2;
	}

	@Override
	public boolean collide() {
		// TODO Auto-generated method stub
		
		return collide;
	}

	@Override
	public boolean isEnemy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BasicProjectile bp = this;
			Timer timer = new Timer(1000/200,new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(dir == 1){
						fireUp();
					}else if(dir == 2){
						fireDown();
					}else if(dir == 3){
						fireLeft();
					}else if(dir == 4){
						fireRight();
					}
				}

			} );
			
			timer.start();
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
        //sizeX = p.x - originX;
        //sizeY = p.y  - originY;
    	
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
	public void setEnemy(boolean b) {
		// TODO Auto-generated method stub
		enemy =b;
	}

	@Override
	public void setDamge(double d) {
		// TODO Auto-generated method stub
		damage = d;
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
	public void containsPoint(Point p) {
		// TODO Auto-generated method stub
		
	}

	public void setCollide(boolean b) {
		// TODO Auto-generated method stub
		collide = b;
	}

	@Override
	public boolean containsProjectile(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
	
    
}
