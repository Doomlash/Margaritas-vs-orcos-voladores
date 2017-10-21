package logica.almacen.creadorComprables.creadorAliados;

import logica.almacen.*;
import logica.entidad.aliado.*;
import logica.mapa.Mapa;

public abstract class CreadorAliado implements Creador{
	protected Aliado aliado;
	
	protected void agregar(Mapa m){
		if((m.getNivel().getPresupuesto()-aliado.getPrecio()>=0)){
			boolean disponible=true;
			for(int i=aliado.getX();(i<(aliado.getDimensionX()+aliado.getX()))&&disponible;i++){
				if(i>=0&&i<10)
					disponible = m.getCelda(i, aliado.getY()).isEmpty();
				else
					disponible=false;
			}
			if(disponible){
				m.agregarElemento(aliado);
				m.getAlmacenHilos().getAtaAliado().agregarAliado(aliado);
				m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-aliado.getPrecio());
			}
		}
	}
}