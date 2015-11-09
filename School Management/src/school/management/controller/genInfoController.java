/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import school.management.login.login_form;
import school.management.view.generalInformation;
import school.management.view.StudentViewTable;
import school.management.view.staffView;
import school.management.view.streamView;
import school.management.view.subjectsView;
import school.management.view.departmentsView;
import school.management.view.classesView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author youssouf.dasilva
 */
public class genInfoController implements ActionListener {
    login_form loginFrame;
    generalInformation gI;
    StudentViewTable stdV;
    staffView stfV;
    streamView strV;
    subjectsView subV;
    departmentsView depV;
    classesView claV;
    
    public genInfoController(generalInformation genInfo){
        gI = genInfo;
    }
    
    public void control(){
        gI.getStudents_btn().addActionListener(this);
        gI.getStaff_btn().addActionListener(this);
        gI.getClasses_btn().addActionListener(this);
        gI.getStreams_btn().addActionListener(this);
        gI.getSubjects_btn().addActionListener(this);
        gI.getDepartments_btn().addActionListener(this);
        gI.getBack_btn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==gI.getStudents_btn()){
            System.out.println("About to set the GI to visible");
            stdV = new StudentViewTable(loginFrame,true);
            stdV.setVisible(true);
        } else if (ae.getSource()==gI.getStaff_btn()){
            stfV = new staffView(loginFrame,true);
            stfV.setVisible(true);
        } else if (ae.getSource()==gI.getStreams_btn()){
            strV = new streamView(loginFrame,true);
            strV.setVisible(true);
        } else if (ae.getSource()==gI.getSubjects_btn()){
            subV = new subjectsView(loginFrame,true);
            subV.setVisible(true);
        } else if (ae.getSource()==gI.getDepartments_btn()){
            depV = new departmentsView(loginFrame,true);
            depV.setVisible(true);
        } else if (ae.getSource()==gI.getClasses_btn()){
            claV = new classesView(loginFrame,true);
            claV.setVisible(true);
        } else if (ae.getSource()==gI.getBack_btn()){
            gI.dispose();
        }
    }
}
