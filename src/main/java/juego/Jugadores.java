/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import java.awt.Color;

/**
 *
 * @author Pc-pro
 */
public class Jugadores {
    private String nombre;
    private Color color;
    private Integer puntos;
    private Integer vecesPrimero;
    private Integer vecesSegundo; 
    private Integer vecesTercero;
    
    public Jugadores(String nombre, Color color, Integer puntos, Integer vecesPrimero, Integer vecesSegundo, Integer vecesTercero) {
        this.nombre = nombre;
        this.color = color;
        this.puntos = puntos;
        this.vecesPrimero = vecesPrimero;
        this.vecesSegundo = vecesSegundo;
        this.vecesTercero = vecesTercero;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public Color getColor() {
        return color;
    }
    
    

    public void setVecesPrimero(Integer vecesPrimero) {
        this.vecesPrimero = vecesPrimero;
    }

    public void setVecesSegundo(Integer vecesSegundo) {
        this.vecesSegundo = vecesSegundo;
    }

    public void setVecesTercero(Integer vecesTercero) {
        this.vecesTercero = vecesTercero;
    }

    public Integer getVecesPrimero() {
        return vecesPrimero;
    }

    public Integer getVecesSegundo() {
        return vecesSegundo;
    }

    public Integer getVecesTercero() {
        return vecesTercero;
    }
    
    
    
    
}
