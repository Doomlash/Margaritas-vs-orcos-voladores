package logica.hilos;

public class AlmacenHilos{
	private HiloMovimientoEnemigo movEnemigo;
	private HiloAtaqueEnemigo ataqueEnemigo;
	private HiloDisparoEnemigo disparosEnemigo;
	
	public HiloMovimientoEnemigo getMovEnemigo(){
		if(movEnemigo==null){
			movEnemigo = new HiloMovimientoEnemigo();
			movEnemigo.start();
		}
		return movEnemigo;
	}
	public HiloAtaqueEnemigo getAtaEnemigo(){
		if(ataqueEnemigo==null){
			ataqueEnemigo = new HiloAtaqueEnemigo();
			ataqueEnemigo.start();
		}
		return ataqueEnemigo;
	}
	public HiloDisparoEnemigo getDisEnemigo(){
		if(disparosEnemigo==null){
			disparosEnemigo = new HiloDisparoEnemigo();
			disparosEnemigo.start();
		}
		return disparosEnemigo;
	}
}