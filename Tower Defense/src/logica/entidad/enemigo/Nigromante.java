package logica.entidad.enemigo;

import logica.mapa.*;
import logica.gameObjects.*;
import logica.visitor.visitorEnemigo.*;
import grafica.entidad.enemigo.*;

import java.util.ArrayList;
import java.util.List;

public class Nigromante extends Enemigo{
	private List<Esqueleto> ejercito;
	private VisitorCeldaEsqueleto visitorEsqueleto;
	private int cargaInvocacion, cargaInvocacionActual;
	
	/**
	 * Se crea el elemento grafico asociado a la clase y se lo agrega al mapa grafico.
	 * @param x : int - Representa la posicion x inicial que ocupa en la matriz de celdas
	 * @param y : int - Representa la posicion y que ocupa en la matriz de celdas
	 * @param m : Mapa - Destinado a vincular el GameObject con el mapa
	 */
	public Nigromante(int x, int y, Mapa m){
		super(x,y,1,1,m);
		velocidad=8;
		puntaje=90;
		monedas=20;
		vida=vidaMax=30;
		rango=1;
		fuerza=20;
		cargaAtaqueNecesaria = 50;
		cargaAtaqueActual = 40;
		cargaInvocacion=20;
		cargaInvocacionActual=0;
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
		super.move();
		if(cargaInvocacionActual==cargaInvocacion){
			cargaInvocacionActual=0;
			if(ejercito.size()<=3)
				((GraphicNigromante)grafico).summon();
			for(int i=0;(i<2)&&(ejercito.size()<=3);i++)
				for(int j=-1;(j<2)&&(ejercito.size()<=3);j++){
					if(!(i==0&&j==0)){
						visitorEsqueleto.actualizarCeldaDeCreacion(x+i, j+y);
						Celda c = map.getCelda(x+i, y+j);
						if(c!=null){
							if(c.isEmpty())
								agregarEsqueleto(new Esqueleto(x+i,y+j,map,this));
							else
								c.getFirst().accept(visitorEsqueleto);
						}
					}
				}
		}
		else
			cargaInvocacionActual++;
	}
	public void kill(){
		int aux=ejercito.size();
		for(int i=0;i<aux;i++){
			ejercito.get(0).kill();
		}
		super.kill();
	}
	public void agregarEsqueleto(Esqueleto e){
		if(ejercito.size()<=3){
			map.agregarElemento(e);
			ejercito.add(e);
			map.getAlmacenHilos().getMovEnemigo().agregarEnemigo(e);
			map.getAlmacenHilos().getAtaEnemigo().agregarEnemigo(e);
		}
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