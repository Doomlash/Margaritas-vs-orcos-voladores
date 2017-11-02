package logica.visitor;

import logica.entidad.aliado.Aliado;
import logica.premio.magiaTemporal.*;

public class VisitorBooster extends Visitor{

	public void visit(Aliado a){
		PowerBooster b = new PowerBooster(a);
		
	}
	
	public void kill(){}

}