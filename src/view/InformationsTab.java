package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.AbstractTableModelFailed;
import gui.MainFrame;
import model.Adress;
import model.Grade;
import model.Student;
import model.StudentsDatabase;
import model.Subject;
import model.Student.Status;
import controller.StudentController;

public class InformationsTab extends JPanel {

	private JPanel pnl;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblSurname;
	private JTextField tfSurname;
	private JLabel lblBirthDate;
	private JTextField tfBirthDate;
	private JLabel lblStreet;
	private JTextField tfStreet;
	private JLabel lblNr;
	private JTextField tfNr;
	private JLabel lblCity;
	private JTextField tfCity;
	private JLabel lblState;
	private JTextField tfState;
	private JLabel lblPhone;
	private JTextField tfPhone;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblIndex;
	private JTextField tfIndex;
	private JLabel lblEnroll;
	private JTextField tfEnroll;
	private JLabel lblCurrent;
	private String[] years = {"I(prva)","II(druga)","III(treća)","IV(četvrta)"};
	private JComboBox cbCurrent;
	private JLabel lblStatus;
	private String[] status = {"Budžet","Samofinansiranje"};
	private JComboBox cbStatus;
	private JButton confirm;
	private JButton quit;
	private JPanel bPnl;
	private Student student;
	
	public InformationsTab(int row, JDialog parent) {
	
		student = StudentsDatabase.getInstance().getRow(row);
		
		
		initGui();
		constructGui();
		buttonActions(parent);
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());

		pnl = new JPanel(new GridBagLayout());
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		tfName.setText(student.getName());
		tfName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			
		}});
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		tfSurname.setText(student.getSurname());
		tfSurname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
					inputCheck();	
			}
		});
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		tfBirthDate.setText(new SimpleDateFormat("dd.mm.yyyy.").format(student.getBirthDate()));
		tfBirthDate.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		lblStreet = new JLabel("Ulica");
		tfStreet = new JTextField(20);
		tfStreet.setText(student.getAdress().getStreet());
		tfStreet.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			}
			
		});
		
		lblNr = new JLabel("Broj");
		tfNr = new JTextField(20);
		tfNr.setText(student.getAdress().getNr());
		tfNr.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			}
			
		});
		
		lblCity = new JLabel("Grad");
		tfCity = new JTextField(20);
		tfCity.setText(student.getAdress().getCity());
		tfCity.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			}
			
		});
		
		lblState = new JLabel("Drzava");
		tfState = new JTextField(20);
		tfState.setText(student.getAdress().getState());
		tfState.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			}
			
		});
		
		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		tfPhone.setText(student.getPhoneNr());
		tfPhone.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		tfEmail.setText(student.getEmail());
		tfEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
			}
			
		});
		
		lblIndex = new JLabel("Broj indeksa*");
		tfIndex = new JTextField(20);
		tfIndex.setText(student.getIndex());
		tfIndex.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				if((StudentsDatabase.getInstance().findById(tfIndex.getText())) && !(tfIndex.getText().equals(student.getIndex()))) {
					JOptionPane.showMessageDialog(null, "Postoji student sa unetim indeksom.");
				}
			}
			
		});
		
		lblEnroll = new JLabel("Godina upisa*");
		tfEnroll = new JTextField(20);
		tfEnroll.setText(Integer.toString(student.getEnrollYear()));
		tfEnroll.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				inputCheck();
				
			}
			
		});
		
		lblCurrent = new JLabel("Trenutna godina studija*");
		String currYear;
		if(student.getCurrentYear() == 1){
			currYear = years[0];
		} else if(student.getCurrentYear() == 2) {
			currYear = years[1];
		}  else if(student.getCurrentYear() == 3) {
			currYear = years[2];
		} else {
			currYear = years[3];
		}
		cbCurrent = new JComboBox(years);
		cbCurrent.setSelectedItem(currYear.toString());
		
		
		lblStatus = new JLabel("Način finansiranja*");
		String stat;
		if(student.getStatus() == Status.B) {
			stat = "Budžet";
		} else {
			stat = "Samofinansiranje";
		}
		cbStatus = new JComboBox(status);
		cbStatus.setSelectedItem(stat);
		
		confirm = new JButton("Potvrdi");
		quit = new JButton("Odustani");
		
		bPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
	}

	private void constructGui() {
	
		pnl.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblSurname, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfSurname, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblBirthDate, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfBirthDate, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblStreet, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfStreet, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
			
			pnl.add(lblNr, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
			
			pnl.add(tfNr, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
			
			pnl.add(lblCity, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
				
			pnl.add(tfCity, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
			
			pnl.add(lblState, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
					
			pnl.add(tfState, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblPhone, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfPhone, new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblEmail, new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfEmail, new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblIndex, new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfIndex, new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblEnroll, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(tfEnroll, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblCurrent, new GridBagConstraints(0, 11, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(cbCurrent, new GridBagConstraints(1, 11, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			pnl.add(lblStatus, new GridBagConstraints(0, 12, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 0, 0, 0), 0, 0));
		
			pnl.add(cbStatus, new GridBagConstraints(1, 12, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 0, 0));
		
			bPnl.add(confirm);
			bPnl.add(quit);
			add(pnl, BorderLayout.CENTER);
			add(bPnl, BorderLayout.SOUTH);
	}
	
	private void buttonActions(JDialog parent) {
		
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();	
			}
		});
		
		
		confirm.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					
					Status status;
					if(cbStatus.getSelectedItem().toString().equals("Budžet")) {
						status = Status.B;
					} else {
						status = Status.S;
					}
					
					int currYear;
					if(cbCurrent.getSelectedItem().equals("I(prva)")){
						currYear = 1;
					} else if(cbCurrent.getSelectedItem().equals("II(druga)")) {
						currYear = 2;
					} else if(cbCurrent.getSelectedItem().equals("III(treća)")) {
						currYear = 3;
					} else {
						currYear = 4;
					}
					
				try {	
					StudentController.getInstance().editStudent(MainFrame.getInstance().getStudentTable().getSelectedRow(), tfName.getText(), tfSurname.getText(), new SimpleDateFormat("dd.mm.yyyy.").parse(tfBirthDate.getText()), new Adress(tfStreet.getText(),tfNr.getText(),tfCity.getText(),tfState.getText()) , tfPhone.getText(), tfEmail.getText(), tfIndex.getText(), Integer.parseInt(tfEnroll.getText()), currYear, status, new ArrayList<Grade>(), new ArrayList<Subject>()); 
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				parent.dispose();	
			}
			
		});
				
	}
	
	private void inputCheck() {
		
		if((Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+",tfName.getText())) &&
				   (Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+",tfSurname.getText())) &&
				   (Pattern.matches("(3[01]|[12][0-9]|0[1-9]).^(1[0-2]|0[1-9]).[0-9]{4}.$", tfBirthDate.getText())) &&
				   (Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+", tfStreet.getText())) &&
				   (Pattern.matches("[0-9]+[a-z]{0,1}", tfNr.getText())) &&
				   (Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+", tfCity.getText())) &&
				   (Pattern.matches("[A-Za-zĐđŠšČčĆćŽž\\s]+", tfState.getText())) && 
				   (Pattern.matches("0{1}[1-9]{2}/[0-9]{3,4}-[0-9]{3,4}",tfPhone.getText())) &&
				   (Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", tfEmail.getText())) &&
				   (Pattern.matches("[A-za-z]{1,3}-[0-9]{1,4}-[0-9]{4}", tfIndex.getText())) &&
				   (!StudentsDatabase.getInstance().findById(tfIndex.getText())) &&
				   (Pattern.matches("20[0-9]{2}", tfEnroll.getText()))) {
					confirm.setEnabled(true);
				} else {
					confirm.setEnabled(false);
				}
		
		if((StudentsDatabase.getInstance().findById(tfIndex.getText())) && !(tfIndex.getText().equals(student.getIndex()))) {
			confirm.setEnabled(false);
		}
		
		
	}
	
	
}
