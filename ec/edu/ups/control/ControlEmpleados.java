/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import ec.edu.ups.clases.Empleados;
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
public class ControlEmpleados {
    
      private Connection connection;
      private  ConexionBD cont=new ConexionBD();
      private Statement sentencia;
      private ResultSet resultado;
      private String sql; 
      private Empleados empleado;
     
      
   public Empleados buscarempleado(int codigo){
       connection = cont.connect();
       sql="select Nombre, Apellido from sakila.Persona where idPersona"
               + "=(select Persona_idPersona from sakila.Empleado where idEmpleado='"+codigo+"');";
       String nombre="";
       try {
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              empleado= new Empleados();
              while(resultado.next()){
                  nombre=resultado.getString("Nombre");
                  nombre=nombre+" "+resultado.getString("Apellido");
                  empleado.setNombre(nombre);
              }
              
             
          } catch (SQLException ex) {
              Logger.getLogger(ControlEmpleados.class.getName()).log(Level.SEVERE, null, ex);
          }
       cont.cerrarConexion();
        return empleado;
   }     
        
    
}
