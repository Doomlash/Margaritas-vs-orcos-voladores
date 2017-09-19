package grafica.mapa.GraphicElementosMapa.GraphicTemporales;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicAgua extends GraphicGameObject{
	
	public GraphicAgua(int x, int y){
		super(x,y,0);
		
		imagenes[0] = new ImageIcon(dir+"Agua.png");
	}
}