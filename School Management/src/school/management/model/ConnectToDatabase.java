/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.model;

/**
 *
 * @author Migaliza
 */
import java.sql.*;

public class ConnectToDatabase {
    static private Connection connection;
    public static Connection getConnection() throws Exception{
        if(connection == null){
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = java.sql.DriverManager.getConnection(
	"jdbc:mysql://http://cs.ashesi.edu.gh/~csashesi/phpmyadmin/cdcol?user=csashesi_bl16&password=db!hiJ35");
        }
        
        return connection;
    }
    
}
