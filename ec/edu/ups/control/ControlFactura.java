/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import ec.edu.ups.clases.CabeceraFac;
import ec.edu.ups.clases.Clientes;
import ec.edu.ups.clases.FacturaDetalle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xavier
 */
public class ControlFactura {
    
     private Connection connection;
      private  ConexionBD cont=new ConexionBD();
      private Statement sentencia;
      private ResultSet resultado;
      private String sql; 
      private String sql1;
      private String sql2;
      private String sql3;
      
      public void guardarFactura(Clientes cli,CabeceraFac cabecera,
                                 ArrayList<FacturaDetalle> listaDe,int codigoCaje){
         int codigoCli = 0;
          try {
            connection = cont.connect();
           
            sql3="select idCliente from Cliente where Persona_idPersona='"+cli.getCodigo()+"'";
            sentencia=connection.createStatement();
            resultado=sentencia.executeQuery(sql3);
            while(resultado.next()){
                codigoCli=resultado.getInt("idCliente");
            
                int codigoFa=0;
                sql="select count(idFacturaCabecera) from FacturaCabecera";
                try {
                    sentencia=connection.createStatement();
                    resultado=sentencia.executeQuery(sql);
                    while(resultado.next()){
                        codigoFa=resultado.getInt("count(idFacturaCabecera)");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                codigoFa++;
                
                sql="insert into FacturaCabecera() values ('"+codigoFa+"','"+cabecera.getFecha()+"','"+cabecera.getSubtotal()+"'"
                        + ",'"+cabecera.getIva()+"','"+cabecera.getDescuento()+"','"+cabecera.getTotal()+"',"
                        + "'"+'1'+"','"+codigoCli+"','1')";
                sentencia=connection.createStatement();
                sentencia.executeUpdate(sql);
                
                guardarDetalle(cli, cabecera, listaDe, codigoCaje, codigoFa);
                
            
            
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
         
      }
      
      public void guardarDetalle(Clientes cli,CabeceraFac cabecera,
                                 ArrayList<FacturaDetalle> listaDe,int codigoCaje, int codigoFa){
         try {
             int codigoDeFa=0;
             connection = cont.connect();
             sql="select count(idDetalleFactura) from DetalleFactura";
             System.out.println(listaDe.size());
             
             sentencia=connection.createStatement();
             resultado=sentencia.executeQuery(sql);
             while(resultado.next()){
                 codigoDeFa=resultado.getInt("count(idDetalleFactura)");
             }
             
             
             
             for (int i=0; i<listaDe.size();i++){
                 codigoDeFa++;
                 sql1="insert DetalleFactura () values ('"+codigoDeFa+"','"+listaDe.get(i).getCantidad()+"',"
                         + "'"+listaDe.get(i).getPrecioU()+"','"+listaDe.get(i).getTotal()+"',"
                         + "'"+listaDe.get(i).getCodigo()+"','"+codigoFa+"')";
                 sentencia=connection.createStatement();
                 sentencia.executeUpdate(sql1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(ControlFactura.class.getName()).log(Level.SEVERE, null, ex);
         }
                
                
      }
          
           
    
}
