package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicArquero extends GraphicAliado{

	public GraphicArquero(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Estaticas Aliados/ArqueroIdle.png").getImage();
	}
}