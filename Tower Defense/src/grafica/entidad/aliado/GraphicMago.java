package grafica.entidad.aliado;

import grafica.mapa.*;

import javax.swing.ImageIcon;

public class GraphicMago extends GraphicAliado{
	
	public GraphicMago(int x, int y, GraphicMapa m){
		super(x,y,1,1,8,m);

		imagenes[0] = new ImageIcon(t.createImage(dir+"Aliados/Mago/MagoIdle.png"));
		imagenes[1] = new ImageIcon(t.createImage(dir+"Aliados/Mago/MagoAtaque.gif"));
		imagenes[2] = new ImageIcon(t.createImage(dir+"Aliados/Mago/MagoMuerte.gif"));

		upgrades[0] = new ImageIcon(t.createImage(dir+"Aliados/MagoUpgrade/MagoUpgradeIdle.png"));
		upgrades[1] = new ImageIcon(t.createImage(dir+"Aliados/MagoUpgrade/MagoUpgradeAtaque.gif"));
		upgrades[2] = new ImageIcon(t.createImage(dir+"Aliados/MagoUpgrade/MagoUpgradeMuerte.gif"));
	}
}