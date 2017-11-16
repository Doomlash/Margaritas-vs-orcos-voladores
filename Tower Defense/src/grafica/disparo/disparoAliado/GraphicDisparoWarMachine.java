package grafica.disparo.disparoAliado;

import javax.swing.ImageIcon;

public class GraphicDisparoWarMachine extends GraphicDisparoAliado{
	
	public GraphicDisparoWarMachine(int x, int y){
		super(x,y);
		
		pos.x-=70;
		pos.y-=10;
	}
	public void setImagen(ImageIcon image){
		imagenes[0] = image;
	}
}