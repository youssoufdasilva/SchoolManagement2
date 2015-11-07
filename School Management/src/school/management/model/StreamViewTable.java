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
public class StreamViewTable extends AbstractTableModel{
    ArrayList<Stream> data;
    static  StreamViewTable theModel = null;
    String[] columnNames = {"STREAN ID","STREAN NAME"};
    final static int STREAMID=0;
    final static int STREAMNAME=1;

    public StreamViewTable(){
        data = new ArrayList<Stream>();
    }

    public static StreamViewTable getInstance(){
        if(theModel == null)
            theModel = new StreamViewTable();
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
        return columnNames.length; //we know stream has 2 fields
    }
    /*
    function to fix what goes into each column
    */
    @Override
     public Object getValueAt(int row, int col) {
        Stream str = data.get(row);

        Object cellData = null;
        switch (col){
            case STREAMID:
                cellData = str.streamId;
                break;
            case STREAMNAME:
                cellData = str.streamName;
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
    public Stream getColumnStream(int c) {
        return getValueAt(0, c).getStream();
    }

    //implement this to be able to alter your table data from UI!
    //without this, all edits are discarded.
    @Override
    public void setValueAt(Object value, int row, int col) {
        Stream str;
        str = data.get(row);
        switch (col){
            case STREAMID:
                cellData = (String) str.streamId;
                break;
            case STREAMNAME:
                cellData = (String) str.streamName;
                break;
        }

        fireTableCellUpdated(row, col); //*works best with this

    }

    /*
    Method to save to database
    */

    public static void saveToDataBase(String query){
        try{
            Connection connect = ConnectToDatabase.getConnection();
            Statement statm = connect.createStatement();
            statm.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //my own function to add to model
    //this could have received the raw data as four params and added.
    public void addToModel(Stream str){
        data.add(str);
        fireTableRowsInserted(0, 0);
    }
    public ArrayList<Stream> getList(){
        return data;
    }
}
