package grafica.disparo.disparoEnemigo;

import javax.swing.JLabel;

import grafica.gameObjects.*;

public abstract class GraphicDisparoEnemigo extends GraphicGameObject{
	
	public GraphicDisparoEnemigo(int x, int y){
		super(x,y,1,1);
		getGrafico().setHorizontalAlignment(JLabel.LEFT);
	}
}