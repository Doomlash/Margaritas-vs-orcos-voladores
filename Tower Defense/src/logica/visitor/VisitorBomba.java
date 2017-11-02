package logica.visitor;

import java.util.ArrayList;
import java.util.List;

import logica.comprables.Barricada;
import logica.entidad.aliado.Aliado;
import logica.entidad.enemigo.Enemigo;
import logica.gameObjects.Obstaculo;
import logica.mapa.elementosMapa.destruibles.Piedra;
import logica.mapa.elementosMapa.temporales.Agua;
import logica.premio.objetoPrecioso.Trampa;

public class VisitorBomba extends Visitor {
	private List<Obstaculo> objetivos;
	
	public VisitorBomba(){
		objetivos=new ArrayList<Obstaculo>();
	}
public void visit(Aliado a){
		objetivos.add(a);
	}
	public void visit(Enemigo e){
		objetivos.add(e);
	}
	public void visit(Barricada b){
		objetivos.add(b);
	}
	public void visit(Piedra p){
		objetivos.add(p);
	}
	public void visit(Agua a){
	}
	public void visit(Trampa t){
	}
	public void kill(){}
	
	public List<Obstaculo> getObjetivos(){
		return objetivos;
	}
}
