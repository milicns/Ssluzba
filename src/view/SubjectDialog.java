package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.security.auth.Subject;
 /// import model.Subject; Javlja greskU !! ! 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import controller.SubjectController;
import model.Professor;
import model.Student;
import model.Subject.Semester;
import model.SubjectDatabase;




public class SubjectDialog extends JDialog{
	
private static final long serialVersionUID = 1L;
	
	
	private JPanel pnlContent;
	private JLabel lblSubjectCode;
	private JTextField tfSubjectCode;
	private JLabel lblSubjectName;
	private JTextField tfSubjectName;
	private JLabel lblSemester;
	private JComboBox<String> cbSemester;
	private JLabel lblStudyYear;
	private JComboBox<String> cbStudyYear;
	private JLabel lblEspb;
	private JTextField tfEspb;
	private JLabel lblProfessor;   
	private JTextField tfProfessor;
	private JButton confirm;
	private JButton quit;
	private JPanel pnlButton;
	private JLabel lblMessage;
	
	public SubjectDialog(JFrame parent, String title, boolean modal)
	{
		super(parent, title, modal);
		setTitle(title);
		setSize(400,400);
		setLocationRelativeTo(parent);
		initGUI();
		constructGUI();
		buttonActions();
	}
	

	private void initGUI() {
		
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		lblSubjectCode = new JLabel("Sifra predmeta*");
		tfSubjectCode = new JTextField(20);
		
		
		lblSubjectName = new JLabel("Naziv predmeta*");
		tfSubjectName = new JTextField(20);
		
		
		
		lblSemester = new JLabel("Semestar*");
		String[] semesterStrings = {"Zimski","Letnji"};
		cbSemester = new JComboBox<String>(semesterStrings);
		
		lblStudyYear = new JLabel("Godina*");
		String[] studyYearStrings = {"I(prva)","II(druga)","III(treća)","IV(četvrta)"};
		cbStudyYear = new JComboBox<String>(studyYearStrings);
		
		
		
		lblEspb = new JLabel("Espb*");
		tfEspb = new JTextField(20);
		
		quit = new JButton("Odustani");
		confirm = new JButton("Potvrdi");
		
		pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
	}


	private void constructGUI() {
		
		pnlContent.add(lblSubjectCode, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(tfSubjectCode, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		pnlContent.add(lblSubjectName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(tfSubjectName, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		
		pnlContent.add(lblSemester, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(cbSemester, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnlContent.add(lblStudyYear, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(cbStudyYear, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnlContent.add(lblEspb, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(tfEspb, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnlContent.add(confirm, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(quit, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 0, 0));
		add(pnlContent, BorderLayout.CENTER);
		add(pnlButton, BorderLayout.SOUTH);
		
		
	}
	
	
	private void buttonActions() {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();	
			}
		});
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Semester sem;
				if(cbSemester.getSelectedItem().equals("Zimski")) {
					sem = Semester.Z;
				} else {
					sem = Semester.L;
				}
				
				int year;
				if(cbStudyYear.getSelectedItem().equals("I(prva)")) {
					year = 1;
				} else if(cbStudyYear.getSelectedItem().equals("II(druga)")) {
					year = 2;
				} else if(cbStudyYear.getSelectedItem().equals("III(treća)")) {
					year = 3;
				} else {
					year = 4;
				}

				SubjectController.getInstance().addSubject(tfSubjectCode.getText(), tfSubjectName.getText() ,sem, year,new Professor(), Integer.parseInt(tfEspb.getText()), new ArrayList<Student>(), new ArrayList<Student>());
				dispose();
			}

		});

	}
	

}
