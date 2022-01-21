package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.ResourceBundleController;

public class StatusBar extends JPanel implements ActionListener{

	private JLabel fName;
	private JLabel time;
	private JLabel tName;
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm     dd.MM.yyyy.");
	
	public StatusBar() {
		super();
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		fName = new JLabel("Studentska Sluzba");
		this.add(fName);
		this.add(Box.createHorizontalStrut(10));
	}
	
	public StatusBar(String tableName) {
		super();
		setBorder(BorderFactory.createEtchedBorder());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		fName = new JLabel(ResourceBundleController.getInstance().getResourceBundle().getString("title"));
		this.add(fName);
		this.add(Box.createHorizontalStrut(10));
		tName = new JLabel(tableName);
		this.add(tName);
		this.add(Box.createHorizontalStrut(920));
		
		//https://coderanch.com/t/331575/java/Display-time-date-status-bar
		time = new JLabel(sdf.format(new GregorianCalendar().getTime()));
		Timer timer = new Timer(1000, this);
		timer.start();
		this.add(time);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		time.setText(sdf.format(new GregorianCalendar().getTime()));
	}
	
	public void changeLanguage() {
		if(MainFrame.getInstance().getTabs().getSelectedIndex()==0) {
			tName.setName(ResourceBundleController.getInstance().getResourceBundle().getString("studentsTable"));
		} else if(MainFrame.getInstance().getTabs().getSelectedIndex()==1) {
			tName.setName(ResourceBundleController.getInstance().getResourceBundle().getString("professorsTable"));
		} else if(MainFrame.getInstance().getTabs().getSelectedIndex()==2) {
			tName.setName(ResourceBundleController.getInstance().getResourceBundle().getString("subjectsTable"));
		}
		fName.setName((ResourceBundleController.getInstance().getResourceBundle().getString("title")));
	}
}
