package logica.entidad.enemigo;

public class Ogro extends Enemigo{

	public Ogro(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}