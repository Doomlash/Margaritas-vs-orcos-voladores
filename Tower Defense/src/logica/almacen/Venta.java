package logica.almacen;

import logica.mapa.*;
import logica.visitor.*;

public class Venta implements Accion{
	
	public void ejecutarAccion(int x, int y, Mapa m){
		m.getCelda(x, y).getFirst().accept(new VisitorVenta(m));
	}
}