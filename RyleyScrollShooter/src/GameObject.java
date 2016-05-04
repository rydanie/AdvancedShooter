import java.awt.Graphics;
import java.awt.Point;

public interface GameObject {
	
	public void draw(Graphics g);
	
	public void setThisObjectLocation(Point p);
	
	public Point getThisObjectLocation();

}
