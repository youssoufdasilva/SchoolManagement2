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
public class gradeTableModel extends AbstractTableModel {
    ArrayList<GradeTable> data;
    static  gradeTableModel theModel=null;
    String[] columnNames={"YEAR GROUP","STREAM","STUDENT ID","FIRST NAME ","LASTNAME","MATH","SCIENCE","ENGLISH","TECHNOLOGY","AVERAGE","MEAN GRADE"};
    final static int YEARGROUP=0;
    final static int STREAM=1;
    final static int STUDENTID=2;
    final static int FIRSTNAME=3;
    final static int LASTNAME=4;
    final static int MATH=5;
    final static int SCIENCE=6;
    final static int ENGLISH=7;
    final static int TECHNOLOGY=8;
    final static int AVERAGE=9;
    final static int GRADE=10;
    
    public gradeTableModel(){
        data=new ArrayList<GradeTable>();
    }
    
    public static gradeTableModel getInstance(){
        if(theModel==null)
            theModel=new gradeTableModel();
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
        GradeTable g= data.get(row);
        
        Object cellData=null;
        switch (col){
            case YEARGROUP: 
                cellData= g.yearGroup;
                break;
            case STREAM: 
                cellData=g.stream;
                break;
            case STUDENTID: 
                cellData= g.StudentId;
                break;
            case FIRSTNAME:
                cellData= g.firstName;
                break;
            case LASTNAME:
                cellData= g.lastName;
                break;
            case MATH:
                cellData= g.Math;
                break;
            case SCIENCE:
                cellData= g.science;
                break;
            case ENGLISH:
                cellData= g.english;
                break;
            case TECHNOLOGY:
                cellData= g.technology;
                break;
            case AVERAGE:
                cellData= g.average;
                break;
            case GRADE:
                cellData= g.Grade;
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
        GradeTable g;
        g=data.get(row);
        switch(col){
            case YEARGROUP: 
                g.yearGroup=(String)value;
                break;
            case STREAM: 
                g.stream=(String)value;
                break;
            case STUDENTID: 
                g.StudentId=(String)value;
                break;
            case FIRSTNAME: 
                g.firstName=(String)value;;
                break;
            case LASTNAME: 
                g.lastName=(String)value;
                break;
            case MATH: 
                g.Math=Integer.valueOf((Integer)value);
                break;
            case SCIENCE: 
                g.science=Integer.valueOf((Integer)value);
                break;
            case ENGLISH: 
                g.english=Integer.valueOf((Integer)value);
                break;
            case TECHNOLOGY: 
                g.technology=Integer.valueOf((Integer)value);
                break;
            case AVERAGE: 
                g.average=Integer.valueOf((Integer)value);
                break;    
            case GRADE: 
                g.Grade=(String)value;
                break;    
            
        }
        
	
        fireTableCellUpdated(row, col); //*works best with this

    }
    
   
    
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(GradeTable g){
        data.add(g);        
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<GradeTable> getList(){
        return data;
    }
}
