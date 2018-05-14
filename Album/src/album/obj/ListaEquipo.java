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
public class ListaEquipo {
    Equipo primero, ultimo;
    
    public ListaEquipo(){
        primero = null;
        ultimo = null;
    }
    
    public void verEquipo(){
        Equipo equipoP = primero;
        while(equipoP!=null){
            System.out.println(equipoP.pais);
            equipoP.jugadores.verJugadores();
            equipoP = equipoP.siguiente;
        }
    }
    
    public void ingresarEquipo(String pais, String codigo, String capitan, String entrenador, int mundiales){
        Equipo equipo = new Equipo();
        equipo.pais = pais;
        equipo.codigo = codigo;
        equipo.capitan = capitan;
        equipo.entrenador = entrenador;
        equipo.mundiales = mundiales;
        equipo.jugadores = new ListaJugador();
        if(primero == null){
            primero = equipo;
            primero.siguiente = null;
            primero.anterior = null;
            ultimo = primero;
        }else{
            ultimo.siguiente = equipo;
            equipo.anterior = ultimo;
            equipo.siguiente = null;
            ultimo = equipo;
        }
    }
    
    public void ingresarJugadorEquipo(String pais, Jugador jugador){
        //boolean existe = false;
        Equipo temporal = primero;
        while(temporal !=null){
            if(temporal.pais.equals(pais)){
                temporal.jugadores.ingresarJugador(jugador.pais, jugador.noCalcomanilla, 
                        jugador.nombre, jugador.posicion, jugador.fNacimiento, jugador.club, jugador.rareza);
                temporal = null;
            }else{
                temporal = temporal.siguiente;
            }
        }
        //return existe;
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
