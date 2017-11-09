package logica.comprables;

import logica.modificador_PowerUp.*;
import logica.mapa.*;
import logica.visitor.visitorPowerUpYPremios.*;

public class CampoDeCuracion extends Modificador implements Comprable{
	private int precio,x,y;
	private double tiempo;
	private VisitorCuracion curacion;
	
	public CampoDeCuracion(int x, int y, Mapa m){
		precio=50;
		this.x=x;
		this.y=y;
		this.map=m;
		tiempo=8;
		curacion = new VisitorCuracion(this);
	}
	public int getPrecio(){
		return precio;
	}
	
	public void actualizar(){
		Celda c;
		for(int i=-1;i<2;i++)
			for(int j=-1;j<2;j++){
				c=map.getCelda(x+i, y+j);
				if(c!=null&&(!c.isEmpty()))
					c.accept(curacion);
			}
		tiempo = tiempo - (0.25);
		if(tiempo<=0)
			kill();
	}
	public int getPorcentaje(){
		return 2;
	}
}