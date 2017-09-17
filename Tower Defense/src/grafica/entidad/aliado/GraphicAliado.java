package grafica.entidad.aliado;

import grafica.elemento.*;
import javax.swing.ImageIcon;

public abstract class GraphicAliado extends GraphicElemento{
	
	public GraphicAliado(int x, int y){
		super(x,y);
		imagenes= new ImageIcon[3];
	}
}