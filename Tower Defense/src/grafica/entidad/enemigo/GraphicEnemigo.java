package grafica.entidad.enemigo;

import grafica.entidad.*;
import grafica.mapa.*;

import javax.swing.ImageIcon;

public abstract class GraphicEnemigo extends GraphicEntidad{
	
	public GraphicEnemigo(int x, int y,int a, GraphicMapa m){
		super(x,y,a,m);
		imagenes = new ImageIcon[3];
	}
	public void atacar(){
		this.getGrafico().setIcon(imagenes[2]);
	}
	public void avanzar(){
		this.getGrafico().setIcon(imagenes[1]);
	}
	public void cambiarPos(int newX, int newY){
		super.cambiarPos(newX,newY);
		if(escudo!=null)
			escudo.cambiarPos(pos.x, pos.y);
	}
}