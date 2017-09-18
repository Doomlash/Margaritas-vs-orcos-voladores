package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y){
		super(x,y);
		
		imagenes = new ImageIcon[3];
		imagenes[0] = new ImageIcon(dir+"Goblin"+ext);
	}
}