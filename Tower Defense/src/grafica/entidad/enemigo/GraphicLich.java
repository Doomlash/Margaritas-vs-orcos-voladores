package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicLich extends GraphicEnemigo{
	
	public GraphicLich(int x, int y, GraphicMapa m){
		super(x,y,1,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Lich/LichIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Lich/LichCaminar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Lich/LichAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Lich/LichMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Lich/LichCongelado.png"));
	}
}