package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicGoblin extends GraphicEnemigo{
	
	public GraphicGoblin(int x, int y, GraphicMapa m){
		super(x,y,1,1,8,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Goblin/GoblinIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Goblin/GoblinMovimiento.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Goblin/GoblinAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Goblin/GoblinMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Goblin/GoblinCongelado.png"));
	}
}