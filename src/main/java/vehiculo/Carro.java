/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculo;

import identificadores.IdCarro;
import identificadores.IdJuego;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pc-pro
 */
public class Carro {
    protected Conductor conductor;
    protected Color color;
    protected Integer distancia;
    protected IdJuego idjuego;
    private final Map<IdCarro, Conductor> carros = new HashMap<>();

    public Carro() {
    }
    
    public Carro(Conductor conductor, Integer distancia, Color color, IdJuego Idjuego) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.color = color;
        this.idjuego = Idjuego;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }
    
    
    public void asignarConductor(IdCarro Idcarro, Conductor conductor) {
        carros.put(Idcarro, conductor);
    }
    
    public Map<IdCarro, Conductor> carros() {
        return carros;
    }
    
    public Integer numeroCarros() {
        return carros.size();
    }
    
    public Conductor conductor() {
        return conductor;
    }
    
    public Integer distancia() {
        return distancia;
    }

    public Color color() {
        return color;
    }
    
     
}
