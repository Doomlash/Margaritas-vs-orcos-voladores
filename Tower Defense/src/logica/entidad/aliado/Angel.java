package logica.entidad.aliado;

import logica.gameObjects.*;
import logica.mapa.*;
import grafica.entidad.aliado.*;

public class Angel extends Aliado{
	
	public Angel(int x, int y, Mapa m){
		super(x,y,2,2,m);
		precio = 800;
		vida=vidaMax=500;
		rango=1;
		fuerza=80;
		duracionAtaque=8;
		cargaAtaqueNecesaria = duracionAtaque*3;
		cargaAtaqueActual = duracionAtaque*2;
		grafico = new GraphicAngel(x,y,map.getMapaGrafico());
	}
	public void atacar(Obstaculo o){
		((GraphicAliado)grafico).atacar();
		o.setVida(o.getVida()-fuerza);
	}

}