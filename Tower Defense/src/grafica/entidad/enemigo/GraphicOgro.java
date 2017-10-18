package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicOgro extends GraphicEnemigo{
	
	public GraphicOgro(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Ogro/OgroCaminar.gif");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Ogro/OgroAtacar.gif");
	}
}