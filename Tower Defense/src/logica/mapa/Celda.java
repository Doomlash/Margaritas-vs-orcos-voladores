package logica.mapa;

import logica.gameObjects.*;
import java.util.List;

public class Celda{
	private List<Elemento> lista;

	public void agregarElemento(Elemento e) {
		lista.add(e);//completar
	}

	public List<Elemento> getElementos() {
		return lista;
	}
}
