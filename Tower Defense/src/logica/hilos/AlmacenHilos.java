package logica.hilos;

public class AlmacenHilos{
	private HiloMovimientoEnemigo movEnemigo;
	private HiloAtaqueEnemigo ataqueEnemigo;
	private HiloDisparoEnemigo disparosEnemigo;
	
	public AlmacenHilos(){
		movEnemigo = new HiloMovimientoEnemigo();
		ataqueEnemigo = new HiloAtaqueEnemigo();
		disparosEnemigo = new HiloDisparoEnemigo();
		movEnemigo.start();
		ataqueEnemigo.start();
		disparosEnemigo.start();
	}
	public HiloMovimientoEnemigo getMovEnemigo(){
		return movEnemigo;
	}
	public HiloAtaqueEnemigo getAtaEnemigo(){
		return ataqueEnemigo;
	}
	public HiloDisparoEnemigo getDisEnemigo(){
		return disparosEnemigo;
	}
}