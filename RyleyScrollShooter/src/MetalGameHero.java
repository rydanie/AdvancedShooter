import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MetalGameHero implements Runnable, Player, GameObject {

	String name1 = "MHero_Front.jpg";
	BufferedImage img;
	int sizeP =20;
	int originX;
	int originY;
	Rectangle hitBox;
	
	public MetalGameHero(Point p){
		
		//File name = new File("MHero_Front.jpg");
		//name1 = name;
		
		loadImage(name1);
		
		setThisObjectLocation(p);
		
		hitBox = new Rectangle();
		
		System.out.println("I Loaded");
	}
	
	public void loadImage(String s){
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setImage(String s){
		
		name1 = s;
	}
	
	@Override
	public void setThisObjectLocation(Point p) {
		// TODO Auto-generated method stub
		originX = p.x;
		originY = p.y;
		
	}

	@Override
	public Point getThisObjectLocation() {
		// TODO Auto-generated method stub
		return null;
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
       g.drawImage(img, originX, originY, sizeP, sizeP, null);
        
        
        System.out.println( "Redrawing Image @" + 20 + ", " + 20 + "; " + 20 + " x " + 20);
        //this.setSize( this.getPreferredSize() );
	}

	@Override
	public void setSize(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
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
		return null;
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
		return false;
	}

	@Override
	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingUp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFacingRight() {
		// TODO Auto-generated method stub
		return false;
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
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
