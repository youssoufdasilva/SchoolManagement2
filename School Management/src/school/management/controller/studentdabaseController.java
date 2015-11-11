/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.controller;
import java.sql.*;
import school.management.model.Student;
import school.management.view.AddNewStudent;
import school.management.model.StudentViewTable;
//import school.management.model.ConnectToDatabase;

/**
 *
 * @author Migaliza
 */
public class studentdabaseController {
     private Connection conn;
    public  void getConnection() throws Exception{
        try{
           if(conn == null){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection(
	"jdbc:mysql://localhost:3306/basicSchoolDataBase?" + "user=root&password=");

        } 
        }catch(Exception e){
            e.toString();
        }
        
    }
        
        
    
    public void addStudent(AddNewStudent student) {
        //student_id, firstname,lastname,date_of_birth,age,yeargroup,nationality
        /*
        try{
            PreparedStatement prepared = conn.prepareStatement("INSERT INTO Student set student_id=?,firstname=?,lastname=?,date_of_birth=?,age=?,yearGroup=?,nationality=?");
            prepared.setInt(1,student.getStudentID());
            prepared.setString(2,student.getFirstName());
            prepared.setString(3,student.getLastName());
            java.sql.Date sqldate = new java.sql.Date(student.getDateOfBirth().getTime());
            prepared.setDate(4,sqldate);
            prepared.setInt(5,student.getAge());
            prepared.setInt(6,student.getAge());
            prepared.setString(7,student.getYearGroup());
            prepared.setString(8,student.getYearGroup());
            
            prepared.execute();
           
        }catch(Exception e){
            e.toString();
           
        }
        */
    }
    
    public void displayFromDatabase(Connection conn, String tablename){
        
    }
}
