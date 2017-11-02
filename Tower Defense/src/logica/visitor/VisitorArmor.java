
package logica.visitor;

import logica.entidad.aliado.Aliado;

public class VisitorArmor extends Visitor{
	public void visit(Aliado a){
		a.armadura();
	}
	public void kill(){}
}
