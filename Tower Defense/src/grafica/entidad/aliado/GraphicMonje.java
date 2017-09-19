package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicMonje extends GraphicAliado{
	
	public GraphicMonje(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Estaticas Aliados/MonjeIdle.png");
	}
}