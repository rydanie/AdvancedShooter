import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

public class EndFrame extends JFrame implements ActionListener {

	
	public GridBagLayout layout;
	public JLabel title;
	 
	GameFrame gf;
	StartScreen jmf;
	boolean closeGF;
	
	public EndFrame(){
		super();
		
		//this.addKeyListener(this);
		JPanel p = new JPanel();
		layout =new GridBagLayout();
		
		closeGF = false;
		
		p.setLayout( layout );
       this.setName( "Ryley's Sooter");
       this.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
       
       
       GridBagConstraints c = new GridBagConstraints();
       // general constraints
       
       c.fill = GridBagConstraints.BOTH;
       
       // label constraints
       c.weightx = 0.0;
       c.gridwidth = GridBagConstraints.RELATIVE;
       
       c.gridx = 0;
       c.gridy = 3;
       title = new JLabel( "Game Project" );
       layout.setConstraints( title, c );
       this.add( title );
       
       
       c.weightx = 0.0;
       c.gridwidth = GridBagConstraints.CENTER;
       
       c.gridx = 1;
       c.gridy = 2;
       
       JButton start = new JButton("Restart Game");
       start.addActionListener(this);
       start.setActionCommand("start main");
       p.add(start);
       
       
       c.gridwidth = GridBagConstraints.CENTER;
       c.gridx = 3;
       c.gridy = 0;
       
       JButton editer = new JButton("Main Menue");
       editer.addActionListener(this);
       editer.setActionCommand("main");
       p.add(editer);
       
       c.gridwidth = GridBagConstraints.ABOVE_BASELINE;
       
       c.gridx = 1;
       c.gridy = 4;
       
       /*
       JLabel l = new JLabel("You Died");;
       l.setFont(getFont());
       l.setBackground(Color.BLUE);
       this.add(l);
       */
       
       p.setBackground(Color.RED);
       
       //sets input focus in gf
       //gf.setFocusable(true);
       //gf.requestFocusInWindow();
       
       //this.setForeground(Color.BLUE);//(new BufferedImage(new File("uiImage")));
       this.add(p);
       this.setBackground(Color.RED);
       
       this.pack();
       this.setSize(400,400 );
       // Our size will be wrong, so let's fix it
       //myFrame.setSize(600, 200);
       // alternate: use pack
       //myFrame.pack();

       this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		switch (a.getActionCommand()){
		
		case("start main"):
			this.setVisible(false);
			closeGF =true;
			gf = new GameFrame();
			//gf.setFocusable(true);
	        //gf.requestFocusInWindow();1
			new Thread(gf).start();
			break;
			
		case("main"):
			this.setVisible(false);
			jmf = new StartScreen();
			closeGF = true;
			break;
			
		default:
			System.out.println("You killed us all");
			break;
		}
	}

public boolean getCloseGF(){
	return closeGF;
}
	

}
