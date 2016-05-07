
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woytek
 */
public class JMenuFrame extends JFrame implements ActionListener {
	int x = 1;
    int y = 2;
   
    ToolPanel tPane;
    static JColorChooser color;
   // ColorPanel cPane;
    DrawingPane dPane;
    //SaveImageFrame savI;
    //static int turnedOn;
    //JPanel p
    
    public JMenuFrame() {
        super();
        dPane = new DrawingPane();
        tPane = new ToolPanel();
        color = new JColorChooser();
        //cPane = new ColorPanel();
        //savI = new SaveImageFrame();
        
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;
        JMenu subMenu;
        
        JRadioButton outline = new JRadioButton();
                
        this.setLayout( new BorderLayout() );
        this.setName( "Jay Manue Teeest Frum");
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        dPane.setPreferredSize(new Dimension(100,200));
        this.add(color, BorderLayout.SOUTH);
        this.add( tPane, BorderLayout.NORTH);
        this.add( dPane, BorderLayout.CENTER );
       // this.add(cPane, BorderLayout.WEST);
        color.setVisible(false);
        //cPane.setVisible(false);
       // cPane.fo = 2;
        
        menuBar = new JMenuBar();
        
        menu = new JMenu( "My Menu" );
        
        menuItem = new JMenuItem( "Save Image" );
        menuItem.setActionCommand( "Save Image" );
        menuItem.addActionListener( this );
       
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Save All" );
        menuItem.setActionCommand( "Save All" );
        menuItem.addActionListener( this );
       
        menu.add(menuItem);
        
        menuItem = new JMenuItem( "Load All" );
        menuItem.setActionCommand( "Load All" );
        menuItem.addActionListener( this );
       
        menu.add(menuItem);
        
        /*
        menuItem = new JMenuItem( "Load Image" );
        menuItem.setActionCommand( "Load Image" );
        menuItem.addActionListener( this );
       
        menu.add(menuItem);
        */
        
        menuItem = new JMenuItem( "New" );
        menuItem.setActionCommand( "New" );
        menuItem.addActionListener( this );
 
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Exit" );
        menuItem.setActionCommand( "Quit" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menuBar.add( menu );
        
        menu = new JMenu( "FOO" );
        
        menuItem = new JMenuItem( "Foo Thing" );
        menuItem.setActionCommand( "MenuFoo" );
        menuItem.addActionListener( this );
        menu.add(menuItem);
        
        menu.addSeparator();
        
        menuItem = new JMenuItem( "Foo 2" );
        menuItem.setActionCommand( "MenuFoo2" );
        menuItem.addActionListener( this );
        menu.add( menuItem );
        
        subMenu = new JMenu( "SubMenu" );
        menuItem = new JMenuItem( "SubFoo" );
        menuItem.setActionCommand( "MenuSubFoo" );
        menuItem.addActionListener( this );
        subMenu.add( menuItem );
        
        menu.add(subMenu);
        
        menuBar.add( menu );
        
        menu = new JMenu( "Colors" );
        menuItem = new JMenuItem( "Color Pane" );
        menuItem.setActionCommand("colorBox");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        menu = new JMenu( "Shapes" );
        menuItem = new JMenuItem( "Tool Panel" );
        menuItem.setActionCommand("S&P");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        menu = new JMenu( "Edit" );
        menuItem = new JMenuItem( "Move" );
        menuItem.setActionCommand("edit");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        //menu.addSeparator();
        
        menuItem = new JMenuItem( "Resize" );
        menuItem.setActionCommand("resize");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        //menu.addSeparator();
        
        menuItem = new JMenuItem( "Delete" );
        menuItem.setActionCommand("delete");
        menuItem.addActionListener(this);
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        menuBar.add( Box.createHorizontalGlue() );
        
        menu = new JMenu( "Help" );
        menuItem = new JMenuItem( "About" );
        menuItem.setActionCommand( "MenuAbout" );
        menuItem.addActionListener( this );
        
        menu.add( menuItem );
        
        menuBar.add( menu );
        
        this.setJMenuBar( menuBar );
        
        //this.setSize( new Dimension(this.getPreferredSize() ) ); 
        this.setSize( 900, 900 );
        
        this.setVisible( true );
        
    }
    

    public void actionPerformed( ActionEvent e ) {
    	
    	
    	
        switch( e.getActionCommand() ) {
            case "Save Image":
            	//dPane.createImage(100, 200);
            	//dPane.saveImage("First", "jpg");
            	//savI.setVisible(true);
            	JFileChooser s = new JFileChooser();
            	int retv = s.showSaveDialog(this);
            	
            	if(retv == JFileChooser.APPROVE_OPTION){
            		File name = s.getSelectedFile();
            		dPane.saveImage(name);
            	}
            	
                System.out.println( "Something Pressed" );
                break;
                
            case "Load Image":
            	//dPane.createImage(100, 200);
            	//dPane.saveImage("First", "jpg");
            	//savI.setVisible(true);
            	s = new JFileChooser();
            	//s.setApproveButtonText("Open");
            	retv = s.showOpenDialog(this);
            	
            	if(retv == JFileChooser.APPROVE_OPTION){
            		File name = s.getSelectedFile();
            		dPane.loadImage(name);
            	}
            	
                
                break;
            
            case "Load All":
            	s = new JFileChooser();
            	//s.setApproveButtonText("Open");
            	retv = s.showOpenDialog(this);
            	
            	if(retv == JFileChooser.APPROVE_OPTION){
            		File name = s.getSelectedFile();
            		try {
						dPane.loadDrob(name);
						System.out.println("I Loaded");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	System.out.print("Save All" );
            	break;
            	
            case "Save All":
            	s = new JFileChooser();
            	//s.setApproveButtonText("Open");
            	retv = s.showSaveDialog(this);
            	
            	if(retv == JFileChooser.APPROVE_OPTION){
            		File name = s.getSelectedFile();
            		dPane.saveDrob(name);
            	}
            	System.out.print("Save All" );
            	break;
                
            case "New":
            	
                tPane.check = -1;
                dPane.drob.clear();
                // dPane.setVisible(false);
            	//dPane.setVisible(true);
            	tPane.setVisible(true);
               	//color.setVisible(false);
               	//cPane.setVisible(false);
               	repaint();
                System.out.println( "new Pressed" );
                break;
                
            case "Quit":
                System.out.println( "quit Pressed" );
                System.exit(0);
                break;
                
            case "colorBox":
            	//color.setVisible(true);
            	//cPane.setVisible(true);
            	tPane.setVisible(false);
            	//tPane.setVisible(false);
            	ToolPanel.check= 5;
            	//cPane.fo = cPane.
            	break;
            	
            case "S&P":
            	tPane.setVisible(true);
            	color.setVisible(false);
            	//cPane.setVisible(false);
            	//cPane.fo = 2;
            	ToolPanel.check=-1;
            	
            	//tPane.setVisible(false);
                break;
                
            case "edit":
            	tPane.setVisible(false);
            	color.setVisible(false);
            	//cPane.setVisible(false);
            	ToolPanel.check = 0;
                break;
                
            case "resize":
            	tPane.setVisible(false);
            	color.setVisible(false);
            	//cPane.setVisible(false);
            	ToolPanel.check = 7;
                break;
                
            case "delete":
            	tPane.setVisible(false);
            	color.setVisible(false);
            	//cPane.setVisible(false);
            	ToolPanel.check = 8;
                break;
                
            default:
                System.out.println( "I DON'T KNOW HOW YOU GOT HERE!!!!" );
                System.exit(-1);
                break;
        }
        
    }
    
    /**
     * Checks to see whether or not color frame is on
     * @return boolean
     */
   
    
    
    /**
     * Returns a color from 
     * @return
     */
    public static Color getColor(){
    	return color.getColor();
    	
    }
    
   

}
