/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import school.management.login.login_form;
import school.management.view.menuView;
import school.management.view.generalInformation;
import school.management.view.gradeManagementView;
import school.management.view.feePaymentView;
import school.management.view.*; //Supposed to be for reports

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.table.TableColumn;

/**
 *
 * @author youssouf.dasilva
 */
public class menuController implements ActionListener{
    login_form loginFrame;
    menuView mV;
    generalInformation gI;
    gradeManagementView gM;
    feePaymentView fP;
    
    public menuController(menuView mview){
        mV = mview;
        
//        gI = new generalInformation(loginFrame,true);
//        gM = new gradeManagementView(loginFrame,true);
//        fP = new feePaymentView(loginFrame,true);
    }
    
    public void control(){
        System.out.println("Called control ");
        mV.getGeneralInformation_btn().addActionListener(this);
        mV.getGradeManagement_btn().addActionListener(this);
        mV.getFeePayment_btn().addActionListener(this);
//        mV.getGeneralInformation_btn().addActionListener(this); 
        System.out.println("end of control");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==mV.getGeneralInformation_btn()){
            System.out.println("About to set the GI to visible");
            gI = new generalInformation(loginFrame,true);
            gI.setVisible(true);
        } else if (ae.getSource()==mV.getGradeManagement_btn()){
            
        }
    }
}
