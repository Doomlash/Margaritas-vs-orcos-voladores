package grafica.mapa;

import logica.mapa.*;
import grafica.gameObjects.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GraphicMapa extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image fondo;
	private Mapa mapa;
	
	public GraphicMapa(Mapa m){
		mapa = m;
		this.setLayout(null);
		int ancho = m.getNivel().getJuego().getGui().getAncho();
		int alto = m.getNivel().getJuego().getGui().getAlto();
		this.setBounds(ancho/12,alto/12,ancho/12*10,alto/12*11);
		this.setPreferredSize(new Dimension(1000,520));
		this.addMouseListener(new OyenteMouse());
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
	
	
	private class OyenteMouse implements MouseListener{
		public void mouseClicked(MouseEvent e){
			int x= e.getX() / 90;
			int y= e.getY();
			if(y>=40){
				y = (y-40)/95;
				mapa.getNivel().getJuego().getAlmacen().crearObjeto(x, y, mapa);
			}
		}
		
		public void mouseEntered(MouseEvent e){
			
		}
		
		public void mouseExited(MouseEvent e){
			
		}
		
		public void mousePressed(MouseEvent e){
			
		}
		
		public void mouseReleased(MouseEvent e){
			
		}
	}
}