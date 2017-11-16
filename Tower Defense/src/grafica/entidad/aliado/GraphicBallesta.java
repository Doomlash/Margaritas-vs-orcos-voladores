package grafica.entidad.aliado;

import grafica.disparo.disparoAliado.GraphicDisparoWarMachine;
import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicBallesta extends GraphicAliado{
	private ImageIcon[] disparo;
	private int disparoActual=0;
	
	public GraphicBallesta(int x, int y, GraphicMapa m){
		super(x,y,2,1,9,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Ballesta/BallestaIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Ballesta/BallestaAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Ballesta/BallestaMuerte.gif"));
		
		upgrades[0] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaIdle.png"));
		upgrades[1] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaAtaque.gif"));
		upgrades[2] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/CatapultaMuerte.gif"));
		
		disparo = new ImageIcon[2];
		disparo[0] = new ImageIcon(t.createImage(dir+"Aliados/Ballesta/FlechaBallesta.png"));
		disparo[1] = new ImageIcon(t.createImage(dir+"Aliados/Catapulta/Piedra.gif"));
	}
	public void atacar(GraphicDisparoWarMachine d){
		atacar();
		d.setImagen(disparo[disparoActual]);
	}
	
	public ImageIcon getImagenDisparo(){
		return disparo[disparoActual];
	}
	public void upgrade(){
		disparoActual=1;
		super.upgrade();
	}
	public void downgrade(){
		disparoActual=0;
		super.downgrade();
	}
}