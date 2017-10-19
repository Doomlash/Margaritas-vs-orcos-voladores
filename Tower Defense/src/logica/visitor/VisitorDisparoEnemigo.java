package logica.visitor;

import logica.disparo.disparoEnemigo.*;
import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.mapa.elementosMapa.destruibles.*;

public class VisitorDisparoEnemigo extends Visitor{
	private DisparoEnemigo disparo;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d){
		this.disparo = d;
	}

	public void visit(Aliado a){
		if(disparo!=null){
			a.setVida(a.getVida()-disparo.getDamage());
			disparo.stop();
			disparo.kill();
			kill();
		}
	}
	public void visit(Barricada b){
		if(disparo!=null){
			b.setVida(b.getVida()-disparo.getDamage());
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