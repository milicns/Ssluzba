package gui;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


public class ToolBar extends JToolBar {
	
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		JButton create = new JButton();
		create.setToolTipText("Create");
		create.setIcon(new ImageIcon("images/add.png"));
		add(create);
		
		JButton edit = new JButton();
		edit.setToolTipText("Edit");
		edit.setIcon(new ImageIcon("images/edit.png"));
		add(edit);
		
		JButton delete = new JButton();
		delete.setToolTipText("Delete");
		delete.setIcon(new ImageIcon("images/bin.png"));
		add(delete);
		
		JTextField tf = new JTextField();
		add(Box.createHorizontalGlue());
		tf.setMaximumSize(new Dimension(3000, 40));
		//add(Box.createHorizontalStrut(1000));
		add(tf);
		
		JButton search = new JButton();
		search.setToolTipText("Search");
		search.setIcon(new ImageIcon("images/search.png"));
		add(search);
		
	}

}
