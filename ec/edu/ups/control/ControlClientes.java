/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import ec.edu.ups.clases.Clientes;
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
public class ControlClientes {
    
      private Connection connection;
      private  ConexionBD cont=new ConexionBD();
      private Statement sentencia;
      private ResultSet resultado;
      private String sql; 
    
    public Clientes buscarCliente(String cedula){
        
        connection = cont.connect();
        sql="select idPersona, Nombre, Apellido, Direccion, Telefono, Email from Persona where CedulaRucPersona= '"+cedula+"' ";
        String nombre;
        Clientes cli=new Clientes();
          try {
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              
              while(resultado.next()){
                  cli.setCodigo(resultado.getInt("idPersona"));
                  nombre=resultado.getString("Nombre");
                  nombre=nombre+" "+resultado.getString("Apellido");
                  cli.setNombre(nombre);
                  cli.setDireccion(resultado.getString("Direccion"));
                  cli.setTelefono(resultado.getString("Telefono"));
                  cli.setEmail(resultado.getString("Email"));
              }
              
          } catch (SQLException ex) {
              Logger.getLogger(ControlClientes.class.getName()).log(Level.SEVERE, null, ex);
          }
              
        cont.cerrarConexion();
        
        
        return cli;
    }
    
}
