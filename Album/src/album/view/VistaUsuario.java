/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album.view;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Junior
 */
public class VistaUsuario {
    public void crearVistaUsuario(){
        JFrame ventanaAdmin = new JFrame();
        ventanaAdmin.setSize(500,540);
        ventanaAdmin.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                ventanaAdmin.dispose();
                Login log = new Login();
                log.crearLogin();
            }
        });
        ventanaAdmin.setLayout(null);
        ventanaAdmin.setResizable(false);
        
        JLabel lblTitulo = new JLabel();
        JButton btnAlbum = new JButton("Album");
        JButton btnSinPegar = new JButton("Sin Pegar");
        JButton btnIntercambio = new JButton("Intercambio");
        JButton btnReportes = new JButton("Reportes");
        JButton btnDorado = new JButton("Sobre Dorado");
        JButton btnPlateado = new JButton("Sobre Plateado");
        JButton btnSalir = new JButton("Salir");
        
        lblTitulo.setText("Registro");
        lblTitulo.setFont(new Font("Segoe UI", 0, 25));
        lblTitulo.setBounds(200, 45, 180, 40);
        btnSalir.setBounds(360, 20, 70, 25);
        btnAlbum.setBounds(70, 120, 130, 60);
        btnSinPegar.setBounds(310, 120, 130, 60);
        btnIntercambio.setBounds(70, 220, 130, 60);
        btnReportes.setBounds(310, 220, 130, 60);
        btnDorado.setBounds(310, 320, 130, 60);
        btnPlateado.setBounds(70, 320, 130, 60);
        
        ventanaAdmin.add(lblTitulo);
        ventanaAdmin.add(btnAlbum);
        ventanaAdmin.add(btnSalir);
        ventanaAdmin.add(btnSinPegar);
        ventanaAdmin.add(btnIntercambio);
        ventanaAdmin.add(btnReportes);
        ventanaAdmin.add(btnDorado);
        ventanaAdmin.add(btnPlateado);
        ventanaAdmin.setVisible(true);
    }
}
