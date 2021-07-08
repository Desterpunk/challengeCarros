/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package identificadores;

import java.util.UUID;

/**
 *
 * @author Pc-pro
 */
public class IdCarro {
    
    private UUID id;

    //construcctor IdCarro
    public IdCarro(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }  
}
