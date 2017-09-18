package logica.mapa;

import logica.juego.niveles.*;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import grafica.mapa.*;

import java.util.Random;
import logica.entidad.aliado.*;
import logica.entidad.enemigo.Goblin;

public class Mapa{
	private Nivel nivel;
	private Celda[][] celdas;
	private GraphicMapa grafico;
	
	public Mapa(Nivel n){
		grafico = new GraphicMapa(n);
		nivel=n;
		celdas = new Celda[6][10];
		for(int i=0;i<celdas.length;i++)
			for(int j=0;j<celdas[i].length;j++)
				celdas[i][j] = new Celda();
		Arquero ar= new Arquero(0,0,this);
		celdas[0][0].agregarElemento(ar);
		agregarObstaculos(2,2);
		Goblin g= new Goblin(9,2,this);
		celdas[2][9].agregarElemento(g);
		Thread t = new Thread(g);
		t.start();
	}
	
	/**
	 * Agrega al mapa p piedras y a lagos. Ninguno de estos pueden estar en la primera fila
	 * @param p: Entero que representa la cantidad de piedras a agregar.
	 * @param a: Entero que representa la cantidad de lagos a agregar
	 */
	public void agregarObstaculos(int p, int a){
		Random r=new Random();
		int fila;
		int columna;
		while(celdasVacias()&&(p>0)){
			fila=r.nextInt(6);
			columna=r.nextInt(9)+1;
			if(celdas[fila][columna].getElementos().isEmpty()){
				celdas[fila][columna].agregarElemento(new Piedra(columna,fila,this));				p--;
			}
		}
		while(celdasVacias()&&(a>0)){
			fila=r.nextInt(6);
			columna=r.nextInt(9)+1;
			if(celdas[fila][columna].getElementos().isEmpty()){
				celdas[fila][columna].agregarElemento(new Agua(columna,fila,this));
				a--;
			}
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
	
	private boolean celdasVacias(){
		boolean vacia=false;
		for(int i=0;(i<celdas.length)&&!vacia;i++)
			for(int j=0;(j<celdas[i].length)&&(!vacia);j++)
				vacia= celdas[i][j].getElementos().isEmpty();
		return vacia;
	}
}
