package logica.comprables;

public class Stun implements Comprable{
	private int precio, tiempo, y;
	
	public Stun(int y){
		precio = 40;
		tiempo = 10;
		this.y = y;
	}
	public void reducirTemporizador(){
		tiempo--;
	}
	public int filaAfectada(){
		return y;
	}
	public int getTiempo(){
		return tiempo;
	}
	public int getPrecio(){
		return precio;
	}
}