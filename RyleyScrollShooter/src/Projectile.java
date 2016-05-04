import java.awt.Graphics;
import java.awt.Point;

public interface Projectile {

	//public void draw(Graphics g);
	
	public void setSize(int x, int y);
	
	public void setLocation(Point p);
	
	public Point getLocation();
	
	public void fireUp(Boolean b, Point p);
	
	public void fireDown(Boolean b, Point p);
	
	public void fireLeft(Boolean b, Point p);
	
	public void fireRight(Boolean b, Point p);
	
	public boolean collide();
	
	public boolean isEnemy();
}
