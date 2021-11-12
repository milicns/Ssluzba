package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;








public class MainFrame extends JFrame {  
	
	
	
	/*
	 * private static final long serialVersionUID = 1L;
	 */
	
	
	
	public MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(3*screenHeight / 4, 3*screenWidth / 4);
	    setTitle("Studentska služba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); //na centar
	    
	    
	    
	    /*
	    
	   
        
        JLabel lbl = new JLabel();
        panel.add(lbl);
        
        Toolbar tb=new Toolbar(this);
        add(tb,BorderLayout.NORTH);
        
        MenuBar meni = new MenuBar(this);
		setJMenu(meni);
		
		
		
		
		Tabovi tab=Tabovi.getInstance();
        add(tab,BorderLayout.CENTER);
	    */
	    
	    
	    
	    
	}
	       
	    


}
