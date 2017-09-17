package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCaballero extends GraphicAliado{
	
	public GraphicCaballero(int x, int y){
		super(x,y);
		
		this.imagenes[0] = new ImageIcon(this.getClass().getResource("/Sprites/caballeroEstatico.png"));
		this.imagenes[1] = new ImageIcon(this.getClass().getResource("/Sprites/caballeroAtacando.png"));
	}
}