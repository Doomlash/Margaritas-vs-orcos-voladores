package grafica.comprables;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicAgujeroGusano extends GraphicGameObject{
	
	public GraphicAgujeroGusano(int x, int y){
		super(x,y,1,1);
		
		imagenes[0] = new ImageIcon(dir+"Gusano.gif");
	}
}