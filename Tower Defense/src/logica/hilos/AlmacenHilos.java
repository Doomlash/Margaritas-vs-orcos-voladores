package logica.hilos;

public class AlmacenHilos{
	private HiloEnemigo[] hilos;
	private HiloAtaqueAliado ataqueAliado;
	
	public AlmacenHilos(){
		hilos = new HiloEnemigo[2];
		hilos[0] = new HiloMovimientoEnemigo();
		hilos[1] = new HiloAtaqueEnemigo();
		Thread t = new Thread(hilos[0]);
		t.start();
	}
	public HiloEnemigo getMovEnemigo(){
		return hilos[0];
	}
	public HiloEnemigo getAtaEnemigo(){
		return hilos[1];
	}
}