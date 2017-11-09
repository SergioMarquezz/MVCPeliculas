/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
package models;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class ModelClientes {
    
    
 private final ModelConectar model_conectar;   
 private PreparedStatement pst;
 private ResultSet resut;
 
 private int id_cliente;
 private String nombre;
 private String telefono;
 private String email;
 private String direccion;
 private String sql;
 
    public ModelClientes(ModelConectar model_conectar){
        
        this.model_conectar = model_conectar;
        
    }
 
 public int getIdCliente(){
     
     return id_cliente;
 }
 
 public String getNombre(){
     
     return nombre;
 }
 
 public String getTelefono(){
     
     return telefono;
 }
 
 public String getEmail(){
     
     return email;
 }
 
 public String getDireccion(){
     
     return direccion;
 }
 
 public void setIdCliente(int id_cliente){
     
     this.id_cliente = id_cliente;
 }
 
 public void setNombre(String nombre){
     
     this.nombre = nombre;
 }
 
 public void setTelefono(String telefono){
     
     this.telefono = telefono;
 }
 
 public void setEmail(String email){
     
     this.email = email;
 }
 
 public void setDireccion(String direccion){
     
     this.direccion = direccion;
 }
 
 
 public void llenarClientes(){
     
     try{
         setIdCliente(resut.getInt("id_cliente"));
         setNombre(resut.getString("nombre"));
         setTelefono(resut.getString("telefono"));
         setEmail(resut.getString("email"));
         setDireccion(resut.getString("direccion"));
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 102" + ex.getMessage());
     }
 }
 
 public void primerCliente(){
     
     try{
         
         resut.first();
         llenarClientes();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 103" + ex.getMessage());
     }
 }
 
 public void seleccionarTodos(){
     
     try{
         
         sql = "Select * from clientes;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         resut = pst.executeQuery();
         primerCliente();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 104" + ex.getMessage());
     }
     
 }
 
 public void ultimoCliente(){
     
     try{
         
         resut.last();
         llenarClientes();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 105" + ex.getMessage());
     }
 }
 
 public void siguienteCliente(){
     
     try{
     
     if(resut.isLast()==false){
         
         resut.next();
         llenarClientes();
     }
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 106" + ex.getMessage());
     }
 }
 
 public void anteriorCliente(){
     
     try{
         
         if(resut.isFirst()==false){
             
             resut.previous();
             llenarClientes();
         }
             
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 107" + ex.getMessage());
     }
 }
 
 public void insertarCliente(){
     
     try{

          sql = "Insert into clientes(nombre,telefono,email,direccion) values(?,?,?,?);";
          pst = model_conectar.getConexion().prepareStatement(sql);
          
          pst.setString(1, getNombre());
          pst.setString(2, getTelefono());
          pst.setString(3, getEmail());
          pst.setString(4, getDireccion());

          pst.executeUpdate();
          primerCliente();
                  
       }catch(SQLException ex){
                  
             JOptionPane.showMessageDialog(null, "Error 108" + ex.getMessage());   
       }
   }
 
 public void modificarCliente(){
     
     try{
         
         sql = "Update clientes set nombre = ?, telefono = ?, email = ?, direccion = ? where id_cliente = ?;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         
         pst.setInt(5, getIdCliente());
         pst.setString(1, getNombre());
         pst.setString(2, getTelefono());
         pst.setString(3, getEmail());
         pst.setString(4, getDireccion());
         
         pst.executeUpdate();
         primerCliente();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 109" + ex.getMessage());
     }
 }
 
 public void eliminarCliente(){
     
     try{
         
         sql = "Delete from clientes where id_cliente = ?;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         
         pst.setInt(1, getIdCliente());
         
         pst.executeUpdate();
         primerCliente();
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 110" + ex.getMessage());
     }
 }
    
}
