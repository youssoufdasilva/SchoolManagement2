/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;

import java.util.Date;
import javax.swing.table.AbstractTableModel;
import java.sql.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Migaliza
 */
public class StudentViewTable extends AbstractTableModel{
    ArrayList<Student> data;
    static  StudentViewTable theModel=null;
    String[] columnNames={"STUDENT ID","FIRST NAME","SURNAME","DATE OF BIRTH","AGE","NATIONALITY","YEAR GROUP"};
    final static int STUDENTID=0;
    final static int FIRSTNAME=1;
    final static int SURNAME=2;
    final static int DATEOFBIRTH=3;
    final static int AGE=4;
    final static int NATIONALITY=5;
    final static int YEARGROUP=6;
    
    public StudentViewTable(){
        data=new ArrayList<Student>();
    }
    
    public static StudentViewTable getInstance(){
        if(theModel==null)
            theModel=new StudentViewTable();
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
        Student s= data.get(row);
        
        Object cellData=null;
        switch (col){
            case STUDENTID: 
                cellData= s.studentId;
                break;
            case FIRSTNAME: 
                cellData=s.firstName;
                break;
            case SURNAME: 
                cellData= s.lastName;
                break;
            case DATEOFBIRTH:
                cellData= s.dateOfBirth;
                break;
            case AGE:
                cellData= s.age;
                break;
            case NATIONALITY:
                cellData= s.nationality;
                break;
            case YEARGROUP:
                cellData= s.yearGroup;
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
        Student s;
        s=data.get(row);
        switch(col){
            case STUDENTID: 
                s.studentId=(String)value;
                break;
            case FIRSTNAME: 
                s.firstName=(String)value;
                break;
            case SURNAME: 
                s.lastName=(String)value;
                break;
            case DATEOFBIRTH: 
                s.dateOfBirth=(Date)value;;
                break;
            case AGE: 
                s.age=Integer.valueOf((Integer)value);
                break;
            case NATIONALITY: 
                s.nationality=(String)value;
                break;
            case YEARGROUP: 
                s.yearGroup=(String)value;
                break;
        }
        
	
        fireTableCellUpdated(row, col); //*works best with this

    }
    
   
    
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(Student s){
        data.add(s);        
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<Student> getList(){
        return data;
    }
}
