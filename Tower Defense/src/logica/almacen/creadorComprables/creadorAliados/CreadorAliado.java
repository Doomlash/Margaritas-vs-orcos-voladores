package logica.almacen.creadorComprables.creadorAliados;

import logica.almacen.*;
import logica.entidad.aliado.*;
import logica.mapa.Mapa;
import grafica.gameObjects.*;

public abstract class CreadorAliado implements Creador{
	protected Aliado aliado;
	
	protected void agregar(Mapa m){
		if((m.getNivel().getPresupuesto()-aliado.getPrecio()>=0)){
			boolean disponible=true;
			for(int i=aliado.getX();(i<(aliado.getDimensionX()+aliado.getX()))&&disponible;i++){
				for(int j=aliado.getY();j<(aliado.getDimensionY()+aliado.getY())&&disponible;j++){
					if((i>=0&&i<m.getCeldas()[0].length)&&(j>=0&&j<m.getCeldas().length))
						disponible = m.getCelda(i, j).isEmpty();
					else
						disponible=false;
				}
			}
			if(disponible){
				m.agregarElemento(aliado);
				m.getAlmacenHilos().getAtaAliado().agregarAliado(aliado);
				m.getNivel().modificarPresupueto(m.getNivel().getPresupuesto()-aliado.getPrecio());
			}
			else
				((GraphicObstaculo)aliado.getGraphic()).removeLifeLine();
		}
	}
}