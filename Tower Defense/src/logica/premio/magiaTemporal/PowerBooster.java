package logica.premio.magiaTemporal;

import logica.premio.*;
import logica.entidad.aliado.*;
import logica.mapa.*;
import grafica.premio.*;

public class PowerBooster extends PowerUp{
	private int cd, tiempo;
	private GraphicBooster grafico;
	private Aliado aliado;
	
	public PowerBooster(int x, int y, Mapa m){
		tiempo = 10;
		this.map = m;
		grafico = new GraphicBooster(x,y);
	}
	public void actualizar(){
		tiempo--;
		if(tiempo<=0)
			kill();
	}
	
	public void afectar(Aliado a){
		this.aliado=a;
		map.getMapaGrafico().addGraphicElemento(grafico);
		cd = aliado.getCargaAtaqueNecesaria();
		aliado.setCargaAtaqueNececaria(cd/2);
	}
	public void restaurar(){
		aliado.setCargaAtaqueNececaria(cd);
	}
}