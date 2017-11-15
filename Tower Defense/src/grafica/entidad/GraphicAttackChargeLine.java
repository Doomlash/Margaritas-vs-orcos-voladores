package grafica.entidad;

import grafica.gameObjects.*;

import javax.swing.ImageIcon;

public class GraphicAttackChargeLine extends GraphicGameObject{
	private final int anchoBarraCompleta=36; //36 pixeles.
	private final int anchoDisminucionBarra=3; //3 pixeles.
	private boolean recargar;
	
	public GraphicAttackChargeLine(int x, int y, int dx, int dy){
		super(x,y,1,dx,dy);
		
		recargar=true;
		imagenes = new ImageIcon[13];
		for(int i=0;i<imagenes.length;i++){
			imagenes[i] = new ImageIcon(dir+"Line/AttackChargeLine/AttackChargeLine-"+(i+1)+".png");
		}
	}
	public void updateAttackChargeLine(int cMax, int cActual){
		if(recargar){
			int barraBuscada= (cActual*anchoBarraCompleta)/cMax;
			barraBuscada = barraBuscada/anchoDisminucionBarra;
			if(barraBuscada==imagenes.length-1)
				recargar=false;
			barraBuscada++;
			this.getGrafico().setIcon(imagenes[imagenes.length-barraBuscada]);
		}
	}
	public void recargar(){
		recargar=true;
	}
}