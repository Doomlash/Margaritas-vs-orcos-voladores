package grafica.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TesterGui extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, p1, p2;
	private int ancho=1200, alto=600;
	private Color c;
	private JLabel etiquetaMouse, item;
	private JLabel[][] me;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesterGui frame = new TesterGui();
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
	public TesterGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 40, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		etiquetaMouse = new JLabel();
		etiquetaMouse.setText("Color seleccionado: No hay color");
		etiquetaMouse.setHorizontalAlignment(JLabel.CENTER);
		etiquetaMouse.setForeground(Color.BLACK);
		
		panelSuperior();
		panelInferior();
		contentPane.add(p2, BorderLayout.CENTER);
		contentPane.add(p1, BorderLayout.SOUTH);
	}
	
	public void panelSuperior(){
		p2= new JPanel();
		p2.setLayout(null);
//		p2.setLayout(new GridLayout(3,6));
//		
//		me = new JLabel[3][6];
//		for(int i=0;i<me.length;i++)
//			for(int j=0;j<me[i].length;j++){
//				me[i][j] = new JLabel();
//				me[i][j].setBorder(new LineBorder(Color.WHITE,1));
//				me[i][j].setHorizontalAlignment(JLabel.CENTER);
//				p2.add(me[i][j]);
//			}
//		
//		OyenteMouse oy = new OyenteMouse();
		
		item = new JLabel(new ImageIcon("src/Sprites/Granada.png"));
		item.setBounds(100,100,100,100);
		item.addMouseListener(new ItemListener());
		
		p2.add(item);
		
//		p2.addMouseListener(oy);
	}
	
	public void panelInferior(){
		p1= new JPanel();
		p1.setLayout(new GridLayout(1,4));
		p1.setPreferredSize(new Dimension(ancho,60));
		
		OyenteBoton oy = new OyenteBoton();
		String b[] = {"Rojo","Azul","Verde"};
		JButton bot[] = new JButton[3];
		for(int i=0;i<bot.length;i++){
			bot[i] = new JButton(b[i]);
			bot[i].addActionListener(oy);
			bot[i].setFocusable(false);
			p1.add(bot[i]);
		}
		p1.add(etiquetaMouse);
	}
	
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s=="Rojo"){
				c= Color.RED;
				p1.setBackground(Color.RED);
			}
			if(s=="Azul"){
				c= Color.BLUE;
				p1.setBackground(Color.BLUE);
			}
			if(s=="Verde"){
				c = Color.GREEN;
				p1.setBackground(Color.GREEN);
			}
			etiquetaMouse.setText("Color seleccionado: "+s);
			etiquetaMouse.setForeground(Color.WHITE);
		}
		
	}
	
	private class ItemListener implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			item.setIcon(new ImageIcon("src/Sprites/Agua.png"));
		}
		
		public void mouseEntered(MouseEvent e){
			item.setIcon(new ImageIcon("src/Sprites/Piedra.png"));
		}
		
		public void mouseExited(MouseEvent e){
			item.setIcon(new ImageIcon("src/Sprites/Granada.png"));
		}
		
		public void mousePressed(MouseEvent e){
		}
		
		public void mouseReleased(MouseEvent e){
		}
		
	}
	
	private class OyenteMouse extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			int x= e.getX() / (int)me[0][0].getBounds().getWidth();
			int y= e.getY() / (int)me[0][0].getBounds().getHeight();
			if(c!=null){
				me[y][x].setBackground(c);
				me[y][x].repaint();
				c=null;
				etiquetaMouse.setText("Color seleccionado: No hay color");
				etiquetaMouse.setForeground(Color.BLACK);
				etiquetaMouse.setBackground(Color.WHITE);
			}
			me[y][x].setText(e.getX()+"_"+e.getY()+"  /  "+x+"-"+y);
		}
	}
	
}
