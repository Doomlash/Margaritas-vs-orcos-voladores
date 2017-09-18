package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCatapulta extends GraphicAliado{
	
	public GraphicCatapulta(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Catapulta"+ext);
	}
}