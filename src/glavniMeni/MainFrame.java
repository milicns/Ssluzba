package glavniMeni;



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
	    int screenWidth = screenSize.width;
	    int screenHeight = screenSize.height;
	    setSize( (int)(0.75*screenWidth) , (int)(0.75*screenHeight)) ;
	    setTitle("Studentska služba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); //na centar
	    
	    
	    
	    
	    
	   
      
        
      
        
        MenuBar meni = new MenuBar();
		this.setJMenuBar(meni);
		
		
		
		
	    
	    
	    
	    
	}
	       
	    


}
