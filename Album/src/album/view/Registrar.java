/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album.view;

import album.Ejecucion;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Junior
 */
public class Registrar {
    public JDialog crearRegistro(){
        JFrame frameRegistro = new JFrame();
        frameRegistro.setSize(500,540);
        frameRegistro.setLayout(null);
        frameRegistro.setResizable(false);
        frameRegistro.setTitle("Registrarse");
        
        JTextField txtNombre = new JTextField();
        JTextField txtApellido = new JTextField();
        JTextField txtNick = new JTextField();
        JPasswordField pswContraseña = new JPasswordField();
        JLabel lblTitulo = new JLabel("Registro");
        JLabel lblNick = new JLabel("Usuario:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblApellido = new JLabel("Apellido:");
        JLabel lblContraseña = new JLabel("Contraseña:");
        JButton btnRegistrarse = new JButton("Registrarse");
        JButton btnLogin = new JButton("Login");
        
        lblTitulo.setBounds(200, 45, 180, 40);
        lblTitulo.setFont(new Font("Segoe UI", 0, 25));
        lblNick.setFont(new Font("Segoe UI", 0, 15));
        lblContraseña.setFont(new Font("Segoe UI", 0, 15));
        lblNombre.setFont(new Font("Segoe UI", 0, 15));
        lblApellido.setFont(new Font("Segoe UI", 0, 15));
        
        lblNombre.setBounds(162, 100, 90, 20);
        txtNombre.setBounds(162, 135, 175, 30);
        lblApellido.setBounds(162, 165, 90, 20);
        txtApellido.setBounds(162, 195, 175, 30);
        lblNick.setBounds(162, 225, 90, 20);
        txtNick.setBounds(162, 255, 175, 30);
        lblContraseña.setBounds(162, 285, 90, 20);
        pswContraseña.setBounds(162, 315, 175, 30);
        btnRegistrarse.setBounds(140, 380, 105, 30);
        btnLogin.setBounds(260, 380, 105, 30);
        
        JDialog dialogRegistro = new JDialog(frameRegistro);
        dialogRegistro.setModal(true);
        dialogRegistro.setSize(500, 600);
        dialogRegistro.setLayout(null);
        
        btnRegistrarse.addActionListener(
             new ActionListener(){
                 @Override
                    public void actionPerformed (ActionEvent e){
                        if(txtNombre.getText().equals("")||txtApellido.getText().equals("")||
                                txtNick.getText().equals("")||pswContraseña.getText().equals("")){
                            showMessageDialog(null, "Por favor ingrese todos los campos");
                        }else{
                            Ejecucion ejec = new Ejecucion();
                            if(ejec.validarUsuario(txtNick.getText())){
                                showMessageDialog(null, "Ese nombre de usuario ya existe");
                            }else{
                                ejec.crearUsuario(txtNombre.getText(), txtApellido.getText(), 
                                txtNick.getText(), pswContraseña.getText());
                                showMessageDialog(null, "El usuario se añadio correctamente");
                                dialogRegistro.dispose();
                            }
                            System.out.println(txtNombre.getText());
                            System.out.println(txtApellido.getText());
                            System.out.println(txtNick.getText());
                            System.out.println(pswContraseña.getText());
                        }
                    }
             }
        );
        
        btnLogin.addActionListener(
             new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    Login log = new Login();
                    dialogRegistro.dispose();
                    log.crearLogin();
                }
             }
        );
        
        dialogRegistro.add(txtNick);
        dialogRegistro.add(txtNombre);
        dialogRegistro.add(txtApellido);
        dialogRegistro.add(pswContraseña);
        dialogRegistro.add(lblNombre);
        dialogRegistro.add(lblApellido);
        dialogRegistro.add(lblTitulo);
        dialogRegistro.add(lblNick);
        dialogRegistro.add(lblContraseña);
        dialogRegistro.add(btnRegistrarse);
        dialogRegistro.add(btnLogin);
        
        return dialogRegistro;
    }
}
