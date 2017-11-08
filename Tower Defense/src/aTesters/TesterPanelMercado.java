package aTesters;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TesterPanelMercado extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JButton colocables[];
	private String c[] = {"Caballero","Arquero","Monje","Mago","Catapulta","Barricada","Stun","Cancelar"};
	
	public TesterPanelMercado(int anchoGui, int altoGui){
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setBounds(0,0,anchoGui,altoGui/11);

		
		crearBotones(anchoGui, altoGui);
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds((i+1)*ancho/12,5,ancho/12,alto/13);
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			this.add(colocables[i]);
		}
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
		}
	}
}