package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

import grafica.mapa.*;

public class GraphicEsqueleto extends GraphicEnemigo{
	
	public GraphicEsqueleto(int x, int y, GraphicMapa m){
		super(x,y,1,1,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoCaminar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Nigromante/Esqueleto/EsqueletoSpawn.gif"));
	}
}