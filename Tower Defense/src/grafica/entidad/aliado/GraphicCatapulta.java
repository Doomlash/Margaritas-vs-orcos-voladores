package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicCatapulta extends GraphicAliado{
	
	public GraphicCatapulta(int x, int y, GraphicMapa m){
		super(x,y,2,1,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaAtaque.gif"));
	}
}