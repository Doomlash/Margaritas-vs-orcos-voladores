package logica.almacen.creadorComprables.creadorPremios;

import grafica.gameObjects.GraphicGameObject;
import logica.almacen.Creador;
import logica.mapa.Mapa;
import logica.premio.objetoPrecioso.Bomba;

public class CreadorBomba implements Creador {
	public void agregar(int x,int y,Mapa m){
		Bomba bomba=new Bomba(x,y,m);
		GraphicGameObject grafico=bomba.getGraphic();
		m.getMapaGrafico().addGraphicElemento(bomba.getGraphic());
		Thread t=new Thread(bomba);
		t.start();
	}
}
