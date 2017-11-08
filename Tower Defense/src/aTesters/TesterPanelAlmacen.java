package aTesters;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TesterPanelAlmacen extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private JButton colocables[];
	private String c[] = {"Bomba","Booster","Trampa","Escudo","Cancelar"};
	
	public TesterPanelAlmacen(int anchoGui, int altoGui){
		this.setLayout(null);
		this.setBackground(Color.GRAY);
		this.setBounds(0,0,anchoGui/12,altoGui);

		
		crearBotones(anchoGui, altoGui);
	}
	
	private void crearBotones(int ancho, int alto){
		colocables = new JButton[c.length];
		OyenteAgregar oyAgr = new OyenteAgregar();
		for(int i=0;i<colocables.length;i++){
			colocables[i] = new JButton(c[i]);
			colocables[i].setBounds(4,i*alto/13+alto/10,ancho/13,alto/13);
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