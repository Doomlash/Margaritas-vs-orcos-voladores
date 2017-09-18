package grafica.gui;

import logica.juego.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

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
		panelInferior.setPreferredSize(new Dimension(AnchoVentana,80));
	}
}
