import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Generates level 1 of this game
 * @author Ryley Danielson
 *
 */

public class Level_1 implements Runnable, GameLevel {
	
	int numLevel = 1;
	DrawingObject obj;
	GameObject gobj;
	ArrayList<GameObject> gmob;
	ArrayList<DrawingObject> drob;
	
	public Level_1(){
		drob = new ArrayList<DrawingObject>();
		
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

	//@Override
	public void genLevel() throws IOException {
		// TODO Auto-generated method stub
		
		//drob.clear();
   		
   		try{
   			drob = new ArrayList<DrawingObject>();
   			
   			File f =new File("this");
   			
   			FileInputStream fin = new FileInputStream(f.toString());
   			ObjectInputStream ois = new ObjectInputStream(fin);
   			 try {
   				drob =  (ArrayList<DrawingObject>) ois.readObject();
   			} catch (ClassNotFoundException e1) {
   				// TODO Auto-generated catch block
   				e1.printStackTrace();
   			}
   			ois.close();
   		}catch(Exception e){
   			e.printStackTrace();
   		}
   		
   		for(int i =0; i<drob.size(); i++){
   			obj = drob.get(i);
   			if(obj.getColor()== Color.BLUE){
   				gobj =new MetalGameHero(obj.getPoint());
   			}else if(obj.getColor() == Color.RED){
   				gobj = new BasicEnemy(obj.getPoint());
   			}else if(obj.getColor() == Color.GREEN){
   				gobj = new HealthPack(obj.getPoint());
   			}else if(obj.getColor() == Color.BLACK){
   				gobj = new BorderWall(obj.getPoint(),obj.getSize());
   			}
   			
   			gmob.add(gobj);
   		}
	}

	@Override
	public ArrayList<GameObject> getGmob() {
		// TODO Auto-generated method stub
		return gmob;
	}

	@Override
	public void genLevel(File f) {
		// TODO Auto-generated method stub
		
	}
	
}
