package grafica.gameObjects;

import javax.swing.ImageIcon;

public class GraphicLifeLine extends GraphicGameObject{
	private final int anchoBarraCompleta=52; //52 pixeles.
	private final int anchoDisminucionBarra=4; //4 pixeles.
	
	public GraphicLifeLine(int x, int y, int a){
		super(x,y,1,a,1);
		
		imagenes = new ImageIcon[13];
		for(int i=1;i<14;i++){
			imagenes[i-1] = new ImageIcon(dir+"LifeLine/BarraVida-"+i+".png");
		}
	}
	public void updateLifeLine(int vidaMax, int vidaActual){
		int barraBuscada = (vidaActual*anchoBarraCompleta)/vidaMax;
		barraBuscada = barraBuscada/anchoDisminucionBarra+1;
		this.grafico.setIcon(imagenes[imagenes.length-barraBuscada]);
	}
}