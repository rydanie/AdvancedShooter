import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * 
 * @author Ryley Danielson
 *
 */
public class GameFrame extends JFrame implements Runnable, KeyListener {

	DialoguePanel dp;
	ActionPanel ap;
	HealthPanel hp;
	
	public GameFrame(){
		super();
		
		this.setLayout(new BorderLayout());
		
		
		
		dp = new DialoguePanel();
		ap = new ActionPanel();
		hp = new HealthPanel();
		
		//this.add(dp, BorderLayout.NORTH);
		this.add(ap, BorderLayout.CENTER);
		//this.add(hp, BorderLayout.SOUTH);
		
		this.addKeyListener(this);
		//ap.addKeyListener(this);
		ap.setFocusable(true);
        ap.requestFocusInWindow();
		
		this.setSize(100,100);
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
            System.out.println("Right typed."
            		+ ""
            		+ " This is gameframe");
        } 
        else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
            System.out.println("Left typed.");
        } 
        else if (e.getKeyCode() == KeyEvent.VK_UP ) {
            System.out.println("Up typed.");
        } 
        else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
            System.out.println("Down typed.");
        }
        else{
            System.out.println("Key typed: " + e.getKeyChar());
        }

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		GameFrame frame  = this;
		Timer timer = new Timer(1000/60,new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.repaint();
			}

		} );
		
		timer.start();
		
		/*
		while(true){
			this.repaint();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
	}
}
