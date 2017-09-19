package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicLich extends GraphicEnemigo{
	
	public GraphicLich(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Lich.gif").getImage();
	}
}