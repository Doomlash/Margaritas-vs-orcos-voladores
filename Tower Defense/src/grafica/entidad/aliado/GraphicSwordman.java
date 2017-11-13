package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicSwordman extends GraphicAliado{
	
	public GraphicSwordman(int x, int y, GraphicMapa m){
		super(x,y,2,1,6,m);
		
		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Swordman/SwordmanIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Swordman/SwordmanAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Swordman/SwordmanMuerte.gif"));
		pos.x-=20;
		cargaAtaque.cambiarPos(cargaAtaque.getPos().x-45, cargaAtaque.getPos().y);
		vida.cambiarPos(vida.getPos().x-45, vida.getPos().y);
		
		upgrades[0] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroIdle.png"));
		upgrades[1] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroAtaque.gif"));
		upgrades[2] = new ImageIcon(t.createImage(dir+"Aliados/Caballero/CaballeroMuerte.gif"));
	}
}