package grafica.entidad.aliado;

import java.awt.Image;

import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public abstract class GraphicAliado extends GraphicGameObject{
	
	public GraphicAliado(int x, int y){
		super(x,y,1);
		imagenes= new Image[3];
	}
}