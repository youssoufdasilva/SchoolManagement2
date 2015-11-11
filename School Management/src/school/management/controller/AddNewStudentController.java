/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;
import java.awt.event.ActionEvent;
import school.management.model.StudentViewTable;
import school.management.model.Student;
import school.management.view.AddNewStudent;
import java.awt.event.ActionListener;
/*
 *
 * @author Migaliza
 */
public class AddNewStudentController implements ActionListener{
    AddNewStudent view; 
    StudentViewTable model;
    //I have not been consistent in view & model naming. 
    //should be addNewForm etc.
    public AddNewStudentController(StudentViewTable modelTable, AddNewStudent add) {
        view =add;
        model= modelTable;        
    }
    public void control(){
        view.getAdd_btn().addActionListener(this);
        view.getClear_btn().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {            
        if (ae.getSource()==view.getAdd_btn() )
        {               
            studentdabaseController studDatabase = new studentdabaseController();
            studDatabase.addStudent(view);
        }
    }
    
}
