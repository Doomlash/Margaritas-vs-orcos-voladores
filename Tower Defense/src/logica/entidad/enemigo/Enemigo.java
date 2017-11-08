package logica.entidad.enemigo;

import logica.entidad.*;
import logica.mapa.*;
import logica.visitor.*;
import logica.visitor.visitorEnemigo.VisitorAtaqueEnemigo;
import logica.visitor.visitorEnemigo.VisitorMovimientoEnemigo;
import logica.itemPremio.*;
import logica.modificador_PowerUp.*;
import grafica.entidad.enemigo.*;
import grafica.gameObjects.*;

import java.util.Random;


public abstract class Enemigo extends Entidad{
	protected int velocidad;
	protected int puntaje;
	protected int monedas;
	protected boolean canMove;
	protected VisitorAtaqueEnemigo visitorAtaque;
	protected VisitorMovimientoEnemigo visitorMovimiento;
	
	/**
	 * 
	 * @param x : int
	 * @param y : int
	 * @param dx : int - Indica la dimension del objeto en cuanto a ancho
	 * @param m : Mapa
	 */
	public Enemigo(int x, int y, int dx, int dy, Mapa m){
		super(x,y,dx,dy,m);
		visitorAtaque = new VisitorAtaqueEnemigo(this);
		visitorMovimiento = new VisitorMovimientoEnemigo(this,map);
		canMove=true;
	}
	
	/**
	 * Invoca al visit del visitor indicando su tipo (Enemigo)
	 */
	public void accept(Visitor v){
		v.visit(this);
	}
	
	/**
	 * Detiene el movimiento del enemigo
	 */
	public void stop(){
		canMove=false;
	}

	
	/*ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	ACORDARSE DE ELIMINAR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2
	*/
	public abstract void SACARDEARREGLO();
	/**
	 * Actualiza la posicion logica y grafica del enemigo al moverse
	 */
	public void move(){
		if((x-1>=0)&&canMove){
			map.getCelda(x-1, y).accept(visitorMovimiento);
			if(canMove){
				((GraphicEnemigo)grafico).avanzar();
				int aux= (x-1)*grafico.getWidthUnaCelda();
				grafico.cambiarPos(grafico.getPos().x-velocidad, grafico.getPos().y);
				
				if(grafico.getPos().x<aux){
					if(x>=0){
						x--;
						map.getCelda(x, y).agregarElemento(this);
						if(x+dimensionX<10)
							map.getCelda(x+dimensionX, y).remover(this);
					}
				}
			}
			else{
				grafico.setImageIdle();
			}
			canMove=true;
		}
	}
	
	public void atacarRango(){
		if(cargaAtaqueActual>=cargaAtaqueNecesaria){
			cargaAtaqueActual=0;
			for(int i=(x-1);i>=x-rango;i--){
				for(int j=y;j<(y+dimensionY);j++){
					Celda c = map.getCelda(i, y);
					if(c!=null){
						c.accept(visitorAtaque);
					}
				}
			}
		}
		else
			cargaAtaqueActual++;
	}
	
	public void kill(){
		escudo.kill();
		visitorAtaque.kill();
		visitorMovimiento.kill();
		((GraphicEnemigo)grafico).morir();
		this.SACARDEARREGLO();
		map.getAlmacenHilos().getAtaEnemigo().enemigoAEliminar(this);
		map.getAlmacenHilos().getMovEnemigo().enemigoAEliminar(this);
		map.getNivel().getJuego().aumentarPuntaje(puntaje);
		map.getNivel().modificarPresupueto(map.getNivel().getPresupuesto()+monedas);
		map.eliminarElemento(this);
		crearPremio();
	}
	private void crearPremio(){
		Random r = new Random();
		int i = r.nextInt(5);
		switch(i){
			case(0):{
				map.getAlmacenHilos().getItemsPremio().agregarItem(new ItemDiamante(x,y,map));
				break;
			}
			case(1):{
				map.getAlmacenHilos().getItemsPremio().agregarItem(new ItemPowerBooster(x,y,map));
				break;
			}
			case(2):{
				map.getAlmacenHilos().getItemsPremio().agregarItem(new ItemBomba(x,y,map));
				break;
			}
			case(3):{
				map.getAlmacenHilos().getItemsPremio().agregarItem(new ItemTrampa(x,y,map));
				break;
			}
			case(4):{
				map.getAlmacenHilos().getItemsPremio().agregarItem(new ItemEscudo(x,y,map));
				break;
			}
		}
	}
	public void setVelocidad(int x){
		velocidad=x;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	public void afectar(Modificador m){
		m.afectar(this);
	}
	public GraphicGameObject getGraphic(){
		return grafico;
	}
}
