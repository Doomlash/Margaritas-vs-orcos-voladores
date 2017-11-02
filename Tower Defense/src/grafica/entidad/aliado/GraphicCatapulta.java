package grafica.entidad.aliado;

import javax.swing.ImageIcon;

public class GraphicCatapulta extends GraphicAliado{
	
	public GraphicCatapulta(int x, int y){
		super(x,y,2);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Catapulta/CatapultaIdle.png");
		imagenes[1] = new ImageIcon(dir+"Aliados/Catapulta/CatapultaAtaque.gif");
	}
	public void atacar(){
		super.atacar();
		try{
			Thread.sleep(400);
		}catch(InterruptedException e){
		}
	}
	public void finalizarAtaque(){
		try{
			Thread.sleep(700);
		}catch(InterruptedException e){
		}
		setImageIdle();
		try{
			Thread.sleep(500);
		}catch(InterruptedException e){
		}
	}
}