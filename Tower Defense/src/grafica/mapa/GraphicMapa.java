package grafica.mapa;

import grafica.gameObjects.*;
import logica.juego.niveles.*;

public class GraphicMapa{
	
	private Nivel nivel;

	public GraphicMapa(Nivel n){
		this.nivel = n;
	}
	
	public void addGraphicElemento(GraphicGameObject g){
		nivel.getJuego().getGui().add(g.getGrafico());
	}
}