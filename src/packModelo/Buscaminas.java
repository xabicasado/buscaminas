package packModelo;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.Coordenada;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilder;

public class Buscaminas {
	private static Buscaminas elBuscaminas;
	private TableroBuilder tableroBuilder;
	private Tablero tablero;
	
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
	}
	
	public void desplegarCasilla(Coordenada pCoordenada) {
		tablero.desplegarCasilla(pCoordenada);
	}
	
	public void marcarDesmarcarCasilla(Coordenada pCoordenada){
		tablero.marcarDesmarcarCasilla(pCoordenada);
	}

	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		tablero.desplegarAdyacentes(pCoordenada);
	}
	
	public Casilla devolverCasilla(Coordenada pCoordenada) {
		return this.tablero.devolverCasilla(pCoordenada);
	}
	public static void main(String[] args) {
		
	}
}
