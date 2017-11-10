package grafica.entidad;

import grafica.gameObjects.*;
import grafica.mapa.*;
import grafica.premio.GraphicEscudo;

public abstract class GraphicEntidad extends GraphicObstaculo{
	protected GraphicAttackChargeLine cargaAtaque;
	protected GraphicEscudo escudo;
	
	public GraphicEntidad(int x, int y, int dx, int dy, GraphicMapa m){
		super(x,y,1,dx,dy,m);
		cargaAtaque=new GraphicAttackChargeLine(x,y,dx,dy);
	}
	
	public void actualizarAttackChargeLine(int cMax, int cActual){
		cargaAtaque.updateAttackChargeLine(cMax, cActual);
	}
	public void agregarGraficosAsociados(){
		super.agregarGraficosAsociados();
		map.addGraphicElemento(cargaAtaque);
	}
	public void removeAttackChargeLine(){
		map.removeGraphicElemento(cargaAtaque);
	}
	public void saveEscudo(GraphicEscudo e){
		this.escudo=e;
	}
	public void setImageIdle(){
		super.setImageIdle();
	}
}