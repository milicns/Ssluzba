package gui;


/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import gui.TabbedPane;

import tables.AbstractTableProfessor;
import tables.AbstractTableSubject;
import tables.TableProfessor;
import tables.TableSubject;

//public class TabbedPane extends JTabbedPane{
	
	
	//private static final long serialVersionUID = 1L;
	
//private static int selectedIndex1=0;
	
//public static int getSelectedIndex1() {
	//    System.out.println(String.valueOf(selectedIndex1));
		//return selectedIndex1;
	//}
	
private static TabbedPane instance=null;

    public static TabbedPane getInstance() {
        if (instance == null) {
            instance = new TabbedPane();
        }
        return instance;
    }
   
    private JTable TableProfessors;
    private JTable TableSubject;
    private JTable studentsTable;
    private TabbedPane() {

    	studentsTable = new StudentsJTable();
        JScrollPane sp = new JScrollPane(studentsTable);
        TableProfessors = new TableProfessor();
        JScrollPane sp2 = new JScrollPane(TableProfessors);
        TableSubject = new TableSubject();
        JScrollPane sp3 = new JScrollPane(TableSubject);
    	
        add("Studenti",sp);
        add("Profesori",sp2);
        add("Predmeti",sp3);
        setVisible(true);
    }

    
    public void refreshProfessors(String akcija, int vrednost) {
    	AbstractTableProfessor model = (AbstractTableProfessor) TableProfessors.getModel();

         model.fireTableDataChanged();
         validate();
     }
    
    public void refreshSubject(String akcija, int vrednost) {
    	AbstractTableSubject model = (AbstractTableSubject) TableSubject.getModel();

        model.fireTableDataChanged();
        validate();
    }
    

	public void refreshStudents() {
		AbstractTableModelStudents model = (AbstractTableModelStudents) studentsTable.getModel();
		
		model.fireTableDataChanged();
		validate();
	}
	
	
	public JTable getStudentTable() {
		return studentsTable;
	}
}
  /*public void showTableProfessors() throws ParseException {

	   TableProfessors  = new TableProfessor();

         JScrollPane scrollPane = new JScrollPane(TableProfessors);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         prof.add(scrollPane, BorderLayout.CENTER);


         this.refreshProfessors(null, -1);
     }
  
     
   private void showTableSubjects() throws ParseException {

	   TableSubject  = new TableSubject();

         JScrollPane scrollPane = new JScrollPane( TableSubject);
         scrollPane.setPreferredSize(new Dimension(w-200,h-200));
         sub.add(scrollPane, BorderLayout.CENTER);


         this.refreshSubject(null, -1);
     }



   public JTable getTableSubject() {
	   return TableSubject;
   }
   
   public void setTableSubject(JTable tableSubject) {
	   this.TableSubject = tableSubject;
   }



   public JTable getTableProfessors() {
	   return TableProfessors;
   }
   
   public void setTableProfessors(JTable tableProfessors) {
	   this.TableProfessors = tableProfessors;
   }
   	

}
    
*/ 
	
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane{
	
	public TabbedPane() {
		super();
	}
	
}


