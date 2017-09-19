package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Goblin.png");
	}
}