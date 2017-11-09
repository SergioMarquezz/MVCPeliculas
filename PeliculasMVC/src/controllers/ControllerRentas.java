/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//
import javax.swing.JOptionPane;
import models.ModelConectar;
import models.ModelRentas;
import views.ViewRentas;

public class ControllerRentas {
    
    ModelConectar model_conectar;
    ModelRentas model_rentas;
    ViewRentas view_rentas;
    
    public ControllerRentas(ModelRentas model_rentas,ModelConectar model_conectar,ViewRentas view_rentas){
        
        this.model_conectar = model_conectar;
        this.model_rentas = model_rentas;
        this.view_rentas = view_rentas;
        
        initView();
        
        view_rentas.jbtn_guardar.addActionListener(e -> this.jbtnGuardar());
        
    }
    
    public void initView(){
        
        model_conectar.conectarBD();
        model_rentas.seleccionarTodos();
        getValores();
        
    }
    
    public void getValores(){
        
        view_rentas.jtf_cliente.setText("" + model_rentas.getIdCliente());
        view_rentas.jtf_formato.setText(model_rentas.getFormato());
        view_rentas.jtf_codigo.setText(""+model_rentas.getIdRenta());
        view_rentas.jtf_costo.setText(model_rentas.getCosto());
        view_rentas.jtf_pelicula.setText(""+model_rentas.getIdPelicula());
        view_rentas.jtf_dias.setText(model_rentas.getDiasRenta());
        view_rentas.jtf_total.setText(model_rentas.getTotal());
        
    }
    
    public void setValores(){
        
        model_rentas.setCosto(view_rentas.jtf_costo.getText());
        model_rentas.setDiasRenta(view_rentas.jtf_dias.getText());
        model_rentas.setFormato(view_rentas.jtf_formato.getText());
        model_rentas.setIdCliente(Integer.parseInt(view_rentas.jtf_cliente.getText()));
        model_rentas.setIdPelicula(Integer.parseInt(view_rentas.jtf_pelicula.getText()));
        model_rentas.setIdRenta(Integer.parseInt(view_rentas.jtf_codigo.getText()));
        model_rentas.setTotal(view_rentas.jtf_total.getText());
    }
    
    public void jbtnGuardar(){
        
        setValores();
        model_rentas.insertarRenta();
        getValores();
        JOptionPane.showMessageDialog(null, "Registro Guardado");
        model_rentas.seleccionarTodos();
    }
}
