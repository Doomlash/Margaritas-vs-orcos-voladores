package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	
	public GraphicDragon(int x, int y){
		super(x,y,2);
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Dragon/Dragonvolar.gif");
	}
}