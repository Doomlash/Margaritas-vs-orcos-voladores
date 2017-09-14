package logica.mapa;

import logica.juego.niveles.*;
import logica.disparo.*;
import logica.itemsPremio.*;
import java.util.List;
import java.util.ArrayList;

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
