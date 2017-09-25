package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCatapulta extends GraphicAliado{
	
	public GraphicCatapulta(int x, int y){
		super(x,y,2);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Catapulta/CatapultaIdle.png");
	}
}