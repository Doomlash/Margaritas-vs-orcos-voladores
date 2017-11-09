package grafica.entidad.enemigo;

import grafica.mapa.GraphicMapa;

import javax.swing.ImageIcon;

public class GraphicCerberus extends GraphicEnemigo{
	
	public GraphicCerberus(int x, int y, GraphicMapa m){
		super(x,y,2,3,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusMovimiento.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusCongelado.png"));
	}
	
	public void atacar(){
		super.atacar();
		try{
			Thread.sleep(2730);
		}catch(InterruptedException e){
		}
	}
}