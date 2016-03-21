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
		
	}
	
	private void construirTablero(int pNivel) {
		
	}
	
	public void desplegarCasilla(int pFila ,int pColumna ) {
		tablero.desplegarCasilla(pFila, pColumna);
	}
	
	public void accionCasilla(int pFila, int pColumna){
		tablero.accionCasilla(pFila, pColumna);
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		tablero.desplegarAdyacentes(pCoordenada);
	}
}
