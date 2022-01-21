package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

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
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import view.ProfessorEditDialog;
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
					String sdTitle = "Dodavanje studenta";
					StudentDialog sd = new StudentDialog(parent,sdTitle,true);
					sd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
					//ProfessorDialog pd = new ProfessorDialog(parent);
					//pd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
					String sbdTitle = "Dodavanje studenta";
					SubjectDialog sbd = new SubjectDialog(parent,sbdTitle,true);
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
			String sedTitle = "Izmena studenta";
			StudentEditDialog ed = new StudentEditDialog(parent,sedTitle,true);
			ed.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Izaberite studenta kog želite da izmenite.");
			}
		}else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
		   int row = MainFrame.getInstance().getSubjectTable().getSelectedRow();
		   if(row != -1) {
			String sbedTitle = "Izmena predmeta";
		   SubjectEditDialog sbe = new SubjectEditDialog(parent, sbedTitle,true,row);
		   sbe.setVisible(true);
		   } else {
			   JOptionPane.showMessageDialog(null, "Izaberite koji predmet želite da izmenite.");
		   }
		   }else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
				int row = MainFrame.getInstance().getProfessorTable().getSelectedRow();
				if(row != -1) {
					String pedTitle = "Izmena profesora";
				ProfessorEditDialog ped = new ProfessorEditDialog(parent,pedTitle,true);
				ped.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Izaberite profesora kog želite da izmenite.");
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
				if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0) {
					if(MainFrame.getInstance().getStudentTable().getSelectedRow() != -1){
					String[] options = {"Da", "Ne"};
					int d = JOptionPane.showOptionDialog(parent,"Da li ste sigurni da želite da obrišete studenta?", "Brisanje studenta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
					if(d == JOptionPane.YES_OPTION) {
						String index = (MainFrame.getInstance().getStudentTable().getValueAt(MainFrame.getInstance().getStudentTable().getSelectedRow(),0)).toString();
						StudentController.getInstance().deleteStudent(index);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Izaberite studenta kog želite da obrišete.");
				}	
			} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
				if(MainFrame.getInstance().getProfessorTable().getSelectedRow() != -1){
				String[] options = {"Da", "Ne"};
				int d = JOptionPane.showOptionDialog(parent,"Da li ste sigurni da želite da obrišete profesora?", "Brisanje profesora", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
				if(d == JOptionPane.YES_OPTION) {
					int i = MainFrame.getInstance().getProfessorTable().getSelectedRow();
					ProfessorController.getInstance().deleteProfessor(i);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite profesora kog želite da obrišete.");
			}	
			}else if (MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
				if(MainFrame.getInstance().getSubjectTable().getSelectedRow() != -1){
				String[] options = {"Da", "Ne"};
				int d = JOptionPane.showOptionDialog(parent,"Da li ste sigurni da želite da obrišete predmet?", "Brisanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "default");
				if(d == JOptionPane.YES_OPTION) {
					String index = (MainFrame.getInstance().getSubjectTable().getValueAt(MainFrame.getInstance().getSubjectTable().getSelectedRow(),0)).toString();
						SubjectController.getInstance().deleteSubject(index);
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite predmet koji želite da obrišete.");
			}
			}
		}});
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
