/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album;

import album.obj.ListaJugador;

/**
 *
 * @author Junior
 */
public class Album {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaJugador jugadores = new ListaJugador();
        Ejecucion ejec = new Ejecucion();
        ejec.crearLogin();
    }
    
}
