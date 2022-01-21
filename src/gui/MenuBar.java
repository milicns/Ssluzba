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
	
	private DepartmentDialog dd;
	private JMenu mFile;
	private JMenu mEdit;
	private JMenu mHelp;
	private JMenu mLang;
	private JMenu miOpen;
	private JMenuItem miNew;
	private JMenuItem miSave;
	private JMenuItem miClose;
	private JMenuItem miEdit;
	private JMenuItem miDelete;
	private JMenuItem miHelp;
	private JMenuItem miAbout;
	private JMenuItem miStudent;
	private JMenuItem miProfessor;
	private JMenuItem miSubject;
	private JMenuItem miDepartment;
	
	public MenuBar(JFrame parent) {
		
		mFile = new JMenu(ResourceBundleController.getInstance().getResourceBundle().getString("mFile"));
		mEdit = new JMenu(ResourceBundleController.getInstance().getResourceBundle().getString("mEdit"));
		mHelp = new JMenu(ResourceBundleController.getInstance().getResourceBundle().getString("mHelp"));
		mLang = new JMenu(ResourceBundleController.getInstance().getResourceBundle().getString("mLang"));
		
		ButtonGroup btnGroup = new ButtonGroup();
		JCheckBox mSrb = new JCheckBox("Serbian");
		JCheckBox mEng = new JCheckBox("English");
		
		mSrb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResourceBundleController.getInstance().changeLanguage("sr", "RS");
				
				
			}
			
		});
		
		mEng.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResourceBundleController.getInstance().changeLanguage("en", "US");
				
				
			}
			
		});
		btnGroup.add(mSrb);
		btnGroup.add(mEng);
		mLang.add(mSrb);
		mLang.add(mEng);
		
		miOpen = new JMenu ("Open");
		
		miNew = new JMenuItem("New");
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
		
		miSave = new JMenuItem ("Save");
		miClose = new JMenuItem("Close");
		//https://zetcode.com/javaswing/menusandtoolbars/
		miClose.addActionListener((event) -> System.exit(0));

		miEdit = new JMenuItem("Edit");
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
		
		miDelete = new JMenuItem("Delete");
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
		
		miHelp = new JMenuItem("Help");
		miAbout = new JMenuItem("About");
		
		miStudent = new JMenuItem("Student");
		miProfessor = new JMenuItem("Professor");
		miSubject = new JMenuItem("Subject");
		miDepartment = new JMenuItem("Department");
		
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

	public DepartmentDialog getDd() {
		return dd;
	}

	public JMenu getMiOpen() {
		return miOpen;
	}

	public JMenuItem getMiNew() {
		return miNew;
	}

	public JMenuItem getMiSave() {
		return miSave;
	}

	public JMenuItem getMiClose() {
		return miClose;
	}

	public JMenuItem getMiEdit() {
		return miEdit;
	}

	public JMenuItem getMiDelete() {
		return miDelete;
	}

	public JMenuItem getMiHelp() {
		return miHelp;
	}

	public JMenuItem getMiAbout() {
		return miAbout;
	}

	public JMenuItem getMiStudent() {
		return miStudent;
	}

	public JMenuItem getMiProfessor() {
		return miProfessor;
	}

	public JMenuItem getMiSubject() {
		return miSubject;
	}

	public JMenuItem getMiDepartment() {
		return miDepartment;
	}

	public JMenu getmFile() {
		return mFile;
	}

	public JMenu getmEdit() {
		return mEdit;
	}

	public JMenu getmHelp() {
		return mHelp;
	}

	public JMenu getmLang() {
		return mLang;
	}
	
}