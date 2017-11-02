package logica.almacen.creadorComprables.creadorPremios;

import grafica.premio.GraphicBooster;
import logica.almacen.Creador;
import logica.gameObjects.Elemento;
import logica.mapa.Mapa;
import logica.visitor.VisitorBooster;

public class CreadorBooster implements Creador{
	
	public void agregar(int x,int y,Mapa m){
		for(Elemento e:m.getCelda(x,y).getElementos()){
			e.accept(new VisitorBooster());
		}
	}
}
