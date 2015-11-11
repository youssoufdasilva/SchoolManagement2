/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.login;

/**
 *
 * @author youssouf.dasilva
 */

import java.sql.*;
import javax.swing.*;
import school.management.model.Staff;

public class BasicSchoolManagementSystemConnection {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    public BasicSchoolManagementSystemConnection(){
        conn = null;
        pst = null;
        rs = null;
    }
       

    /**
     * @param args the command line arguments
     */
    
    /*public static void main(String[] args) {
        // TODO code application logic here
        
    }*/
    
    /*
    public static Connection ConnectDb(){
        try{
            System.err.println("About to initiate the class.forName section");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Passed the class.forName section");
        conn = DriverManager.getConnection("jdbc:mysql//localhost:3306/basicSchoolDataBase","root","");
        JOptionPane.showMessageDialog(null,"Connection to MySQL Server Established");
        return conn;
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Connection to Database Error: "+e);
        return conn;
        }
    }
    */
    
    public boolean validate_login(String username,String password) {
        try{           
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicSchoolDataBase?" + "user=root&password=");     
            pst = conn.prepareStatement("Select * from login where username=? and password=?");
            pst.setString(1, username); 
            pst.setString(2, password);
            rs = pst.executeQuery();                        
            if(rs.next())            
                return true;    
            else
                return false;            
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addStaff (Staff newStaff) {
        try{           
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicSchoolDataBase?" + "user=root&password="); 
            System.out.println("About to prepare a statement");
//            pst = conn.prepareStatement("insert into staff (firstname=?,lastname=?,subjects=?,employment_date=?,department=?)");
             pst = conn.prepareStatement("insert into staff (firstname,lastname,subjects,employment_date,department) values ('Youssouf','Das','Math','2014/01/01','teacher');");
//             pst = conn.prepareStatement("insert into staff (firstname,lastname,subjects,department) values ('?','?','?','?');");

//            insert into staff (firstname,lastname,subjects,employment_date,department) values ('Youssouf','Das','Math','2014/01/01','teacher');
//            pst.setString(1, newStaff.firstName); 
//            pst.setString(2, newStaff.lastName);
//            pst.setString(3, newStaff.staffSubject);
//            pst.setString(4, newStaff.department);
            
            rs = pst.executeQuery();                        
            if(rs.next()) {   
                System.out.println("Added a staff");
                return true;  
            }
            else
                return false;            
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addStudent (Staff newStaff) {
        try{           
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/basicSchoolDataBase?" + "user=root&password=");     
            pst = conn.prepareStatement("insert into staff (firstname=?,lastname=?,subjects=?,employment_date=?,department=?)");
            pst.setString(1, newStaff.firstName); 
            pst.setString(2, newStaff.lastName);
            pst.setString(3, newStaff.staffSubject);
            pst.setString(4, String.valueOf(newStaff.hiredDate));
            pst.setString(5, newStaff.department);
            
            rs = pst.executeQuery();                        
            if(rs.next()) {   
                System.out.println("Added a staff");
                return true;  
            }
            else
                return false;            
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean validate_login_online(String username,String password) {
        try{           
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            System.out.println("Connecting to the online database");
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net?" + "user=sql495940&password=9BvB5fBfsy");     
            pst = conn.prepareStatement("Select * from login where username=? and password=?");
            pst.setString(1, username); 
            pst.setString(2, password);
            rs = pst.executeQuery();                        
            if(rs.next())            
                return true;    
            else
                return false;            
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
  
    Connection getConnection (){
        return conn;
    }
    
    
}
