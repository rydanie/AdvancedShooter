/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ryley Danielson
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

//import com.sun.jndi.cosnaming.IiopUrl.Address;

public class DrawingPane extends JPanel implements ActionListener, MouseMotionListener, MouseListener,Serializable {
	
	int x;
	int y;
	int a;
	int b;
	int check;
	DrawingObject obj;
	static ArrayList<DrawingObject> drob;
	
	//public static final int l = 1;
	//public static final int rec = 2;
	//public static final int s = 3;
	//public static final int c = 4;
    
    public DrawingPane() {
        super(); 
        
        
        drob = new ArrayList<DrawingObject>();
        
        // always call super() in an extended/derived class!
        //this.setSize( 500, 500 );
        //setSize( getPreferredSize() );
        // size is handled by parent pane placement in JFrame
        // make a border
        setBorder( BorderFactory.createLineBorder(Color.RED) );
        this.setBackground(Color.WHITE);
        setVisible( true );
        
        // we need both a mouse listener (for clicks)...
        addMouseListener( this );
        // ... and a mouse motion listener (for drags)!
        addMouseMotionListener( this );
        
        
        
    }
    
    /**
     * actionPerformed is here in case we need it later. Not currently used.
     * @param e 
     */
    public void actionPerformed( ActionEvent e ) {
        switch( e.getActionCommand() ) {
            default:
                System.out.println( "EVIL BAD PLACE TWO" );
                System.exit(-1);
                break;
        }
    }
    

    

    @Override
    public void mouseClicked(MouseEvent e) {
    	
    	if(obj != null){
    	
    	}
    	
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // handle what happens when the mouse is clicked. This will hinge upon
        // the mode the user has selected in the tool panel.
    	check = ToolPanel.check;
    	x = e.getX();
    	y = e.getY();
    	//a
    	//b
    	
    	if(check !=0 || check !=1 ||check !=2||check !=3||check !=4||check !=6||check !=10){
	    	if(check == 1){
	    		obj = new BWBox();
	    	}else if(check == 2){
	    		obj = new BEBox();
	    	}else if(check == 3) {
	    		obj = new MGHBox();
	    	}else if(check == 4){
	    		obj = new HPBox();
	    	}
	    	//}else if(check == s) {
	    		//int[] q = {x, x+12, x+54,x+18,x+28,x, x-28, x-18, x-54, x-12};
	    		//int[] w = {y, y+36, y+36, y+54, y+96, y+72, y+96, y+54, y+36, y+36 };
	    		//obj = new MyStar(Integer.parseInt(ToolPanel.po));
	    	//}else if(check == 6){
	    		//obj = new MyPolygon(Integer.parseInt(ToolPanel.po2));
	    	//}else if(check == 10){
	    		//obj = new MyImage(ToolPanel.nameI);
	    		//System.out.println("dfbdjbshgdfj,gbs");
	    	//}
    	
	    	if(obj != null){
				//obj.draw(getGraphics());
				obj.start(e.getPoint());
				drob.add(obj);
				System.out.println("Added obj");
	    	}
	    }
    	
	    	
    		if(check == 5){
    			for(int i = drob.size()-1; i>= 0; i--){
	    			if(drob.get(i).contains(e.getPoint())){
	    				System.out.println("star listen to me");
	    				obj = drob.get(i);
	    				break;
	    			}else{
	    				obj = null;
	    			}
	    			
	    		}
    			if(obj!=null){
    				//obj.setFill(ColorPanel.fo);
	    			//obj.setColor(JMenuFrame.getColor());
	    			}
    		}else if(check == 7){
    			for(int i = drob.size()-1; i>= 0; i--){
	    			if(drob.get(i).contains(e.getPoint())){
	    				System.out.println("star listen to me");
	    				obj = drob.get(i);
	    				obj.drag(e.getPoint());
	    				break;
	    			}else{
	    				obj = null;
	    			}
	    			
	    		}
    			
    		}else if(check == 8){
    			for(int i = drob.size()-1; i>= 0; i--){
	    			if(drob.get(i).contains(e.getPoint())){
	    				System.out.println("deleting");
	    				drob.remove(i);
	    				break;
	    			}else{
	    				obj = null;
	    			}
	    			
	    		}
    			
    		}else if(check == 0){
	    		for(int i = drob.size()-1; i>= 0; i--){
	    			if(drob.get(i).contains(e.getPoint())){
	    				//System.out.println("star listen to me");
	    				obj = drob.get(i);
	    				break;
	    			}else{
	    				obj = null;
	    			}
	    		}
	    	}
    	
    	

        System.out.println( "mousePressed" );
        
        repaint();
    	}
	 
        
  
   

    @Override
    public void mouseDragged(MouseEvent e) {
       x = e.getX();
       y = e.getY();
       
       if(obj!=null){
    	   if(check == 0){
    		   System.out.println("It got here line 135");
    		   obj.move(e.getPoint());
    	   }else if(check == 5){
    	   }else{
       		
       			obj.drag(e.getPoint());
       		}
       
       }
       System.out.println( "mouseDragged " + "(" +x + " " +y+ ")"  );
        //paintComponent(getGraphics());
       
       repaint();
    }

    /*
    public Point getMouseLocation(){
    	
    	Point location = new Point(x,y);
    	
    	return location;
    }
    */
    
    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println( "mouseReleased()" );
        obj = null;
        
        return;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
   
    
    public void paintComponent(Graphics g){
    
    	super.paintComponent(g);
    	
    	for(int i = 0; i<drob.size(); i++){
    		
    		drob.get(i).draw(g);
    	}
    }
    
    /**
   	 * Save the Panel as image with the name and the type in parameters
   	 * This is not mine
   	 * @param name name of the file
   	 * @param type type of the file
   	 */
   	public void saveImage(File f) {
   		BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
   		Graphics2D g2 = image.createGraphics();
   		paint(g2);
   		String type = "jpg";
   		
   		try{
   			ImageIO.write(image, type, new File(f.toString() + (".jpg")));
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   	}
   	/**
   	 * Load a .jpg file to be edited in the UI
   	 * @param f
   	 */
   	public void loadImage(File f){
   		BufferedImage image = null; //new BufferedImage(40,20, BufferedImage.TYPE_INT_RGB);
   		//Graphics2D g2 = image.createGraphics();
   		//paint(g2);
   		
   		try {
			image = ImageIO.read(f);
			//image.getScaledInstance(30, 40, 1);
			//image.set
			Graphics2D g2 = image.createGraphics();
	   		paint(g2);
			System.out.println("I loaded an image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
   		repaint();
   		//try{
   			//ImageIO.read(f);
   		//} catch (Exception e) {
   		//	e.printStackTrace();
   		//}
   		
   	}
   /**
    * Saves the Drawing Object ArrayList to file
    * @param f
    */
   	public void saveDrob(File f){
   		try{
   			//f = new File(System.getProperty("user.home"));
   			FileOutputStream fos = new FileOutputStream(f.toString());
   			ObjectOutputStream inf = new ObjectOutputStream(fos);
   			inf.writeObject(drob);
   			System.out.println("flfwejfjdhlk");
   			
   			//inf.close();
   		}catch(Exception e){
   			e.printStackTrace();
   		}
   	}
   	
   	/**
   	 * Loads a Drawing Object ArrayList from file to be edited
   	 * @param f
   	 * @throws IOException 
   	 */
   	public void loadDrob(File f) throws IOException{
   		//FileOutputStream fos = new FileOutputStream(f.toString());
   		//ObjectOutputStream inf = new ObjectOutputStream(fos);
   		
   		drob.clear();
   		
   		try{
   			
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
   		
   		repaint();
    
   	}
}
