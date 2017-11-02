package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicNigromante extends GraphicEnemigo{
	
	public GraphicNigromante(int x, int y, GraphicMapa m){
		super(x,y,1,m);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Nigromante/NigromanteIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Nigromante/NigromanteMovimiento.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Nigromante/NigromanteAtaque.gif");
	}
}