package grafica.mapa.GraphicElementosMapa.GraphicTemporales;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicAgua extends GraphicGameObject{
	
	public GraphicAgua(int x, int y){
		super(x,y);
		
		imagenes = new ImageIcon[2];
		imagenes[0] = new ImageIcon("src/Sprites/Agua.png");
	}
}