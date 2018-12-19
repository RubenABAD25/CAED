/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.control;

import ec.edu.ups.clases.Productos;
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
public class ControlProductos {
    
      private Connection connection;
      private  ConexionBD cont=new ConexionBD();
      private Statement sentencia;
      private ResultSet resultado;
      private String sql; 
      private List<Productos> listProductos=new ArrayList<Productos>();
      
    
    public List<Productos> buscarProductos(String nom){
        
          try {
              connection = cont.connect();
              sql="select Codigo,Detalle,Precio from Producto where Detalle like  '%"+nom+"%'";
              
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              while(resultado.next()){
                  Productos productos=new Productos();
                  productos.setCodigo(resultado.getInt("Codigo"));
                  productos.setDetalle(resultado.getString("Detalle"));
                  productos.setPrecio(resultado.getDouble("Precio"));
                  listProductos.add(productos);
              }
          } catch (SQLException ex) {
              Logger.getLogger(ControlProductos.class.getName()).log(Level.SEVERE, null, ex);
          }
          cont.cerrarConexion();
        return listProductos;
        
        
    }
    
    
    public List<Productos> buscarProductosC(String nom){
        
          try {
              connection = cont.connect();
              sql="select Codigo,Detalle,Precio from Producto where Codigo =  '"+nom+"'";
              
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              while(resultado.next()){
                  Productos productos=new Productos();
                  productos.setCodigo(resultado.getInt("Codigo"));
                  productos.setDetalle(resultado.getString("Detalle"));
                  productos.setPrecio(resultado.getDouble("Precio"));
                  listProductos.add(productos);
              }
          } catch (SQLException ex) {
              Logger.getLogger(ControlProductos.class.getName()).log(Level.SEVERE, null, ex);
          }
          cont.cerrarConexion();
        return listProductos;
        
        
    }
    
    public boolean contarProductos(int codigo){
        
        int cantidad=0;
        connection = cont.connect();
        try {
              
              sql="select Stock from Producto where Codigo = '"+codigo+"'";
              
              sentencia=connection.createStatement();
              resultado=sentencia.executeQuery(sql);
              while(resultado.next()){
                  cantidad=resultado.getInt("Stock");
              }
             
          } catch (SQLException ex) {
              Logger.getLogger(ControlProductos.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        if (cantidad!=0){
            try {
                cantidad=cantidad-1;
                sql="update Producto set Stock='"+cantidad+"' where Codigo= '"+codigo+"'";
                sentencia=connection.createStatement();
                sentencia.executeUpdate(sql);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ControlProductos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return false;
        }
          return false;
        
    }
}
    
    
    
    

