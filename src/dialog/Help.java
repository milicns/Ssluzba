package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import gui.MenuBar;
import gui.ToolBar;

public class Help extends JDialog {
	private static final long serialVersionUID = 1L;

	public Help(Frame parent, String title) {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
		setSize(700, screenHeight/2);
		setLocationRelativeTo(null);
	
		
		///ImageIcon helpIcon = new ImageIcon treba postaviti slike 
		//setIconImage(helpIcon.getImage());
		
		
		
	}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



