/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import school.management.login.login_form;
import school.management.view.staffView;
import school.management.login.BasicSchoolManagementSystemConnection;
import school.management.model.Staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author youssouf.dasilva
 */
public class staffController implements ActionListener {
    login_form loginFrame;
    staffView staV;
    BasicSchoolManagementSystemConnection bsConn = new BasicSchoolManagementSystemConnection();
    Staff staffModel;
    
    public staffController(staffView staView){
        staV = staView;
    }
    
    public void control(){
        staV.getAddStaff_btn().addActionListener(this);
        staV.getExitStaff_btn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==staV.getAddStaff_btn()){
            System.out.println("About to add to the staff model");
            staffModel = new Staff();
            staffModel.firstName = staV.getStaffname_txt();
            staffModel.lastName = staV.getStaffSurname_txt();
            staffModel.staffSubject = staV.getStaffSubject_txt();
            staffModel.department = staV.getStaffDepartment_txt();
            
            staffModel.department = staV.getStaffDepartment_txt();
            
            bsConn.addStaff(staffModel);
        } else if (ae.getSource()==staV.getExitStaff_btn()){
            staV.dispose();
        }
    }
}
