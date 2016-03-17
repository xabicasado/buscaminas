package packModelo;

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
	
	public void setTableroBuilder(TableroBuilder tableroBuilder) { this.tableroBuilder = tableroBuilder; }
	public Tablero getTablero() { return tablero; }
	
	public void jugar() {
		
	}
	
	private void construirTablero() {
		
	}
	
	public void desplegarCasilla(int pFila ,int pColumna ) {
		tablero.desplegarCasilla(pFila, pColumna);
	}
	
	public void accionCasilla(int pFila, int pColumna){
		tablero.accionCasilla(pFila, pColumna);
	}
}
