package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import controller.StudentController;
import dialog.ProfessorDialog;
import view.StudentDialog;
import view.StudentEditDialog;
import view.SubjectDialog;
import view.SubjectEditDialog;


public class ToolBar extends JToolBar {
	
	public ToolBar(JFrame parent) {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		
		JButton create = new JButton();
		create.setToolTipText("Create");
		create.setIcon(new ImageIcon("images/add.png"));
		create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0) {
					StudentDialog sd = new StudentDialog(parent,"Dodavanje studenta",true);
					sd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
					ProfessorDialog pd = new ProfessorDialog(parent);
					pd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
					SubjectDialog sbd = new SubjectDialog(parent,"Dodavanje predmeta",true);
					sbd.setVisible(true);
			}
			
		}});
		create.setMnemonic(KeyEvent.VK_C);
		add(create);
		
		JButton edit = new JButton();
		edit.setToolTipText("Edit");
		edit.setIcon(new ImageIcon("images/edit.png"));
		edit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0) {
			if(MainFrame.getInstance().getStudentTable().getSelectedRow() != -1){
			StudentEditDialog ed = new StudentEditDialog(parent,"Izmena studenta",true);
			ed.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Izaberite studenta kog želite da izmenite.");
			}
		}else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
		   int row = MainFrame.getInstance().getSubjectTable().getSelectedRow();
		   if(row != -1) {
		   SubjectEditDialog sbe = new SubjectEditDialog(parent, "Izmena predmeta",true,row);
		   sbe.setVisible(true);
		   } else {
			   JOptionPane.showMessageDialog(null, "Izaberite koji predmet želite da izmenite.");
		   }
		}
		}});
		edit.setMnemonic(KeyEvent.VK_M);
		add(edit);
		
		JButton delete = new JButton();
		delete.setToolTipText("Delete");
		delete.setIcon(new ImageIcon("images/bin.png"));
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0)
					if(MainFrame.getInstance().getStudentTable().getSelectedRow() != -1){
					String[] options = {"Da", "Ne"};
					int d = JOptionPane.showOptionDialog(parent,"Da li ste sigurni da �elite da obri�ete studenta?", "Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
					if(d == JOptionPane.YES_OPTION) {
						String index = (MainFrame.getInstance().getStudentTable().getValueAt(MainFrame.getInstance().getStudentTable().getSelectedRow(),0)).toString();
						StudentController.getInstance().deleteStudent(index);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Izaberite studenta kog �elite da obri�ete.");
				}	
			}
		});
		delete.setMnemonic(KeyEvent.VK_D);
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
