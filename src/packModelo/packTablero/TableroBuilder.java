package packModelo.packTablero;

public abstract class TableroBuilder {
	protected Tablero tablero;
	
	public void generarTablero(int pNivel) {
		
	}
	
	protected abstract void definirFilas();
	protected abstract void definirColumnas();
	protected abstract void definirMinas();
	
	public void ponerMinas() {
		
	}
	
	public void ponerNumMinasAdyacentes() {
		
	}
}
