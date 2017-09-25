package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCaballero extends GraphicAliado{
	
	public GraphicCaballero(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(dir+"Estaticas Aliados/SwordmanIdle.png");
	}
}