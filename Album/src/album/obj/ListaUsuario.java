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
public class ListaUsuario {
    Usuario primero, ultimo;
    
    public ListaUsuario(){
        Usuario admin = new Usuario();
        admin.nick = "admin";
        admin.pass = "pass";
        admin.rol = true;
        primero = admin;
        primero.siguiente = null;
        ultimo = primero;
    }
    
    public boolean buscarUsuario(String nick, String pass){
        boolean existe = false;
        Usuario temporal = primero;
        while(temporal !=null){
            if(temporal.nick.equals(nick)){
                if(temporal.nick.equals(nick)){
                    existe = true;
                    temporal = null;
                }else{
                    temporal = temporal.siguiente;
                }
            }else{
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }
    
    public boolean obtenerRol(String nick){
        boolean existe = false;
        Usuario temporal = primero;
        while(temporal !=null){
            if(temporal.nick.equals(nick)){
                existe = temporal.rol;
                temporal = null;
            }else{
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }
    
    public boolean validarUsuario(String nick){
        boolean existe = false;
        Usuario temporal = primero;
        while(temporal !=null){
            if(temporal.nick.equals(nick)){
                existe = true;
                temporal = null;
            }else{
                temporal = temporal.siguiente;
            }
        }
        return existe;
    }
    
    public void ingresarUsuario(String nombre, String apellido, String nick, String pass){
        Usuario usuario = new Usuario();
        usuario.nombre = nombre;
        usuario.apellido = apellido;
        usuario.nick = nick;
        usuario.pass = pass;
        usuario.rol = false;
        
        ultimo.siguiente = usuario;
        usuario.siguiente = null;
        ultimo = usuario;
    }
    
    public void limpiar(){
        primero = null;
        primero.siguiente = null;
        ultimo = null;
    }
}
