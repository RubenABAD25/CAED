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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavier
 */
public class ControlLogin {
    
    ConexionBD cont=new ConexionBD();
    private String sql;
    private int codigoCa=0;
    
    
    public Empleados ingresar(String user, String con) throws SQLException{
       
       Empleados emp=new Empleados();
          boolean op=false;
         emp.setEstado("falso");
       Connection connection;
       connection = cont.connect();
       Statement sentencia;
       ResultSet resultado;
       sql="select idEmpleado,Cargo from empleado where User='"+user+"' and Pass='"+con+"'";
       sentencia=connection.createStatement();
       resultado=sentencia.executeQuery(sql);
        while(resultado.next()){
            op=true;
            emp.setCodigo(resultado.getInt("idEmpleado"));
            emp.setCargo(resultado.getString("Cargo"));
            emp.setEstado("true");
        }
        
        if (op){
          if (emp.getCargo().equals("Cajero")){  
            
        //Obtener Codigo
        sql="select count(idCaja) from caja"; 
        try {
            sentencia=connection.createStatement();
            resultado=sentencia.executeQuery(sql);
            while(resultado.next()){
            codigoCa=resultado.getInt("count(idCaja)");
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
         codigoCa++;
        
         
        //Ingresar caja
        Date now = new Date(System.currentTimeMillis());
     
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
       sql="insert into caja() values ('"+codigoCa+"','"+"CajaAbierta"+"','"+'0'+"'"
       + ",'"+date.format(now)+"','"+emp.getCodigo()+"')"; 
        try {
            sentencia=connection.createStatement();
            sentencia.executeUpdate(sql);
            op=true;
          cont.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
         return emp;
          }else{return emp;}
          
         }else{
            return emp;
            
        }
        
    }

}

    

