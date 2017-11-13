package aTesters;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaInicio extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon image = new ImageIcon("src/Sprites/IconosBotones/Hojas.gif");
	private static final int AnchoVentana=1200,AltoVentana=720;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicio frame = new VentanaInicio();
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
	public VentanaInicio() {
		super("Tower Defense");
		
//		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 0, AnchoVentana, AltoVentana);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		contentPane.add(new PanelInicio(this));
	}
	
	public void cambiar(JPanel actual, JPanel nuevo){
		contentPane.remove(actual);
		contentPane.add(nuevo);
		contentPane.repaint();
	}
	public int getAncho(){
		return AnchoVentana;
	}
	public int getAlto(){
		return AltoVentana;
	}
}
