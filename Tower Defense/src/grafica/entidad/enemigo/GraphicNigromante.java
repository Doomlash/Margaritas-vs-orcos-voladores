package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicNigromante extends GraphicEnemigo{
	
	public GraphicNigromante(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Nigromante/NigromanteMovimiento.gif");
	}
}