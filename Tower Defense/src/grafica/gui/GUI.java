package grafica.gui;

import logica.juego.*;
import logica.hilos.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int AnchoVentana, AltoVentana;
	private JPanel contentPane,panelSuperior;
	private Juego j;
	private JLabel puntaje, tiempo;
	private Contador contador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GUI(){
		super("Tower Defense");
		AnchoVentana= 1200; AltoVentana= 720;
		
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 0, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		j= new Juego(this);
		panelSuperior();
		contentPane.add(panelSuperior);
		contentPane.add(j.getAlmacen().getAlmacenPanel());
		
		contador=new Contador(j);
		contador.start();
		j.iniciar();
	}
	public JPanel getPanelPrincipal(){
		return contentPane;
	}
	public void finalizar(String s){
		contador.terminate();
		tiempo.setText(s);
	}
	private void panelSuperior(){
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setLayout(null);
		panelSuperior.setBounds(0, 0, AnchoVentana-10, AltoVentana/12);
		
		puntaje = new JLabel();
		puntaje.setBounds(AnchoVentana-300,0,150,70);
		puntaje.setText("Puntaje: "+j.getPuntaje());
		puntaje.setHorizontalAlignment(JLabel.LEFT);
		puntaje.setVerticalAlignment(JLabel.CENTER);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Arial",Font.ITALIC,20));
		
		tiempo = new JLabel();
		tiempo.setBounds(AnchoVentana-450,0,150,70);
		tiempo.setText("Tiempo: "+j.getTiempo());
		tiempo.setHorizontalAlignment(JLabel.LEFT);
		tiempo.setVerticalAlignment(JLabel.CENTER);
		tiempo.setForeground(Color.WHITE);
		tiempo.setFont(new Font("Arial",Font.ITALIC,20));

		JLabel fondo = new JLabel(new ImageIcon("src/Sprites/IconosBotones/FondoSuperior.png"));
		fondo.setBounds(0, 0, AnchoVentana-15, AltoVentana/12);
		
		panelSuperior.add(puntaje);
		panelSuperior.add(tiempo);
		panelSuperior.add(fondo);
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
}
