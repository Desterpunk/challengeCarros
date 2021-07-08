/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;


import identificadores.IdCarro;
import identificadores.IdJuego;
import identificadores.IdJugador;
import java.awt.Color;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import pista.Carril;
import pista.Pista;
import vehiculo.Carro;
import vehiculo.Conductor;
import vehiculo.Posicion;
import java.sql.*;

/**
 *
 * @author Pc-pro
 */
public class Juego {
    
    private Map<IdJugador, Jugadores> tablaJugadores = new HashMap<>();
    private ArrayList<Carro> carrosEnJuego = new ArrayList<>();
    private ArrayList<Carril> carrilesEnJuego = new ArrayList<>();
    private ArrayList<Pista> pistas = new ArrayList<>();
    private Podio podio = new Podio();
    private Ganadores data = new Ganadores();
    private final Carro carro = new Carro();   
    private Boolean jugando;
    
    //Nombre Jugador
    public String nombreJugador(Integer identificador){
        String nombre;
        Scanner entrada = new Scanner (System.in);
        System.out.println("Nombre del Jugador " + (identificador + 1));
        nombre = entrada.nextLine();
        
        return (identificador + 1)+"."+nombre;
    }
    
    //Creacion de Jugadores
    public void crearJugador(IdJugador idjugador, String nombre, Color color, Integer vecesPrimero, Integer vecesSegundo, Integer vecesTercero) {
        Jugadores jugador = new Jugadores(nombre, color, 0, 0, 0 , 0);
        tablaJugadores.put(idjugador, jugador);
        crearConductor(nombre);
    }
    
    //Creacion del conductor
    public void crearConductor(String nombre) {
        UUID id;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Desea que el jugador con nombre: " + nombre + " sea conductor ? " + "Y/N");
        while (!entrada.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ó y/n");
            entrada.next();
        }
        String consultaConductor = entrada.next();
        
        if(consultaConductor.equals("Y") || consultaConductor.equals("y")) {
            Conductor conductor = new Conductor(nombre);
            id = UUID.randomUUID();
            IdCarro Idcarro = new IdCarro(id);
            carro.asignarConductor(Idcarro, conductor);
        }
    }
    
    public void crearPistas() {
        int kilometrosRandom;
        int totalCarriles = carro.numeroCarros();
        for (int i = 0; i < carro.numeroCarros(); i++) {
            kilometrosRandom = (int) (Math.random() * 100 + 1);
            Pista pista = new Pista(kilometrosRandom, totalCarriles);
            pistas.add(pista);
        }
    }
    
    public void primerLugar(IdJugador idJugador) {
        podio.asignarPrimerLugar(tablaJugadores.get(idJugador));
        System.out.println("**********" + tablaJugadores.get(idJugador).getNombre() + ": Primer Lugar" + "***********");
        tablaJugadores.get(idJugador).setVecesPrimero(tablaJugadores.get(idJugador).getVecesPrimero()+1);
       
    }
    
    public void segundoLugar(IdJugador idJugador) {
        podio.asignarSegundoLugar(tablaJugadores.get(idJugador));
        System.out.println("**********" + tablaJugadores.get(idJugador).getNombre() + ": Segundo Lugar" + "***********");
        tablaJugadores.get(idJugador).setVecesSegundo(tablaJugadores.get(idJugador).getVecesSegundo()+1);
    }
    
    public void tercerLugar(IdJugador idJugador) {
        podio.asignarTercerLugar(tablaJugadores.get(idJugador));
        System.out.println("**********" + tablaJugadores.get(idJugador).getNombre() + ": Tercer Lugar" + "***********");
        tablaJugadores.get(idJugador).setVecesTercero(tablaJugadores.get(idJugador).getVecesTercero()+1);
    }
    
    public void iniciarJuego() {
        UUID id;
        id = UUID.randomUUID();
        IdJuego idJuego = new IdJuego(id);
        
        //Seleccion pista

        System.out.println("Elija la pista en la que desea jugar");
        int contador = 1;
        for (Pista p : pistas) {
            System.out.println(contador + "." + " Kilometros: " + p.getKilometros() + " Número de carriles:  " + p.getTotalCarriles());
            contador++;
            
        }
        
        Scanner entrada = new Scanner(System.in);
        int pistaElegida = entrada.nextInt();
        
        if(pistaElegida > pistas.size() || pistaElegida<=0){
            iniciarJuego();
        }
       //Lista de carros
       carro.carros().forEach((llave,conductor) -> {
     
           Carro carrosJuego = new Carro(conductor, 0, Color.yellow, idJuego);
           carrosEnJuego.add(carrosJuego);
           
           //Carriles con carros
           int kilometrosAMetros = pistas.get(pistaElegida - 1).getKilometros() * 1000;
           Posicion posicion = new Posicion(0, kilometrosAMetros);
           Carril carriles = new Carril(llave, idJuego, posicion, kilometrosAMetros, false);
           carrilesEnJuego.add(carriles);
       });
       
       //Inicio de juego
       
       jugando = true;
       Conductor conductor = new Conductor();
       System.out.println("----------Inicia la carrera--------");
       
       while(jugando) {
           int contador1 = 0;
           System.out.println("--------Avance----- " + "--------- Meta: " + carrilesEnJuego.get(contador1).getMetros() + " metros");
           
           for (Carro carros : carrosEnJuego) {
               //Mientras no haya ganado avanze
               if (!carroGanador(carros.conductor().getNombre())) {
                   int mover = conductor.lanzarDado() * 100;
                   carros.setDistancia(carros.distancia() + mover);
                   carrilesEnJuego.get(contador1).moverCarro(carrilesEnJuego.get(contador1).getPosicion(), mover);
                   System.out.println(carros.conductor().getNombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());
                   
                   if (carrilesEnJuego.get(contador1).getDezplazamientoFinal()) {
                       
                       if (podio.getPrimerLugar() == null) {
                           primerLugar(jugadorID(carros.conductor().getNombre()));
                           dataBaseModificar(carros.conductor().getNombre(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesPrimero(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesSegundo(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesTercero());
                       } else if (podio.getSegundoLugar() == null) {
                           segundoLugar(jugadorID(carros.conductor().getNombre()));
                           dataBaseModificar(carros.conductor().getNombre(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesPrimero(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesSegundo(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesTercero());
                       } else if (podio.getTercerLugar() == null) {
                           tercerLugar(jugadorID(carros.conductor().getNombre()));
                           dataBaseModificar(carros.conductor().getNombre(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesPrimero(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesSegundo(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesTercero());
                       }
                       //System.out.println(carros.conductor().getNombre()); 
                       //System.out.println(tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesPrimero()); 
                       //System.out.println(tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesSegundo()); 
                       //System.out.println(tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesTercero());
                       //dataBaseModificar(carros.conductor().getNombre(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesPrimero(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesSegundo(),tablaJugadores.get(jugadorID(carros.conductor().getNombre())).getVecesTercero());
  
                   }
                
               }

               contador1++;
           }
           if (podio.estaLleno()) {
                break;
            }
       }
       
       mostrarPodio();
       
       repetirJuego();
 
       
    }
    
       // Retorna el id del jugador dando el nombre del jugador
    public IdJugador jugadorID(String nombre) {
        IdJugador lookId = null;
        for (IdJugador keys : tablaJugadores.keySet()) {
            if (tablaJugadores.get(keys).getNombre().equals(nombre)) {
                lookId = keys;
            }
        }
        return lookId;
    }
    
    //Retorna True  si el carro en la carrera ya ganó
    public Boolean carroGanador(String nombre) {
        boolean ganador = false;
        if (podio.getTercerLugar() == tablaJugadores.get(jugadorID(nombre))
            || podio.getPrimerLugar() == tablaJugadores.get(jugadorID(nombre))
            || podio.getSegundoLugar() == tablaJugadores.get(jugadorID(nombre))) {
            ganador = true;
        }
        return ganador;
    }
    
        //Método para mostrar los conductores que quedaron en el podio 
    public void mostrarPodio() {
        System.out.println("--------Podio--------");
        System.out.println("Primer Lugar:  " + podio.getPrimerLugar().getNombre());
        System.out.println("Segundo Lugar:  " + podio.getSegundoLugar().getNombre());
        System.out.println("Tercer Lugar:  " + podio.getTercerLugar().getNombre());
        System.out.println("----------------------");
    }
    
    // Método para saber si repetir el juego y limpiar listas de juego anterior
    public void repetirJuego() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Desea jugar otra carrera?  Y/N");
        while (!entrada.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ó y/n");
            entrada.next();
        }
        String jugarOtro = entrada.next();
        if (jugarOtro.equals("Y") || jugarOtro.equals("y")) {
            carrosEnJuego.clear();
            carrilesEnJuego.clear();
            Podio podioNuevo = new Podio();
            podio = podioNuevo;
            iniciarJuego();
        }
        else {
            Ganadores data = new Ganadores();
        }

    }
    
    public void dataBaseInsertar(String nombre, Integer vecesPrimero, Integer vecesSegundo, Integer vecesTercero) {
        try{
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sofkadata","root","root");
            Statement miStatement = miConexion.createStatement(); 
            String instruccionSql = "INSERT INTO GANADORES (nombre,vecesPrimero,vecesSegundo,vecesTercero) VALUES ('" + nombre + "' ," + vecesPrimero +","+vecesSegundo+","+vecesTercero+")";
            //String instruccionSql = ("UPDATE CLIENTES SET nombre='sofku' WHERE id=12"); 
            miStatement.executeUpdate(instruccionSql);
            System.out.println("Datos insertados correctamente");
        } catch(Exception e) {
            //System.out.println("NO CONECTA CON LA BASE DE DATOS!");
            //e.printStackTrace();
        }
    }
    public void dataBaseModificar(String nombre, Integer vecesPrimero, Integer vecesSegundo, Integer vecesTercero) {
        try{
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sofkadata","root","root");
            Statement miStatement = miConexion.createStatement(); 
            String instruccionSql = "UPDATE GANADORES SET vecesPrimero="+vecesPrimero+",vecesSegundo="+vecesSegundo+",vecesTercero="+vecesTercero+" WHERE nombre='"+nombre+"'"; 
            miStatement.executeUpdate(instruccionSql);
            System.out.println("Datos insertados correctamente");
        } catch(Exception e) {
            //System.out.println("NO CONECTA CON LA BASE DE DATOS!");
            //e.printStackTrace();
        }
    }
    public void dataBaseBorrar() {
        try{
            Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sofkadata","root","root");
            Statement miStatement = miConexion.createStatement(); 
            String instruccionSql = ("DELETE FROM GANADORES"); 
            miStatement.executeUpdate(instruccionSql);
            System.out.println("Creando nueva base de datos");
        } catch(Exception e) {
            System.out.println("NO CONECTA CON LA BASE DE DATOS!");
            e.printStackTrace();
        }
    }
    
}
