
package juegoescaleras;

//import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;



public class InterfazJuego extends JFrame{
    
    // Atributos
    private Dado dado = new Dado();
    private Tablero tablero = new Tablero();
    
    // Componentes de la GUI
    private ImageIcon imagen;
    
    private Container principal;
    private JLayeredPane lpane = new JLayeredPane();
    private JPanel tabla, tiro, serpYesca;
    private JLabel d1;
    
    private JTextArea salida;
    private JScrollPane scrollxd;
    
    private JTextArea salidaResultado;
    private ArrayList<JTextField> tableroGUI;
    
    private JButton boton = new JButton("Lanzar dado");
    private HiloJuego h = new HiloJuego(this);
    
    
    private void declaraciones(){
    	
        // Creacion del registro de los movimientos de los jugadores
        this.salida = new JTextArea(5,5); // Despues se elimina esto cuando se implemente los dados 
        salida.setEditable(false);
        this.scrollxd = new JScrollPane(salida); // Despues se elimina esto
        
        this.salidaResultado = new JTextArea();
        this.salidaResultado.setEditable(false);
        
        imagen = new ImageIcon("src/imagenes/dado.png");
		d1 = new JLabel(imagen);
		
        // Creacion de la tabla 
        tabla = new JPanel();
        tabla.setLayout(new GridLayout(10,10));
        tableroGUI = new ArrayList<JTextField>();
        // Se pone el array tal cual
        for(int i=0; i<=100; i++){
            tableroGUI.add(new JTextField(Integer.toString(i+1)));
            tableroGUI.get(i).setEditable(false);
        }
        //for (int i=100; i!=0;i--)
        	//tabla.add(tableroGUI.get(i));
        // Por aqui se ordena de tal forma que se vea como la tabla de escalerita
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(99-i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(80+i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(79-i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(60+i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(59-i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(40+i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(39-i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(20+i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(19-i));
        }
        for(int i=0; i<10; i++){
            tabla.add(tableroGUI.get(0+i));
        }
       
        // Creacion de el panel de tiro
        this.tiro = new JPanel();
        this.tiro.setLayout(new BoxLayout(tiro, BoxLayout.X_AXIS));
        this.tiro.add(d1);
        this.tiro.add(this.boton);
        this.tiro.add(this.salidaResultado);
        
        //Creaci�n del panel de Serpientes y Escaleras.
        BufferedImage serpiente1 = null;
        try {
        	serpiente1 = ImageIO.read(new File("src/imagenes/serpiente-negra-extensa.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        BufferedImage subImage = serpiente1.getSubimage(0,0,200,200);
        ImageIcon objetoSerpiente = new ImageIcon(subImage);
        JLabel serpi = new JLabel(objetoSerpiente);
        this.serpYesca = new JPanel();
        lpane.setBounds(100, 100, 500, 500);	
        this.serpYesca.add(serpi);

        //Superposici�n
        this.tabla.setOpaque(true);
        this.serpYesca.setOpaque(true);
        lpane.add(tabla, lpane.DRAG_LAYER);
        lpane.add(serpYesca, new Integer(1), 1);
        
        // Creacion del panel principal
        this.principal = getContentPane();
        this.principal.setLayout(new BorderLayout());
        this.principal.add(this.scrollxd,BorderLayout.NORTH);
        this.principal.add(this.tabla,BorderLayout.CENTER);
//        this.principal.add(this.lpane,BorderLayout.CENTER);
        this.principal.add(this.tiro,BorderLayout.SOUTH);
        
        // Listener
        this.boton.addActionListener(new ManejadorDeEventos());
    }
    

    
    public void actualizarTablero(){
        // Aqui es donde se realiza la conexion entre el tablero de la clase tablero (donde esta 
        // implementado toda la parte logica) y el tablero GUI (solo es un espejo de la logica)
        for(int i=0; i<tablero.getCasillas().size(); i++){
            tableroGUI.get(i).setText(Integer.toString(i));
            // Aqui se dibujaran a los personajes
            if(tablero.buscarJugadorEnTablero(tablero.getJugadores().get(0)) == i){ // Si da -1 significa que no esta en la casilla
                String infoActual=tableroGUI.get(i).getText();
                tableroGUI.get(i).setText(infoActual + "\nJugador");
            }
            if(tablero.buscarJugadorEnTablero(tablero.getJugadores().get(1)) == i){
                //System.out.println(i);
                String infoActual=tableroGUI.get(i).getText();
                tableroGUI.get(i).setText(infoActual + "\nBot1");
            }
            if(tablero.buscarJugadorEnTablero(tablero.getJugadores().get(2)) == i){
                String infoActual=tableroGUI.get(i).getText();
                tableroGUI.get(i).setText(infoActual + "\nBot2");
            }
        }
    }
    
    
    public InterfazJuego(){
        this.declaraciones();
        this.actualizarTablero();
        
        setTitle("Escalerita Bizzare Adventure");
       setSize(1280,720);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
  
    }
    
    public class ManejadorDeEventos implements ActionListener {
        
        private int contador = 1;

        @Override
        public void actionPerformed(ActionEvent e) {
            if(tablero.getCasillas().get(99).getJugadores().size()==0){
                salida.append("Ronda #" + Integer.toString(contador) + "\n");	
                
                inicializarHilo();
                h.start();
                
                salida.append("-------------\n");
                contador++;
                
            }else{
                JOptionPane.showMessageDialog(null, "Felicidades " + 
                        tablero.getCasillas().get(99).getJugadores().get(0).getId() +
                        ", has sido el ganador!");
            }
            
            
        }
        
        
        
        
    }
    
    public void moverUnJugador (Jugador jugador, int valor){
        if(valor!=0){
            tablero.moverJugador(jugador, valor);
            actualizarTablero();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());}
            moverUnJugador(jugador,valor-1);
            
        }else{
            System.out.println("Termino su movimiento");
        }
    }
    
    //se crea otro objeto de tipo hilo, porque cada vez que se acabe debe volverse a ejecutar
    public void inicializarHilo() {
    this.h = new HiloJuego(this);
    
    }
    
	public Tablero getTablero() {
		return tablero;
	}


	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}


	public JButton getBoton() {
		return boton;
	}


	public void visualizarCaras() {
    	imagen = new ImageIcon("src/imagenes/"+dado.getDado()+".png");
		d1.setIcon(imagen);
    }


	public Dado getDado() {
		return dado;
	}


	public JTextArea getSalida() {
		return salida;
	}


	public JTextArea getSalidaResultado() {
		return salidaResultado;
	}
   
    
}
