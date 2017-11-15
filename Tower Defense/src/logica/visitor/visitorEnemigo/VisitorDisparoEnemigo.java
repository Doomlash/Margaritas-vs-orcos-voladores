package logica.visitor.visitorEnemigo;

import logica.disparo.disparoEnemigo.*;
import logica.comprables.*;
import logica.entidad.aliado.*;
import logica.gameObjects.Obstaculo;
import logica.mapa.elementosMapa.destruibles.*;
import logica.visitor.Visitor;

public class VisitorDisparoEnemigo extends Visitor{
	private DisparoEnemigo disparo;
	private Obstaculo[] impactados;
	private int agregar=0;
	
	public VisitorDisparoEnemigo(DisparoEnemigo d){
		this.disparo = d;
		impactados = new Obstaculo[d.getImpactos()];
	}

	public void visit(Aliado a){
		if(disparo!=null){
			a.getEstadoEscudo().recibirGolpe(disparo);
			if(disparo!=null){
				boolean pertenece=false;
				for(int i=0;(i<impactados.length)&&!pertenece;i++){
					if(impactados[i]==a)
						pertenece=true;
				}
				if(!pertenece){
					a.setVida(a.getVida()-disparo.getDamage());
					disparo.impactar();
					impactados[agregar]=a;
					agregar++;
				}
			}
		}
	}
	public void visit(Piedra p){
		if(disparo!=null){
			boolean pertenece=false;
			for(int i=0;(i<impactados.length)&&!pertenece;i++){
				if(impactados[i]==p)
					pertenece=true;
			}
			if(!pertenece){
				p.setVida(p.getVida()-disparo.getDamage());
				disparo.impactar();
				impactados[agregar]=p;
				agregar++;
			}
		}
	}
	public void visit(Barricada b){
		if(disparo!=null){
			boolean pertenece=false;
			for(int i=0;(i<impactados.length)&&!pertenece;i++){
				if(impactados[i]==b)
					pertenece=true;
			}
			if(!pertenece){
				b.setVida(b.getVida()-disparo.getDamage());
				disparo.impactar();
				impactados[agregar]=b;
				agregar++;
			}
		}
	}
	
	public void kill(){
		disparo = null;
	}

}