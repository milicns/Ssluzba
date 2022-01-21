package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;




import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import controller.ProfessorController;
import model.Adress;
import model.Professor;

public class ProfessorView extends JPanel{
	
private static final long serialVersionUID = 1L;
	
	private static ProfessorView instance = null;

	public static ProfessorView getInstance() {
		if (instance == null) {
			instance = new ProfessorView();
		}
		return instance;
	}
	private Professor professor;
	private ProfessorController professorsController;
	
	private JPanel pnlContent;
	private JLabel lblSurname;
	private JTextField tfSurname;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblBirthDate;
	private JTextField tfBirthDate;
	private JLabel lblAdress;
	private JTextField tfAdress;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblOffAdress;
	private JTextField tfOffAdress;
	private JLabel lblIdNumber;
	private JTextField tfIdNumber;
	private JLabel lblTitle;
	private JComboBox<String> cbTitle;
	private JLabel lblinternshipYears;
	private JTextField tflinternshipYears;
	private JComboBox<String> cbinternshipYears;
	private JButton confirm;
	private JButton quit;
	private JPanel pnlButton;
	
	
	
	public ProfessorView()
	{
		initGUI();
		constructGUI();
	}





	private void initGUI() {
		// TODO Auto-generated method stub
		
		
		
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		
		
		
		
		lblBirthDate = new JLabel("Datum roÄ‘enja*");
		tfBirthDate = new JTextField(20);
		
	   
		lblAdress = new JLabel("Adresa stanovanja*");
		tfAdress = new JTextField(20);
		
		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		
		
		lblOffAdress = new JLabel("Adresa kancelarije*");
		tfOffAdress = new JTextField(20);
		
		

		
		lblIdNumber = new JLabel("Broj liÄ�ne karte*");
		tfIdNumber = new JTextField(20);
		
		
		lblTitle = new JLabel("Titula*");
		String[] TitleStrings = {"Mr","Dr","Prof"};  
		cbTitle = new JComboBox<String>(TitleStrings);
		
		
		
		lblinternshipYears = new JLabel("Godine staza*");
		tflinternshipYears = new JTextField(20);
		
		
		
		

		
		quit = new JButton("Odustani");
		confirm = new JButton("Potvrdi");
		
		pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		
	}
	
	

	private void constructGUI() {
		// TODO Auto-generated method stub
		
		
		pnlContent.add(lblSurname, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfSurname, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblName, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfName, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblBirthDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfBirthDate, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblAdress, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfAdress, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblPhone, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfPhone, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblEmail, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfEmail, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblOffAdress, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfOffAdress, new GridBagConstraints(1, 6, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblIdNumber, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfIdNumber, new GridBagConstraints(1, 7, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblTitle, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(cbTitle, new GridBagConstraints(1, 8, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblinternshipYears, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tflinternshipYears, new GridBagConstraints(1, 9, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(confirm, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(quit, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		add(pnlContent, BorderLayout.CENTER);
		add(pnlButton, BorderLayout.SOUTH);
		
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
		professorsController = null;
		refreshView();
	}

	public void refreshView() {
		
		tfSurname.setText(professor.getSurname());
		tfName.setText(professor.getName());
		String timePattern = "dd.MM.yyyy.";
		DateFormat df = new SimpleDateFormat(timePattern);
		tfBirthDate.setText(df.format(professor.getBirthDate()));
		String adressPattern = "[0-9A-Z.,-/ ]";
	//	AdressFormat af = new SimpleAdressFormat(adressPattern);
		//tfAdress.setText(Adress.toString(professor.getAdress());  ////Kako aadresu da pretvorim >? ? ?  ??  !!!!!!!!!!!!!
		tfPhone.setText(professor.getPhoneNr());
		tfEmail.setText(professor.getEmail());
		//tfOffAdress.setText(Adress.toString(professor.getOfficeAdress()));  ////kako adresu da pretvorim ? ? ? ?  !!!!!!!!!!!!!!!!!!!!!!!!!!
		tfIdNumber.setText((Integer.toString(professor.getIdNumber())));


		
		
		switch(String.valueOf(professor.getTitle())){
		case "MR":
			cbTitle.setSelectedIndex(0);
			break;
		case  "DR":
			cbTitle.setSelectedIndex(1);
			break;
		case "PROF":
			cbTitle.setSelectedIndex(2);
			break;
		
		}
		
		
		}
		
		
	

}
