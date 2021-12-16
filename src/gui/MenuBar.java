package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class MenuBar extends JMenuBar {
	
	public MenuBar() {
		
		JMenu mFile = new JMenu("File");
		JMenu mEdit = new JMenu("Edit");
		JMenu mHelp = new JMenu("Help");
		
		JMenu miOpen = new JMenu ("Open");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miSave = new JMenuItem ("Save");
		JMenuItem miClose = new JMenuItem("Close");
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		JMenuItem student = new JMenuItem("Student");
		JMenuItem professor = new JMenuItem("Professor");
		JMenuItem subject = new JMenuItem("Subject");
		JMenuItem department = new JMenuItem("Department");
		
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
		
		student.setMnemonic(KeyEvent.VK_U);
		student.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		professor.setMnemonic(KeyEvent.VK_P);
		professor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		subject.setMnemonic(KeyEvent.VK_I);
		subject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		department.setMnemonic(KeyEvent.VK_K);
		department.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK));
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		
		mFile.setMnemonic(KeyEvent.VK_F);
		mEdit.setMnemonic(KeyEvent.VK_E);
		mHelp.setMnemonic(KeyEvent.VK_H);
		
		student.setIcon(new ImageIcon("images/student.png"));
		professor.setIcon(new ImageIcon("images/professor.png"));
		subject.setIcon(new ImageIcon("images/subject.png"));
		department.setIcon(new ImageIcon("images/department.png"));
		
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
		
		miOpen.add(student);
		miOpen.addSeparator();
		miOpen.add(professor);
		miOpen.addSeparator();
		miOpen.add(subject);
		miOpen.addSeparator();
		miOpen.add(department);
		
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
		
		LineBorder lb = new LineBorder(Color.LIGHT_GRAY);
		setBorder(lb);
		
	}
}