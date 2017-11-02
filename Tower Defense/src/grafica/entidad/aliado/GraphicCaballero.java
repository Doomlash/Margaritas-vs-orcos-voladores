package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCaballero extends GraphicAliado{
	
	public GraphicCaballero(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroMuerte.gif"));
	}
	
	public void atacar(){
		super.atacar();
	}
}