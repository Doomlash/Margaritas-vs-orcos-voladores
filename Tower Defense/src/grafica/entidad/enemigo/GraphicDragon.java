package grafica.entidad.enemigo;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	
	public GraphicDragon(int x, int y, GraphicMapa m){
		super(x,y,2,m);
		imagenes = new ImageIcon[8];
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/Dragonvolar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongeladoVolando.png"));
		imagenes[6] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizar.gif"));
		imagenes[7] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonDespegar.gif"));
	}
	public void aterrizar(){
		this.getGrafico().setIcon(imagenes[6]);
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
		}
	}
	public void despegar(){
		this.getGrafico().setIcon(imagenes[7]);
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
		}
	}
}