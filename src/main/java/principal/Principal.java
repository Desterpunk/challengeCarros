/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import identificadores.IdJugador;
import java.awt.Color;
import java.util.Scanner;
import java.util.UUID;
import juego.Juego;



/**
 *
 * @author Pc-pro
 */
public class Principal {
    
    public static void main(String[] args) {
        
        
        int totalJugadores;
        UUID id;
        String nombreJugador;
        
        Juego nuevoJuego = new Juego();
        
        //Datos jugadores para iniciar el juego
        System.out.println("Iniciando un nuevo juego ...");
        nuevoJuego.dataBaseBorrar();
        
        //Cantidad jugadores
        Scanner entrada = new Scanner (System.in);
        System.out.println("¿Cuántos jugadores desea crear?");
        while(!entrada.hasNextInt()) entrada.next();         
        totalJugadores = entrada.nextInt();
        
        for (int i = 0; i < totalJugadores; i++) {
            id = UUID.randomUUID();
            IdJugador idJugador = new IdJugador(id);
            nombreJugador = nuevoJuego.nombreJugador(i);
            nuevoJuego.crearJugador(idJugador, nombreJugador, Color.yellow,0,0,0);
            nuevoJuego.dataBaseInsertar(nombreJugador,0,0,0);
        }
        
     
        
        //Pista
        nuevoJuego.crearPistas();
        
        //Inicio
        nuevoJuego.iniciarJuego();
    }
    
}
