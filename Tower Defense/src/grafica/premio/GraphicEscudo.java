package grafica.premio;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicEscudo extends GraphicGameObject{
	
	public GraphicEscudo(int x, int y, int a){
		super(x,y,1,a);
		
		imagenes[0] = new ImageIcon(dir+"Shield.png");
	}
}