package logica.visitor;

import logica.disparo.disparoAliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.elementosMapa.destruibles.*;

public class VisitorDisparoAliado extends Visitor{
	private DisparoAliado disparo;
	
	public VisitorDisparoAliado(DisparoAliado d){
		this.disparo = d;
	}

	public void visit(Enemigo e){
		if(disparo!=null){
			e.setVida(e.getVida()-disparo.getDamage());
			disparo.stop();
			disparo.kill();
			kill();
		}
	}
	public void visit(Piedra p){
		if(disparo!=null){
			p.setVida(p.getVida()-disparo.getDamage());
			disparo.stop();
			disparo.kill();
			kill();
		}
	}
	
	public void kill(){
		disparo = null;
	}
}