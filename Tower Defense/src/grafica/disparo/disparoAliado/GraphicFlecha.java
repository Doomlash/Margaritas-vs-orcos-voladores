package grafica.disparo.disparoAliado;

import javax.swing.ImageIcon;

public class GraphicFlecha extends GraphicDisparoAliado{
	
	public GraphicFlecha(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Arquero/Flecha.png");
	}
}