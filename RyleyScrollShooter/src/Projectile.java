import java.awt.Graphics;
import java.awt.Point;

public interface Projectile {

	//public void draw(Graphics g);
	
	public void setSize(int x, int y);
	
	public void setLocation(Point p);
	
	public Point getLocation();
	
	public void setEnemy(boolean b);
	
	public void fireUp();
	
	public void fireDown();
	
	public void fireLeft();
	
	public void fireRight();
	
	public boolean collide();
	
	public boolean isEnemy();
	
	public void setDamge(double d);
	
	public double getDamage();
}
