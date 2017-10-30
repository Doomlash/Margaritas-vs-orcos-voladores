package grafica.disparo.disparoAliado;

import javax.swing.ImageIcon;

public class GraphicPiedraCatapulta extends GraphicDisparoAliado{
	
	public GraphicPiedraCatapulta(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Catapulta/Piedra.gif");
		pos.x-=70;
		pos.y-=40;
	}
}