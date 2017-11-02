package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicArquero extends GraphicAliado{

	public GraphicArquero(int x, int y){
		super(x,y,1);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Arquero/ArqueroIdle.png");
		imagenes[1] = new ImageIcon(dir+"Aliados/Arquero/ArqueroAtaque.gif");
		imagenes[2] = new ImageIcon(dir+"Aliados/Arquero/ArqueroMuerte.gif");
		imagenes[3] = new ImageIcon(dir+"Aliados/Arquero/ArqueroEscudo.gif");
	}
	
	public void atacar(){
		super.atacar();
		try{
			Thread.sleep(600);
		}catch(InterruptedException e){
		}
	}
}