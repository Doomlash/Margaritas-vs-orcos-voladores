package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicMonje extends GraphicAliado{
	
	public GraphicMonje(int x, int y, GraphicMapa m){
		super(x,y,1,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Estaticas Aliados/MonjeIdle.png"));
	}
}