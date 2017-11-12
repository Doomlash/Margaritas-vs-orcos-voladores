package grafica.disparo.disparoAliado;

import javax.swing.ImageIcon;

public class GraphicProyectilMagico extends GraphicDisparoAliado{
	
	public GraphicProyectilMagico(int x, int y){
		super(x,y);
		
		imagenes[0] = new ImageIcon(dir+"Aliados/Mago/ProyectilMagico.png");
		pos.x-=46;
		pos.y-=35;
	}
}