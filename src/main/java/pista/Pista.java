/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista;

/**
 *
 * @author Pc-pro
 */
public class Pista {
    
    private Integer kilometros;
    private Integer totalCarriles;
    
    public Pista(Integer kilometros, Integer totalCarriles) {
        this.kilometros = kilometros;
        this.totalCarriles = totalCarriles;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public Integer getTotalCarriles() {
        return totalCarriles;
    }
    
    
}
