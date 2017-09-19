package grafica.mapa.GraphicElementosMapa.GraphicDestruibles;

import grafica.gameObjects.*;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GraphicPiedra extends GraphicGameObject{
	
	public GraphicPiedra(int x, int y){
		super(x,y,1);
		
		imagenes = new Image[1];
		imagenes[0] = new ImageIcon(dir+"Piedra.png").getImage();
	}
}