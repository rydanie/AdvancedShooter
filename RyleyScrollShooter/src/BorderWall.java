import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class BorderWall implements Runnable, Wall, GameObject,Serializable {

	String name1 = "BasicWall.jpg";
	String characterName;
	String type = "BDWall";
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	BufferedImage img;
	int sizeP =75;
	int originX;
	int originY;
	int sizeX;
	int sizeY;
	Rectangle bounds = new Rectangle();
	
	public BorderWall(Point origin, Point size) {
		// TODO Auto-generated constructor stub
		setThisObjectLocation(origin);
		setSize(size);
		setBounds(bounds);
		loadImage(name1);
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
		originX =p.x;
		originY =p.y;
	}

	@Override
	public Point getThisObjectLocation() {
		// TODO Auto-generated method stub
		Point p = new Point(originX, originY);
		return p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
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
        sizeX = p.x - originX;
        sizeY = p.y  - originY;
    	
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
    
    			
    			//bounds.contains(p);
    //}

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
	public void setLocation() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setSize(Point p) {
		// TODO Auto-generated method stub
		sizeX = p.x;
		sizeY = p.y;
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
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 50; i++){
			
			if(bounds.contains(p.x, p.y + i ) || bounds.contains(p.x + i, p.y) || bounds.contains(p.x + i, p.y +50)|| bounds.contains(p.x + 50, p.y +i)){
				return true;
			}
		}
		return false;
		
		/*
		if(bounds.contains(p)){
			return true;
		} else if(bounds.contains(p.x, p.y + 50)){
			return true;
		} else if(bounds.contains(p.x, p.y +25)){
			return true;
		}else if(bounds.contains(p.x, p.y + 10)){
			return true;
		} else if(bounds.contains(p.x, p.y +25)){
			return true;
		}else if(bounds.contains(p.x, p.y + 30)){
			return true;
		} else if(bounds.contains(p.x + 50, p.y +10)){
			return true;
		} else if(bounds.contains(p.x + 50, p.y +30)){
			return true;
		} else if(bounds.contains(p.x + 50, p.y +10)){
			return true;
		} else if(bounds.contains(p.x + 50, p.y +10)){
			return true;
		} else if(bounds.contains(p.x + 50, p.y + 50)){
			return true;
		} else if(bounds.contains(p.x +50 , p.y +25)){
			return true;
		} else if(bounds.contains(p.x, p.y +50)){
			return true;
		} else if(bounds.contains(p.x, p.y +25)){
			return true;
		} else if(bounds.contains(p.x +50 , p.y +10 )){
			return true;
		} else if(bounds.contains(p.x + 50, p.y )){
			return true;
		
		} else {
			return false;
		}
	*/
				
	}


	@Override
	public boolean containsProjectile(Point p) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
		
	}


	@Override
	public void containsPoint(Point p) {
		// TODO Auto-generated method stub
		
	}



}
