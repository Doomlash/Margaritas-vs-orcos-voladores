package grafica.disparo.disparoEnemigo;

import javax.swing.ImageIcon;

public class GraphicPiedraCiclope extends GraphicDisparoEnemigo{
	
	public GraphicPiedraCiclope(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Ciclope/Piedra.gif");
	}
}
