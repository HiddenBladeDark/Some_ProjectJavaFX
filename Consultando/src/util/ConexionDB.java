/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */

//Esta clase es para hacer la conexion con la base de datos
public class ConexionDB {
    
     //Instanciar la conexion de mysql
    Connection conn = null;
    
    
    //Metodo para el establecimiento con la DB
    public static Connection Conexion()
    {
        //Try catch por si se presenta algun error a la conexion
        try{
            
            
            //Llamamos la direccion donde se arroja el servidor (localhost)
          Class.forName("com.mysql.jdbc.Driver");
        Connection ConectandoDB=DriverManager.getConnection("jdbc:mysql://localhost/webstore","root","");
        return ConectandoDB;
        
        
        }catch(ClassNotFoundException | SQLException ex)
        {
        System.err.println("Error Conectar"+ex.getMessage() );
        return null;
        }
        
        
    }
    
    
    
    
}
