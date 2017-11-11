package aTesters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TesterGui2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int Ancho=1200,Alto=720;
	private JButton[] botones;
	private JScrollPane s;
	private JPanel panelBotones;

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
		setBounds(90, 0, Ancho, Alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
//		TesterPanelAlmacenMercado t = new TesterPanelAlmacenMercado(Ancho,Alto);
//		t.agregarPaneles(contentPane);
		
		JLabel l = new JLabel(new ImageIcon("src/Sprites/FondoMapa.png"));
		botones();
		s = new JScrollPane(panelBotones, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		s.setBounds(0,0,Ancho/2,90);
		s.getHorizontalScrollBar().setUnitIncrement(10);
		
		JPanel r = new JPanel();
		r.setBackground(Color.DARK_GRAY);
		r.setBounds(Ancho/17*3,Alto/12,Ancho/12*11,Alto/12*11);
		
		
		
		contentPane.add(r);
		contentPane.add(panelBotones);
	}
	
	private void botones(){
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.GRAY);
//		panelBotones.setBounds(0,0,Ancho/2,Alto/12);
		panelBotones.setLayout(null);
		panelBotones.setBounds(0,Alto/12,Ancho/17*3,Alto);
		
		String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Barricada","Stun","Cancelar"};
		botones = new JButton[c.length];
		int x;
		for(int i=0;i<botones.length;i++){
			botones[i] = new JButton();
			botones[i].setBorder(null);
			botones[i].setBorderPainted(false);
			botones[i].setContentAreaFilled(false);
			x=i%2;
			botones[i].setBounds(x*100+(x+1)*3,(i/2+1)*Alto/12+i/2*7,100,65);
			botones[i].setIcon(new ImageIcon("src/Sprites/IconosBotones/DesMago.png"));
			botones[i].setPressedIcon(new ImageIcon("src/Sprites/IconosBotones/SelMago.png"));
			botones[i].setRolloverIcon(new ImageIcon("src/Sprites/IconosBotones/EnteredMago.png"));
			botones[i].setFocusable(false);
			panelBotones.add(botones[i]);
		}
	}
}