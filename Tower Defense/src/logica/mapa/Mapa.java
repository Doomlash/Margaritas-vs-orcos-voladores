package logica.mapa;

import logica.juego.niveles.*;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import java.util.Random;
import logica.entidad.aliado.*;

public class Mapa{
	private Nivel nivel;
	private Celda[][] celdas;
	
	public Mapa(Nivel n){
		nivel=n;
		celdas = new Celda[6][10];
		for(int i=0;i<celdas.length;i++)
			for(int j=0;j<celdas[i].length;j++)
				celdas[i][j] = new Celda();
		
		int p[] = new int[1];
		p[0] = 0;
		Arquero ar= new Arquero(p,0);
		celdas[0][0].agregarElemento(ar);
		nivel.getJuego().getGui().add(celdas[0][0].getElementos().get(0).getGraphic().getGrafico());
		agregarObstaculos(2,2);
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
			columna=r.nextInt(9)+1;
			System.out.println(fila+"-"+ columna);
			if(celdas[fila][columna].isEmpty()){
				int posX[] = new int[1];
				posX[0] = columna;
				celdas[fila][columna].agregarElemento(new Piedra(posX,fila));
				nivel.getJuego().getGui().add(celdas[fila][columna].getElementos().get(0).getGraphic().getGrafico());
				p--;
			}
			System.out.println(p);
		}
		while(celdasVacias()&&(l>0)){
			fila=r.nextInt(6);
			columna=r.nextInt(9)+1;
			System.out.println(fila+"-"+ columna);
			if(celdas[fila][columna].isEmpty()){
				int posX[] = new int[1];
				posX[0] = columna;
				celdas[fila][columna].agregarElemento(new Agua(posX,fila));
				nivel.getJuego().getGui().add(celdas[fila][columna].getElementos().get(0).getGraphic().getGrafico());
				l--;
			}
			System.out.println(l);
		}
		System.out.println("why?");
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
				vacia= celdas[i][j].isEmpty();
		return vacia;
	}
}
