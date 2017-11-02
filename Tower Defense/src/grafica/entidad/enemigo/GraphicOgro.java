package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicOgro extends GraphicEnemigo{
	
	public GraphicOgro(int x, int y, GraphicMapa m){
		super(x,y,1,m);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Ogro/OgroIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Ogro/OgroCaminar.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Ogro/OgreAtacar.gif");
	}
}