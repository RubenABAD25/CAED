/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavier
 */
public class ControlCabeFac {
    
      private Connection connection;
      private  ConexionBD cont=new ConexionBD();
      private Statement sentencia;
      private ResultSet resultado;
      private String sql; 
    
    public int obtenerNumFac(){
        connection = cont.connect();
        sql="select count(idFacturaCabecera) from FacturaCabecera ";
        int numeroFactura = 0;
              
          try {
              
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              while(resultado.next()){
                  numeroFactura=resultado.getInt("count(idFacturaCabecera)");   
              }
          } catch (SQLException ex) {
              Logger.getLogger(ControlCabeFac.class.getName()).log(Level.SEVERE, null, ex);
          }
          cont.cerrarConexion();
            numeroFactura++;
            return numeroFactura;
    } 
    
    
    
}
