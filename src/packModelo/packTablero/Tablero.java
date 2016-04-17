package packModelo.packTablero;

import packModelo.packCasilla.Casilla;
import packModelo.packCasilla.CasillaMina;
import packModelo.packCasilla.CasillaNumero;
import packModelo.packCasilla.Coordenada;

public class Tablero {
	private int filas;
	private int columnas;
	private int minas;
	private Casilla [][] casillas;
	private int nCasillasRestantes;
	
	public void setFilas(int filas) { this.filas = filas; }
	public int getFilas() { return this.filas; }
	
	public void setColumnas(int columnas) { this.columnas = columnas; }
	public int getColumnas() { return this.columnas; }
	
	public void setMinas(int minas) { this.minas = minas; }
	public int getMinas() { return this.minas; }
	
	public void setnCasillasRestantes(int nCasillasRestantes) { this.nCasillasRestantes = nCasillasRestantes; }
	public int getnCasillasRestantes() { return nCasillasRestantes; }
	public void decrementarCasillasRestantes() { this.nCasillasRestantes = this.nCasillasRestantes - 1; }
	
	public Casilla[][] getCasillas() { return this.casillas; }
	public void setCasillas(Casilla[][] casillas) { this.casillas = casillas; }
	
	public Casilla devolverCasilla(Coordenada pCoordenada) {
		return this.casillas[pCoordenada.getFila()][pCoordenada.getColumna()];
	}
	
	public void ponerCasilla(Casilla pCasilla) {
		Coordenada c = pCasilla.getCoordenada();
		this.casillas[c.getFila()][c.getColumna()] = pCasilla;
	}
	
	public void desplegarCasilla(Coordenada pCoordenada) {
		if ((pCoordenada.getFila() >=0 && pCoordenada.getColumna()>=0)&&
				(pCoordenada.getFila()<filas && pCoordenada.getColumna() < columnas)){
			casillas[pCoordenada.getFila()][pCoordenada.getColumna()].desplegarCasilla();
		}
	}
	
	public void marcarDesmarcarCasilla(Coordenada pCoordenada){
		casillas[pCoordenada.getFila()][pCoordenada.getColumna()].marcarDesmarcarCasilla();
	}
	
	public void desplegarAdyacentes(Coordenada pCoordenada){
		Coordenada c= new Coordenada();
		c.setFila(pCoordenada.getFila()-1);
		c.setColumna(pCoordenada.getColumna()-1);
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila()-1);
		c.setColumna(pCoordenada.getColumna());
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila()-1);
		c.setColumna(pCoordenada.getColumna()+1);
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila());
		c.setColumna(pCoordenada.getColumna()+1);
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila()+1);
		c.setColumna(pCoordenada.getColumna()+1);
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila()+1);
		c.setColumna(pCoordenada.getColumna());
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila()+1);
		c.setColumna(pCoordenada.getColumna()-1);
		desplegarCasilla(c);
		c.setFila(pCoordenada.getFila());
		c.setColumna(pCoordenada.getColumna()-1);
		desplegarCasilla(c);
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
		System.out.println("");
	}
}
