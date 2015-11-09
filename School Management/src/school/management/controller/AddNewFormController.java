/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.youssouf.mvc.controllers;

import com.youssouf.mvc.models.MyTableModel;
import com.youssouf.mvc.models.Student;
import com.youssouf.mvc.views.AddNewStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author namanquah
 */
public class AddNewFormController implements ActionListener{
    
    AddNewStudent view; 
    MyTableModel model;
    //I have not been consistent in view & model naming. 
    //should be addNewForm etc.
    public AddNewFormController(MyTableModel myTableModel, AddNewStudent addNewStudent) {
        view = addNewStudent;
        model = myTableModel;        
    }
    public void control(){
        view.getAddButton().addActionListener(this);
        view.getCloseButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {            
        if (ae.getSource()==view.getCloseButton() )
        {               
            view.dispose();
        }
        if (ae.getActionCommand().equalsIgnoreCase("Add"))
        {            
            //fetch the data into a student.
            //I can have a separate fxn in the model to simply receive
            //the individual elements instead of a stuent object
            Student s = new Student();
            s.Surname = view.getFullName();
            s.Major = view.getMajor();
            s.WASSCE = Integer.parseInt(view.getWASCE());
            s.age = Integer.parseInt(view.getAge());
            model.addToModel(s);
        }
    }
    
}
