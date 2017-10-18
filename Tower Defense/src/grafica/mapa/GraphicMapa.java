package grafica.mapa;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import grafica.gameObjects.*;

public class GraphicMapa extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image fondo;
	
	public GraphicMapa(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1000,480));
		fondo = new ImageIcon("src/Sprites/FondoMapa.png").getImage();
	}
	
	public void addGraphicElemento(GraphicGameObject g){
		this.add(g.getGrafico());
		if(g.getPrioridad()==0)
			this.setComponentZOrder(g.getGrafico(), getComponentCount()-1);
		if(g.getPrioridad()==1)
			this.setComponentZOrder(g.getGrafico(), 0);
		repaint();
	}
	public void removeGraphicElemento(GraphicGameObject g){
		this.remove(g.getGrafico());
		this.repaint();
	}
	
	public void paint(Graphics g){
		g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
}