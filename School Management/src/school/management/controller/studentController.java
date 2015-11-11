/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import school.management.login.login_form;
//import school.management.view.StudentViewTable;
import school.management.view.AddNewStudentView;
import school.management.login.BasicSchoolManagementSystemConnection;
import school.management.model.Student;
import school.management.controller.AddNewStudentController;
import school.management.model.StudentViewTable;
import school.management.view.AddNewStudent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author youssouf.dasilva
 */
public class studentController implements ActionListener {
    login_form loginFrame;
    StudentViewTable stuV;
    BasicSchoolManagementSystemConnection bsConn;
    Student staffModel;
    AddNewStudentView addStud;
    AddNewStudentController addStudController;
    AddNewStudent add;
    
    public studentController(AddNewStudentView studView){
        addStud = studView;
    }
    
    public void control(){
        addStud.getAddStudentButton().addActionListener(this);
    }    
        
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==addStud.getAddStudentButton()){
            addStud = new AddNewStudentView(loginFrame, true);
            addStudController = new AddNewStudentController(stuV,add);
            addStud.setVisible(true);

    }
    }
}
