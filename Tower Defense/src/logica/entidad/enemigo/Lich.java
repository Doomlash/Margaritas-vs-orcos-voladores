package logica.entidad.enemigo;

public class Lich extends Enemigo{

	public Lich(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}