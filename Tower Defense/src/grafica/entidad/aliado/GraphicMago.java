package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicMago extends GraphicAliado{
	
	public GraphicMago(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Estaticas Aliados/MagoIdle.png");
	}
}