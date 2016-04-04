package packModelo;

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
	
	public void jugar() {
		// TODO Implementar método
		this.tableroBuilder.generarTablero();
	}
	
	// TODO desplegarCasilla y accionCasilla deberían recibir Coordenada en lugar de dos variables
	public void desplegarCasilla(int pFila ,int pColumna ) {
		tablero.desplegarCasilla(pFila, pColumna);
	}
	
	public void accionCasilla(int pFila, int pColumna){
		tablero.accionCasilla(pFila, pColumna);
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		tablero.desplegarAdyacentes(pCoordenada);
	}
	
	public static void main(String[] args) {
		
	}
}
