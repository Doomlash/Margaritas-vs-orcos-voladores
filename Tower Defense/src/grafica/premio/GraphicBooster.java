package grafica.premio;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicBooster extends GraphicGameObject{
	
	public GraphicBooster(int x, int y, int ancho){
		super(x,y,1,ancho);
		
		imagenes[0] = new ImageIcon(dir+"Booster.gif");
	}
}