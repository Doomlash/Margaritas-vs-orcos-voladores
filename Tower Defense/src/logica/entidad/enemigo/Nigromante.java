package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import logica.visitor.*;
import grafica.entidad.enemigo.*;

import java.util.ArrayList;
import java.util.List;

public class Nigromante extends Enemigo{
	private List<Esqueleto> ejercito;
	private VisitorCeldaEsqueleto visitorEsqueleto;
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Nigromante(int x, int y, Mapa m){
		super(x,y,1,m);
		velocidad=8;
		puntaje=90;
		monedas=20;
		vida=vidaMax=30;
		rango=1;
		fuerza=20;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		grafico = new GraphicNigromante(x,y,map.getMapaGrafico());
		ejercito = new ArrayList<Esqueleto>();
		visitorEsqueleto = new VisitorCeldaEsqueleto(this,map);
	}
	/*ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	*/
	public void SACARDEARREGLO(){
		map.getNivel().getJuego().getGui().getEnemigos()[4]=null;		
	}
	public void move(){
		int auxX=x;
		super.move();
		if(auxX!=x){
			for(int i=0;(i<2)&&(ejercito.size()<=3);i++)
				for(int j=-1;(j<2)&&(ejercito.size()<=3);j++){
					visitorEsqueleto.actualizarCeldaDeCreacion(x+i, j+y);
					Celda c = map.getCelda(x+i, y+j);
					if(c!=null)
						c.getFirst().accept(visitorEsqueleto);
				}
		}
	}
	public void agregarEsqueleto(Esqueleto e){
		if(ejercito.size()<=3)
			ejercito.add(e);
	}
	public void eliminarEsqueleto(Esqueleto e){
		ejercito.remove(e);
	}
	public void atacar(Obstaculo o){
		canMove=false;
		((GraphicEnemigo)grafico).atacar();
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
		}
		o.setVida(o.getVida()-fuerza);
		canMove=true;
	}
}