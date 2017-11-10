package logica.almacen.creadorComprables;

import logica.almacen.Accion;
import logica.comprables.Barricada;
import logica.mapa.Mapa;

public class CreadorBarricada implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		Barricada b = new Barricada(x,y,m);
		if((m.getNivel().getPresupuesto()-b.getPrecio()>=0)){
			if((x>=0)&&(x<m.getCeldas()[0].length)&&(m.getCelda(x, y).isEmpty())){
				m.agregarElemento(b);
				m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-b.getPrecio());
			}
		}
	}
}