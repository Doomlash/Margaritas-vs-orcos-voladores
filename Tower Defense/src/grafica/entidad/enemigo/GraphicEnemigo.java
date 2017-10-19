package grafica.entidad.enemigo;

import grafica.gameObjects.*;
import javax.swing.Icon;

public abstract class GraphicEnemigo extends GraphicGameObject{
	
	public GraphicEnemigo(int x, int y,int a){
		super(x,y,1,a);
		imagenes = new Icon[3];
	}
	public void atacar(){
		this.getGrafico().setIcon(imagenes[2]);
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e){
		}
		this.setImageIdle();
	}
	public void avanzar(){
		this.getGrafico().setIcon(imagenes[1]);
	}
}