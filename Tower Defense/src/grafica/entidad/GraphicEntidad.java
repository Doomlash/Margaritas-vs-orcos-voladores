package grafica.entidad;

import grafica.gameObjects.*;
import grafica.mapa.*;
import grafica.premio.*;

import java.awt.Toolkit;

public abstract class GraphicEntidad extends GraphicObstaculo{
	protected GraphicEscudo escudo;
	protected Toolkit t = Toolkit.getDefaultToolkit();
	
	public GraphicEntidad(int x, int y, int a, GraphicMapa m){
		super(x,y,1,a,m);
	}
	
	public void activarEscudo(int x, int y, int ancho){
		escudo = new GraphicEscudo(x,y,ancho);
		map.addGraphicElemento(escudo);
	}
	public void desactivarEscudo(){
		if(escudo!=null){
			map.removeGraphicElemento(escudo);
			escudo = null;
		}
	}
}