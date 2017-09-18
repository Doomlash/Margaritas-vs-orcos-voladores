package logica.entidad.enemigo;

public class Dragon extends Enemigo{

	public Dragon(int x, int y){
		super(x,y);
		velocidad=8;
	}
	public void run(){
		while(execute){
			move();
		}
	}
}