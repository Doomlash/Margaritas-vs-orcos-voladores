package grafica.mapa.GraphicElementosMapa.GraphicDestruibles;

import grafica.gameObjects.*;
import javax.swing.ImageIcon;

public class GraphicPiedra extends GraphicGameObject{
	
	public GraphicPiedra(int x, int y){
		super(x,y);
		
		imagenes = new ImageIcon[1];
		imagenes[0] = new ImageIcon(dir+"Piedra"+ext);
	}
}