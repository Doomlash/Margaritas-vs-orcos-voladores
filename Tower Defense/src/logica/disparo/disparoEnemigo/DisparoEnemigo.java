package logica.disparo.disparoEnemigo;

import logica.disparo.*;
import logica.mapa.*;
import grafica.disparo.dsparoEnemigo.*;
import grafica.gameObjects.*;

public abstract class DisparoEnemigo extends Disparo{
	protected GraphicDisparoEnemigo grafico;

	public DisparoEnemigo(int x,int y, Mapa m, int a){
		super(x,y,m,a);
	}
	public void kill(){
		
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}