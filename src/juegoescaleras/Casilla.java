
package juegoescaleras;

import java.util.ArrayList;

public class Casilla {
   private int id;
   private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
   
   public Casilla(int id){
       this.id = id;
   }
   
   public ArrayList<Jugador> getJugadores(){
       return jugadores;
   }
   
   public int getId(){
       return id;
   }
   
   public void agregarJugador(Jugador jugador){
       jugadores.add(jugador);
       
       String mensaje = "";
       for(int i=0; i<jugadores.size();i++){
           mensaje = jugadores.get(i).getId() + " ";
       }
       System.out.println("Los jugadores son: " + mensaje);
   }
   
   public void quitarJugador(Jugador jugador){
       String mensaje = "Inicio: ";
       for(int i=0; i<jugadores.size();i++){
           mensaje = mensaje + " " + jugadores.get(i).getId();
       }
       System.out.println(mensaje);
       
       
       jugadores.remove(jugadores.indexOf(jugador));
       
       String mensaje2 = "Despues de tirar: ";
       for(int i=0; i<jugadores.size();i++){
           mensaje2 = mensaje2 + " " + jugadores.get(i).getId();
       }
       System.out.println(mensaje2);
       

   }
}