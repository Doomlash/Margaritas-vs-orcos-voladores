package grafica.entidad.enemigo;

import grafica.mapa.*;
import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicDragon extends GraphicEnemigo{
	private int cantAtaques;
	
	public GraphicDragon(int x, int y, GraphicMapa m){
		super(x,y,2,2,6,m);
		imagenes = new ImageIcon[11];
		cantAtaques=0;
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/Dragonvolar.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonCongeladoVolando.png"));
		imagenes[6] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizar.gif"));
		imagenes[7] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonDespegar.gif"));
		imagenes[8] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizarAtaqueArriba.gif"));
		imagenes[9] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizarAtaqueArribaAbajo.gif"));
		imagenes[10] = new ImageIcon(t.createImage(dir+"Enemigos/Dragon/DragonAterrizarAtaqueAbajo.gif"));
	}
	public void aterrizar(){
		this.getGrafico().setIcon(imagenes[6]);
	}
	public void despegar(){
		this.getGrafico().setIcon(imagenes[7]);
	}
	public void atacar(int yObs, int dyObs, int yDra, GraphicGameObject g){
		cantAtaques++;
		if(cantAtaques==1){
			if((yObs+dyObs-1)==yDra){
				imagenes[8].getImage().flush();
				this.getGrafico().setIcon(imagenes[8]);
				cargaAtaque.recargar();
				g.cambiarPos(g.getPos().x, g.getPos().y+35);
			}
			else{
				imagenes[10].getImage().flush();
				this.getGrafico().setIcon(imagenes[10]);
				cargaAtaque.recargar();
				g.cambiarPos(g.getPos().x, g.getPos().y-35);
			}
			
		}
		else
			if(cantAtaques==2){
				imagenes[9].getImage().flush();
				this.getGrafico().setIcon(imagenes[9]);
				cargaAtaque.recargar();
				g.cambiarPos(g.getPos().x, g.getPos().y-35);
			}
	}
	public void resetearAtaques(){
		cantAtaques=0;
	}
	public void congelar(){
		if(getGrafico().getIcon()==imagenes[1])
			grafico.setIcon(imagenes[5]);
		else
			grafico.setIcon(imagenes[4]);
	}
}