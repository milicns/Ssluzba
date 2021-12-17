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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class About extends JDialog{
	
	private static final long serialVersionUID = 1L;

	public About(Frame parent, String title) {
		super(parent, title, false);
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
		setSize(600, screenHeight/2);
		setLocationRelativeTo(null);
		
		/*ImageIcon helpIcon =  DODATI SLIKE OVDE  I AKO TREBA JOS NESTO U TEKSTU */
		
		
	
	

          }
}
