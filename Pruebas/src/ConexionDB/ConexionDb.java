/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ConexionDb {
    
    public static Connection getConnection() throws SQLException {
       
  
        Connection ConexionDB = DriverManager.getConnection("jdbc:mysql://localhost:3306/webstore","root","1234");
        
        
          
        
        return ConexionDB;
    }

        
        

    
    
    
}
