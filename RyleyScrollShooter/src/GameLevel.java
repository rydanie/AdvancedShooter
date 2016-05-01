import java.awt.Graphics;

public interface GameLevel {

	public void start();
	
	public void endFail();
	
	public void endSuccess();
	
	public void draw(Graphics g);
	
	public void setEnemyCount(int n);
	
	public int getEnemyCount();
	
	public void setTimer(Double d);
	
	public Double getTimer();
	
	public void setLevelNumber(int i);
	
	public int getLevelNumber();
	
}
