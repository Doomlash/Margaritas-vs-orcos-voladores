package grafica.entidad.aliado;

import javax.swing.Icon;

import grafica.gameObjects.*;

public abstract class GraphicAliado extends GraphicGameObject{
	
	public GraphicAliado(int x, int y){
		super(x,y,1);
		imagenes= new Icon[3];
	}
}