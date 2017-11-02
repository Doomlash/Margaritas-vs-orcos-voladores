package logica.premio.magiaTemporal;

import logica.premio.*;
import logica.entidad.aliado.*;

public class PowerBooster extends PowerUp{
	private int cd;
	
	public PowerBooster(Aliado a){
		this.aliado = a;
	}
	
	public void afectarAliado(){
		
	}
	
	public void run(){
		afectarAliado();
	}
}