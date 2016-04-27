package packModelo;



import packModelo.packCasilla.*;
import packModelo.packCasilla.Coordenada;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilder;
import packVista.IObserver;

public class Buscaminas extends Observable{
	private static Buscaminas elBuscaminas;
	private TableroBuilder tableroBuilder;
	private Tablero tablero;
	private boolean derrota;
	
	private Buscaminas() { }
	
	public static Buscaminas getElBuscaminas() {
		if (elBuscaminas == null) elBuscaminas = new Buscaminas();
		return elBuscaminas;
	}
	
	public void setTableroBuilder(TableroBuilder pTableroBuilder) { this.tableroBuilder = pTableroBuilder; }
	
	public Tablero getTablero() { return tablero;}

	public void jugar() {
		// TODO Implementar método
		this.tablero = this.tableroBuilder.generarTablero();
		this.derrota = false;
	}
	
	public void desplegarCasilla(Coordenada pCoordenada) {
		Casilla c = tablero.desplegarCasilla(pCoordenada);
		if (c!=null && c.getEstado() instanceof Descubierta){
			if (c instanceof CasillaMina) notificar(pCoordenada, "*");
			else if (c instanceof CasillaVacia) notificar(pCoordenada, "-");
			else if (c instanceof CasillaNumero) notificar(pCoordenada, ((CasillaNumero) c).getNumero()+"");
			
		}
	}
	
	public void marcarDesmarcarCasilla(Coordenada pCoordenada){
		tablero.marcarDesmarcarCasilla(pCoordenada);
		notificar(pCoordenada, "m");
		
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
	
	public void notificar(Coordenada pC, String tipo){
		observador.update(pC, tipo);
	}
	public  void setObservador(IObserver pObservador){
		this.observador=pObservador;
	}
}
