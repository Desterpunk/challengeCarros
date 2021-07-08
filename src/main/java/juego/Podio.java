/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author Pc-pro
 */
public class Podio {
    
    private Jugadores primerLugar;
    private Jugadores segundoLugar;
    private Jugadores tercerLugar;
    
    public Podio() {
        
    }
    
    public void asignarPrimerLugar(Jugadores jugador) {
        primerLugar = jugador;
    }
    public void asignarSegundoLugar(Jugadores jugador) {
        segundoLugar = jugador;
    }
    public void asignarTercerLugar(Jugadores jugador) {
        tercerLugar = jugador;
    }

    public Jugadores getPrimerLugar() {
        return primerLugar;
    }

    public Jugadores getSegundoLugar() {
        return segundoLugar;
    }

    public Jugadores getTercerLugar() {
        return tercerLugar;
    }
    
    
    
    public Boolean estaLleno() {
        Boolean lleno = false;
        
        if (primerLugar != null && segundoLugar != null && tercerLugar != null) {
            lleno = true;
        }
        return lleno;
    }
}
