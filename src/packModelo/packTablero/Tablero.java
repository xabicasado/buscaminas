package packModelo.packTablero;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.Coordenada;

public class Tablero {
	private int filas;
	private int columnas;
	private int minas;
	private Casilla [][] casillas;
	
	public void setFilas(int filas) { this.filas = filas; }
	public int getFilas() { return this.filas; }
	
	public void setColumnas(int columnas) { this.columnas = columnas; }
	public int getColumnas() { return this.columnas; }
	
	public void setMinas(int minas) { this.minas = minas; }
	public int getMinas() { return this.minas; }
	
	public Casilla[][] getCasillas() { return this.casillas; }
	public void setCasillas(Casilla[][] casillas) { this.casillas = casillas; }
	
	public Casilla devolverCasilla(Coordenada pCoordenada) {
		return this.casillas[pCoordenada.getFila()][pCoordenada.getColumna()];
	}
	public void incrementarNumCasilla(Coordenada pCoordenada){
		
	}
	public void ponerCasilla(Casilla pCasilla) {
		Coordenada c = pCasilla.getCoordenada();
		this.casillas[c.getFila()][c.getColumna()] = pCasilla;
	}
	
	public void desplegarCasilla(int pFila ,int pColumna ) {
		if ((pFila >=0 && pColumna>=0)&&(pFila<filas && pColumna < columnas)){
		casillas[pFila][pColumna].desplegarCasilla();
		}
	}
	
	public void accionCasilla(int pFila, int pColumna){
		casillas[pFila][pColumna].accionCasilla();
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna());
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()-1);
		desplegarCasilla(pCoordenada.getFila(), pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila(), pCoordenada.getColumna()-1);
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna());
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()-1);
		
	}
}
