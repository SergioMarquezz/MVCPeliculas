/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//
package main;

import models.ModelClientes;
import models.ModelPeliculas;
import models.ModelPrincipal;
import models.ModelConectar;
import models.ModelRentas;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewRentas;
import views.ViewPrincipal;
import controllers.ControllerClientes;
import controllers.ControllerPeliculas;
import controllers.ControllerRentas;
import controllers.ControllerPrincipal;


public class Main {
    
    public static void main(String alb[]){
        
        ModelConectar model_conectar = new ModelConectar();
        
        ModelClientes model_clientes = new ModelClientes(model_conectar);
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes = new ControllerClientes(model_clientes,model_conectar,view_clientes);
        
        ModelPeliculas model_peliculas = new ModelPeliculas(model_conectar);
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas,model_conectar,view_peliculas);
        
        ModelRentas model_rentas = new ModelRentas(model_conectar);
        ViewRentas view_rentas = new ViewRentas();
        ControllerRentas controller_rentas = new ControllerRentas(model_rentas,model_conectar,view_rentas);
        
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        
        Object models[] = new Object[2];
        Object views[] = new Object[4];
        Object controllers[] = new Object[3];
        
        models[0] = model_principal;
        models[1] = model_conectar;
        views[0] = view_principal;
        views[1] = view_clientes;
        views[2] = view_peliculas;
        views[3] = view_rentas;
        controllers[0] = controller_clientes;
        controllers[1] = controller_peliculas;
        controllers[2] = controller_rentas;
        
        ControllerPrincipal controller_principal = new ControllerPrincipal(models,views,controllers);
    }
    
}
