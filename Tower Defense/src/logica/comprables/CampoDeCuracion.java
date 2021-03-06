package logica.comprables;

import logica.modificador_PowerUp.*;
import logica.mapa.*;
import logica.visitor.visitorPowerUpYPremios.*;
import grafica.comprables.*;

public class CampoDeCuracion extends Modificador implements Comprable{
	private int precio,x,y;
	private double tiempo;
	private VisitorCuracion curacion;
	private GraphicCuracion[] grafico;
	
	public CampoDeCuracion(int x, int y, Mapa m){
		precio=200;
		this.x=x;
		this.y=y;
		this.map=m;
		tiempo=10;
		curacion = new VisitorCuracion(this);
		grafico = new GraphicCuracion[9];
		int aux=0;
		for(int i=-1;i<2;i++){
			for(int j=-1;j<2;j++){
				grafico[aux] = new GraphicCuracion(x+i,y+j);
				map.getMapaGrafico().addGraphicElemento(grafico[aux]);
				aux++;
			}
		}
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
	public void kill(){
		for(int i=0;i<grafico.length;i++)
			map.getMapaGrafico().removeGraphicElemento(grafico[i]);
		super.kill();
	}
	public int getPorcentaje(){
		return 2;
	}
}