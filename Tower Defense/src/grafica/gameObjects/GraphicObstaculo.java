package grafica.gameObjects;

import grafica.mapa.*;

public abstract class GraphicObstaculo extends GraphicGameObject{
	protected GraphicMapa map;
	protected GraphicLifeLine vida;
	
	public GraphicObstaculo(int x, int y, int p, int dx, int dy, GraphicMapa m){
		super(x,y,p,dx,dy);
		this.map=m;
		vida = new GraphicLifeLine(x,y,dx,dy);
	}
	
	public void actualizarLifeLine(int vidaMax, int vidaActual){
		vida.updateLifeLine(vidaMax, vidaActual);
	}
	public void removeLifeLine(){
		map.removeGraphicElemento(vida);
	}
	public void agregarGraficosAsociados(){
		map.addGraphicElemento(vida);
	}
	public GraphicMapa getMapaGrafico(){
		return map;
	}
}