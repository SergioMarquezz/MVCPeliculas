/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author SergioMarquez
 */
public class ViewClientes extends javax.swing.JPanel {

    /**
     * Creates new form ViewClientes
     */
    public ViewClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jl_codigo = new javax.swing.JLabel();
        jl_nombre = new javax.swing.JLabel();
        jl_telefono = new javax.swing.JLabel();
        jl_email = new javax.swing.JLabel();
        jl_direccion = new javax.swing.JLabel();
        jtf_codigo = new javax.swing.JTextField();
        jtf_nombre = new javax.swing.JTextField();
        jtf_telefono = new javax.swing.JTextField();
        jtf_email = new javax.swing.JTextField();
        jtf_direccion = new javax.swing.JTextField();
        jbtn_nuevo = new javax.swing.JButton();
        jbtn_guardar = new javax.swing.JButton();
        jbtn_modificar = new javax.swing.JButton();
        jbtn_eliminar = new javax.swing.JButton();
        jbtn_primero = new javax.swing.JButton();
        jbtn_ultimo = new javax.swing.JButton();
        jbtn_anterior = new javax.swing.JButton();
        jbtn_siguiente = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setLayout(null);

        jl_codigo.setText("Codigo");
        add(jl_codigo);
        jl_codigo.setBounds(20, 30, 60, 20);

        jl_nombre.setText("Nombre");
        add(jl_nombre);
        jl_nombre.setBounds(20, 90, 80, 20);

        jl_telefono.setText("Telefono");
        add(jl_telefono);
        jl_telefono.setBounds(20, 130, 80, 20);

        jl_email.setText("Email");
        add(jl_email);
        jl_email.setBounds(20, 170, 70, 20);

        jl_direccion.setText("Dirección");
        add(jl_direccion);
        jl_direccion.setBounds(20, 210, 90, 20);
        add(jtf_codigo);
        jtf_codigo.setBounds(100, 30, 90, 20);
        add(jtf_nombre);
        jtf_nombre.setBounds(100, 90, 100, 20);
        add(jtf_telefono);
        jtf_telefono.setBounds(100, 130, 110, 20);
        add(jtf_email);
        jtf_email.setBounds(100, 170, 150, 18);
        add(jtf_direccion);
        jtf_direccion.setBounds(100, 210, 190, 20);

        jbtn_nuevo.setText("Nuevo");
        add(jbtn_nuevo);
        jbtn_nuevo.setBounds(10, 240, 110, 24);

        jbtn_guardar.setText("Guardar");
        add(jbtn_guardar);
        jbtn_guardar.setBounds(130, 240, 120, 24);

        jbtn_modificar.setText("Modificar");
        add(jbtn_modificar);
        jbtn_modificar.setBounds(260, 240, 120, 24);

        jbtn_eliminar.setText("Eliminar");
        add(jbtn_eliminar);
        jbtn_eliminar.setBounds(130, 280, 120, 24);

        jbtn_primero.setText("|<");
        add(jbtn_primero);
        jbtn_primero.setBounds(240, 50, 60, 24);

        jbtn_ultimo.setText(">|");
        add(jbtn_ultimo);
        jbtn_ultimo.setBounds(310, 50, 60, 24);

        jbtn_anterior.setText("<<");
        add(jbtn_anterior);
        jbtn_anterior.setBounds(240, 80, 60, 24);

        jbtn_siguiente.setText(">>");
        add(jbtn_siguiente);
        jbtn_siguiente.setBounds(310, 80, 60, 24);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JButton jbtn_anterior;
    public javax.swing.JButton jbtn_eliminar;
    public javax.swing.JButton jbtn_guardar;
    public javax.swing.JButton jbtn_modificar;
    public javax.swing.JButton jbtn_nuevo;
    public javax.swing.JButton jbtn_primero;
    public javax.swing.JButton jbtn_siguiente;
    public javax.swing.JButton jbtn_ultimo;
    private javax.swing.JLabel jl_codigo;
    private javax.swing.JLabel jl_direccion;
    private javax.swing.JLabel jl_email;
    private javax.swing.JLabel jl_nombre;
    private javax.swing.JLabel jl_telefono;
    public javax.swing.JTextField jtf_codigo;
    public javax.swing.JTextField jtf_direccion;
    public javax.swing.JTextField jtf_email;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}