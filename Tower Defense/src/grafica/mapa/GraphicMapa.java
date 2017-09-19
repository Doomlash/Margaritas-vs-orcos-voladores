package grafica.mapa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import grafica.gameObjects.*;

public class GraphicMapa extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private List<GraphicGameObject> intermedio, abajo, arriba;
	
	public GraphicMapa(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1000,480));
		this.setBackground(Color.LIGHT_GRAY);
		intermedio = new ArrayList<GraphicGameObject>();
		abajo = new ArrayList<GraphicGameObject>();
		arriba = new ArrayList<GraphicGameObject>();
	}
	
	public void addGraphicElemento(GraphicGameObject g){
		if(g.getPrioridad()==0)
			abajo.add(g);
		if(g.getPrioridad()==1)
			intermedio.add(g);
		if(g.getPrioridad()==2)
			arriba.add(g);
		repaint();
	}
	
	public void paint(Graphics graphics){
		super.paint(graphics);
		Graphics2D g = (Graphics2D) graphics;
		g.drawImage(new ImageIcon("src/Sprites/FondoMapa.png").getImage(), 0, 0, null);
		for(GraphicGameObject ggo : abajo)
			g.drawImage(ggo.getGrafico(), ggo.getPos().x, ggo.getPos().y, null);
		for(GraphicGameObject ggo : intermedio)
			g.drawImage(ggo.getGrafico(), ggo.getPos().x, ggo.getPos().y, null);
		for(GraphicGameObject ggo : arriba)
			g.drawImage(ggo.getGrafico(), ggo.getPos().x, ggo.getPos().y, null);
	}
}