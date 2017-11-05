package grafica.mapa.GraphicElementosMapa.GraphicDestruibles;

import grafica.gameObjects.*;
import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicPiedra extends GraphicObstaculo{
	
	public GraphicPiedra(int x, int y, GraphicMapa m){
		super(x,y,1,1,m);
		
		imagenes[0] = new ImageIcon(dir+"Piedra.png");
	}
}