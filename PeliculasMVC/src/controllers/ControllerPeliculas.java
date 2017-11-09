/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import models.ModelPeliculas;
import models.ModelConectar;
import views.ViewPeliculas;


public class ControllerPeliculas {
    
    ModelPeliculas model_peliculas;
    ViewPeliculas view_peliculas;
    ModelConectar model_conectar;
    
    public ControllerPeliculas(ModelPeliculas model_peliculas,ModelConectar model_conectar,ViewPeliculas view_peliculas){
        
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        this.model_conectar = model_conectar;
        
        initView();
        
        view_peliculas.jbtn_anterior.addActionListener(e -> this.jbtnAnterior());
        view_peliculas.jbtn_siguiente.addActionListener(e -> this.jbtnSiguiente());
        view_peliculas.jbtn_ultimo.addActionListener(e -> this.jbtnUltimo());
        view_peliculas.jbtn_primero.addActionListener(e -> this.jbtnPrimero());
        view_peliculas.jbtn_guardar.addActionListener(e -> this.jbtnInsertar());
        view_peliculas.jbtn_modificar.addActionListener(e -> this.jbtnModificar());
        view_peliculas.jbtn_eliminar.addActionListener(e -> this.jbtnEliminar());
        view_peliculas.jbtn_nuevo.addActionListener(e -> this.jbtnNuevo());
        
    }
    
    public void initView(){
        
         model_conectar.conectarBD();
         model_peliculas.seleccionarTodos();
         getValores();
        
    }
    
    public void getValores(){
        
        view_peliculas.jtf_codigo.setText(""+model_peliculas.getIdPelicula());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuraccion());
        view_peliculas.jtf_formato.setText(model_peliculas.getFormato());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
        view_peliculas.jtexarea_descripcion.setText(model_peliculas.getDescripcion());
    }
    
    public void setValores(){
        
        model_peliculas.setDescripcion(view_peliculas.jtexarea_descripcion.getText());
        model_peliculas.setDuraccion(view_peliculas.jtf_duracion.getText());
        model_peliculas.setFormato(view_peliculas.jtf_formato.getText());
        model_peliculas.setIdPelicula(Integer.parseInt(view_peliculas.jtf_codigo.getText()));
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
    }
    
     public void jbtnPrimero(){
        
        model_peliculas.primeraPelicula();
        getValores();
    }
     
     public void jbtnAnterior(){
        
        model_peliculas.anteriorPelicula();
        getValores();
    }
     
     public void jbtnUltimo(){
        
        model_peliculas.ultimaPelicula();
        getValores();
    }
     
    public void jbtnSiguiente(){
        
        model_peliculas.siguientePelicula();
        getValores();
    }
    
    public void jbtnInsertar(){
        
        setValores();
        model_peliculas.insertarPelicula();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        model_peliculas.seleccionarTodos();
    }
    
    public void jbtnModificar(){
        
        setValores();
        model_peliculas.modificarPelicula();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Modificado");
        model_peliculas.seleccionarTodos();
    }
    
    public void jbtnEliminar(){
        
        setValores();
        model_peliculas.eliminarPelicula();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
        model_peliculas.seleccionarTodos();
    }
    
    public void jbtnNuevo(){
        
        view_peliculas.jtexarea_descripcion.setText("");
        view_peliculas.jtf_codigo.setText("");
        view_peliculas.jtf_duracion.setText("");
        view_peliculas.jtf_formato.setText("");
        view_peliculas.jtf_nombre.setText("");
    }
}
