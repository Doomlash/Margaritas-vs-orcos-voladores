package logica.hilos;

public class AlmacenHilos{
	private HiloMovimientoEnemigo movEnemigo;
	private HiloAtaqueEnemigo ataqueEnemigo;
	
	public AlmacenHilos(){
		movEnemigo = new HiloMovimientoEnemigo();
		ataqueEnemigo = new HiloAtaqueEnemigo();
		movEnemigo.start();
		ataqueEnemigo.start();
	}
	public HiloEnemigo getMovEnemigo(){
		return movEnemigo;
	}
	public HiloEnemigo getAtaEnemigo(){
		return ataqueEnemigo;
	}
}