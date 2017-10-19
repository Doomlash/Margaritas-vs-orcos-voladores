package logica.disparo.disparoEnemigo;

import grafica.disparo.disparoEnemigo.*;
import logica.mapa.*;

public class PiedraCiclope extends DisparoEnemigo{
	
	public PiedraCiclope(int x, int y, Mapa m, int alcance){
		super(x,y,m,alcance);
		grafico = new GraphicPiedraCiclope(x,y);
	}
}