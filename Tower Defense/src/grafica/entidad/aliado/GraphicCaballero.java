package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicCaballero extends GraphicAliado{
	
	public GraphicCaballero(int x, int y, GraphicMapa m){
		super(x,y,1,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroMuerte.gif"));
	}
}