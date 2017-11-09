package logica.premio.magiaTemporal;

import logica.entidad.aliado.*;
import logica.entidad.enemigo.*;
import logica.mapa.*;
import logica.modificador_PowerUp.*;
import grafica.entidad.aliado.*;

public class PowerBooster extends ModificadorEntidad{
	private int cd;
	private double tiempo;
	
	public PowerBooster(int x, int y, Mapa m){
		tiempo = 10;
		this.map = m;
	}
	public void actualizar(){
		tiempo=tiempo-(0.25);
		if(tiempo<=0)
			kill();
	}
	
	public void afectar(Aliado a){
		this.entidad=a;
		((GraphicAliado)a.getGraphic()).activarBooster(entidad.getX(), entidad.getY(), entidad.getDimensionX(), entidad.getDimensionY());
		cd = entidad.getCargaAtaqueNecesaria();
		entidad.setCargaAtaqueNececaria(cd/2);
	}
	public void afectar(Enemigo e){
		
	}
	public void restaurar(){
		entidad.setCargaAtaqueNececaria(cd);
		((GraphicAliado)entidad.getGraphic()).desactivarBooster();
	}
}