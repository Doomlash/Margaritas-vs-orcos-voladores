package grafica.entidad;

import javax.swing.ImageIcon;

import grafica.gameObjects.*;

public class GraphicAttackChargeLine extends GraphicGameObject{
	private final int anchoBarraCompleta=36; //36 pixeles.
	private final int anchoDisminucionBarra=3; //3 pixeles.
	
	public GraphicAttackChargeLine(int x, int y, int dx, int dy){
		super(x,y,1,dx,dy);
		
		imagenes = new ImageIcon[13];
		for(int i=0;i<imagenes.length;i++){
			imagenes[i] = new ImageIcon(dir+"Line/AttackChargeLine/AttackChargeLine-"+(i+1)+".png");
		}
	}
	public void updateAttackChargeLine(int cMax, int cActual){
		int barraBuscada= (cActual*anchoBarraCompleta)/cMax;
		barraBuscada = barraBuscada/anchoDisminucionBarra;
		if(barraBuscada==0)
			barraBuscada++;
		this.grafico.setIcon(imagenes[imagenes.length-barraBuscada]);
	}
}