import java.awt.Graphics;
import java.awt.Point;

public interface Enemy {

	//public void draw(Graphics g);
	
	public void setSize(int height, int width);
	
	public void action();
	
	public void setName(String name);
	
	public String getName();

	public void idle();
	
	public void moveUp();
	
	public void moveDown();
	
	public void moveLeft();
	
	public void moveRight();
	
	public void setSpawn(Point p);
	
	public void setLocation(Point p);
	
	public Point getLocation();
	
	public void attackRanged();
	
	public void attackMelee();
	
	public void attackSpecial();
	
	public void setHealth(Double health);
	
	public Double getHealth();
	
	public void looseHealth(Double damage);
	
	public void gainHealth(Double gain);
	
	public void setRangeAttackDamage(Double damage);
	
	public Double getRangedAttackDamage();
	
	public void setMeleeAttackDamage(Double damage);
	
	public Double getMeleeAttackDamage();
	
	public void setSpecialAttackDamage(Double damage);
	
	public Double getSpecialAttackDamage();
	
	public boolean isDamaged();
	
	public void setWallCollision(boolean b);
	
	public boolean wallCollision();
	
	public boolean isDead();
	
	public boolean isFacingUp();
	
	public boolean isFacingDown();
	
	public boolean isFacingLeft();
	
	public boolean isFacingRight();
	
	public boolean playerNear(Point p);
	
	public void setFacingUp(); 

	public void setFacingDown();

	public void setFacingLeft();

	public void setFacingRight();

	public boolean containsProjectile(Point p, int i);
	
	public void setDamaged(double damaged);

}
