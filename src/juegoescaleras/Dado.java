
package juegoescaleras;

import java.util.Random;

public class Dado {
    private int dado;
    
    
    public int getDado(){
        return dado;
    }
    
    public void lanzarDado(){
    	Random aleatorio = new Random();
    	this.dado = aleatorio.nextInt(6)+1;;
        //this.dado = (int)(Math.random()*6+1);
        System.out.println("El tiro fue de :" + this.getDado());
    }
}