package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicOgro extends GraphicEnemigo{
	
	public GraphicOgro(int x, int y, GraphicMapa m){
		super(x,y,1,1,7,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Ogro/OgroIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Ogro/OgroCaminar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Ogro/OgreAtacar.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Ogro/OgroMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Ogro/OgroCongelado.png"));
	}
}