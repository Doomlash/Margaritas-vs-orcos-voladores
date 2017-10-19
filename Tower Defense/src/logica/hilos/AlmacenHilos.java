package logica.hilos;

public class AlmacenHilos{
	private HiloMovimientoEnemigo movEnemigo;
	private HiloAtaqueEnemigo ataqueEnemigo;
	private HiloAtaqueAliado ataqueAliado;
	private HiloDisparoEnemigo disparosEnemigos;
	private HiloDisparoAliado disparosAliados;
	
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
	public HiloAtaqueAliado getAtaAliado(){
		if(ataqueAliado==null){
			ataqueAliado = new HiloAtaqueAliado();
			ataqueAliado.start();
		}
		return ataqueAliado;
	}
	public HiloDisparoEnemigo getDisEnemigo(){
		if(disparosEnemigos==null){
			disparosEnemigos = new HiloDisparoEnemigo();
			disparosEnemigos.start();
		}
		return disparosEnemigos;
	}
	public HiloDisparoAliado getDisAliado(){
		if(disparosAliados==null){
			disparosAliados = new HiloDisparoAliado();
			disparosAliados.start();
		}
		return disparosAliados;
	}
	public void terminateAll(){
		if(movEnemigo!=null)
			movEnemigo.terminate();
		if(ataqueEnemigo!=null)
			ataqueEnemigo.terminate();
		if(ataqueAliado!=null)
			ataqueAliado.terminate();
		if(disparosEnemigos!=null)
			disparosEnemigos.terminate();
		if(disparosAliados!=null)
			disparosAliados.terminate();
	}
}