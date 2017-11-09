package grafica.itemPremio;

import logica.itemPremio.*;
import grafica.gameObjects.GraphicGameObject;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;


public abstract class GraphicItemPremio extends GraphicGameObject{
	protected ItemPremio item;
	
	public GraphicItemPremio(int x, int y){
		super(x,y,1,1,1);
		
		imagenes = new ImageIcon[2];
	}
	public void achicar(){
		grafico.setIcon(imagenes[0]);
	}
	public void agrandar(){
		grafico.setIcon(imagenes[1]);
	}
	
	protected class Oyente implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			item.clickeado();
		}
		
		public void mouseEntered(MouseEvent e){
			agrandar();
		}
		
		public void mouseExited(MouseEvent e){
			achicar();
		}
		
		public void mousePressed(MouseEvent e){
		}
		
		public void mouseReleased(MouseEvent e){
		}
	}
}