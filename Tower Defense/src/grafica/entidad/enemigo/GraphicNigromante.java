package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicNigromante extends GraphicEnemigo{
	
	public GraphicNigromante(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Nigromante.gif").getImage();
	}
}