/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import school.management.model.MajorComboboxModel;
import school.management.model.MyTableModel;
import school.management.model.Student;
import school.management.view.AddNewStudent;
import school.management.view.TableView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.TableColumn;

/**
 *
 * @author namanquah
 */
public class TableViewController implements ActionListener{
    TableView tableView;
    MyTableModel myTableModel;
    ActionListener actionListener;
    
    public TableViewController(TableView tableView,MyTableModel myTableModel ){
        this.tableView= tableView;
        this.myTableModel=myTableModel;  
        tableView.getTable().setModel(myTableModel);
    }
    
    //this illustrates how both approaches for event handling are accomplished
    public void control(){ 
        tableView.getAddButton().addActionListener(this);
        tableView.getDetailButton().addActionListener(this);
        tableView.getPrintButton().addActionListener(this);
        ChangeMajorColumnEditor();
        //this uses an anonymous class to handle one of the buttons
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                  
                  System.exit(0);
              }
        };                
        tableView.getExitButton().addActionListener(actionListener);   
        
        //make the table use a combo in the view
        
        tableView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //following method wont work if btn text is changed.
        if (ae.getActionCommand().equals("Add")){
            MyTableModel m=MyTableModel.getInstance();
            AddNewStudent v= new AddNewStudent(null, true);            
            AddNewFormController cntroller= new AddNewFormController(m, v);            
            cntroller.control();            
            v.setVisible(true);
            
        }
        if (ae.getActionCommand().equals("Print")){
            //poorly written fxn. type conversions shd be in model
            Object [] tmp=myTableModel.getList().toArray();
            Student s;
            for (int i = 0; i < tmp.length; i++) {
                
                s=(Student)tmp[i];
                System.out.println(s.toString());                
            }
        }
        //comparing with the actual btn
        if (ae.getSource()== tableView.getDetailButton()){
            
        }
        
    }
    
    
    
    //method to change default editor for column 0 (first names)
    public void ChangeMajorColumnEditor(){
        TableColumn MajorCol = tableView.getTable().getColumnModel().getColumn(2);
        Vector v= new MajorComboboxModel().getData();
        JComboBox MyComboEditor = new JComboBox(v);
        MajorCol.setCellEditor(new DefaultCellEditor(MyComboEditor));
    }
}
