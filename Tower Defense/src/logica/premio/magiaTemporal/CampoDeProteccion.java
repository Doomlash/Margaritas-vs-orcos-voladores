package logica.premio.magiaTemporal;

import logica.entidad.Entidad;

public class CampoDeProteccion {
	private Entidad entidad;
	
	
	public void destroy(){
		entidad.setCP(null);
	}
}