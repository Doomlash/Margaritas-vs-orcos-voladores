package grafica.mapa;

import logica.gameObjects.*;
import logica.juego.niveles.*;

public class GraphicMapa{
	
	private Nivel nivel;

	public GraphicMapa(Nivel n){
		this.nivel = n;
	}
	
	public void addGraphicElemento(GameObject g){
		nivel.getJuego().getGui().add(g.getGraphic().getGrafico());
	}
}