/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista;

import identificadores.IdCarro;
import identificadores.IdJuego;
import vehiculo.Posicion;

/**
 *
 * @author Pc-pro
 */
public class Carril {
    private IdCarro idCarro;
    private IdJuego idJuego;
    private Posicion posicion;
    private Integer metros;
    private Boolean dezplazamientoFinal;
    
    public Carril () {
        
    }

    public Carril(IdCarro idCarro, IdJuego idJuego, Posicion posicion, Integer metros, Boolean dezplazamientoFinal) {
        this.idCarro = idCarro;
        this.idJuego = idJuego;
        this.posicion = posicion;
        this.metros = metros;
        this.dezplazamientoFinal = dezplazamientoFinal;
    }

    public Integer getMetros() {
        return metros;
    }

    public Posicion getPosicion() {
        return posicion;
    }
    
    public Integer getPosicionActual() {
        return posicion.getActual();
    }
    
    public Integer getPosicionMeta() {
        return posicion.getMeta();
    }

    public Boolean getDezplazamientoFinal() {
        return dezplazamientoFinal;
    }
    
    public void alcanzarMeta() {
        if (getPosicionActual() >= getPosicionMeta()) {
            dezplazamientoFinal = true;
        }
    }
    
    public void moverCarro(Posicion posicion, Integer cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.getActual() + cantidad);
        alcanzarMeta();
    }
    
}
