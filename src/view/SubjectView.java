package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.security.auth.Subject;
 /// import model.Subject; Javlja greskU !! ! 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import controller.SubjectController;

import model.SubjectDatabase;




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
	private SubjectController subjectController;
	
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
	private JLabel lblMessage;
	
	public SubjectView()
	{
		initGUI();
		constructGUI();
	}
	
	/*
	public SubjectView(int selRow) {
		initGUI(true);
		constructGUI();

		setSubject(SubjectDatabase.getInstance().getRow(selRow));
	}
*/

	private void initGUI() {
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
		
		pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		
		
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
	
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
		subjectController = null;
		refreshView();
	}

	public void refreshView() {
	//	tfsubjectCode.setText(subject.getSubjectCode()); ///za klasu SUBJECT PRAVI PROBLEM I ZATO NECE ovi geteri ! 
		//tfsubjectName.setText(subject.getSubjectName());
		/*  switch(subject.studyYear()){
		case 1:
			cbstudyYear.setSelectedIndex(0);
			break;
		case 2:
			cbstudyYear.setSelectedIndex(1);
			break;
		case 3:
			cbstudyYear.setSelectedIndex(2);
			
		case 4:
			cbstudyYear.setSelectedIndex(3);
			break;
		case 5:
			cbstudyYear.setSelectedIndex(4);
			break;
		default:
			cbstudyYear.setSelectedIndex(5);
		}
		
		if(subject.getSemester() == Subject.Semester.Z)
			cbSemester.setSelectedIndex(0);
		else
			cbSemester.setSelectedIndex(1);
		tfespb.setText(Integer.toString(subject.getEspb()));
		*/
	}
	
	
	/*
	 * 	@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(StudentsDatabase.getInstance().findById(tfIndex.getText())) {
					JOptionPane.showMessageDialog(null, "Postoji student sa unetim indeksom.");
					requestFocus();
				}
				inputCheck();
				
			}
	 */
	
	public JTextField getTfsubjectCode() {
		return tfsubjectCode;
	}
	public void setTfCode(JTextField tfsubjectCode) {
		this.tfsubjectCode = tfsubjectCode;
	}
	public JTextField getTfsubjectName() {
		return tfsubjectName;
	}
	public void setTfName(JTextField tfsubjectName) {
		this.tfsubjectName = tfsubjectName;
	}
	public JTextField getTfespb() {
		return tfespb;
	}
	public void setTfESPB(JTextField tfespb) {
		this.tfespb = tfespb;
	}
	public JButton getBtnconfirm() {
		return confirm;
	}
	public void setBtnOK(JButton confirm) {
		this.confirm = confirm;
	}
	public JLabel getLblMessage() {
		return lblMessage;
	}
	public void setLblMessage(JLabel lblMessage) {
		this.lblMessage = lblMessage;
	}
	
	
	
	

}
