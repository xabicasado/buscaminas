package packModelo.packTablero;

import java.util.Random;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.CasillaVacia;
import packModelo.packCoordenada.Coordenada;

public abstract class TableroBuilder {
	protected Tablero tablero;
	
	public void generarTablero() {
		tablero = new Tablero();
		// TODO ¿Esto va aquí o en Buscaminas?
		definirFilas();
		definirColumnas();
		definirMinas();
		tablero.setCasillas(new Casilla[tablero.getFilas()][tablero.getColumnas()]);
		inicializarCasillas();
		ponerMinas();
		ponerNumMinasAdyacentes();
	}
	
	protected abstract void definirFilas();
	protected abstract void definirColumnas();
	protected abstract void definirMinas();
	
	public void inicializarCasillas() {
		for (int i = 0; i <= tablero.getFilas() - 1; i++) {
			for (int j = 0; j < tablero.getColumnas() - 1; j++) {
				// TODO Preguntar si se puede usar el mismo objeto Coordenada
				Coordenada c = new Coordenada(i,j);
				tablero.ponerCasilla(new CasillaVacia(c));
			}
		}
	}
	
	public void ponerMinas() {
		boolean hayMina;
		Coordenada c = new Coordenada();
		int fila, columna;
		Random r = new Random();
		
		for(int i = 0 ; i <= tablero.getMinas(); i++){
			do {
				fila = r.nextInt(tablero.getFilas() - 1);
				columna = r.nextInt(tablero.getColumnas() - 1);
				c.setFila(fila);
				c.setColumna(columna);
				if(tablero.devolverCasilla(c) instanceof CasillaMina) hayMina = true;
				else hayMina = false;
			} while (hayMina);
			tablero.ponerCasilla(new CasillaMina(c));
		}
	}
	
	public void ponerNumMinasAdyacentes() {
		Coordenada c = new Coordenada();
		for (int i = 0; i < tablero.getFilas() - 1; i++) {
			for (int j = 0; j < tablero.getColumnas() - 1; j++) {
				c.setFila(i);
				c.setColumna(j);
				if(tablero.devolverCasilla(c) instanceof CasillaMina) {
					incrementarAdyacentes(c);
				}
			}
		}
	}
	private void incrementarAdyacentes(Coordenada pC){
		incrementarCasilla(pC.getFila()-1, pC.getColumna()+1);
		incrementarCasilla(pC.getFila()-1, pC.getColumna());
		incrementarCasilla(pC.getFila()-1, pC.getColumna()-1);
		incrementarCasilla(pC.getFila(), pC.getColumna()+1);
		incrementarCasilla(pC.getFila(), pC.getColumna()-1);
		incrementarCasilla(pC.getFila()+1, pC.getColumna()+1);
		incrementarCasilla(pC.getFila()+1, pC.getColumna());
		incrementarCasilla(pC.getFila()+1, pC.getColumna()-1);
	}
	private void incrementarCasilla(int pFila, int pColumna){
		if ((pFila >= 0 && pColumna >= 0)&&(pFila < tablero.getFilas() && pColumna < tablero.getColumnas())){
			if (tablero.getCasillas()[pFila][pColumna] instanceof CasillaVacia){
				tablero.ponerCasilla(new CasillaNumero(new Coordenada(pFila, pColumna)));
			}
			else if (tablero.getCasillas()[pFila][pColumna] instanceof CasillaNumero){
				Coordenada c = new Coordenada(pFila, pColumna);
				((CasillaNumero) tablero.devolverCasilla(c)).incrementarNumero();
			}
		}
	}
}
