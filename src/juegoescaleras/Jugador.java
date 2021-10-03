
package juegoescaleras;


public class Jugador {

    private String id;
    private int puntajeDado;
    
    public Jugador(String id){
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public int getPuntajeDado(){
        return puntajeDado;
    }
    
    public void setPuntajeDado(int puntajeDado){
        this.puntajeDado = puntajeDado;
    }
    
    
}
