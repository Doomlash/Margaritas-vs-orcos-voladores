package grafica.gui;

import logica.juego.*;
import logica.hilos.*;
import aTesters.*;

import javax.swing.JPanel;

public class GUI extends JPanel {
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
	public GUI(VentanaInicio v){
		ventana=v;
//		super("Tower Defense");
		AnchoVentana= 1200; AltoVentana= 720;
		
//		this.setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, AnchoVentana, AltoVentana);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
//		setContentPane(contentPane);

//		j= new Juego(this);
//		contentPane.add(panelSuperior);
//		contentPane.add(j.getAlmacen().getAlmacenPanel());
		
//		contador=new Contador(j);
//		contador.start();
//		j.iniciar();
	}
	public JPanel getPanelPrincipal(){
		return this;
	}
	public void finalizar(String s){
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
		ventana.getInicio().juegoFinalizado();
		ventana.cambiar(this, ventana.getInicio());
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
