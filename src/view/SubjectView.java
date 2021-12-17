package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.security.auth.Subject;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import controller.SubjectController;




public class SubjectView extends JPanel{
	
private static final long serialVersionUID = 1L;
	
	private static SubjectView instance = null;

	
	public static SubjectView getInstance() {
		if (instance == null) {
			instance = new SubjectView();
		}
		return instance;
	
	}
	
	private Subject subject;
	private SubjectController predmetController;
	
	private JPanel pnlContent;
	private JLabel lblsubjectCode;
	private JTextField tfsubjectCode;
	private JLabel lblsubjectName;
	private JTextField tfsubjectName;
	private JLabel lblSemester;
	private JComboBox<String> cbSemester;
	private JLabel lblstudyYear;
	private JComboBox<String> cbstudyYear;
	private JLabel lblespb;
	private JTextField tfespb;
	private JLabel lblProfessor;   //// ili labela ka studentima zbog polozenih neppolozenih predmeta 
	private JTextField tfProfessor;
	private JButton confirm;
	private JButton quit;
	private JPanel pnlButton;
	
	
	public SubjectView()
	{
		initGUI(false);
		constructGUI();
	}


	private void initGUI(boolean b) {
		// TODO Auto-generated method stub
		
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		
		
		lblsubjectCode = new JLabel("Sifra predmeta*");
		tfsubjectCode = new JTextField(20);
		
		
		lblsubjectName = new JLabel("Naziv predmeta*");
		tfsubjectName = new JTextField(20);
		
		
		
		lblSemester = new JLabel("Semestar*");
		String[] semesterStrings = {"Zimski","Letnji"};
		cbSemester = new JComboBox<String>(semesterStrings);
		
		lblstudyYear = new JLabel("Godina*");
		String[] studyYearStrings = {"1","2","3","4"};
		cbstudyYear = new JComboBox<String>(studyYearStrings);
		
		
		
		lblespb = new JLabel("Espb*");
		tfespb = new JTextField(20);
		
		
		lblProfessor = new JLabel("Profesor*");
		tfProfessor = new JTextField(20);
		tfProfessor.setMinimumSize(new Dimension(150,20));
		
		quit = new JButton("Odustani");
		confirm = new JButton("Potvrdi");
		
		
		
		
		
		
	}


	private void constructGUI() {
		// TODO Auto-generated method stub
		pnlContent.add(lblsubjectCode, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfsubjectCode, new GridBagConstraints(1, 0, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblsubjectName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfsubjectName, new GridBagConstraints(1, 1, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		
		pnlContent.add(lblSemester, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbSemester, new GridBagConstraints(1, 3, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblstudyYear, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbstudyYear, new GridBagConstraints(1, 2, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblespb, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfespb, new GridBagConstraints(1, 4, 1, 1, 120, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(confirm, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(quit, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(pnlContent, BorderLayout.CENTER);
		add(pnlButton, BorderLayout.SOUTH);
		
		
	}
	
	
	
	
	

}
