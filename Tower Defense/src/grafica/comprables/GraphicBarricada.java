package grafica.comprables;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public class GraphicBarricada extends GraphicGameObject{
	
	public GraphicBarricada(int x, int y){
		super(x,y,0,1);
		imagenes = new ImageIcon[3];
		imagenes[0] = new ImageIcon(dir+"Barricada/Barricada.png");
		imagenes[1] = new ImageIcon(dir+"Barricada/BarricadaDeterioro.png");
		imagenes[2] = new ImageIcon(dir+"Barricada/BarricadaDobleDeterioro.png");
	}
	
	public void restaurar(){
		setImageIdle();
	}
	public void deterioro(){
		grafico.setIcon(imagenes[1]);
	}
	public void dobleDeterioro(){
		grafico.setIcon(imagenes[2]);
	}
}