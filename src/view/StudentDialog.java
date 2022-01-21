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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.StudentController;
import model.Adress;
import model.Grade;
import model.StudentsDatabase;
import model.Student.Status;
import model.Subject;


public class StudentDialog extends JDialog {
	
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
	
	public StudentDialog() {}
	
	public StudentDialog(JFrame parent, String title, boolean modal) {
		
		super(parent, title, modal);
		setSize(650,650);
		setLocationRelativeTo(parent);
		setTitle(title);
		initGui();
		constructGui();
		buttonActions();
		
	}
	
	private void initGui() {
		
		setLayout(new BorderLayout());

		pnl = new JPanel(new GridBagLayout());
		confirm = new JButton("Potvrdi");
		quit = new JButton("Odustani");
		confirm.setEnabled(false);
		
		lblName = new JLabel("Ime*");
		tfName = new JTextField(20);
		tfName.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-Za-zČčĆćŽžĐđŠš]+",tfName.getText()))) {
					confirm.setEnabled(true);
				} else {
					confirm.setEnabled(false);
				}
						  
			}
			
		});
		
		
		lblSurname = new JLabel("Prezime*");
		tfSurname = new JTextField(20);
		tfSurname.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-Za-zČčĆćŽžĐđŠš]+",tfSurname.getText()))) {
					confirm.setEnabled(true);
					
				}else {
					confirm.setEnabled(false);
				}
				
			}
			
		});
		
		lblBirthDate = new JLabel("Datum rođenja*");
		tfBirthDate = new JTextField(20);
		tfBirthDate.setToolTipText("dd.mm.yyyy.");
		tfBirthDate.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("(3[01]|1[0-9]|0[1-9]|2[0-9]).(1[0-2]|0[1-9]).[0-9]{4}.$", tfBirthDate.getText()))) {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblStreet = new JLabel("Ulica");
		tfStreet = new JTextField(20);
		tfStreet.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-Za-zĆćČčŠšĐđŽž\\s]+", tfStreet.getText())))
						   {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblNr = new JLabel("Broj");
		tfNr = new JTextField(20);
		tfNr.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[0-9]+[a-z]{0,1}", tfNr.getText())))
						   {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblCity = new JLabel("Grad");
		tfCity = new JTextField(20);
		tfCity.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-Za-zĆćČčŠšĐđŽž\\s]+", tfCity.getText())))
						    {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblState = new JLabel("Država");
		tfState = new JTextField(20);
		tfState.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-Za-zĆćČčŠšĐđŽž\\s]+", tfState.getText())))
						    {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});

		lblPhone = new JLabel("Broj telefona*");
		tfPhone = new JTextField(20);
		tfPhone.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("0{1}[1-9]{2}/[0-9]{3,4}-[0-9]{3,4}",tfPhone.getText()))) {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblEmail = new JLabel("E-mail adresa*");
		tfEmail = new JTextField(20);
		tfEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", tfEmail.getText()))) {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblIndex = new JLabel("Broj indeksa*");
		tfIndex = new JTextField(20);
		tfIndex.setToolTipText("sm-nn-yyyy, sm-skraćenica naziva smera");
		tfIndex.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("[A-za-z]{1,3}\\s[0-9]{1,4}/[0-9]{4}", tfIndex.getText()))) {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
				if((StudentsDatabase.getInstance().findById(tfIndex.getText()))) {
					confirm.setEnabled(false);
				}
				
			}
			
		});
		
		lblEnroll = new JLabel("Godina upisa*");
		tfEnroll = new JTextField(20);
		tfEnroll.setToolTipText("yyyy");
		tfEnroll.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if((Pattern.matches("20[0-9]{2}", tfEnroll.getText()))) {
							confirm.setEnabled(true);
						} else {
							confirm.setEnabled(false);
						}
				
			}
			
		});
		
		lblCurrent = new JLabel("Trenutna godina studija*");
		cbCurrent = new JComboBox(years);
		
		lblStatus = new JLabel("Način finansiranja*");
		cbStatus = new JComboBox(status);
		
		
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
					 StudentController.getInstance().addStudent(tfName.getText(), tfSurname.getText(), new SimpleDateFormat("dd.mm.yyyy.").parse(tfBirthDate.getText()), new Adress(tfStreet.getText(),tfNr.getText(),tfCity.getText(),tfState.getText()) , tfPhone.getText(), tfEmail.getText(), tfIndex.getText(), Integer.parseInt(tfEnroll.getText()), currYear, status, new ArrayList<Grade>(), new ArrayList<Subject>());
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				dispose();	
				}
			});			
		}
	
	
	private void inputCheck() {
		
		if((Pattern.matches("[A-Za-zČčĆćŽžĐđŠš\\s]+",tfName.getText())) &&
		   (Pattern.matches("[A-Za-zČčĆćŽžĐđŠš]+",tfSurname.getText())) &&
		   (Pattern.matches("(3[01]|1[0-9]|0[1-9]|2[0-9]).(1[0-2]|0[1-9]).[0-9]{4}.$", tfBirthDate.getText())) &&
		   (Pattern.matches("[A-Za-zČčĆćŽžĐđŠš\\s]+", tfStreet.getText())) &&
		   (Pattern.matches("[0-9]+[a-z]{1}", tfNr.getText())) &&
		   (Pattern.matches("[A-Za-zČčĆćŽžĐđŠš\\s]+", tfCity.getText())) &&
		   (Pattern.matches("[A-Za-zČčĆćŽžĐđŠš\\s]+", tfState.getText())) && 
		   (Pattern.matches("0{1}[1-9]{2}/[0-9]{3,4}-[0-9]{3,4}",tfPhone.getText())) &&
		   (Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", tfEmail.getText())) &&
		   (Pattern.matches("[A-Za-z]{1,3}\\s[0-9]{1,4}/[0-9]{4}", tfIndex.getText())) &&
		   (!StudentsDatabase.getInstance().findById(tfIndex.getText())) &&
		   (Pattern.matches("20[0-9]{2}", tfEnroll.getText()))) {
			confirm.setEnabled(true);
		} else {
			confirm.setEnabled(false);
		}
		   
	}
	
}
