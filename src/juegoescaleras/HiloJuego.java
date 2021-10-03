package juegoescaleras;

import juegoescaleras.InterfazJuego.ManejadorDeEventos;

public class HiloJuego extends Thread {

InterfazJuego interfaz;



public HiloJuego(InterfazJuego interfaz) {
	super();
	this.interfaz = interfaz;
}


public void run() {
	//deshabilitar boton del interfaz cada que se haga un lanzamiento
	
		
		
		interfaz.getBoton().setEnabled(false);
		

        interfaz.getDado().lanzarDado();
        interfaz.visualizarCaras();
        int valor = interfaz.getDado().getDado();
        interfaz.getSalidaResultado().setText("Tu dado tiro: " + Integer.toString(valor));
        
        interfaz.moverUnJugador(interfaz.getTablero().getJugadores().get(0),valor);
        interfaz.getSalida().append("El jugador saco " + Integer.toString(valor) + "\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());}
        
        
        interfaz.getDado().lanzarDado();
        interfaz.visualizarCaras();
        valor = interfaz.getDado().getDado();
        interfaz.moverUnJugador(interfaz.getTablero().getJugadores().get(2),valor);
        interfaz.getSalidaResultado().setText("El Bot 1 tiro: " + Integer.toString(valor));
        interfaz.getSalida().append("El Bot#1 saco: " + Integer.toString(valor) + "\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());}
        
        interfaz.getDado().lanzarDado();
        interfaz.visualizarCaras();
        valor = interfaz.getDado().getDado();
        interfaz.moverUnJugador(interfaz.getTablero().getJugadores().get(1),valor);
        interfaz.getSalidaResultado().setText("El Bot 2 tiro: " + Integer.toString(valor));
        interfaz.getSalida().append("El Bot#2 saco: " + Integer.toString(valor) + "\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());}

        
        interfaz.getBoton().setEnabled(true);
        
        
}


//metodo que consulta si ya ganaste
public boolean ganado() {
	if(interfaz.getTablero().getCasillas().get(99).getJugadores().size()==0){
	return false;
	
}else return true;
}







}
