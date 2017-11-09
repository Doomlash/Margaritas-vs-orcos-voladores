package grafica.entidad.enemigo;

import grafica.entidad.*;
import grafica.mapa.*;

import java.awt.Toolkit;

import javax.swing.ImageIcon;

public abstract class GraphicEnemigo extends GraphicEntidad{
	protected Toolkit t = Toolkit.getDefaultToolkit();
	
	public GraphicEnemigo(int x, int y,int dx, int dy, GraphicMapa m){
		super(x,y,dx,dy,m);
		imagenes = new ImageIcon[6];
	}
	public void atacar(){
		imagenes[2].getImage().flush();
		this.getGrafico().setIcon(imagenes[2]);
	}
	public void avanzar(){
		this.getGrafico().setIcon(imagenes[1]);
	}
	public void morir(){
		imagenes[3].getImage().flush();
		this.getGrafico().setIcon(imagenes[3]);
		removeLifeLine();
	}
	public void cambiarPos(int newX, int newY){
		super.cambiarPos(newX,newY);
		vida.cambiarPos(newX, newY);
		if(escudo!=null)
			escudo.cambiarPos(pos.x, pos.y);
	}
	public void congelar(){
		this.getGrafico().setIcon(imagenes[4]);
	}
}