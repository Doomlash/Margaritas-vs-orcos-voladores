package grafica.entidad.enemigo;

import logica.entidad.enemigo.*;
import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	private Dragon dragon;
	private int cantAtaques;
	
	public GraphicDragon(int x, int y, GraphicMapa m, Dragon d){
		super(x,y,2,2,6,m);
		imagenes = new ImageIcon[10];
		cantAtaques=0;
		this.dragon=d;
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/Dragonvolar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongeladoVolando.png"));
		imagenes[6] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizar.gif"));
		imagenes[7] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonDespegar.gif"));
		imagenes[8] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizarAtaque.gif"));
		imagenes[9] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAtaqueDespegar.gif"));
	}
	public void aterrizar(){
		this.getGrafico().setIcon(imagenes[6]);
	}
	public void despegar(){
		this.getGrafico().setIcon(imagenes[7]);
	}
	public void atacar(){
		if(this.getGrafico().getIcon()==imagenes[1]){
			super.atacar();
			dragon.setDuracionAtaque(6);
		}
		else{
			imagenes[8].getImage().flush();
			this.getGrafico().setIcon(imagenes[8]);
			cargaAtaque.recargar();
			dragon.setDuracionAtaque(11);
		}
//		cantAtaques++;
//		if(cantAtaques==1){
//			imagenes[8].getImage().flush();
//			getGrafico().setIcon(imagenes[8]);
//			dragon.setDuracionAtaque(11);
//		}
//		else{
//			if(cantAtaques==2)
//				dragon.setDuracionAtaque(6);
//			super.atacar();
//		}
	}
	public void finalizarAtaque(){
		if(cantAtaques==1){
			imagenes[7].getImage().flush();
			getGrafico().setIcon(imagenes[7]);
			dragon.setDuracionAtaque(4);
		}
		else
			if(cantAtaques>1){
				imagenes[9].getImage().flush();
				getGrafico().setIcon(imagenes[9]);
				dragon.setDuracionAtaque(9);
			}
	}
	public void congelar(){
		if(getGrafico().getIcon()==imagenes[1])
			grafico.setIcon(imagenes[5]);
		else
			grafico.setIcon(imagenes[4]);
	}
}