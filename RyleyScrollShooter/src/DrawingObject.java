
import java.awt.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Interface class for any drawable object.
 * @author Ryley Danielson
 */
public interface DrawingObject {
    //private int originX, originY;
    
    /**
     * Draw the object.
     * @param g 
     */
    public void draw( Graphics g );
    /**
     * Called to start drawing a new object.
     * @param p 
     */
    public void start( Point p );
    /**
     * Called repeatedly while dragging a new object out to size (typically 
     * called from within a mouseDragged() ).
     * @param p 
     */
    public void drag( Point p );
    /**
     * Called to move an object. Often called repeatedly inside a mouseDragged().
     * @param p 
     */
    public void move( Point p );
    /**
     * Set the bounding rectangle.
     * @param b 
     */
    public void setBounds( Rectangle b );
   
    /**
     * Determines if the point clicked is contained by the object.
     * @param p
     * @return 
     */
    public boolean contains( Point p );
    
    /**
     * Set shape color
     * @param newC
     */
    public void setColor(Color newC);
	
    /**
     * return shape color
     * @return
     */
	public Color getColor();
	
	/**
	 * sets fill or outline when coloring
	 * @param fo
	 */
	public void setFill(int fo);
	
	public Point getPoint();
	
	public Point getSize();
	
	
}
