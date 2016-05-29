import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Level_2 implements Runnable, GameLevel {
	
	//static MetalGameHero pUnit;
	//static int enNum = 0;
	int numLevel = 1;
	File f;
	DrawingObject obj;
	GameObject gobj;
	ArrayList<GameObject> gmob;
	ArrayList<DrawingObject> drob;
	
	public Level_2(){
		drob = new ArrayList<DrawingObject>();
		gmob = new ArrayList<GameObject>();
		//enNum = 0;
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
		return 0;//enNum;
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
   			
   			f =new File("Lv2");
   			
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
				//System.out.println("drob " + drob.size());
   			if(obj.getColor()== Color.BLUE){
   				gobj =new MetalGameHero(obj.getPoint());
   				//pUnit = (MetalGameHero) gobj;
   				System.out.println("hero");
   			}else if(obj.getColor() == Color.RED){
   				gobj = new BasicEnemy(obj.getPoint());
   				
   				System.out.println("enemy");
   			}else if(obj.getColor() == Color.GREEN){
   				gobj = new HealthPack(obj.getPoint());
   				System.out.println("health");
   			}else if(obj.getColor() == Color.BLACK){
   				gobj = new BorderWall(obj.getPoint(),obj.getSize());   				
   				System.out.println("wall");
   			}else if(obj.getColor() == Color.MAGENTA){
   				gobj = new PlayableArea(obj.getPoint(),obj.getSize());   				
   				System.out.println("Playable Space");
   			}else if(obj.getColor() == Color.ORANGE){
   				gobj = new FinalBoss(obj.getPoint());
   				System.out.println("Final Boss ");
   			}
   			
   			if(gobj != null){
   			gmob.add(gobj);
   			}
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
