package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCatapulta extends GraphicAliado{
	
	public GraphicCatapulta(int x, int y){
		super(x,y,2);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaAtaque.gif"));
	}
}