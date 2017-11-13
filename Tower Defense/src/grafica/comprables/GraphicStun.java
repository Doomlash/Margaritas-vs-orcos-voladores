package grafica.comprables;

import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public class GraphicStun extends GraphicGameObject{
	
	public GraphicStun(){
		super(0,0,0,1,1);
		
		pos.x-=5;
		pos.y-=35;
		imagenes[0] = new ImageIcon(dir+"Reloj.gif");
	}
}