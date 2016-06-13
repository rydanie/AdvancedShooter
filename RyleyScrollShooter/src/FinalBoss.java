import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class FinalBoss implements Runnable, Enemy, GameObject, Serializable{
	

	Random rnd;
	String name1 = "BasicEnemy_Front.jpg";
	String name2 = "BasicEnemy_Back.jpg";
	String name3 = "BasicEnemy_Lect.jpg";
	String name4 = "BaiscEnemy_Right.jpg";
	String characterName;
	String type = "FEnemy";
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean collide = false;
	BufferedImage img;
	int sizeP =75;
	int originX;
	int originY;
	int sizeX = 100;
	int sizeY = 100;
	int inc;
	int i;
	int num;
	double proElapseTime;
	double proStartTime;
	double health = 300;
	FinalBoss eUnit;
	ArrayList<Integer> dList = new ArrayList<Integer>();
	ArrayList<GameObject> gmob;
	Rectangle bounds = new Rectangle();
	Rectangle detection = new Rectangle();
	BasicProjectile thatHurt;
	Player pUnit;
	Point p;
	
	
	public FinalBoss(Point p) {
		// TODO Auto-generated constructor stub
		setThisObjectLocation(p);
		setBounds(bounds);
		loadImage(name1);
		dList.add(1); dList.add(2); dList.add(3); dList.add(4); 
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
        
        //fillout = ColorPanel.fo;
        /*
        if(c != null){
	        g2d.setColor( c );
		 }else{
			 g2d.setColor( Color.BLACK );
		 }
		 */
        //g2d.clearRect( originX, originY, sizeX, sizeY );  // this is cool to make a background-filled rectangle!
        /*
        if(fillout == 2){
			g.drawRect(originX, originY, sizeX, sizeY );
		}else if(fillout == 1){
			g.fillRect(originX, originY, sizeX, sizeY);
		}
        */
       //R = new Rectangle(originX, originY, sizeX, sizeY);
       g.drawImage(img, originX, originY, sizeX, sizeY, null);
       //g2d.setColor(Color.BLUE);
       //g.drawRect(bounds.x,bounds.y,bounds.width,bounds.height);
        
        
        //System.out.println( "Redrawing Image @" + originX + ", " + originY + "; " + sizeX + " sizeY " + 20);
        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void setThisObjectLocation(Point p2) {
		// TODO Auto-generated method stub
		originX = p2.x;
		originY = p2.y;
		setBounds(bounds);
		//p = new Point(originX, originY);
				
	}

	@Override
	public Point getThisObjectLocation() {
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public void setSize(int height, int width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void idle() {
		// TODO Auto-generated method stub
		rnd = new Random();
			inc = 0;
			int index = rnd.nextInt(dList.size());
		    dList.get(index);
		    i = 0;
		 
			
			inc = 0;
			
		    while(dList.get(index)== 1){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num, pUnit);
		    	moveUp();
		    	setFacingUp();
		    	p = new Point(originX, originY);
		    	setThisObjectLocation(p);
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveUp();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		    	
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 2){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num, pUnit);
		    	moveDown();
		    	setFacingDown();
		    	p = new Point(originX, originY);
		    	setThisObjectLocation(p);		    	
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveDown();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 3){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num, pUnit);
		    	moveLeft();
		    	setFacingLeft();
		    	p = new Point(originX, originY);
		    	setThisObjectLocation(p);
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveLeft();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    	
		    	if(i>20){
		    		break;
		    	}
		    }
		    while(dList.get(index)== 4){
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	this.enemyCollide(gmob, num, pUnit);
		    	moveRight();
		    	setFacingRight();
		    	p = new Point(originX, originY);
		    	setThisObjectLocation(p);
		    	i++;
		    	
		    	if(collide == true){
		    		break;
		    	}
		    	
		    	/*
		    	Timer timer = new Timer(100000/2,new ActionListener(){
					public void actionPerformed(ActionEvent e){
						moveRight();
						i++;
					}

				} );
				
				timer.start();
		    	*/
		    	
		    	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		    	if(i>20){
		    		break;
		    	}
		    }
		}
		
	
		
	

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		originY -= 2;
		setFacingUp();
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		originY += 2;
		setFacingDown();
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		originX += 2;
		setFacingLeft();
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		originX -= 2;
		setFacingRight();
	}

	@Override
	public void setSpawn(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocation(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		
		Point p =new Point(originX,originY);
		
		return p;
	}

	@Override
	public void attackRanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackMelee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackSpecial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHealth(Double health) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getHealth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void looseHealth(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gainHealth(Double gain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRangeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getRangedAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMeleeAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getMeleeAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSpecialAttackDamage(Double damage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getSpecialAttackDamage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDamaged() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean wallCollision() {
		// TODO Auto-generated method stub
		return collide;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingUp() {
		// TODO Auto-generated method stub
		return up;
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		return down;
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public boolean playerNear(Point p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(GameFrame.endAll == false){
			idle();
		}	
		
		
		
	}

	public void start( Point p ) {
        originX = p.x;
        originY = p.y;
        //lastX = p.x;
        //lastY = p.y;
        
        setBounds(bounds);
    }
    
    /**
     * Called repeatedly while dragging an object to size (usually in a 
     * mouseDragged() MouseMotionListener).
     * 
     * @param p 
     */
    public void drag( Point p ) {
        //sizeX = p.x - originX;
        //sizeY = p.y  - originY;
    	
        setBounds( bounds );
    }
    
    /**
     * Called repeatedly while moving an object (usually in a mouseDragged()
     * MouseMotionListener).
     * 
     * @param p 
     */
    public void move( Point p ) {
        originX = p.x ;
        originY = p.y ;
        setBounds( bounds );
    }
    
    /**
     * Update the bounding box. The Rectangle argument is typically but not always
     * in this object. This is required for @method contains() to work.
     * 
     * @param b 
     */
    public void setBounds( Rectangle b ) {
        b.setBounds( originX, originY, sizeX, sizeY  );
       // detection.setBounds(originX - 50,originY -50, 100, 100);
    }
    
    /**
     * Returns true if the point p is in the bounding box for this object. Might
     * be used to select and/or move an object.
     * 
     * @param p
     * @return 
     */
    public boolean contains( Point p ) {
    	
    	//System.out.println(bounds);
    	
    	return bounds.contains(p);
    }

	@Override
	public void loadImage(String s) {
		// TODO Auto-generated method stub
		img = null;
		try {
		    img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setObjectType(String s) {
		// TODO Auto-generated method stub
		type = s;
	}

	@Override
	public String getObjectType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return bounds;
	}

	@Override
	public boolean contains(Rectangle p) {
		// TODO Auto-generated method stub
		return bounds.contains(p);
	}

	@Override
	public boolean containsProjectile(Point p, int i) {
		
		for(int e =0; e< i; e++ ){
			
			if(bounds.contains(p.x + e, p.y)){
				return true;
			}else if(bounds.contains(p.x, p.y + e)){
				return true;
			}
			
		}
		
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void containsPoint(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFacingUp() {
		// TODO Auto-generated method stub
		up = true;
		down = false;
		left = false;
		right = false;
	}

	@Override
	public void setFacingDown() {
		// TODO Auto-generated method stub
		up = false;
		down = true;
		left = false;
		right = false;
	}

	@Override
	public void setFacingLeft() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = true;
		right = false;
	}

	@Override
	public void setFacingRight() {
		// TODO Auto-generated method stub
		up = false;
		down = false;
		left = false;
		right = true;
	}

	@Override
	public void setWallCollision(boolean b) {
		// TODO Auto-generated method stub
		collide = b;
		
	}
	
public void enemyCollide(ArrayList<GameObject> mob, int n, Player b){
		
		gmob = mob;
		
		try{
		eUnit = (FinalBoss) gmob.get(n);
		}catch(ClassCastException e){
			eUnit = eUnit;
		}
	
		for(int i =0; i < gmob.size(); i++){
			
			if(gmob.get(i).getObjectType() == "Hero"){
				pUnit = (Player) gmob.get(i);
			}
			
			if(gmob.get(i).getObjectType() == "BDWall"){
				
				//System.out.println("It is a wall");
				
				for(int r = 1; r<gmob.size(); r++){
					
					
					
					if(eUnit.isFacingUp()){
						//System.out.println("Up");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveDown();
						}
						eUnit.setWallCollision(false);
					}else if(eUnit.isFacingDown()){
						//System.out.println("Down");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveUp();
						}
						eUnit.setWallCollision(false);
					}else if(eUnit.isFacingLeft()){
						//System.out.println("Left");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveRight();
						}
						//eUnit.setWallCollision(false);
					}else if(eUnit.isFacingRight()){
						//System.out.println("Right");
						if (gmob.get(i).contains(eUnit.getLocation()) == true && gmob.get(i).getObjectType() != "BEnemy"){
						eUnit.setWallCollision(true);
						eUnit.moveLeft();
						}
						eUnit.setWallCollision(false);
					}
				}
			}
					
				if(gmob.get(i).getObjectType() == "BProjectile"){
				
				
				BasicProjectile bp = (BasicProjectile) gmob.get(i);
				//System.out.println("It is a wall");
				//for(int r = 1; r<gmob.size(); r++){
					
					if(eUnit.containsProjectile(bp.getLocation(), bp.getSize()) == true && bp.enemy == false){
						//System.out.println("Up");
						//thatHurt = (BasicProjectile) gmob.get(i);
						
							
						//System.out.println("I collided with enemy");
						gmob.remove(bp);
						gmob.add(thatHurt);
						
						eUnit.setDamaged(bp.getDamage());
					}
					
					if(bp.isFacingDown()){
						thatHurt = new BasicProjectile(eUnit.getLocation(), 1, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
					}else if(bp.isFacingUp()){
						thatHurt = new BasicProjectile(eUnit.getLocation(), 2, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
					}else if(bp.isFacingLeft()){
						thatHurt = new BasicProjectile(eUnit.getLocation(), 4, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
					}else if(bp.isFacingRight()){
						thatHurt = new BasicProjectile(eUnit.getLocation(), 3, 1);
						thatHurt.setSize(100,100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
					}
						new Thread(thatHurt).start();
				} 
				
				
				//if( gmob.get(i).getObjectType() == "Hero"){
					pUnit = b;
				  if(bounds.contains(pUnit.getLocation())){
					proElapseTime = System.currentTimeMillis() - proStartTime;
		            if(proElapseTime > 250){
					  if(pUnit.isFacingUp()){
						  
						thatHurt = new BasicProjectile(eUnit.getLocation(), 2, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
						
					}else if(pUnit.isFacingDown()){
						
						thatHurt = new BasicProjectile(eUnit.getLocation(), 1, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
						
					} else if(pUnit.isFacingRight()){
						
						thatHurt = new BasicProjectile(eUnit.getLocation(), 3, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
						
					}else if(pUnit.isFacingLeft() && pUnit.isFacingLeft()){
						
						thatHurt = new BasicProjectile(eUnit.getLocation(), 4, 1);
						thatHurt.setSize(100, 100);
						thatHurt.setDamge(25);
						thatHurt.setEnemy(true);
					}
						new Thread(thatHurt).start();
						proStartTime = System.currentTimeMillis();
						
					//System.out.println("I collided with enemy");
					gmob.add(thatHurt);
			}
				 // }
		}
			

	}
		
				
			}
		
			

public void setGmob(ArrayList<GameObject> gmob2) {
	// TODO Auto-generated method stub
	gmob = gmob2;
}

public void setNum(int i2) {
	// TODO Auto-generated method stub
	num = i2;
}

@Override
public boolean containsProjectile(Point p) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void setDamaged(double damaged) {
	// TODO Auto-generated method stub
	health -= damaged;
	
	if(health <= 0){
		try {
			this.loadImage("DeadEBody.jpg");
			ActionPanel.enNum -= 1;
			Thread.sleep(System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}

public ArrayList<GameObject> getGmob() {
	// TODO Auto-generated method stub
	return gmob;
}

public void setPlayer(Player p){
	pUnit = p;
}

}
