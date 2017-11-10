package grafica.entidad.aliado;

import grafica.entidad.*;
import grafica.mapa.*;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public abstract class GraphicAliado extends GraphicEntidad{
	protected Toolkit t = Toolkit.getDefaultToolkit();
	
	public GraphicAliado(int x, int y, int dx, int dy, GraphicMapa m){
		super(x,y,dx,dy,m);
		imagenes= new ImageIcon[4];
	}
	public void atacar(){
		imagenes[1].getImage().flush();
		this.getGrafico().setIcon(imagenes[1]);
	}
	public void morir(){
		this.getGrafico().setIcon(imagenes[2]);
		removeLifeLine();
		removeAttackChargeLine();
	}
}