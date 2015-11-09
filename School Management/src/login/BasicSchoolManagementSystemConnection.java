/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicschoolmanagementsystem;

/**
 *
 * @author youssouf.dasilva
 */

import java.sql.*;
import javax.swing.*;

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
            pst = conn.prepareStatement("Select * from staff where username=? and password=?");
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
    
    public boolean validate_login_online(String username,String password) {
        try{           
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
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
