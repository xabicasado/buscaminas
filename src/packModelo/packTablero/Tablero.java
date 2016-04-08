package packModelo.packTablero;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.Coordenada;
import packModelo.packCasilla.Cubierta;

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
	
	public void ponerCasilla(Casilla pCasilla) {
		Coordenada c = pCasilla.getCoordenada();
		this.casillas[c.getFila()][c.getColumna()] = pCasilla;
	}
	
	public void desplegarCasilla(int pFila ,int pColumna ) {
		if ((pFila >=0 && pColumna>=0)&&(pFila<filas && pColumna < columnas)){
			casillas[pFila][pColumna].desplegarCasilla();
		}
	}
	
	public void marcarDesmarcarCasilla(Coordenada pCoordenada){
		casillas[pCoordenada.getFila()][pCoordenada.getColumna()].marcarDesmarcarCasilla();
	}
	
	public void accionCasilla(int pFila, int pColumna){
		casillas[pFila][pColumna].accionCasilla();
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()-1);
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna());
		desplegarCasilla(pCoordenada.getFila()-1, pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila(), pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()+1);
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna());
		desplegarCasilla(pCoordenada.getFila()+1, pCoordenada.getColumna()-1);
		desplegarCasilla(pCoordenada.getFila(), pCoordenada.getColumna()-1);
	}
	
	public void imprimirChivato() {
		Coordenada c = new Coordenada();
		Casilla casilla;
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				c.setFila(i);
				c.setColumna(j);
				casilla = devolverCasilla(c);
				
				if(casilla instanceof CasillaMina) {
					System.out.print(" * ");
				} else if(casilla instanceof CasillaNumero) {
					System.out.print(" " + ((CasillaNumero) casilla).getNumero() + " ");
				} else {
					System.out.print(" 0 ");
				}	
			}
			System.out.println("");
		}
	}
	
	public void imprimirResultado() {
		Coordenada c = new Coordenada();
		Casilla casilla;
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				c.setFila(i);
				c.setColumna(j);
				casilla = devolverCasilla(c);
				
				if(casilla.getEstado() instanceof Cubierta) {
					System.out.print(" - ");
				} else {
					System.out.print(" X ");
				}	
			}
			System.out.println("");
		}
	}
}
