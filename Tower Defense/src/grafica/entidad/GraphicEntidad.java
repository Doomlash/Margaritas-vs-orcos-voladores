package grafica.entidad;

import grafica.gameObjects.*;
import grafica.mapa.*;
import grafica.premio.*;

public abstract class GraphicEntidad extends GraphicGameObject{
	protected GraphicMapa map;
	protected GraphicEscudo escudo;
	
	public GraphicEntidad(int x, int y, int a, GraphicMapa m){
		super(x,y,1,a);
		this.map = m;
	}
	
	public void activarEscudo(int x, int y){
		escudo = new GraphicEscudo(x,y,1);
		map.addGraphicElemento(escudo);
	}
	public void desactivarEscudo(){
		if(escudo!=null){
			map.removeGraphicElemento(escudo);
			escudo = null;
		}
	}
}