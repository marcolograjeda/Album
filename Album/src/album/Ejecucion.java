/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album;

import album.obj.Jugador;
import album.obj.ListaEquipo;
import album.obj.ListaJugador;
import album.obj.ListaUsuario;
import album.view.Login;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Junior
 */
public class Ejecucion {
    public static ListaUsuario usuarios = new ListaUsuario();
    public static ListaEquipo album = new ListaEquipo();
    public static ListaJugador jugadores = new ListaJugador();
    
    public void crearLogin(){
        Login log = new Login();
        log.crearLogin();
    }
    
    public void crearUsuario(String nombre, String apellido, String nick, String pass){
        usuarios.ingresarUsuario(nombre, apellido, nick, pass);
    }
    
    public boolean validarUsuario(String nick){
        boolean existe = usuarios.validarUsuario(nick);
        return existe;
    }
    
    public void cargaMasiva(String ubicacionArchivo){
        BufferedReader buff = null;
        try{
            buff = new BufferedReader(new FileReader(ubicacionArchivo));
            String linea = buff.readLine();
            while(linea!=null){
                StringTokenizer token = new StringTokenizer(linea, ",");
                int contador = token.countTokens();
                switch(contador){
                    case 5:
                        album.ingresarEquipo(token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken(),
                                Integer.parseInt(token.nextToken()));
                    break;
                    case 7:
                        Jugador jugador = new Jugador();
                        jugador.pais = token.nextToken();
                        jugador.noCalcomanilla = Integer.parseInt(token.nextToken());
                        jugador.nombre = token.nextToken();
                        jugador.posicion = token.nextToken();
                        jugador.fNacimiento = token.nextToken();
                        jugador.club = token.nextToken();
                        jugador.rareza = Integer.parseInt(token.nextToken());
                        album.ingresarJugadorEquipo(jugador.pais, jugador);
                    break;
                    default:
                        
                    break;
                }
                linea = buff.readLine();
            }
            album.verEquipo();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
