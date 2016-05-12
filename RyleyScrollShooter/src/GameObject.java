import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public interface GameObject {
	
	public void draw(Graphics g);
	
	public void setThisObjectLocation(Point p);
	
	public Point getThisObjectLocation();
	
	public void start(Point p);
	
	public void drag(Point p);
	
	public void move(Point p);
	
	public void setBounds(Rectangle r);
	
	public Rectangle getBounds();
	
	public boolean contains(Rectangle p);
	
	public boolean contains(Point p);
	
	public void loadImage(String s);
	
	public void setObjectType(String s);
	
	public String getObjectType();
	
	

}
