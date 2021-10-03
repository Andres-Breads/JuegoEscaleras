
package juegoescaleras;

import java.util.ArrayList;


public class Tablero{
    
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    
    
    public Tablero(){
        for(int i=1; i<101; i++){
            casillas.add(new Casilla(i+1));
        }
        
        jugadores.add(new Jugador("jugador"));
        jugadores.add(new Jugador("bot 1"));
        jugadores.add(new Jugador("bot 2")); 
        
        // Agregamos los jugadores en la primera casilla
        casillas.get(0).agregarJugador(jugadores.get(0));
        casillas.get(0).agregarJugador(jugadores.get(1));
        casillas.get(0).agregarJugador(jugadores.get(2));
        
        
    }
    
    // Mueve al jugador una vez
    public void moverJugador(Jugador jugador, int valorDado){
        int posJugador = buscarJugadorEnTablero(jugador);
        
        casillas.get(posJugador).quitarJugador(jugador);
        casillas.get(posJugador+1).agregarJugador(jugador);
        
             
    }
    
    public int buscarJugadorEnTablero(Jugador jugador){
        int pos = -1;
        for(int i=0; i<casillas.size(); i++){
            if(casillas.get(i).getJugadores().indexOf(jugador) != -1){
                pos = i;
                System.out.println("El jugador esta la posicion: " + i);
            }
        }
        if(pos == -1) System.out.println("El jugador no se encontro :(");
        return pos;
    }
    
    
    
}
