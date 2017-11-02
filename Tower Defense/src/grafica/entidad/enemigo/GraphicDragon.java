package grafica.entidad.enemigo;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	
	public GraphicDragon(int x, int y){
		super(x,y,2);
		imagenes = new ImageIcon[5];
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Dragon/DragonIdle.png");
		imagenes[1] = new ImageIcon(dir+"Enemigos/Dragon/Dragonvolar.gif");
		imagenes[2] = new ImageIcon(dir+"Enemigos/Dragon/DragonAtaque.gif");
		imagenes[3] = new ImageIcon(dir+"Enemigos/Dragon/DragonAterrizar.gif");
		imagenes[4] = new ImageIcon(dir+"Enemigos/Dragon/DragonDespegar.gif");
	}
	public void aterrizar(){
		this.getGrafico().setIcon(imagenes[3]);
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
		}
	}
	public void despegar(){
		this.getGrafico().setIcon(imagenes[4]);
		try{
			Thread.sleep(200);
		}catch(InterruptedException e){
		}
	}
}