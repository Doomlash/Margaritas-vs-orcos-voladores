package logica.mapa;

import logica.juego.niveles.*;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.hilos.*;
import grafica.mapa.*;

import java.util.Random;
import logica.gameObjects.Elemento;

public class Mapa{
	private Nivel nivel;
	private Celda[][] celdas;
	private GraphicMapa grafico;
	private AlmacenHilos hilos;
	
	public Mapa(Nivel n){
		hilos = new AlmacenHilos();
		nivel=n;
		grafico = new GraphicMapa(this);
		celdas = new Celda[6][10];
		for(int i=0;i<celdas.length;i++)
			for(int j=0;j<celdas[i].length;j++)
				celdas[i][j] = new Celda();
		agregarObstaculos(6,6);
	}
	
	/**
	 * Agrega al mapa p piedras y a lagos. Ninguno de estos pueden estar en la primera fila
	 * @param p: Entero que representa la cantidad de piedras a agregar.
	 * @param a: Entero que representa la cantidad de lagos a agregar
	 */
	public void agregarObstaculos(int p, int l){
		Random r=new Random();
		int fila;
		int columna;
		while(celdasVacias()&&(p>0)){
			fila=r.nextInt(6);
			columna=5;
			if(celdas[fila][columna].isEmpty()){
				agregarElemento(new Piedra(columna,fila,this));
				p--;

			}
		}
		while(celdasVacias()&&(l>0)){
			fila=r.nextInt(6);
			columna=7;
			if(celdas[fila][columna].isEmpty()){
				Agua a = new Agua(columna,fila,this);
				Thread t = new Thread(a);
				t.start();
				agregarElemento(a);
				l--;
			}
		}
	}
	public boolean agregarElemento(Elemento e){
		int x = e.getX();
		int y = e.getY();
		int dx = e.getDimensionX();
		int dy = e.getDimensionY();
		boolean agregado=false;
		if(x>=0&&x<celdas[0].length)
			if((y>=0)&&((y+dy-1)<celdas.length)){
				for(int i=x;i<x+dx;i++)
					for(int j=y;j<y+dy;j++){
						if(i<celdas[0].length){
							celdas[j][i].agregarElemento(e);
							agregado = true;
						}
					}
				grafico.addGraphicElemento(e.getGraphic());
				e.getGraphic().agregarGraficosAsociados();
			}
		return agregado;
	}
	public void eliminarElemento(Elemento e){
		int x = e.getX();
		int y = e.getY();
		int dx = e.getDimensionX();
		int dy = e.getDimensionY();
		if(x>=0&&x<celdas[0].length)
			if(y>=0&&(y+dy-1)<celdas.length){
				for(int i=x;i<x+dx;i++)
					for(int j=y;j<y+dy;j++){
						if(i<celdas[0].length){
							celdas[j][i].remover(e);
						}
					}
				grafico.removeGraphicElemento(e.getGraphic());
			}
		
	}
	
	public Nivel getNivel(){
		return nivel;
	}
	public GraphicMapa getMapaGrafico(){
		return grafico;
	}
	public Celda[][] getCeldas(){
		return celdas;
	}
	public Celda getCelda(int x, int y){
		if((x>=0)&&(x<celdas[0].length))
			if((y>=0)&&(y<celdas.length))
				return celdas[y][x];
		return null;
	}
	public AlmacenHilos getAlmacenHilos(){
		return hilos;
	}
	
	public boolean celdasVacias(){
		boolean vacia=false;
		for(int i=0;(i<celdas.length)&&!vacia;i++)
			for(int j=0;(j<celdas[i].length)&&(!vacia);j++)
				vacia= celdas[i][j].isEmpty();
		return vacia;
	}
}
