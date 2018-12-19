/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavier
 */
public class ConexionBD {
    Connection connection = null;
public Connection connect(){
    String url = "jdbc:mysql://localhost:3306/sakila";
    String user = "root";
    String pass = "cuenca123";
    System.out.println("Conectando...");
    
    try{
    connection = DriverManager.getConnection(url,user,pass);
    //System.out.println("Conectado!!");

    }catch(SQLException e){
    System.out.println(e.getErrorCode());
    }
    return connection;
}

public void cerrarConexion(){
    
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
