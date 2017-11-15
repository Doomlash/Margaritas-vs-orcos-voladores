package grafica.gui;

import logica.juego.*;
import logica.hilos.*;
import aTesters.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private static int AnchoVentana, AltoVentana;
	private JPanel panelSuperior;
	private Juego j;
	private JLabel puntaje, tiempo, hordas;
	private ImageIcon[] cantHordas;
	private Contador contador;
	private int hordaActual=1;
	private VentanaInicio ventana;

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
		tiempo.setText(s);
	}
	public void ejecutar(){
		if(j==null){
			j=new Juego(this);
			panelSuperior();
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
	private void panelSuperior(){
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setLayout(null);
		panelSuperior.setBounds(0, 0, AnchoVentana-10, AltoVentana/12);
		
		puntaje = new JLabel();
		puntaje.setBounds(AnchoVentana-150,0,150,60);
		puntaje.setText("Puntaje: "+j.getPuntaje());
		puntaje.setHorizontalAlignment(JLabel.LEFT);
		puntaje.setVerticalAlignment(JLabel.CENTER);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Arial",Font.ITALIC,20));
		
		tiempo = new JLabel();
		tiempo.setBounds(AnchoVentana-300,0,150,60);
		tiempo.setText("Tiempo: "+j.getTiempo());
		tiempo.setHorizontalAlignment(JLabel.LEFT);
		tiempo.setVerticalAlignment(JLabel.CENTER);
		tiempo.setForeground(Color.WHITE);
		tiempo.setFont(new Font("Arial",Font.ITALIC,20));
		
		hordas();
		backButton();

		JLabel fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoSuperior.png"));
		fondo.setBounds(0, 0, AnchoVentana-15, AltoVentana/12);
		
		panelSuperior.add(puntaje);
		panelSuperior.add(tiempo);
		panelSuperior.add(fondo);
	}
	private void cambiar(JPanel panel){
		ventana.cambiar(this, panel);
	}
	private void backButton(){
		JButton back = new JButton();
		back.setBorder(null);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusable(false);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				j.pausar();
				pausar();
				cambiar(ventana.getInicio());
			}
		});
		back.setBounds(5,0,60,60);
		back.setIcon(new ImageIcon("src/Sprites/IconosBotones/Back.png"));
		back.setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/BackEntered.png"));
		back.setPressedIcon(new ImageIcon("src/Sprites/IconosBotones/BackSelected.png"));
		add(back);
	}
	private void hordas(){
		cantHordas = new ImageIcon[4];
		for(int i=0;i<cantHordas.length;i++){
			cantHordas[i] = new ImageIcon("src/Sprites/IconosBotones/Horda"+i+".png");
		}
		
		hordas = new JLabel(cantHordas[hordaActual]);
		hordas.setBounds(220,0,150,60);
		hordas.setHorizontalAlignment(JLabel.LEFT);
		hordas.setVerticalAlignment(JLabel.CENTER);
		hordas.setForeground(Color.WHITE);
		hordas.setFont(new Font("Arial",Font.ITALIC,20));
		
		panelSuperior.add(hordas);
	}
	public void actualizarPuntaje(){
		puntaje.setText("Puntaje: "+j.getPuntaje());		
	}
	public void actualizarTemporizador(){
		tiempo.setText("Tiempo: "+j.getTiempo());
	}
	public int getAncho(){
		return AnchoVentana;
	}
	public int getAlto(){
		return AltoVentana;
	}
	public void actualizarNumHordas(){
		hordaActual=(hordaActual+1)%cantHordas.length;
		hordas.setIcon(cantHordas[hordaActual]);
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
}
