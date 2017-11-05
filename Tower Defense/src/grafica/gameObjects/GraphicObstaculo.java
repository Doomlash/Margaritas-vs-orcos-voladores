package grafica.gameObjects;

import grafica.entidad.aliado.*;
import grafica.mapa.*;

public abstract class GraphicObstaculo extends GraphicGameObject{
	protected GraphicMapa map;
	protected GraphicLifeLine vida;
	
	public GraphicObstaculo(int x, int y, int p, int a, GraphicMapa m){
		super(x,y,p,a);
		this.map=m;
		vida = new GraphicLifeLine(x,y,a);
		m.addGraphicElemento(vida);
	}
	
	public void actualizarLifeLine(int vidaMax, int vidaActual){
		vida.updateLifeLine(vidaMax, vidaActual);
	}
	public void removeLifeLine(){
		map.removeGraphicElemento(vida);
	}
}