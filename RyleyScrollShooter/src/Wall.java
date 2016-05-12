import java.awt.Point;

public interface Wall {
	
	//public boolean contains();
	
	public void setLocation();
	
	/**
	 * The point values x and y  stand for sizeX and sizeY
	 * @param p
	 */
	public void setSize(Point p);

}
