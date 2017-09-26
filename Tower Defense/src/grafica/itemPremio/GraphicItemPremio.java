package grafica.itemPremio;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

import grafica.gameObjects.GraphicGameObject;

public abstract class GraphicItemPremio extends GraphicGameObject{
	
	public GraphicItemPremio(int x, int y){
		super(x,y,1,1);
		
		imagenes = new ImageIcon[2];
		
		this.getGrafico().addMouseListener(new Oyente());
	}
	
	private class Oyente implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
		}
		
		public void mouseEntered(MouseEvent e){
			cambiarGrafico(1);
		}
		
		public void mouseExited(MouseEvent e){
			cambiarGrafico(0);
		}
		
		public void mousePressed(MouseEvent e){
		}
		
		public void mouseReleased(MouseEvent e){
		}
	}
}