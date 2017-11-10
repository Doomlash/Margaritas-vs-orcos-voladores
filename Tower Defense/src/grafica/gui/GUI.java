package grafica.gui;

import logica.entidad.enemigo.*;
import logica.juego.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int AnchoVentana, AltoVentana;
	private JPanel contentPane,panelSuperior,panelDerecha;
	private Juego j;
	private JLabel presupuesto, puntaje, tiempo;
	private Enemigo[] ene;

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
	

	/*ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	*/
	public Enemigo[] getEnemigos(){
		return ene;
	}
	/**
	 * Create the frame.
	 */
	public GUI(){
		super("Tower Defense");
		AnchoVentana= 1240; AltoVentana= 720;
		j= new Juego(this);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 0, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelSuperior();
		panelDerecha();
		contentPane.add(panelSuperior);
		contentPane.add(j.getNivel().getMapa().getMapaGrafico(),BorderLayout.CENTER);
		contentPane.add(j.getAlmacen().getAlmacenPanel());
		contentPane.add(panelDerecha);
		
	}
	public void finalizar(){
		j.getNivel().getMapa().getAlmacenHilos().terminateAll();
	}
	private void panelSuperior(){
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		panelSuperior.setLayout(null);
		panelSuperior.setBounds(0, 0, AnchoVentana, AltoVentana/12);
		

		
		puntaje = new JLabel();
		puntaje.setBounds(AnchoVentana-300,0,150,70);
		puntaje.setText("Puntaje: "+j.getPuntaje());
		puntaje.setHorizontalAlignment(JLabel.LEFT);
		puntaje.setVerticalAlignment(JLabel.CENTER);
		puntaje.setForeground(Color.WHITE);
		puntaje.setFont(new Font("Arial",Font.ITALIC,20));
		
		presupuesto = new JLabel();
		presupuesto.setBounds(AnchoVentana-150,0,150,70);
		presupuesto.setBorder(new LineBorder(Color.WHITE));
		presupuesto.setText("$ "+j.getNivel().getPresupuesto());
		presupuesto.setHorizontalAlignment(JLabel.CENTER);
		presupuesto.setVerticalAlignment(JLabel.CENTER);
		presupuesto.setForeground(Color.WHITE);
		presupuesto.setFont(new Font("Arial",Font.ITALIC,20));
		
		tiempo = new JLabel();
		tiempo.setBounds(AnchoVentana-450,0,150,70);
		tiempo.setText("Tiempo: "+j.getTiempo());
		tiempo.setHorizontalAlignment(JLabel.LEFT);
		tiempo.setVerticalAlignment(JLabel.CENTER);
		tiempo.setForeground(Color.WHITE);
		tiempo.setFont(new Font("Arial",Font.ITALIC,20));
		
		panelSuperior.add(puntaje);
		panelSuperior.add(presupuesto);
		panelSuperior.add(tiempo);
	}
	
	private void panelDerecha(){
		panelDerecha = new JPanel();
		panelDerecha.setBackground(Color.DARK_GRAY);
		panelDerecha.setBounds(AnchoVentana/12*11, AltoVentana/12, AnchoVentana/12, AltoVentana);
		panelDerecha.setLayout(null);
		
		ene = new Enemigo[7];
		
		String e[] = {"Ciclope","Dragon","Goblin","Lich","Nigromante","Ogro","Cerberus"};
		JButton enemigos[] = new JButton[e.length];
		OyenteEnemigo oy = new OyenteEnemigo();
		for(int i=0;i<enemigos.length;i++){
			enemigos[i] = new JButton(e[i]);
			enemigos[i].setBounds(0,i*AltoVentana/15,AnchoVentana/12,AltoVentana/15);
			enemigos[i].addActionListener(oy);
			enemigos[i].setFocusable(false);
			panelDerecha.add(enemigos[i]);
		}
	}
	public void actualizarPuntaje(){
		puntaje.setText("Puntaje: "+j.getPuntaje());		
	}
	public void actualizarPresupuesto(){
		presupuesto.setText("$ "+j.getNivel().getPresupuesto());
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
	private class OyenteEnemigo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s= e.getActionCommand();
			Random r = new Random();
			int fila= r.nextInt(6);
			switch(s){
				case "Ciclope":{
					if(ene[0]==null){
						ene[0] = new Ciclope(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[0])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[0]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[0]);
						}
						else
							ene[0]=null;
					}
					else{
						ene[0].kill();
						ene[0]=null;
					}
					break;
				}
				case "Dragon":{
					if(ene[1]==null){
						ene[1] = new Dragon(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[1])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[1]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[1]);
						}
						else
							ene[1]=null;
					}
					else{
						ene[1].kill();
						ene[1]=null;
					}
					break;
				}
				case "Goblin":{
					if(ene[2]==null){
						ene[2] = new Goblin(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[2])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[2]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[2]);
						}
						else
							ene[2]=null;
					}
					else{
						ene[2].kill();
						ene[2]=null;
					}
					break;
				}
				case "Lich":{
					if(ene[3]==null){
						ene[3] = new Lich(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[3])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[3]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[3]);
						}
						else
							ene[3]=null;
					}
					else{
						ene[3].kill();
						ene[3]=null;
					}
					break;
				}
				case "Nigromante":{
					if(ene[4]==null){
						ene[4] = new Nigromante(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[4])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[4]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[4]);
//						j.getNivel().getMapa().getAlmacenHilos().getInvocacioNigromante().agregarNigromante((Nigromante)ene[4]);
						}
						else
							ene[4]=null;
					}
					else{
						ene[4].kill();
						ene[4]=null;
					}
					break;
				}
				case "Ogro":{
					if(ene[5]==null){
						ene[5] = new Ogro(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[5])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[5]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[5]);
						}
						else
							ene[5]=null;	
					}
					else{
						ene[5].kill();
						ene[5]=null;
					}
					break;
				}
				case "Cerberus":{
					if(ene[6]==null){
						ene[6] = new Cerberus(9,fila,j.getNivel().getMapa());
						if(j.getNivel().getMapa().agregarElemento(ene[6])){
							j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[6]);
							j.getNivel().getMapa().getAlmacenHilos().getAtaEnemigo().agregarEnemigo(ene[6]);
						}
						else
							ene[0]=null;
					}
					else{
						ene[6].kill();
						ene[6]=null;
					}
					break;
				}
				case "Finalizar":{
					finalizar();
				}
			}
		}
	}
}
