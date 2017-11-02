package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y, GraphicMapa m){
		super(x,y,1,m);
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Goblin/GoblinIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Goblin/GoblinMovimiento.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Goblin/GoblinAtaque.gif");
	}
}