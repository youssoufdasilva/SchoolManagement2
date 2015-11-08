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
 * @author Youssouf
 */
public class StaffViewTable extends AbstractTableModel{
    ArrayList<Staff> data;
    static  StaffViewTable theModel=null;
    String[] columnNames={"STAFF ID","FIRST NAME","LAST NAME","DATE OF BIRTH","HIRED DATE","DEPARTMENT"};
    final static int STAFFID=0;
    final static int FIRSTNAME=1;
    final static int LASTNAME=2;
    final static int DATEOFBIRTH=3;
    final static int HIREDDATE=4;
    final static int DEPARTMENT=6;

    public StaffViewTable(){
        data=new ArrayList<Staff>();
    }

    public static StaffViewTable getInstance(){
        if(theModel==null)
            theModel=new StaffViewTable();
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
        return columnNames.length; //we know Staff has 4 fields
    }
    /*
    function to fix what goes into each column
    */
    @Override
     public Object getValueAt(int row, int col) {
        Staff s= data.get(row);

        Object cellData = null;
        switch (col){
            case STAFFID:
                cellData= s.staffId;
                break;
            case FIRSTNAME:
                cellData=s.firstName;
                break;
            case LASTNAME:
                cellData= s.lastName;
                break;
            case DATEOFBIRTH:
                cellData= s.dateOfBirth;
                break;
            case HIREDDATE:
                cellData= s.hiredDate;
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
        Staff s;
        s=data.get(row);
        Object cellData = null;
        switch (col){
            case STAFFID:
                cellData= s.staffId;
                break;
            case FIRSTNAME:
                cellData=s.firstName;
                break;
            case LASTNAME:
                cellData= s.lastName;
                break;
            case DATEOFBIRTH:
                cellData= s.dateOfBirth;
                break;
            case HIREDDATE:
                cellData= s.hiredDate;
                break;
            case DEPARTMENT:
                cellData= s.department;
                break;
        }


        fireTableCellUpdated(row, col); //*works best with this

    }

    /*
    Method to save to database
    */

    public static void saveToDataBase(String query){
        try{
            //Connection connect = ConnectToDatabase.getConnection();
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/cdcol?user=root&password=");
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(Staff s){
        data.add(s);
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<Staff> getList(){
        return data;
    }
}
