package grafica.entidad.aliado;

import javax.swing.ImageIcon;

import grafica.mapa.*;

public class GraphicAngel extends GraphicAliado{
	
	public GraphicAngel(int x, int y, GraphicMapa m){
		super(x,y,2,2,8,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Angel/AngelIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Angel/AngelAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Angel/AngelMuerte.gif"));
		
		upgrades[0] = new ImageIcon(t.createImage(dir+"Aliados/Archangel/ArchangelIdle.png"));
		upgrades[1] = new ImageIcon(t.createImage(dir+"Aliados/Archangel/ArchangelAtaque.gif"));
		upgrades[2] = new ImageIcon(t.createImage(dir+"Aliados/Archangel/ArchangelMuerte.gif"));
	}
}