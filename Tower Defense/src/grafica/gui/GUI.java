package grafica.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args){
		GUI frame = new GUI();
		frame.setVisible(true);
	}
	
	/**
	 * Create the frame
	 */
	public GUI(){
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
