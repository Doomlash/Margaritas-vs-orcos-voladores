package logica.entidad.DirectorPowerUp;

import logica.modificador_PowerUp.*;
import logica.entidad.enemigo.*;
import logica.comprables.*;

public class DirectorPowerUpEnemigo extends DirectorPowerUp{
	private RalentizadorAgua raleAgua;
	
	public DirectorPowerUpEnemigo(Enemigo e){
		super(e);
	}
	
	public void receive(RalentizadorAgua r){
		if(raleAgua==null){
			raleAgua=r;
			entidad.afectar(r);
		}
		else{
			if(raleAgua==r){
				r.kill();
				raleAgua=null;
			}
		}
	}
	public void receive(Upgrade u){}
}