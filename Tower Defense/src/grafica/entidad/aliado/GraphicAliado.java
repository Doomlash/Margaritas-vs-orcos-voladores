package grafica.entidad.aliado;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public abstract class GraphicAliado extends GraphicGameObject{
	
	public GraphicAliado(int x, int y, int a){
		super(x,y,1,a);
		imagenes= new ImageIcon[3];
	}
	public void atacar(){
		imagenes[1].getImage().flush();
		this.getGrafico().setIcon(imagenes[1]);
	}
	public void morir(){
		this.getGrafico().setIcon(imagenes[2]);
	}
}