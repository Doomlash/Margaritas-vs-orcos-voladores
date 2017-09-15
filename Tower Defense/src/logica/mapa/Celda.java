package logica.mapa;

import java.util.List;

import logica.disparo.Disparo;
import logica.gameObjects.*;
import logica.mapa.elementosMapa.destruibles.Piedra;

public class Celda{
	private List<Elemento> lista;

	public void agregarElemento(Elemento e) {
		lista.add(e);
	}

	public List<Elemento> getElementos() {
		return lista;
	}
}
