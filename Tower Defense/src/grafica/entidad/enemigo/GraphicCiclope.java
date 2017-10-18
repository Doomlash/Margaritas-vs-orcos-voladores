package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicCiclope extends GraphicEnemigo{
	
	public GraphicCiclope(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Enemigos/Ciclope/CiclopeIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Ciclope/CyclopeCaminar.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Ciclope/CyclopeAtacar.gif");
	}
}