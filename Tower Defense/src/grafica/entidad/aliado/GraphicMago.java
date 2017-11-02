package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicMago extends GraphicAliado{
	
	public GraphicMago(int x, int y){
		super(x,y,1);

		imagenes[0] = new ImageIcon(dir+"Aliados/Mago/MagoIdle.png");
		imagenes[1] = new ImageIcon(dir+"Aliados/Mago/MagoAtaque.gif");
	}
	public void atacar(){
		super.atacar();
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
		}
	}
}