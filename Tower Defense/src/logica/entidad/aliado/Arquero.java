package logica.entidad.aliado;

import grafica.entidad.aliado.*;

public class Arquero extends Aliado{
	
	public Arquero(int x[],int y){
		grafico = new GraphicArquero(x[0],y);
	}
}