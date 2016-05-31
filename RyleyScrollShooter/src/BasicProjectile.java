import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
	int sizeX = 25;
	int sizeY = 25;
	int dir;
	int pType;
	int pro;
	double damage = 15;
	Timer proTimer;
	Timer timer;
	Rectangle bounds = new Rectangle();
	ArrayList<GameObject> gmob;
	Point p;
	
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
        
        
        //System.out.println( "Redrawing Projectile@" + originX + ", " + originY + "; " + sizeX + " sizeY " + 20);
        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void setThisObjectLocation(Point p2) {
		// TODO Auto-generated method stub
		originX = p2.x;
		originY = p2.y;
		p = new Point(originX, originY);
	}

	@Override
	public Point getThisObjectLocation() {
		// TODO Auto-generated method stub
		
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
		originX = p.x;
		originY = p.y;
		p = new Point(originX, originY);
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		//System.out.println("location got");
		//System.out.println(p);
		return p;
	}

	@Override
	public void fireUp() {
		// TODO Auto-generated method stub
		originY -=10;
		
		p = new Point(originX, originY);
	}

	@Override
	public void fireDown() {
		// TODO Auto-generated method stub
		originY +=10;
		p = new Point(originX, originY);
	}

	@Override
	public void fireLeft() {
		// TODO Auto-generated method stub
		originX -=10;
		p = new Point(originX, originY);
	}

	@Override
	public void fireRight() {
		// TODO Auto-generated method stub
		originX +=10;
		p = new Point(originX, originY);
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
			timer = new Timer(1000/250,new ActionListener(){
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
					//colDetect();
				}

			} );
			
			timer.start();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(GameFrame.endAll == true){
				timer.stop();
			}
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

	public void setGmob(ArrayList<GameObject> mob) {
		// TODO Auto-generated method stub
		gmob = mob;
		//pro = i;
	}
	
	public ArrayList<GameObject> colDetect(){
		
		BasicEnemy eUnit;
		Player pUnit;
		BasicProjectile bp2 = (BasicProjectile) gmob.get(pro);
		BorderWall bdw;//= (BasicEnemy) gmob.get(n);
	
		for(int i =0; i < gmob.size(); i++){
				
				for(int r = 0; r<gmob.size(); r++){
					
					
					
					if(bp2.contains(gmob.get(r).getThisObjectLocation()) == true && gmob.get(r).getObjectType()== type && 
									gmob.get(r).getObjectType()== "Hero"){
						System.out.println("I hit something");
					}
						
						
			
				}
			}
		
		
		
		return gmob;
		
	}

	public void getWhich(int num) {
		// TODO Auto-generated method stub
		pro = num;
	}
	
	public int getSize(){
		return sizeX;
	}

	@Override
	public double getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public boolean containsProjectile(Point location, int size) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFacingUp() {
		// TODO Auto-generated method stub
		if(dir == 1){
			return true;
		}
		return false;
	
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		
		if(dir == 2){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		
		if(dir == 3){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		if(dir == 4){
			return true;
		}
		return false;
	}

    
}
