package packModelo.packCasilla;

public class Coordenada {
	private int fila;
	private int columna;
	
	public Coordenada() { }
	public Coordenada(int pFila, int pColumna){
		this.fila = pFila;
		this.columna = pColumna;
	}
	
	public int getFila() { return this.fila; }
	public void setFila(int fila) { this.fila = fila; }
	
	public int getColumna() { return this.columna; }
	public void setColumna(int columna) { this.columna = columna; }
}
