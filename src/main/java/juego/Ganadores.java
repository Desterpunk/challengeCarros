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
public class Ganadores {
    private String nombre;
    private int vecesPrimero;
    private int vecesSegundo;
    private int vecesTercero;
    
    public Ganadores() {
        
    }

    public Ganadores(String nombre, int vecesPrimero, int vecesSegundo, int vecesTercero) {
        this.nombre = nombre;
        this.vecesPrimero = vecesPrimero;
        this.vecesSegundo = vecesSegundo;
        this.vecesTercero = vecesTercero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVecesPrimero(int vecesPrimero) {
        this.vecesPrimero = vecesPrimero;
    }

    public void setVecesSegundo(int vecesSegundo) {
        this.vecesSegundo = vecesSegundo;
    }

    public void setVecesTercero(int vecesTercero) {
        this.vecesTercero = vecesTercero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVecesPrimero() {
        return vecesPrimero;
    }

    public int getVecesSegundo() {
        return vecesSegundo;
    }

    public int getVecesTercero() {
        return vecesTercero;
    }

    
    
    
    
}
