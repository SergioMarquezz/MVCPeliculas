/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModelPeliculas {
    
 private ModelConectar model_conectar;   
 private PreparedStatement pst;
 private ResultSet resut;
    
 
 public ModelPeliculas(ModelConectar model_conectar){
     
     this.model_conectar = model_conectar;
     
 }
 
 private int id_pelicula;
 private String nombre;
 private String formato;
 private String duraccion;
 private String descripcion;
 private String sql;

    public int getIdPelicula(){
        
        return id_pelicula;
    }

    public void setIdPelicula(int id_pelicula){
        
        this.id_pelicula = id_pelicula;
    }

    public String getNombre(){
        
        return nombre;
    }

    public void setNombre(String nombre){
        
        this.nombre = nombre;
    }

    public String getFormato(){
        
        return formato;
    }

    public void setFormato(String formato){
        
        this.formato = formato;
    }

    public String getDuraccion(){
        
        return duraccion;
    }

    public void setDuraccion(String duraccion){
        
        this.duraccion = duraccion;
    }

    public String getDescripcion(){
        
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        
        this.descripcion = descripcion;
    }
    
     public void llenarPeliculas(){
     
     try{
         
         setIdPelicula(resut.getInt("id_pelicula"));
         setNombre(resut.getString("nombre"));
         setFormato(resut.getString("formato"));
         setDuraccion(resut.getString("duracion"));
         setDescripcion(resut.getString("descripcion"));
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 111" + ex.getMessage());
     }
 }
     
   public void primeraPelicula(){
     
     try{
         
         resut.first();
         llenarPeliculas();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 112" + ex.getMessage());
     }
 }

 public void seleccionarTodos(){
     
     try{
         
         sql = "Select * from peliculas;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         resut = pst.executeQuery();
         primeraPelicula();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 113" + ex.getMessage());
     }
     
 }
 
  public void ultimaPelicula(){
     
     try{
         
         resut.last();
         llenarPeliculas();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 114" + ex.getMessage());
     }
 }
  
   public void siguientePelicula(){
     
     try{
     
     if(resut.isLast()==false){
         
         resut.next();
         llenarPeliculas();
     }
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 115" + ex.getMessage());
     }
 }
   
    public void anteriorPelicula(){
     
     try{
         
         if(resut.isFirst()==false){
             
             resut.previous();
             llenarPeliculas();
         }
             
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 116" + ex.getMessage());
     }
 }
    
     public void insertarPelicula(){
     
     try{

          sql = "Insert into peliculas(nombre,formato,duracion,descripcion) values(?,?,?,?);";
          pst = model_conectar.getConexion().prepareStatement(sql);
          
          pst.setString(1, getNombre());
          pst.setString(2, getFormato());
          pst.setString(3, getDuraccion());
          pst.setString(4, getDescripcion());

          pst.executeUpdate();
          primeraPelicula();
                  
       }catch(SQLException ex){
                  
             JOptionPane.showMessageDialog(null, "Error 117" + ex.getMessage());   
       }
   }
     
   public void modificarPelicula(){
     
     try{
         
         sql = "Update peliculas set nombre = ?, formato = ?, duracion = ?, descripcion = ? where id_pelicula = ?;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         
         pst.setInt(5, getIdPelicula());
         pst.setString(1, getNombre());
         pst.setString(2, getFormato());
         pst.setString(3, getDuraccion());
         pst.setString(4, getDescripcion());
         
         pst.executeUpdate();
         primeraPelicula();
         
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 118" + ex.getMessage());
     }
 }
   
   public void eliminarPelicula(){
     
     try{
         
         sql = "Delete from peliculas where id_pelicula = ?;";
         pst = model_conectar.getConexion().prepareStatement(sql);
         
         pst.setInt(1, getIdPelicula());
         
         pst.executeUpdate();
         primeraPelicula();
     }catch(SQLException ex){
         
         JOptionPane.showMessageDialog(null, "Error 119" + ex.getMessage());
     }
 }
 
 
 
}
