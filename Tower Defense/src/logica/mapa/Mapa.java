package logica.mapa;

import logica.juego.niveles.*;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.disparo.*;
import logica.itemsPremio.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import logica.comprables.*;

public class Mapa{
	private Nivel nivel;
	private Celda[][] celdas;
	private List<Disparo> disparos;
	private List<ItemPremio> items;
	private List<CampoDeCuracion> cc;
	
	public Mapa(Nivel n){
		nivel=n;
		celdas = new Celda[6][10];
		disparos= new ArrayList<Disparo>();
		items= new ArrayList<ItemPremio>();
		cc= new ArrayList<CampoDeCuracion>();
		cargarMapa();
	}
	
	public void cargarMapa(){
		Random r=new Random();
		int piedras=0;
		while(piedras<2){
			int fila=r.nextInt()%6;
			int columna=(r.nextInt()%10)+1;
			if(celdas[fila][columna].getElementos().isEmpty()){
				celdas[fila][columna].agregarElemento(new Piedra());
			piedras++;
			}
		}
		int lagos=0;
		while(lagos<2){
			int fila=r.nextInt()%6;
			int columna=(r.nextInt()%10)+1;
			if(celdas[fila][columna].getElementos().isEmpty()){
				celdas[fila][columna].agregarElemento(new Agua());
			lagos++;
			}
		}
	}
	
	public List<Disparo> getDisparos(){
		return disparos;
	}
	public List<ItemPremio> getItems(){
		return items;
	}
	public List<CampoDeCuracion> getCC(){
		return cc;
	}
}
