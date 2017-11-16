package logica.disparo.disparoAliado;

import grafica.disparo.disparoAliado.*;
import logica.mapa.*;

public class DisparoWarMachine extends DisparoAliado{
	
	public DisparoWarMachine(int x, int y, Mapa m, int alcance, int dam, int generacion){
		super(x,y,m,alcance,dam,generacion,1);
		velocidad=16;
		grafico = new GraphicDisparoWarMachine(x,y);
	}
}