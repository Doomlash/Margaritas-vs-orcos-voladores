package logica.premio.magiaTemporal;

import logica.premio.*;
import logica.entidad.aliado.*;
import logica.mapa.*;
import grafica.premio.*;

public class PowerBooster extends PowerUp{
	private int cd;
	private GraphicBooster grafico;
	
	public PowerBooster(Aliado a, Mapa m){
		this.aliado = a;
		this.map = m;
		grafico = new GraphicBooster(aliado.getX(),aliado.getY());
		map.getMapaGrafico().addGraphicElemento(grafico);
		afectarAliado();
	}
	
	public void afectarAliado(){
		cd = aliado.getCargaAtaqueNecesaria();
		aliado.setCargaAtaqueNececaria(cd/2);
	}
	public void restaurarAliado(){
		aliado.setCargaAtaqueNececaria(cd);
	}
}