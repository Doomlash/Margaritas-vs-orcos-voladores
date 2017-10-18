package logica.hilos;

public class AlmacenHilos{
	private HiloEnemigo[] hilos;
	private HiloAtaqueAliado ataqueAliado;
	
	public AlmacenHilos(){
		hilos = new HiloEnemigo[2];
		hilos[0] = new HiloMovimientoEnemigo();
		hilos[1] = new HiloAtaqueEnemigo();
		ataqueAliado = new HiloAtaqueAliado();
		Thread t1 = new Thread(hilos[0]);
		t1.start();
		Thread t2 = new Thread(hilos[1]);
		t2.start();
	}
	public HiloEnemigo getMovEnemigo(){
		return hilos[0];
	}
}