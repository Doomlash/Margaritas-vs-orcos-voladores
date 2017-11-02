package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicMonje extends GraphicAliado{
	
	public GraphicMonje(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Estaticas Aliados/MonjeIdle.png"));
	}
}