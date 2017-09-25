package grafica.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TesterGui2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane,arriba,izq;
	private int Ancho=1200,Alto=700;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesterGui2 frame = new TesterGui2();
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
	public TesterGui2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 20, Ancho, Alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		izquierda();
		arriba();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(arriba, BorderLayout.NORTH);
		contentPane.add(izq, BorderLayout.WEST);
	}
	private void arriba(){
		arriba=new JPanel();
		arriba.setPreferredSize(new Dimension(Ancho,80));
		arriba.setBackground(Color.DARK_GRAY);
	}
	
	private void izquierda(){
		izq= new JPanel();
		izq.setLayout(new GridLayout(13,1));
		izq.setPreferredSize(new Dimension(Ancho/10,Alto-120));
		izq.setBackground(Color.DARK_GRAY);

		String c[] = {"Caballero", "Arquero", "Mago", "Catapulta"};
		JButton aliados[] = new JButton[4];
		for(int i=0;i<aliados.length;i++){
			aliados[i] = new JButton(c[i]);
			aliados[i].setFocusable(false);
			
			izq.add(aliados[i]);
		}
		izq.add(new JLabel());
		
		String b[] = {"Bomba","Escudo","Trampa","Booster","Dragon","Armadura","Curacion","Barricada"};
		JButton agregables[] = new JButton[8];
		for(int i=0;i<agregables.length;i++){
			agregables[i]= new JButton(b[i]);
			agregables[i].setFocusable(false);
			
			izq.add(agregables[i]);
		}
	}
}