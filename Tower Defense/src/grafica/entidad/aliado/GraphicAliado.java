package grafica.entidad.aliado;

import grafica.entidad.*;
import grafica.mapa.*;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public abstract class GraphicAliado extends GraphicEntidad{
	protected Toolkit t = Toolkit.getDefaultToolkit();
	protected ImageIcon[] upgrades;
	
	public GraphicAliado(int x, int y, int dx, int dy, GraphicMapa m){
		super(x,y,dx,dy,m);
		imagenes= new ImageIcon[3];
		upgrades = new ImageIcon[3];
	}
	public void atacar(){
		imagenes[1].getImage().flush();
		this.getGrafico().setIcon(imagenes[1]);
		cargaAtaque.recargar();
	}
	public void morir(){
		this.getGrafico().setIcon(imagenes[2]);
		removeLifeLine();
		removeAttackChargeLine();
	}
	public void upgrade(){
		ImageIcon[] aux = new ImageIcon[upgrades.length];
		for(int i=0;i<upgrades.length;i++){
			aux[i] = imagenes[i];
			imagenes[i] = upgrades[i];
			upgrades[i] = aux[i];
		}
		this.getGrafico().repaint();
	}
	public void downgrade(){
		ImageIcon[] aux = new ImageIcon[upgrades.length];
		for(int i=0;i<upgrades.length;i++){
			aux[i] = upgrades[i];
			upgrades[i] = imagenes[i];
			imagenes[i] = aux[i];
		}
		this.getGrafico().repaint();
	}
}