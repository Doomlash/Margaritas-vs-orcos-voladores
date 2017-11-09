package grafica.entidad;

import grafica.gameObjects.*;
import grafica.mapa.*;
import grafica.premio.*;

public abstract class GraphicEntidad extends GraphicObstaculo{
	protected GraphicEscudo escudo;
	protected GraphicBooster booster;
	
	public GraphicEntidad(int x, int y, int dx, int dy, GraphicMapa m){
		super(x,y,1,dx,dy,m);
	}
	
	public void activarBooster(int x, int y, int ancho, int alto){
		booster = new GraphicBooster(x,y,ancho,alto);
		map.addGraphicElemento(booster);
	}
	public void desactivarBooster(){
		if(booster!=null){
			map.removeGraphicElemento(booster);
			booster=null;
		}
	}
	public void activarEscudo(int x, int y, int ancho, int alto){
		escudo = new GraphicEscudo(x,y,ancho,alto);
		map.addGraphicElemento(escudo);
	}
	public void desactivarEscudo(){
		if(escudo!=null){
			map.removeGraphicElemento(escudo);
			escudo = null;
		}
	}
}