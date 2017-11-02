package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicArquero extends GraphicAliado{

	public GraphicArquero(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Arquero/ArqueroIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Arquero/ArqueroAtaque.gif"));
	}
	
	public void atacar(){
		super.atacar();
	}
}