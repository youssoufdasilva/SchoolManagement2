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
import school.management.view.ReportsView;
import school.management.controller.genInfoController;

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
    ReportsView rV;
    genInfoController gic;
    
    public menuController(menuView mview){
        mV = mview;
    }
    
    public void control(){
        System.out.println("Called control ");
        mV.getGeneralInformation_btn().addActionListener(this);
        mV.getGradeManagement_btn().addActionListener(this);
        mV.getFeePayment_btn().addActionListener(this);
        mV.getReports_btn().addActionListener(this); 
        mV.getBack_btn().addActionListener(this);
        System.out.println("end of control");
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==mV.getGeneralInformation_btn()){
            System.out.println("About to set the GI to visible");
            gI = new generalInformation(loginFrame,true);
            gic = new genInfoController(gI);
            gic.control();
            gI.setVisible(true);
        } else if (ae.getSource()==mV.getGradeManagement_btn()){
            gM = new gradeManagementView(loginFrame,true);
            gM.setVisible(true);
        } else if (ae.getSource()==mV.getFeePayment_btn()){
            fP = new feePaymentView(loginFrame,true);
            fP.setVisible(true);
        } else if (ae.getSource()==mV.getReports_btn()){
            rV = new ReportsView(loginFrame,true);
            rV.setVisible(true);
        } else if (ae.getSource()==mV.getBack_btn()){
            mV.dispose();
        } 
    }
}
