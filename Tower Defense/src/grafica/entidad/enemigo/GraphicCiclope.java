package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicCiclope extends GraphicEnemigo{
	
	public GraphicCiclope(int x, int y, GraphicMapa m){
		super(x,y,1,1,6,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Ciclope/CiclopeIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Ciclope/CyclopeCaminar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Ciclope/CyclopeAtacar.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Ciclope/CiclopeMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Ciclope/CiclopeCongelado.png"));
		cargaAtaque.cambiarPos(cargaAtaque.getPos().x, cargaAtaque.getPos().y-16);
		vida.cambiarPos(vida.getPos().x, vida.getPos().y-16);
	}
}