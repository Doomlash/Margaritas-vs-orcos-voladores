package logica.entidad.enemigo;

public class Goblin extends Enemigo{
	
	public Goblin(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}