package logica.disparo.disparoAliado;

import logica.mapa.*;
import grafica.disparo.disparoAliado.*;

public class Flecha extends DisparoAliado{
	
	public Flecha(int x, int y, Mapa m, int alcance, int dam, int generacion){
		super(x,y,m,alcance,dam,generacion);
		velocidad=16;
		grafico = new GraphicFlecha(x,y);
	}
}