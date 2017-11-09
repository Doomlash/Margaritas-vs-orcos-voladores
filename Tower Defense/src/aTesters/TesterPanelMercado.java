package aTesters;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TesterPanelMercado extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton colocables[];
	private String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Barricada","Stun","Cancelar"};
	private JLabel test;
	
	public TesterPanelMercado(int anchoGui, int altoGui){
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setBounds(0,0,anchoGui,altoGui/5);
		
		
		crearBotones(anchoGui, altoGui);
		
		test = new JLabel(new ImageIcon("src/Sprites/FosoLava.gif"));
		test.setBounds(anchoGui/12,altoGui/12+4,anchoGui/12,altoGui/12);
		this.add(test);
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteMouse oyAgr = new OyenteMouse();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds((i+1)*ancho/12,2,ancho/12,alto/12);
			colocables[i].addMouseListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
		}
	}
	
	private class Oyente implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(test.isVisible())
				test.setVisible(false);
			else
				test.setVisible(true);
		}
	}
	
	private class OyenteMouse implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			test.setVisible(true);
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			test.setVisible(false);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
	}
}