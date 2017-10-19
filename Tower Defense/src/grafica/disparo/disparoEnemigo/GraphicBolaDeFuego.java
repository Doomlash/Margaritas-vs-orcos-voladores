package grafica.disparo.disparoEnemigo;

import javax.swing.ImageIcon;

public class GraphicBolaDeFuego extends GraphicDisparoEnemigo{
	
	public GraphicBolaDeFuego(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Enemigos/Dragon/BolaDeFuego.png");
	}
}