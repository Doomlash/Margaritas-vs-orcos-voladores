package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicOgro extends GraphicEnemigo{
	
	public GraphicOgro(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Ogre/Caminar.gif");
	}
}