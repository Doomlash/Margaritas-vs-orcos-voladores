package logica.visitor;

import logica.entidad.aliado.Aliado;

public class VisitorBooster extends Visitor{
	public void visit(Aliado a){
		a.boostear();
	}
	public void kill(){}
}
