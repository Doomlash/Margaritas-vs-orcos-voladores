package logica.mapa;

import logica.gameObjects.*;

import java.util.ArrayList;
import java.util.List;

public class Celda{
	private List<Elemento> lista;

	public Celda(){
		lista = new ArrayList<Elemento>();
	}
	
	public void agregarElemento(Elemento e){
		lista.add(e);
	}
	public void deleteElemento(Elemento e){
		int pos=0;
		boolean eliminado=false;
		if(!lista.isEmpty()){
			while(!eliminado&&pos<lista.size()){
				if(lista.get(pos)==e){
					lista.remove(pos);
					eliminado=true;
				}
				pos++;
			}
		}
	}

	public List<Elemento> getElementos() {
		return lista;
	}
}
