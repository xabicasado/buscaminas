package packModelo.packTablero;

public class TableroBuilderNivel1 extends TableroBuilderSinPersonalizar {
	@Override
	protected void definirFilas() {
		tablero.setFilas(7);
	}

	@Override
	protected void definirColumnas() {
		tablero.setColumnas(10);
	}

	@Override
	protected void definirMinas() {
		tablero.setMinas(10);
	}	
}
