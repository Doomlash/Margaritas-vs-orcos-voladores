package grafica.entidad.enemigo;

import grafica.mapa.GraphicMapa;

import javax.swing.ImageIcon;

public class GraphicCerberus extends GraphicEnemigo{
	
	public GraphicCerberus(int x, int y, GraphicMapa m){
		super(x,y,2,2,10,m);
		
		imagenes = new ImageIcon[8];
		imagenes[0] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusMovimiento.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusAtaque.gif"));
		imagenes[3] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusMuerte.gif"));
		imagenes[4] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusCongelado.png"));
		imagenes[5] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusAtaqueArriba.gif"));
		imagenes[6] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusAtaqueAdelante.gif"));
		imagenes[7] = new ImageIcon(t.createImage(dir+"Enemigos/Cerberus/CerberusAtaqueAbajo.gif"));
	}
	
	public void atacar(int yObs, int dyObs, int yCer){
		if((yObs+dyObs-1)==yCer){
			imagenes[5].getImage().flush();
			this.getGrafico().setIcon(imagenes[5]);
			cargaAtaque.recargar();
		}
		else{
			if(yObs==(yCer+1)){
				imagenes[7].getImage().flush();
				this.getGrafico().setIcon(imagenes[7]);
				cargaAtaque.recargar();				
			}
			else{
				imagenes[6].getImage().flush();
				this.getGrafico().setIcon(imagenes[6]);
				cargaAtaque.recargar();
			}
		}
	}
}