package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import controller.SubjectController;
import gui.MainFrame;
import model.StudentsDatabase;
import model.Subject;
import model.SubjectDatabase;
import model.Subject.Semester;

public class SubjectEditDialog extends JDialog{
	
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
	private Subject subject;
	private JButton plus;
	private JButton minus;
	
	public SubjectEditDialog(JFrame parent, String title, boolean modal, int row)
	{
		super(parent, title, modal);
		setTitle(title);
		setSize(500,450);
		setLocationRelativeTo(parent);
		subject = SubjectDatabase.getInstance().getRow(row);
		initGUI();
		constructGUI();
		buttonActions();
	}
	
	private void initGUI() {
		
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		lblSubjectCode = new JLabel("Sifra predmeta*");
		tfSubjectCode = new JTextField(20);
		tfSubjectCode.setText(subject.getSubjectCode());
		tfSubjectCode.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		lblSubjectName = new JLabel("Naziv predmeta*");
		tfSubjectName = new JTextField(20);
		tfSubjectName.setText(subject.getSubjectName());
		tfSubjectName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		
		lblSemester = new JLabel("Semestar*");
		String[] semesterStrings = {"Zimski","Letnji"};
		cbSemester = new JComboBox<String>(semesterStrings);
		
		lblStudyYear = new JLabel("Godina*");
		String[] studyYearStrings = {"I(prva)","II(druga)","III(treća)","IV(četvrta)"};
		cbStudyYear = new JComboBox<String>(studyYearStrings);
		
		lblEspb = new JLabel("Espb*");
		tfEspb = new JTextField(20);
		tfEspb.setText(Integer.toString(subject.getEspb()));
		tfEspb.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		
		lblProfessor = new JLabel("Profesor*");
		tfProfessor = new JTextField(20);
		if(subject.getSubjectProfessor()==null) {
			tfProfessor.setText(" ");
		}else if(subject.getSubjectProfessor().getName()==null || subject.getSubjectProfessor().getSurname()==null){
			tfProfessor.setText(" ");
		} else {
			tfProfessor.setText(subject.getSubjectProfessor().getName()+" "+subject.getSubjectProfessor().getSurname());
		}
		tfProfessor.setEnabled(false);
		
		quit = new JButton("Odustani");
		confirm = new JButton("Potvrdi");
		
		plus = new JButton("+");
		minus = new JButton("-");
		
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
		
		pnlContent.add(lblProfessor, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(tfProfessor, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		pnlContent.add(plus, new GridBagConstraints(2, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		pnlContent.add(minus, new GridBagConstraints(3, 5, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
		pnlContent.add(confirm, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(40, 0, 0, 0), 0, 0));
		pnlContent.add(quit, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(40, 40, 0, 40), 0, 0));
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

				SubjectController.getInstance().editSubject(MainFrame.getInstance().getSubjectTable().getSelectedRow(),tfSubjectName.getText(), tfSubjectName.getText() ,sem, year, Integer.parseInt(tfEspb.getText()));
				dispose();
			}

		});

	}
    
    private void inputCheck() {
		
		if((Pattern.matches("[A-Za-z0-9]+",tfSubjectCode.getText())) &&
		   (Pattern.matches("[A-Za-z\\s*0-9]+",tfSubjectName.getText())) &&
		   (Pattern.matches("[1-9]{1,2}",tfEspb.getText())))
		   {
			confirm.setEnabled(true);
		} else {
			confirm.setEnabled(false);
		}
		
		if((SubjectDatabase.getInstance().findByCode2(tfSubjectCode.getText())) && !(tfSubjectCode.getText().equals(subject.getSubjectCode()))) {
			confirm.setEnabled(false);
		}
		   
	}

}
