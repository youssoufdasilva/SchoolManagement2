/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import school.management.login.login_form;
import school.management.view.*;

/**
 *
 * @author Anne Gitau
 */
public class SubjectsController implements ActionListener{
    login_form lf;
    subjectsView sV;
     public SubjectsController(subjectsView subV){
         sV=subV;
     }
      public void control(){
        System.out.println("Called control ");
        sV.getSubjectCode();
        sV.getSubjectName();
        sV.getDepartment();
        sV.getAddSubjectButton().addActionListener(this); 
        sV.getExitSubjectButton().addActionListener(this);
        System.out.println("end of control");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
