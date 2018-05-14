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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Junior
 */
public class VistaAdmin {
    public void crearVistaAdmin(){
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
        JButton btnDocumentos = new JButton("Album");
        JButton btnCarga = new JButton("Carga");
        JButton btnUsuarios = new JButton("Limpiar");
        JButton btnReportes = new JButton("Reportes");
        JButton btnSalir = new JButton("Salir");
        
        lblTitulo.setText("Registro");
        lblTitulo.setFont(new Font("Segoe UI", 0, 25));
        lblTitulo.setBounds(200, 45, 180, 40);
        btnSalir.setBounds(360, 20, 70, 25);
        btnDocumentos.setBounds(70, 120, 120, 120);
        btnCarga.setBounds(310, 120, 120, 120);
        btnUsuarios.setBounds(70, 320, 120, 120);
        btnReportes.setBounds(310, 320, 120, 120);
        
        btnCarga.addActionListener(
             new ActionListener(){
                @Override
                public void actionPerformed (ActionEvent e){
                    JFileChooser buscar = new JFileChooser();
                    buscar.setMultiSelectionEnabled(true);
                    buscar.setFileFilter(new FileNameExtensionFilter("","csv"));
                    buscar.showOpenDialog(buscar);
                    String path = buscar.getSelectedFile().getAbsolutePath();
                    Ejecucion ejec = new Ejecucion();
                    ejec.cargaMasiva(path);
                }
             }
        );
        
        
        
        ventanaAdmin.add(lblTitulo);
        ventanaAdmin.add(btnDocumentos);
        ventanaAdmin.add(btnSalir);
        ventanaAdmin.add(btnCarga);
        ventanaAdmin.add(btnUsuarios);
        ventanaAdmin.add(btnReportes);
        ventanaAdmin.setVisible(true);
    }
}
