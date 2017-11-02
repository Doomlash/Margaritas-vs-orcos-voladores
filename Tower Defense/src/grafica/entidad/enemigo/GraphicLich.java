package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicLich extends GraphicEnemigo{
	
	public GraphicLich(int x, int y, GraphicMapa m){
		super(x,y,1,m);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Lich/LichIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Lich/LichCaminar.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Lich/LichAtaque.gif");
	}
}