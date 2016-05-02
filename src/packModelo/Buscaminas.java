package packModelo;



import java.util.ArrayList;
import java.util.Observable;

import packModelo.packCasilla.*;
import packModelo.packCasilla.Coordenada;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilder;

public class Buscaminas extends Observable{
	private static Buscaminas elBuscaminas;
	private TableroBuilder tableroBuilder;
	private Tablero tablero;
	private boolean derrota;
	private Usuario usuario;
	
	private Buscaminas() { }
	
	public static Buscaminas getElBuscaminas() {
		if (elBuscaminas == null) elBuscaminas = new Buscaminas();
		return elBuscaminas;
	}
	
	public void setTableroBuilder(TableroBuilder pTableroBuilder) { this.tableroBuilder = pTableroBuilder; }
	
	public Tablero getTablero() { return tablero;}
	
	public void crearUsuario(String pNombre, int pNivel) {
		this.usuario = new Usuario(pNombre, pNivel);
	}
	
	public void jugar() {
		setTableroBuilder(this.usuario.getNivel());
		this.tablero = this.tableroBuilder.generarTablero();
		this.derrota = false;
	}
	
	public void desplegarCasilla(Coordenada pCoordenada) {
		Casilla c = tablero.desplegarCasilla(pCoordenada);
		ArrayList<Object> a =new ArrayList<Object>();
		if (c!=null && c.getEstado() instanceof Descubierta){
			if (c instanceof CasillaMina) {
				a.add(pCoordenada);
				a.add("*");
				setChanged();
				notifyObservers(a);
				}
			else if (c instanceof CasillaVacia) {
				a.add(pCoordenada);
				a.add("-");
				setChanged();
				notifyObservers(a);
			}
			else if (c instanceof CasillaNumero) {
				a.add(pCoordenada);
				a.add(""+((CasillaNumero) c).getNumero()+"");
				setChanged();
				notifyObservers(a);
			}
			
		}
	}
	
	public void marcarDesmarcarCasilla(Coordenada pCoordenada){
		ArrayList<Object> a =new ArrayList<Object>();
		tablero.marcarDesmarcarCasilla(pCoordenada);
		a.add(pCoordenada);
		a.add("m");
		setChanged();
		notifyObservers(a);
		
	}
	
	public void decrementarCasillasRestantes() {
		this.tablero.decrementarCasillasRestantes();
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		tablero.desplegarAdyacentes(pCoordenada);
	}
	
	public Casilla devolverCasilla(Coordenada pCoordenada) {
		return this.tablero.devolverCasilla(pCoordenada);
	}

	public boolean hasGanado() {
		return this.tablero.getnCasillasRestantes() == this.tablero.getMinas();
	}
	
	public void derrotado() { this.derrota = true; }
	public boolean hasPerdido() { return this.derrota; }

	public void accionCasilla(Coordenada coordenada) {
		tablero.devolverCasilla(coordenada).accionCasilla();
	}
	
	
	
}
