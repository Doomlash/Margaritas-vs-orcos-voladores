package grafica.gui;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.juego.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private JPanel contentPane,panelSuperior,panelIzquierda,panelDerecha;
	private Juego j;
	private JLabel presupuesto, puntaje;
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

	/**
	 * Create the frame.
	 */
	public GUI(){
		super("Tower Defense");
		this.setResizable(false);
		AnchoVentana= 1240; AltoVentana= 680;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 20, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		j= new Juego(this);
		
		panelSuperior();
		panelIzquierda();
		panelDerecha();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		contentPane.add(j.getNivel().getMapa().getMapaGrafico(),BorderLayout.CENTER);
		contentPane.add(panelIzquierda, BorderLayout.WEST);
		contentPane.add(panelDerecha, BorderLayout.EAST);
		
	}
	private void panelSuperior(){
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.GRAY);
		panelSuperior.setLayout(null);
		panelSuperior.setPreferredSize(new Dimension(AnchoVentana,65));
		

		
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
		
		panelSuperior.add(puntaje);
		panelSuperior.add(presupuesto);
	}
	private void panelIzquierda(){
		panelIzquierda = new JPanel();
		panelIzquierda.setBackground(Color.GRAY);
		panelIzquierda.setPreferredSize(new Dimension(AnchoVentana/12,AltoVentana));
		panelIzquierda.setLayout(null);
		
		String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta"};
		//"Barricada","Dragon","Armadura","Curacion","Booster","Escudo","Bomba","Trampa"};
		JButton colocables[] = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds(0,i*AltoVentana/15,AnchoVentana/12,AltoVentana/15);
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			panelIzquierda.add(colocables[i]);
		}
		
		JButton eliminar[] = new JButton[c.length];
		OyenteEliminar oyE = new OyenteEliminar();
		for(int i=0;i<eliminar.length;i++){
			eliminar[i] = new JButton(c[i]);
			eliminar[i].setBounds(0,(i+7)*AltoVentana/15,AnchoVentana/12,AltoVentana/15);
			eliminar[i].addActionListener(oyE);
			eliminar[i].setFocusable(false);
			eliminar[i].setBackground(Color.ORANGE);
			panelIzquierda.add(eliminar[i]);
		}
	}
	private void panelDerecha(){
		panelDerecha = new JPanel();
		panelDerecha.setBackground(Color.DARK_GRAY);
		panelDerecha.setPreferredSize(new Dimension(AnchoVentana/12,AltoVentana));
		panelDerecha.setLayout(null);
		
		ene = new Enemigo[6];
		
		String e[] = {"Ciclope","Dragon","Goblin","Lich","Nigromante","Ogro"};
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
	
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			if(j.getNivel().getMapa().celdasVacias()){
				Random r = new Random();
				int fila, columna;
				Aliado a = null;
				fila = r.nextInt(6);
				columna = r.nextInt(10);
				while(!j.getNivel().getMapa().getCelda(columna, fila).isEmpty()){
					fila = r.nextInt(6);
					columna = r.nextInt(10);
				}
				if(s=="Caballero"){
					a= new Caballero(columna,fila,j.getNivel().getMapa());
				}
				if(s=="Arquero"){
					a= new Arquero(columna,fila,j.getNivel().getMapa());
				}
				if(s=="Monje"){
					a= new Monje(columna,fila,j.getNivel().getMapa());
				}
				if(s=="Catapulta"){
					a= new Catapulta(columna,fila,j.getNivel().getMapa());
				}
				if(s=="Mago"){
					a= new Mago(columna,fila,j.getNivel().getMapa());
				}
				for(int i=a.getX();i<(a.getDimensionX()+a.getX());i++){
					j.getNivel().getMapa().agregarElemento(a.getX(), a.getY(), a);
				}
			}
		}
	}
	
	private class OyenteEliminar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
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
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[0]);
						j.getNivel().getMapa().agregarElemento(ene[0].getX(), ene[0].getY(), ene[0]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[0]);
						ene[0].kill();
						ene[0]=null;
					}
					break;
				}
				case "Dragon":{
					if(ene[1]==null){
						ene[1] = new Dragon(9,fila,j.getNivel().getMapa());
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[1]);
						j.getNivel().getMapa().agregarElemento(ene[1].getX(), ene[1].getY(), ene[1]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[1]);
						ene[1].kill();
						ene[1]=null;
					}
					break;
				}
				case "Goblin":{
					if(ene[2]==null){
						ene[2] = new Goblin(9,fila,j.getNivel().getMapa());
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[2]);
						j.getNivel().getMapa().agregarElemento(ene[2].getX(), ene[2].getY(), ene[2]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[2]);
						ene[2].kill();
						ene[2]=null;
					}
					break;
				}
				case "Lich":{
					if(ene[3]==null){
						ene[3] = new Lich(9,fila,j.getNivel().getMapa());
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[3]);
						j.getNivel().getMapa().agregarElemento(ene[3].getX(), ene[3].getY(), ene[3]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[3]);
						ene[3].kill();
						ene[3]=null;
					}
					break;
				}
				case "Nigromante":{
					if(ene[4]==null){
						ene[4] = new Nigromante(9,fila,j.getNivel().getMapa());
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[4]);
						j.getNivel().getMapa().agregarElemento(ene[4].getX(), ene[4].getY(), ene[4]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[4]);
						ene[4].kill();
						ene[4]=null;
					}
					break;
				}
				case "Ogro":{
					if(ene[5]==null){
						ene[5] = new Ogro(9,fila,j.getNivel().getMapa());
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().agregarEnemigo(ene[5]);
						j.getNivel().getMapa().agregarElemento(ene[5].getX(), ene[5].getY(), ene[5]);
					}
					else{
						j.getNivel().getMapa().getAlmacenHilos().getMovEnemigo().enemigoAEliminar(ene[5]);
						ene[5].kill();
						ene[5]=null;
					}
					break;
				}
			}
			presupuesto.setText("$ "+j.getNivel().getPresupuesto());
			puntaje.setText("Puntaje: "+j.getPuntaje());
		}
	}
}
