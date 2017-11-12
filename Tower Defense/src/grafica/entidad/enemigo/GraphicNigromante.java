package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicNigromante extends GraphicEnemigo{
	
	public GraphicNigromante(int x, int y, GraphicMapa m){
		super(x,y,1,1,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteMovimiento.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/NigromanteSummon.gif"));
	}
	
	public void summon(){
		imagenes[5].getImage().flush();
		this.getGrafico().setIcon(imagenes[5]);
	}
}