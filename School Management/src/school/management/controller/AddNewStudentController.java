/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;
import java.awt.event.ActionEvent;
import school.management.model.StudentViewTable;
import school.management.model.Student;
import school.management.view.AddNewStudentView;
import java.awt.event.ActionListener;
/*
 *
 * @author Migaliza
 */
public class AddNewStudentController implements ActionListener{
    AddNewStudentView view; 
    StudentViewTable model;
    //I have not been consistent in view & model naming. 
    //should be addNewForm etc.
    public AddNewStudentController(StudentViewTable modelTable, AddNewStudentView add) {
        view =add;
        model= modelTable;        
    }
    public void control(){
        view.getExitStudentButton().addActionListener(this);
        view.getAddStudentButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {            
        if (ae.getSource()==view.getExitStudentButton() )
        {               
            view.dispose();
        }
        if (ae.getActionCommand().equalsIgnoreCase("ADD"))
        {            
            //fetch the data into a student.
            //I can have a separate fxn in the model to simply receive
            //the individual elemnets instead of a stuent object
            Student s= new Student();
            s.studentId= view.getStudentID();
            s.firstName=view.getFirstName();
            s.lastName=view.getLastName();
            s.dateOfBirth=view.getDateOfBirth();
            s.age=view.getAge();
            s.nationality=view.getNationality();
            s.yearGroup=view.getYearGroup();
            

            model.addToModel(s);
        }
    }
    
}
