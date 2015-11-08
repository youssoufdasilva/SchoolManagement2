/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;
import java.awt.event.ActionEvent;
import school.management.model.StudentViewTable;
import school.management.model.Student;
import school.management.view.AddNewStudentDialog;
import java.awt.event.ActionListener;
/**
 *
 * @author Migaliza
 */
public class AddNewStudentController implements ActionListener{
    AddNewStudentDialog view; 
    StudentViewTable model;
    //I have not been consistent in view & model naming. 
    //should be addNewForm etc.
    public AddNewStudentController(StudentViewTable modelTable, AddNewStudentDialog add) {
        view =add;
        model= modelTable;        
    }
    public void control(){
        view.getExitFormButton().addActionListener(this);
        view.getAddVallueButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {            
        if (ae.getSource()==view.getExitFormButton() )
        {               
            view.dispose();
        }
        if (ae.getActionCommand().equalsIgnoreCase("ADD"))
        {            
            //fetch the data into a student.
            //I can have a separate fxn in the model to simply receive
            //the individual elemnets instead of a stuent object
            Student s= new Student();
            s.StudentID= view.getStudentID();
            s.FirstName=view.getStudentFirstName();
            s.Surname=view.getStudentSurname();
            s.Age=Integer.parseInt(view.getStudentAge());
            s.graduationYear=Integer.parseInt(view.getStudentYearGroup());
            s.LetterGrade=(String)view.getCombobox();
            s.marks=Integer.parseInt(view.getStudentMArks());
            s.program=myMajor.Major.valueOf(view.getCombobox());

            model.addToModel(s);
        }
    }
    
}
