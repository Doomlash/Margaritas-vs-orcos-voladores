package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicArquero extends GraphicAliado{

	public GraphicArquero(int x, int y, GraphicMapa m){
		super(x,y,1,1,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Arquero/ArqueroIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Arquero/ArqueroAtaque.gif"));
	}
}