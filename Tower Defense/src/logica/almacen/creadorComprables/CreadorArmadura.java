package logica.almacen.creadorComprables;

import logica.almacen.*;
import logica.mapa.*;
import logica.visitor.VisitorArmor;
import logica.comprables.*;
import logica.gameObjects.Elemento;

public class CreadorArmadura implements Creador{
	
	public void agregar(int x, int y, Mapa m){
		Armadura a = new Armadura();
		if(m.getNivel().getPresupuesto()>=a.getPrecio()){
			for(Elemento e:m.getCelda(x,y).getElementos()){
				e.accept(new VisitorArmor());
			}
		}
	}
}
