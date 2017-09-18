package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicCiclope extends GraphicEnemigo{
	
	public GraphicCiclope(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Ciclope"+ext);
	}
}