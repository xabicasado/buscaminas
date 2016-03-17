package packModelo.packTablero;

public class TableroBuilderNivel3 extends TableroBuilderSinPersonalizar {
	@Override
	protected void definirFilas() {
		tablero.setFilas(12);
	}

	@Override
	protected void definirColumnas() {
		tablero.setColumnas(25);
	}

	@Override
	protected void definirMinas() {
		tablero.setMinas(75);
	}
}
