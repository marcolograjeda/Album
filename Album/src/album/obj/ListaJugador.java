/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package album.obj;

/**
 *
 * @author Junior
 */
public class ListaJugador {
    Jugador primero, ultimo;
    
    public ListaJugador(){
        primero = null;
        ultimo = null;
    }
    
    public void verJugadores(){
        Jugador jug = primero;
        while(jug!=null){
            System.out.println(jug.nombre);
            jug = jug.siguiente;
        }
    }
    
    public void ingresarJugador(String pais, int noCal, String nombre, String posicion, String fecha, String club, int rareza){
        Jugador nuevoJugador = new Jugador();
        nuevoJugador.pais = pais;
        nuevoJugador.noCalcomanilla = noCal;
        nuevoJugador.nombre = nombre;
        nuevoJugador.posicion = posicion;
        nuevoJugador.fNacimiento = fecha;
        nuevoJugador.club = club;
        nuevoJugador.rareza = rareza;
        if(primero == null){
            primero = nuevoJugador;
            primero.siguiente = null;
            primero.anterior = null;
            ultimo = primero;
        }else{
            if(primero.noCalcomanilla > nuevoJugador.noCalcomanilla){
                Jugador auxiliar = primero;
                primero = nuevoJugador; 
                primero.siguiente = auxiliar;
            }else if(primero.siguiente != null){
                Jugador auxiliar = primero.siguiente;
                Jugador atras = primero;
                while(auxiliar!=null){
                    if(auxiliar.noCalcomanilla > nuevoJugador.noCalcomanilla){
                        atras.siguiente = nuevoJugador;
                        nuevoJugador.anterior = atras;
                        nuevoJugador.siguiente = auxiliar;
                        auxiliar = null;
                        atras = null;
                    }else{
                        atras = auxiliar;
                        auxiliar = auxiliar.siguiente;
                    }
                }
            }else{
                ultimo.siguiente = nuevoJugador;
                nuevoJugador.anterior = ultimo;
                nuevoJugador.siguiente = null;
                ultimo = nuevoJugador;
            }
        }
    }
    
    public void limpiar(){
        primero = null;
        primero.anterior = null;
        primero.siguiente = null;
        ultimo = null;
        ultimo.anterior = null;
        ultimo.siguiente = null;
    }
}
