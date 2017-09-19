package grafica.mapa.GraphicElementosMapa.GraphicTemporales;

import grafica.gameObjects.*;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GraphicAgua extends GraphicGameObject{
	
	public GraphicAgua(int x, int y){
		super(x,y,0);
		
		imagenes = new Image[2];
		imagenes[0] = new ImageIcon(dir+"Agua.png").getImage();
	}
}