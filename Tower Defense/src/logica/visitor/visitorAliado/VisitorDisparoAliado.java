package logica.visitor.visitorAliado;

import logica.disparo.disparoAliado.*;
import logica.entidad.enemigo.*;
import logica.gameObjects.Obstaculo;
import logica.visitor.Visitor;

public class VisitorDisparoAliado extends Visitor{
	protected DisparoAliado disparo;
	private Obstaculo[] impactados;
	private int agregar=0;
	
	public VisitorDisparoAliado(DisparoAliado d){
		this.disparo = d;
		impactados = new Obstaculo[d.getImpactos()];
	}
	public void visit(Enemigo e){
		if(disparo!=null){
			e.getEstadoEscudo().recibirGolpe(disparo);
			if(disparo!=null){
				boolean pertenece=false;
				for(int i=0;(i<impactados.length)&&!pertenece;i++){
					if(impactados[i]==e)
						pertenece=true;
				}
				if(!pertenece){
					e.setVida(e.getVida()-disparo.getDamage());
					disparo.impactar();
					impactados[agregar]=e;
					agregar++;
				}
			}
		}
	}
	
	public void kill(){
		disparo = null;
	}
}