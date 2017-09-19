package grafica.entidad.enemigo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y){
		super(x,y);
		
		imagenes = new Image[3];
		imagenes[0] = new ImageIcon(dir+"Goblin.png").getImage();
	}
}