package grafica.entidad.aliado;

import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public abstract class GraphicAliado extends GraphicGameObject{
	
	public GraphicAliado(int x, int y){
		super(x,y);
		imagenes= new ImageIcon[3];
	}
}