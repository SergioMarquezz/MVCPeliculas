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


public class ModelRentas {
    
    private final ModelConectar model_conectar;
    
    public PreparedStatement pst;
    public ResultSet resut;
    
    
    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private String costo;
    private String dias_renta;
    private String total;
    private String sql;
    
    public ModelRentas(ModelConectar model_conectar){
        
        this.model_conectar = model_conectar;
        
    }

    public int getIdRenta() {
        return id_renta;
    }

    public void setIdRenta(int id_renta) {
        this.id_renta = id_renta;
    }

    public int getIdCliente() {
        return id_cliente;
    }

    public void setIdCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIdPelicula() {
        return id_pelicula;
    }

    public void setIdPelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDiasRenta() {
        return dias_renta;
    }

    public void setDiasRenta(String dias_renta) {
        this.dias_renta = dias_renta;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public void llenarRentas(){
        
        try{
            
            setIdRenta(resut.getInt("id_renta"));
            setIdCliente(resut.getInt("id_cliente"));
            setIdPelicula(resut.getInt("id_pelicula"));
            setFormato(resut.getString("formato"));
            setCosto(resut.getString("costo_dia"));
            setDiasRenta(resut.getString("dias_renta"));
            setTotal(resut.getString("total_renta"));
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error 120" + ex.getMessage());
        }
    }
    
    public void primeraRenta(){
        
        try{
            resut.first();
            llenarRentas();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error 121" + ex.getMessage());
        }
    }
    
    public void seleccionarTodos(){
        
        try{
            
            sql = "Select * from rentas;";
            pst = model_conectar.getConexion().prepareStatement(sql);
            resut = pst.executeQuery();
            primeraRenta();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error 122" + ex.getMessage());
        }
    }
    
    
     public void insertarRenta(){
     
     try{

          sql = "Insert into rentas(id_cliente,id_pelicula,formato,costo_dia,dias_renta,total_renta) values(?,?,?,?,?,?);";
          pst = model_conectar.getConexion().prepareStatement(sql);
          
          pst.setInt(1, getIdCliente());
          pst.setInt(2, getIdPelicula());
          pst.setString(3, getFormato());
          pst.setString(4, getCosto());
          pst.setString(5, getDiasRenta());
          pst.setString(6, getTotal());

          pst.executeUpdate();
          primeraRenta();
                  
       }catch(SQLException ex){
                  
             JOptionPane.showMessageDialog(null, "Error 117" + ex.getMessage());   
       }
   }
    
    
}
