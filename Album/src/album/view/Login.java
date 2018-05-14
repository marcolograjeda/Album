/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album.view;

import album.Ejecucion;
import album.obj.Usuario;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Junior
 */
public class Login {
    public void crearLogin(){
        JFrame ventanaLogin = new JFrame();
        ventanaLogin.setSize(500,540);
        ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaLogin.setLayout(null);
        ventanaLogin.setResizable(false);
        
        JTextField txtNick = new JTextField();
        JPasswordField pswContraseña = new JPasswordField();
        JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
        JLabel lblNick = new JLabel("Usuario:");
        JLabel lblContraseña = new JLabel("Contraseña:");
        JButton btnEntrar = new JButton("Entrar");
        JButton btnRegistrarse = new JButton("Registrarse");
        
        lblTitulo.setBounds(160, 90, 180, 40);
        lblTitulo.setFont(new Font("Segoe UI", 0, 25));
        lblNick.setFont(new Font("Segoe UI", 0, 15));
        lblContraseña.setFont(new Font("Segoe UI", 0, 15));
        lblNick.setBounds(162, 165, 90, 20);
        txtNick.setBounds(162, 195, 175, 30);
        lblContraseña.setBounds(162, 245, 90, 20);
        pswContraseña.setBounds(162, 275, 175, 30);
        btnEntrar.setBounds(140, 380, 105, 30);
        btnRegistrarse.setBounds(260, 380, 105, 30);
        
        btnEntrar.addActionListener(
             new ActionListener(){
                 @Override
                public void actionPerformed (ActionEvent e){
                    if(Ejecucion.usuarios.buscarUsuario(txtNick.getText(), pswContraseña.getText())){
                        if(Ejecucion.usuarios.obtenerRol(txtNick.getText())){
                            System.out.println("Soy admin");
                            VistaAdmin admin = new VistaAdmin();
                            admin.crearVistaAdmin();
                            ventanaLogin.dispose();
                        }else{
                            System.out.println("Soy usuario");
                            VistaUsuario usuario = new VistaUsuario();
                            usuario.crearVistaUsuario();
                            ventanaLogin.dispose();
                        }
                    }else{
                        System.out.println("No existe");
                    }
                    /*Usuario usuarioIniciado = ejec.login(txtNick.getText(), pswContraseña.getText());
                    if(usuarioIniciado.isRol()){
                        ventanaLogin.dispose();
                        
                    }else if(usuarioIniciado.getNickName()!=null){
                        System.out.println("Soy usuario");
                        ventanaLogin.dispose();
                        
                    }
                    System.out.println(pswContraseña.getText());
                    System.out.println(txtNick.getText());
                    */
                }
             }
        );
        
        btnRegistrarse.addActionListener(
             new ActionListener(){
                
                @Override
                public void actionPerformed (ActionEvent e){
                    Registrar reg = new Registrar();
                    JDialog dialogRegistro = reg.crearRegistro();
                    dialogRegistro.show();
                    dialogRegistro.setSize(400, 600);
                }
             }
        );
        
        ventanaLogin.add(txtNick);
        ventanaLogin.add(pswContraseña);
        ventanaLogin.add(lblTitulo);
        ventanaLogin.add(lblNick);
        ventanaLogin.add(lblContraseña);
        ventanaLogin.add(btnEntrar);
        ventanaLogin.add(btnRegistrarse);
        ventanaLogin.setVisible(true);
    }
}
