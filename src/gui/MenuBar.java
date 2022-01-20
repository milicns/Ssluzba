package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ResourceBundleController;
import controller.StudentController;
import dialog.ProfessorDialog;
import view.ProfessorEditDialog;
import view.StudentDialog;
import view.StudentEditDialog;
import view.SubjectDialog;
import view.SubjectEditDialog;

public class MenuBar extends JMenuBar {
	
	DepartmentDialog dd;
	
	public MenuBar(JFrame parent) {
		
		JMenu mFile = new JMenu("File");
		JMenu mEdit = new JMenu("Edit");
		JMenu mHelp = new JMenu("Help");
		JMenu mLang = new JMenu("Language");
		
		ButtonGroup btnGroup = new ButtonGroup();
		JCheckBox mSrb = new JCheckBox("Serbian");
		JCheckBox mEng = new JCheckBox("English");
		btnGroup.add(mSrb);
		btnGroup.add(mEng);
		mLang.add(mSrb);
		mLang.add(mEng);
		
		JMenu miOpen = new JMenu ("Open");
		
		JMenuItem miNew = new JMenuItem("New");
		miNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0) {
					String sdTitle = "Dodavanje studenta";
					StudentDialog sd = new StudentDialog(parent,sdTitle,true);
					sd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
					ProfessorDialog pd = new ProfessorDialog(parent);
					pd.setVisible(true);
				} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
					String sbdTitle = "Dodavanje predmeta";
					SubjectDialog sbd = new SubjectDialog(parent,sbdTitle,true);
					sbd.setVisible(true);

			}
				
			
		}});
		
		JMenuItem miSave = new JMenuItem ("Save");
		JMenuItem miClose = new JMenuItem("Close");
		//https://zetcode.com/javaswing/menusandtoolbars/
		miClose.addActionListener((event) -> System.exit(0));

		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.addActionListener(new ActionListener() {
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
			} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 2) {
				int row = MainFrame.getInstance().getSubjectTable().getSelectedRow();
				if(row != -1) {
					String sbedTitle = "Izmena predmeta";
				SubjectEditDialog sbd = new SubjectEditDialog(parent,sbedTitle,true,row);
				sbd.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Izaberite predmet koji želite da izmenite.");
				}
			} else if(MainFrame.getInstance().getTabs().getSelectedIndex() == 1) {
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
		
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainFrame.getInstance().getTabs().getSelectedIndex() == 0)
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
			}
		});
		
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		JMenuItem miStudent = new JMenuItem("Student");
		JMenuItem miProfessor = new JMenuItem("Professor");
		JMenuItem miSubject = new JMenuItem("Subject");
		JMenuItem miDepartment = new JMenuItem("Department");
		
		miDepartment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dd = new DepartmentDialog(parent, "Katedre", true);
				dd.setVisible(true);
				
			}
			
		});
		
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setMnemonic(KeyEvent.VK_S);
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miOpen.setMnemonic(KeyEvent.VK_O);
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		miStudent.setMnemonic(KeyEvent.VK_U);
		miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		miProfessor.setMnemonic(KeyEvent.VK_P);
		miProfessor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		miSubject.setMnemonic(KeyEvent.VK_I);
		miSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		miDepartment.setMnemonic(KeyEvent.VK_K);
		miDepartment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit.setMnemonic(KeyEvent.VK_E);
		mHelp.setMnemonic(KeyEvent.VK_H);
		
		miStudent.setIcon(new ImageIcon("images/student.png"));
		miStudent.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				MainFrame.getInstance().getTabs().setSelectedIndex(0);
				
			}
			
		});
		
		miProfessor.setIcon(new ImageIcon("images/professor.png"));
		miProfessor.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				MainFrame.getInstance().getTabs().setSelectedIndex(1);
				
			}
			
		});
		
		miSubject.setIcon(new ImageIcon("images/subject.png"));
		miSubject.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				MainFrame.getInstance().getTabs().setSelectedIndex(2);
		}});
		
		miDepartment.setIcon(new ImageIcon("images/department.png"));
		
		miNew.setIcon(new ImageIcon("images2/new.png"));
		miSave.setIcon(new ImageIcon("images2/save.png"));
		miOpen.setIcon(new ImageIcon("images2/open.png"));
		miClose.setIcon(new ImageIcon("images2/close.png"));
		miEdit.setIcon(new ImageIcon("images2/edit.png"));
		miDelete.setIcon(new ImageIcon("images2/delete.png"));
		miHelp.setIcon(new ImageIcon("images2/help.png"));
		miAbout.setIcon(new ImageIcon("images2/info.png"));
		
		
		mFile.add(miNew);
		mFile.addSeparator();
		mFile.add(miSave);
		mFile.addSeparator();
		
		miOpen.add(miStudent);
		miOpen.addSeparator();
		miOpen.add(miProfessor);
		miOpen.addSeparator();
		miOpen.add(miSubject);
		miOpen.addSeparator();
		miOpen.add(miDepartment);
		
		mFile.add(miOpen);
		mFile.addSeparator();
		mFile.add(miClose);
		
		mEdit.add(miEdit);
		mEdit.addSeparator();
		mEdit.add(miDelete);
		
		mHelp.add(miHelp);
		mHelp.addSeparator();
		mHelp.add(miAbout);
		
		add(mFile);
		add(mEdit);
		add(mHelp);
		add(mLang);
		
		LineBorder lb = new LineBorder(Color.LIGHT_GRAY);
		setBorder(lb);
		
	}
	
}