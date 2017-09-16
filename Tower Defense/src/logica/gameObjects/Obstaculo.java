package logica.gameObjects;

public abstract class Obstaculo extends Elemento{
	protected int vida;
	protected int vidaMax;
	
	public void setVida(int v){
		if(v>vidaMax)
			vida=vidaMax;
		else
			if(v<=0)
				vida=0;
			else
				vida=v;
	}
	public int getVida(){
		return vida;
	}
}