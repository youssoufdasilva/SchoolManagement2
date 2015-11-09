/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Migaliza
 */
public class SubjectTableModel extends AbstractTableModel {
     ArrayList<SUBJECT> data;
    static  SubjectTableModel theModel=null;
    String[] columnNames={"SUBJECT CODE","SUBJECT NAME","DEPARTMENT"};
    final static int SUBJECTCODE=0;
    final static int SUBJECTNAME=1;
    final static int DEPARTMENT=2;
   
    
    public SubjectTableModel(){
        data=new ArrayList<SUBJECT>();
    }
    
    public static SubjectTableModel getInstance(){
        if(theModel==null)
            theModel=new SubjectTableModel();
        return theModel;
    }
    
    //colum count
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    //row count
    @Override
    public int getColumnCount() {        
        return columnNames.length; //we know student has 4 fields
    }
    /*
    function to fix what goes into each column
    */
    @Override
     public Object getValueAt(int row, int col) {
        SUBJECT s= data.get(row);
        
        Object cellData=null;
        switch (col){
            case SUBJECTCODE: 
                cellData= s.subjectCode;
                break;
            case SUBJECTNAME: 
                cellData=s.subjectName;
                break;
            case DEPARTMENT: 
                cellData= s.department;
                break;
        }
        return cellData;
     
    }
     /*this is based on the functions by DR. Nathan Amanquqh*/
      @Override
    public String getColumnName(int col) {
        return columnNames[col];//otherwise returns A, B, C etc
    }
    //overide this to allow editing of some columns/rows

    @Override
    /*
    public boolean isCellEditable(int row, int col) {
        if ((col == MAJOR)||(col==MARK)||(col==LETTERGRADE)) { 
            return true;
        }
	else 
	return false;
    }*/
        
    // uses this to determine the default renderer or 
    // editor for each cell. 
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
   
    //implement this to be able to alter your table data from UI!
    //without this, all edits are discarded.
    @Override
    public void setValueAt(Object value, int row, int col) {
        SUBJECT s;
        s=data.get(row);
        switch(col){
            case SUBJECTCODE: 
                s.subjectCode=(String)value;
                break;
            case SUBJECTNAME: 
                s.subjectName=(String)value;
                break;
            case DEPARTMENT: 
                s.department=(String)value;
                break;
            
        }
        
	
        fireTableCellUpdated(row, col); //*works best with this

    }
    
   
    
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(SUBJECT s){
        data.add(s);        
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<SUBJECT> getList(){
        return data;
    }
}
