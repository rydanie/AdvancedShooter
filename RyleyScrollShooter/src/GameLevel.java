import java.awt.Graphics;
import java.io.File;

public interface GameLevel {

	public void start();
	
	public void endFail();
	
	public void endSuccess();
	
	//public void draw(Graphics g);
	
	public void genLevel(File f);
	
	public void setEnemyCount(int n);
	
	public int getEnemyCount();
	
	public void setTimer(Double d);
	
	public Double getTimer();
	
	public void setLevelNumber(int i);
	
	public int getLevelNumber();
	
}
