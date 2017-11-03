package grafica.premio;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicBooster extends GraphicGameObject{
	
	public GraphicBooster(int x, int y){
		super(x,y,1,1);
		
		imagenes[0] = new ImageIcon(dir+"Booster.gif");
	}
}