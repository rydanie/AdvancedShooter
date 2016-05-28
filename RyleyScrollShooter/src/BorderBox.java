import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;

public class BorderBox implements Runnable, DrawingObject, Wall, Serializable{
		
	    // critical vars for a rectangle
	    int sizeX, sizeY, originX, originY;
	    // future use
	    int lastX, lastY;
	    // bounding box (needed for move)
	    int fillout;
	    Rectangle bounds = new Rectangle();
	    Color c;
	    /**
	     * Create a new MyRectangle, all params initialized to zero.
	     */
	    public BorderBox() {
	        // NOP
	        sizeX = sizeY = originX = originY = 0;
	        
	        sizeX =50;
	        sizeY =50;
	        setBounds( bounds );
	        
	        //fillout = ColorPanel.fo;
	        c = Color.MAGENTA;
	    }
	    
	    /**
	     * Create a new MyRectangle with params initialized for origin and size.
	     * 
	     * @param oX
	     * @param oY
	     * @param sX
	     * @param sY 
	     */
	    public BorderBox( int oX, int oY, int sX, int sY ) {
	        sizeX = sX;
	        sizeY = sY;
	        originX = oX;
	        originY = oY;
	        setBounds( bounds );
	        
	        System.out.println( "Made rectangle: @" + oX + ", " + oY + "; " + sX + " x " + sY );
	    }
	    
		    /**
		     * draw method actually draws the object. Requires Graphics object.
		     * 
		     * @param g 
		     */
		    public void draw( Graphics g ) {
	
		        Graphics2D g2d = (Graphics2D)g;
		        
		        //fillout = ColorPanel.fo;
		        
		       // if(c != null){
			    //    g2d.setColor( c );
				// }else{
					 g2d.setColor( Color.MAGENTA);
				 //}
		        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
		        
					g.fillRect(originX, originY, sizeX, sizeY);
		
		        
		        System.out.println( "Redrawing rectangle @" + originX + ", " + originY + "; " + sizeX + " x " + sizeY);
		        
		        //this.setSize( this.getPreferredSize() );
		    }
		    
		    /**
		     * Called to start drawing a new object when mouse is clicked.
		     * 
		     * @param p 
		     */
		    public void start( Point p ) {
		        originX = p.x;
		        originY = p.y;
		        lastX = p.x;
		        lastY = p.y;
		        
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
		    public boolean contains( Point p ) {
		    	return bounds.contains(p);
		    }
	
		    @Override
			public void setColor(Color newC) {
				// TODO Auto-generated method stub
				c = newC;
			}
	
			@Override
			public Color getColor() {
				// TODO Auto-generated method stub
				c = Color.MAGENTA;
				return c;
			}
	
			@Override
			public void setFill(int fo) {
				// TODO Auto-generated method stub
				fillout = fo;
			}
	
			@Override
			public Point getPoint() {
				// TODO Auto-generated method stub
				Point p = new Point(originX, originY);
				return p;
			}
	
			@Override
			public Point getSize() {
				// TODO Auto-generated method stub
				Point p = new Point(sizeX, sizeY);
				
				return p;
			}
	
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		
			@Override
			public void setLocation() {
				// TODO Auto-generated method stub
				
			}
		
			@Override
			public void setSize(Point p) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean contains(Point p, int r) {
				// TODO Auto-generated method stub
				return false;
			}
		
		

}
