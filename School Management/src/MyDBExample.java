/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youssoufdasilva
 */
import java.sql.*;
import java.util.ArrayList;
public class MyDBExample {
    
    public static void main(String [] args) {

	java.sql.Connection conn = null;
//        ArrayList arrList = new ArrayList();

	System.out.println("This program demos DB connectivity");
        System.out.println("Attempting to connect with database");
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = java.sql.DriverManager.getConnection(
			"jdbc:mysql://localhost/cdcol?user=root&password=");

	}
	catch (Exception e) {
                System.out.println("Connection Failed");
		System.out.println(e);
		System.exit(0);
	}

	System.out.println("Connection established");

	try {
		java.sql.Statement s = conn.createStatement();
		java.sql.ResultSet r = s.executeQuery("SELECT * FROM first_assignment.MovieExec");
		while(r.next()) {
			System.out.println ( "Name: " +
			r.getString("name") + "; Address: " +
			r.getString("address") + "; Certification: " +
			r.getString("cert") );
		} //while
                
                System.out.println();
                int line = 0;
                
                java.sql.ResultSet rs = s.executeQuery("SELECT * FROM first_assignment.MovieExec");
                while(rs.next()) {
			System.out.println ( "2Name: " +
			rs.getString("name") + "; 2Address: " +
			rs.getString("address") + "; 2Certification: " +
			rs.getString("cert") );
		} //while
                
                
		
		r.close();
                s.close();
                conn.close();
		
	}
	catch (Exception e) {
		System.out.println(e);
		System.exit(0);
	}
}//main
    
}
