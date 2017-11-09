/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
//
import models.ModelPrincipal;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewRentas;
import views.ViewPrincipal;


public class ControllerPrincipal {
    
    ModelPrincipal model_principal;
    ViewClientes view_clientes;
    ViewPeliculas view_peliculas;
    ViewRentas view_rentas;
    ViewPrincipal view_principal;
    
   
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
            
        this.view_clientes = (ViewClientes) views[1];
        this.view_principal = (ViewPrincipal) views[0];
        this.view_peliculas = (ViewPeliculas) views[2];
        this.view_rentas = (ViewRentas) views[3];
        
        initView();
        
        view_principal.jm_item_clientes.addActionListener(e -> this.frameClientes());
        view_principal.jm_item_peliculas.addActionListener(e -> this.framePeliculas());
        view_principal.jm_item_rentas.addActionListener(e -> this.frameRentas());
        
    }
    
    public void initView(){
        
        view_principal.setTitle("MVC Peliculas");
        view_principal.setLocationRelativeTo(null);
        view_principal.setVisible(true);
    }
    
    public void frameClientes(){
        
        view_principal.setContentPane(view_clientes);
        view_principal.revalidate();
        view_principal.repaint();
       
    }
    
    public void framePeliculas(){
        
        view_principal.setContentPane(view_peliculas);
        view_principal.revalidate();
        view_principal.repaint();
    }
    public void frameRentas(){
        
        view_principal.setContentPane(view_rentas);
        view_principal.revalidate();
        view_principal.repaint();
    }
}
