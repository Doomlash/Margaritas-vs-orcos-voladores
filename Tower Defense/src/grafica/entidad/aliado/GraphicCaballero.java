package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCaballero extends GraphicAliado{
	
	public GraphicCaballero(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Caballero/CaballeroIdle.png");
		imagenes[1] = new ImageIcon(dir+"Aliados/Caballero/CaballeroAtaque.gif");
	}
}