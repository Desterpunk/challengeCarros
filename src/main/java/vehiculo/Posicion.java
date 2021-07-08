/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculo;

/**
 *
 * @author Pc-pro
 */
public class Posicion {
    
    private Integer actual;
    private Integer meta;

    public Posicion(Integer actual, Integer meta) {
        this.actual = actual;
        this.meta = meta;
    }

    public void setActual(Integer actual) {
        this.actual = actual;
    }

    public Integer getActual() {
        return actual;
    }

    public Integer getMeta() {
        return meta;
    }
    
    
    
}
