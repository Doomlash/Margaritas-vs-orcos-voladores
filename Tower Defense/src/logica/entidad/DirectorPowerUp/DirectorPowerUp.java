package logica.entidad.DirectorPowerUp;

import logica.entidad.*;
import logica.premio.magiaTemporal.*;
import logica.modificador_PowerUp.*;
import logica.comprables.*;

import java.util.ArrayList;
import java.util.List;

public abstract class DirectorPowerUp{
	protected Entidad entidad;
	private List<PowerBooster> boosters;
	protected Escudo escudo;
	
	public DirectorPowerUp(Entidad e){
		this.entidad=e;
		boosters = new ArrayList<PowerBooster>();
	}
	public void receive(PowerBooster b){
		if(boosters.contains(b)){
			if(boosters.get(boosters.size()-1)==b){
				for(int i=boosters.size()-1;i>=0;i--)
					boosters.get(i).kill();
				boosters.clear();
			}
		}
		else{
			boosters.add(b);
			entidad.afectar(b);
		}
	}
	public abstract void receive(RalentizadorAgua r);
	
	public void receive(Escudo e){
		if(escudo==null){
			escudo=e;
			entidad.afectar(e);
			}
		else{
			if(escudo==e){
				e.kill();
				escudo=null;
			}
			else{
				escudo.kill();
				escudo=e;
				entidad.afectar(e);
			}
		}
	}
	public abstract void receive(Upgrade u);
	
	public void kill(){
		for(int i=boosters.size()-1;i>=0;i--)
			boosters.get(i).kill();
		boosters.clear();
		if(escudo!=null){
			escudo.kill();
			escudo=null;
		}
	}
}