package grafica.mapa;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import grafica.gameObjects.*;

public class GraphicMapa extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public GraphicMapa(){
		this.setLayout(null);
		this.setPreferredSize(new Dimension(1000,480));
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public void addGraphicElemento(GraphicGameObject g){
		this.add(g.getGrafico());
		if(g.getPrioridad()==0)
			this.setComponentZOrder(g.getGrafico(), getComponentCount()-1);
		if(g.getPrioridad()==1)
			this.setComponentZOrder(g.getGrafico(), 0);
		System.out.println(getComponentCount());
		repaint();
	}
}