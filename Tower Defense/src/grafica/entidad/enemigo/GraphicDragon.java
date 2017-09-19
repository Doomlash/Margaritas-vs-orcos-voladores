package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	
	public GraphicDragon(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Dragon.gif").getImage();
	}
}