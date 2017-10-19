package logica.disparo.disparoAliado;

import logica.disparo.*;
import logica.mapa.*;
import grafica.disparo.disparoAliado.*;
import grafica.gameObjects.*;

public abstract class DisparoAliado extends Disparo{
	protected GraphicDisparoAliado grafico;

	public DisparoAliado(int x,int y, Mapa m, int a){
		super(x,y,m,a);
	}
	public void ejecutar(){
		
	}
	public void kill(){
		
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}