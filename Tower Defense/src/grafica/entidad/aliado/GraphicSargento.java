package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicSargento extends GraphicAliado{
	
	public GraphicSargento(int x, int y){
		super(x,y);

		imagenes[0] = new ImageIcon(dir+"Sargento"+ext);
	}
}