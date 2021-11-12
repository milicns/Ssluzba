package gui;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainFrame extends JFrame {  
	
	/*
	 * private static final long serialVersionUID = 1L;
	 */
	
	public MainFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(3*screenWidth / 4, 3*screenHeight/ 4);
	    setTitle("Studentska služba");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null); //na centar
	     
        MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		ToolBar toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		
	}
	       
}
