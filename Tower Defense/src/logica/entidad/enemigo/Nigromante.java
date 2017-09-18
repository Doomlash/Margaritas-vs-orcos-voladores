package logica.entidad.enemigo;

public class Nigromante extends Enemigo{

	public Nigromante(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}