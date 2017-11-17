package grafica.gui;

import logica.juego.*;
import logica.hilos.*;

import javax.swing.JPanel;

import interfazGrafica.*;
import interfazGrafica.Paneles.PanelDerrota;
import interfazGrafica.Paneles.PanelVictoria;

public class PanelJuego extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int AnchoVentana, AltoVentana;
	private PanelSuperior panelSuperior;
	private Juego j;
	private Contador contador;
	private VentanaInicio ventana;
	protected final String dir = "src/Sprites/";

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI frame = new GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public PanelJuego(VentanaInicio v){
		ventana=v;
		AnchoVentana= 1200; AltoVentana= 720;
		setBounds(0, 0, AnchoVentana, AltoVentana);
		this.setLayout(null);
	}
	public JPanel getPanelPrincipal(){
		return this;
	}
	public void finalizar(){
		contador.terminate();
		ventana.getInicio().juegoFinalizado();
	}
	public void ejecutar(){
		if(j==null){
			j=new Juego(this);
			panelSuperior = new PanelSuperior(AnchoVentana,AltoVentana,this);
			this.add(panelSuperior);
			this.add(j.getAlmacen().getAlmacenPanel());
			contador=new Contador(j);
			contador.start();
			j.iniciar();
		}
		else{
			j.reanudar();
			reanudar();
		}
	}
	public void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	public int getAncho(){
		return AnchoVentana;
	}
	public int getAlto(){
		return AltoVentana;
	}
	public void ganar(){
		ventana.cambiar(this, new PanelVictoria(ventana));
	}
	public void perder(){
		ventana.cambiar(this, new PanelDerrota(ventana));
	}
	public void pausar(){
		contador.pausar();
	}
	public void reanudar(){
		contador.reanudar();
	}
	public void terminate(){
		if(j!=null)
			j.finalizar();
		if(contador!=null)
			contador.terminate();
	}
	public Juego getJuego(){
		return j;
	}
	public VentanaInicio getVentana(){
		return ventana;
	}
	public PanelSuperior getPanelSuperior(){
		return panelSuperior;
	}
}
