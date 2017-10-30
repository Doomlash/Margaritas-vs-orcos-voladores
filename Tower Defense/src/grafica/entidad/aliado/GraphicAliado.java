package grafica.entidad.aliado;

import javax.swing.Icon;

import grafica.gameObjects.*;

public abstract class GraphicAliado extends GraphicGameObject{
	
	public GraphicAliado(int x, int y, int a){
		super(x,y,1,a);
		imagenes= new Icon[3];
	}
	public void atacar(){
		this.getGrafico().setIcon(imagenes[1]);
	}
	public void morir(){
		this.getGrafico().setIcon(imagenes[2]);
	}
}