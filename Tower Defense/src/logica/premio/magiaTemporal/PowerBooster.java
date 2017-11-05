package logica.premio.magiaTemporal;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.*;
import logica.modificador_PowerUp.Modificador;
import grafica.premio.*;

public class PowerBooster extends Modificador{
	private int cd;
	private float tiempo;
	private GraphicBooster grafico;
	
	public PowerBooster(int x, int y, Mapa m){
		tiempo = 10;
		this.map = m;
		grafico = new GraphicBooster(x,y);
	}
	public void actualizar(){
		tiempo=tiempo-(1/4);
		if(tiempo<=0)
			kill();
	}
	
	public void afectar(Aliado a){
		this.entidad=a;
		map.getMapaGrafico().addGraphicElemento(grafico);
		cd = entidad.getCargaAtaqueNecesaria();
		entidad.setCargaAtaqueNececaria(cd/2);
	}
	public void afectar(Enemigo e){
		
	}
	public void restaurar(){
		entidad.setCargaAtaqueNececaria(cd);
	}
}