package aTesters;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TesterGui2 extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		TesterPanelAlmacenMercado t = new TesterPanelAlmacenMercado(Ancho,Alto);
		t.agregarPaneles(contentPane);
	}
}