package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicLich extends GraphicEnemigo{
	
	public GraphicLich(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Lich/LichCaminar.gif");
	}
}