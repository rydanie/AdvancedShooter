import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;

/**
 * Generates level 1 of this game
 * @author Ryley Danielson
 *
 */

public class Level_1 implements Runnable, GameLevel {
	
	int numLevel = 1;
	DrawingObject obj;
	GameObject go;
	ArrayList<GameObject> gmob;
	
	
	public Level_1(){
		
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endFail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endSuccess() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setEnemyCount(int n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getEnemyCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTimer(Double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLevelNumber(int i) {
		// TODO Auto-generated method stub
		numLevel =i;
	}

	@Override
	public int getLevelNumber() {
		// TODO Auto-generated method stub
		return numLevel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void genLevel(File f) {
		// TODO Auto-generated method stub
		
	}

}
