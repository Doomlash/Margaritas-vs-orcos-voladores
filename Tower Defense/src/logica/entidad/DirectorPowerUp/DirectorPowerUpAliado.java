package logica.entidad.DirectorPowerUp;

import logica.entidad.aliado.*;
import logica.modificador_PowerUp.*;
import logica.comprables.*;

public class DirectorPowerUpAliado extends DirectorPowerUp{
	private Upgrade mejora;
	
	public DirectorPowerUpAliado(Aliado a){
		super(a);
	}
	public void receive(RalentizadorAgua r){
		
	}
	public void receive(Upgrade u){
		if(mejora==null){
			mejora=u;
			entidad.afectar(u);
		}
		else{
			if(mejora==u){
				mejora.kill();
				mejora=null;
			}
			else{
				mejora.kill();
				mejora=u;
				entidad.afectar(u);
			}
		}
	}
}