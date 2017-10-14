package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Goblin/GoblinMovimiento.gif");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Goblin/GoblinAtaque.gif");
	}
}