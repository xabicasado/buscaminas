package packModelo.packTablero;

import packModelo.packCasilla.Casilla;

public class Tablero {
	private int filas;
	private int columnas;
	private int minas;
	private Casilla [][] casillas;
	
	public void setFilas(int filas) { this.filas = filas; }
	public void setColumnas(int columnas) { this.columnas = columnas; }
	public void setMinas(int minas) { this.minas = minas; }
	
	public void desplegarCasilla(int pFila ,int pColumna ) {
		casillas[pFila][pColumna].desplegarCasilla();
	}
	
	public void accionCasilla(int pFila, int pColumna){
		casillas[pFila][pColumna].accionCasilla();
	}
	
	public void desplegarAdyacentes(int pFila, int pColumna){
		desplegarCasilla(pFila-1, pColumna+1);
		desplegarCasilla(pFila-1, pColumna);
		desplegarCasilla(pFila-1, pColumna-1);
		desplegarCasilla(pFila, pColumna+1);
		desplegarCasilla(pFila, pColumna-1);
		desplegarCasilla(pFila+1, pColumna+1);
		desplegarCasilla(pFila+1, pColumna);
		desplegarCasilla(pFila+1, pColumna-1);
		
	}
}
