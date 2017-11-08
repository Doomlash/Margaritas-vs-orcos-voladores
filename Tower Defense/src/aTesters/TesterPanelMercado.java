package aTesters;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
			colocables[i].setBounds((i+1)*ancho/12,2,ancho/12,alto/12);
			colocables[i].addActionListener(oyAgr);
			colocables[i].setFocusable(false);
			Image image = new ImageIcon("src/Sprites/IconosBotones/MagoBoton.png").getImage();
			Image image2 = image.getScaledInstance(ancho/11, alto/12, Image.SCALE_SMOOTH);
			colocables[i].setIcon(new ImageIcon(image2));
			Image img = new ImageIcon("src/Sprites/IconosBotones/MagoBotonDisabled.png").getImage();
			Image img2 = img.getScaledInstance(ancho/11, alto/12, Image.SCALE_SMOOTH);
			colocables[i].setPressedIcon(new ImageIcon(img2));
			this.add(colocables[i]);
		}
	}
	
	private class OyenteAgregar implements ActionListener{
		public void actionPerformed(ActionEvent e){
		}
	}
}