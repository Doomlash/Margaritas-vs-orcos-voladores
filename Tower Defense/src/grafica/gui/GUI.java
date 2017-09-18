package grafica.gui;

import logica.entidad.aliado.*;
import logica.juego.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
	private JPanel contentPane,panelSuperior,panelInferior;
	private Juego j;
	private ContadorTiempo t;

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
		AnchoVentana= 1000; AltoVentana= 600;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 40, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		j= new Juego(this);
		
		panelSuperior();
		panelInferior();
		contentPane.add(panelSuperior, BorderLayout.NORTH);
		contentPane.add(panelInferior, BorderLayout.SOUTH);
	}
	private void panelSuperior(){
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.GRAY);
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.setPreferredSize(new Dimension(AnchoVentana,70));
		
		JLabel presupuesto = new JLabel();
		presupuesto.setPreferredSize(new Dimension(150,70));
		presupuesto.setBorder(new LineBorder(Color.WHITE));
		presupuesto.setText(""+j.getNivel().getPresupuesto());
		presupuesto.setHorizontalAlignment(JLabel.CENTER);
		presupuesto.setVerticalAlignment(JLabel.CENTER);
		presupuesto.setForeground(Color.WHITE);
		presupuesto.setFont(new Font("Arial",Font.ITALIC,20));
		
		panelSuperior.add(presupuesto,BorderLayout.EAST);
	}
	private void panelInferior(){
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.GRAY);
		panelInferior.setPreferredSize(new Dimension(AnchoVentana,60));
		panelInferior.setLayout(new GridLayout(1,5));
		
		String bot[] = {"Agregar caballero","Agregar arquero","Agregar sargento","Agregar mago","Agregar catapulta"};
		JButton botones[] = new JButton[5];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<botones.length;i++){
			botones[i] = new JButton(bot[i]);
			botones[i].addActionListener(oyAgr);
			botones[i].setFocusable(false);
			panelInferior.add(botones[i]);
		}
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s =e.getActionCommand();
			System.out.println(s);
			Random r = new Random();
			int fila, columna;
			Aliado a = null;
			fila = r.nextInt(6);
			columna = r.nextInt(10);
			if(s=="Agregar caballero"){
				a= new Caballero(columna,fila,j.getNivel().getMapa());
			}
			if(s=="Agregar arquero"){
				a= new Arquero(columna,fila,j.getNivel().getMapa());
			}
			if(s=="Agregar sargento"){
				a= new Sargento(columna,fila,j.getNivel().getMapa());
			}
			if(s=="Agregar catapulta"){
				a= new Catapulta(columna,fila,j.getNivel().getMapa());
			}
			if(s=="Agregar mago"){
				a= new Mago(columna,fila,j.getNivel().getMapa());
			}
			j.getNivel().getMapa().agregarElemento(a.getX(), a.getY(), a);
		}
	}
}