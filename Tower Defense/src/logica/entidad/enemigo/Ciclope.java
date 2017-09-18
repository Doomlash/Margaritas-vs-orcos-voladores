package logica.entidad.enemigo;

public class Ciclope extends Enemigo{

	public Ciclope(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}