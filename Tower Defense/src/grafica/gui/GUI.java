package grafica.gui;

import logica.juego.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private static int AnchoVentana, AltoVentana;
	private JPanel contentPane;
	private Juego j;

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
	public GUI() {
		AnchoVentana= 1000; AltoVentana= 600;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 40, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		j= new Juego(this);
	}

}
