/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.swing.JOptionPane;
import models.ModelConectar;
import models.ModelClientes;
import views.ViewClientes;


public class ControllerClientes {
    
    ModelClientes model_clientes;
    ViewClientes view_clientes;
    ModelConectar model_conectar;
    
    public ControllerClientes(ModelClientes model_clientes,ModelConectar model_conectar,ViewClientes view_clientes){
        
        this.model_clientes = model_clientes;
        this.model_conectar = model_conectar;
        this.view_clientes = view_clientes;
        
        view_clientes.jbtn_anterior.addActionListener(e -> this.jbtnAnterior());
        view_clientes.jbtn_siguiente.addActionListener(e -> this.jbtnSiguiente());
        view_clientes.jbtn_ultimo.addActionListener(e -> this.jbtnUltimo());
        view_clientes.jbtn_primero.addActionListener(e -> this.jbtnPrimero());
        view_clientes.jbtn_guardar.addActionListener(e -> this.jbtnInsertar());
        view_clientes.jbtn_eliminar.addActionListener(e -> this.jbtnEliminar());
        view_clientes.jbtn_modificar.addActionListener(e -> this.jbtnModificar());
        view_clientes.jbtn_nuevo.addActionListener(e -> this.jbtnNuevo());
        
        initView();
    }
    
    public void initView(){
        
        model_conectar.conectarBD();
        model_clientes.seleccionarTodos();
        getValores();
        
    }
    
    public void getValores(){
        
        view_clientes.jtf_codigo.setText(""+model_clientes.getIdCliente());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
    }
    
    public void setValores(){
        
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
        model_clientes.setEmail(view_clientes.jtf_email.getText());
        model_clientes.setIdCliente(Integer.parseInt(view_clientes.jtf_codigo.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
    }
    
    public void jbtnPrimero(){
        
        model_clientes.primerCliente();
        getValores();
    }
    
    public void jbtnUltimo(){
        
        model_clientes.ultimoCliente();
        getValores();
    }
    
    public void jbtnSiguiente(){
        
        model_clientes.siguienteCliente();
        getValores();
    }
    
    public void jbtnAnterior(){
        
        model_clientes.anteriorCliente();
        getValores();
    }
    
    public void jbtnInsertar(){
        
        setValores();
        model_clientes.insertarCliente();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        model_clientes.seleccionarTodos();
    }
    
    public void jbtnModificar(){
        
        setValores();
        model_clientes.modificarCliente();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Modificado");
        model_clientes.seleccionarTodos();
    }
    
    public void jbtnEliminar(){
        
        setValores();
        model_clientes.eliminarCliente();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Eliminado");
        model_clientes.seleccionarTodos();
    }
    
    public void jbtnNuevo(){
        
        view_clientes.jtf_codigo.setText("");
        view_clientes.jtf_direccion.setText("");
        view_clientes.jtf_email.setText("");
        view_clientes.jtf_nombre.setText("");
        view_clientes.jtf_telefono.setText("");
    }
}
