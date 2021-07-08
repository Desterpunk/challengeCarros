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
public class Conductor {
    private String nombre;
    
    public Conductor() {
        
    }
    
    //Constructor del conductor
    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public Integer lanzarDado() {
        int dadoAleatorio = (int) (Math.random() * 6 + 1);
        return dadoAleatorio;
    }    
      
}
