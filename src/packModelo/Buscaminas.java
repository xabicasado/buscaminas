package packModelo;

import packModelo.packCoordenada.Coordenada;
import packModelo.packTablero.Tablero;
import packModelo.packTablero.TableroBuilder;

public class Buscaminas {
	private static Buscaminas elBuscaminas;
	private TableroBuilder tableroBuilder;
	private static Tablero tablero;
	
	private Buscaminas() { }
	
	public static Buscaminas getElBuscaminas() {
		if (elBuscaminas == null) elBuscaminas = new Buscaminas();
		return elBuscaminas;
	}
	
	public void setTableroBuilder(TableroBuilder pTableroBuilder) { this.tableroBuilder = pTableroBuilder; }
	public Tablero getTablero() { return tablero; }
	
	public void jugar() {
		
	}
	
	private void construirTablero(int pNivel) {
		
	}
	
	public static void desplegarCasilla(int pFila ,int pColumna ) {
		tablero.desplegarCasilla(pFila, pColumna);
	}
	
	public void accionCasilla(int pFila, int pColumna){
		tablero.accionCasilla(pFila, pColumna);
	}
	
	public static void desplegarAdyacentes(Coordenada pCoordenada){
		tablero.desplegarAdyacentes(pCoordenada);
	}
}
