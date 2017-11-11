package grafica.gameObjects;

import javax.swing.ImageIcon;

public class GraphicLifeLine extends GraphicGameObject{
	private final int anchoBarraCompleta=52; //52 pixeles.
	private final int anchoDisminucionBarra=4; //4 pixeles.
	
	public GraphicLifeLine(int x, int y, int dx, int dy){
		super(x,y,1,dx,dy);
		
		imagenes = new ImageIcon[13];
		for(int i=0;i<imagenes.length;i++){
			imagenes[i] = new ImageIcon(dir+"Line/LifeLine/BarraVida-"+(i+1)+".png");
		}
	}
	public void updateLifeLine(int vidaMax, int vidaActual){
		int barraBuscada= (vidaActual*anchoBarraCompleta)/vidaMax;
		barraBuscada = barraBuscada/anchoDisminucionBarra;
		barraBuscada++;
		if(vidaMax==vidaActual)
			barraBuscada=imagenes.length;
		this.grafico.setIcon(imagenes[imagenes.length-barraBuscada]);
	}
}