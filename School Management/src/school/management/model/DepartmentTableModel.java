/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Migaliza
 */
public class DepartmentTableModel extends AbstractTableModel {
     ArrayList<Department> data;
    static  DepartmentTableModel theModel=null;
    String[] columnNames={"DEPARTMENT ID","DEPARTMENT NAME"};
    final static int DEPARTMENTID=0;
    final static int DEPARTMENTNAME=1;

   
    
    public DepartmentTableModel(){
        data=new ArrayList<Department>();
    }
    
    public static DepartmentTableModel getInstance(){
        if(theModel==null)
            theModel=new DepartmentTableModel();
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
        Department d= data.get(row);
        
        Object cellData=null;
        switch (col){
            case DEPARTMENTID: 
                cellData= d.departmentId;
                break;
            case DEPARTMENTNAME: 
                cellData=d.departmentName;
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
        Department d;
        d=data.get(row);
        switch(col){
            case DEPARTMENTID: 
                d.departmentId=(String)value;
                break;
            case DEPARTMENTNAME: 
                d.departmentName=(String)value;
                break;

            
        }
        
	
        fireTableCellUpdated(row, col); //*works best with this

    }
    
   
    
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(Department d){
        data.add(d);        
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<Department> getList(){
        return data;
    }
}
