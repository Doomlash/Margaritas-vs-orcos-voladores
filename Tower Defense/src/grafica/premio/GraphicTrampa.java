package grafica.premio;

import grafica.gameObjects.*;
import grafica.mapa.*;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GraphicTrampa extends GraphicGameObject{
	private Toolkit t = Toolkit.getDefaultToolkit();
	private int tiempoAccionar;
	private GraphicMapa map;
	
	public GraphicTrampa(int x, int y, GraphicMapa m){
		super(x,y,0,1,1);
		
		tiempoAccionar=5;
		this.map=m;
		imagenes = new ImageIcon[2];
		imagenes[0] = new ImageIcon(t.createImage(dir+"TrampaIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Trampa2.gif"));
	}

	public void decrementarTiempoAccionar(){
		tiempoAccionar--;
		if(tiempoAccionar==0)
			map.removeGraphicElemento(this);
	}
	public int getTiempoAccionar(){
		return tiempoAccionar;
	}
	public void accionar(){
		imagenes[1].getImage().flush();
		this.getGrafico().setIcon(imagenes[1]);
		map.addGraphicElemento(this);
	}
}