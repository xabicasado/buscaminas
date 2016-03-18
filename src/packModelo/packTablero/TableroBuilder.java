package packModelo.packTablero;

import java.util.Random;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaMina;
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
		Coordenada c;
		for (int i = 0; i < tablero.getFilas() - 1; i++) {
			for (int j = 0; j < tablero.getColumnas() - 1; j++) {
				c.setFila(i);
				c.setColumna(j);
				if(tablero.devolverCasilla(c) instanceof CasillaMina) {
					// TODO Falta terminar
				}
			}
		}
		
		
		for(int line=1 ; line < 9 ; line++)
			for(int column=1 ; column < 9 ; column++){
				for(int i=-1 ; i<=1 ; i++)
					for(int j=-1 ; j<=1 ; j++)
						if(mines[line][column] != -1)
							if(mines[line+i][column+j] == -1) mines[line][column]++;
	            }
	}
}
