package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import view.StudentDialog;


public class ToolBar extends JToolBar {
	
	public ToolBar(JFrame fr) {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		JButton create = new JButton();
		create.setToolTipText("Create");
		create.setIcon(new ImageIcon("images/add.png"));
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentDialog sd = new StudentDialog(fr,"Dodavanje studenta");
				sd.setVisible(true);
			}
			
		});
		
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
		add(tf);
		
		JButton search = new JButton();
		search.setToolTipText("Search");
		search.setIcon(new ImageIcon("images/search.png"));
		add(search);
		
	}

}
