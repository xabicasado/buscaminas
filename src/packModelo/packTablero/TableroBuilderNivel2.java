package packModelo.packTablero;

public class TableroBuilderNivel2 extends TableroBuilderSinPersonalizar {
	@Override
	protected void definirFilas() {
		tablero.setFilas(10);
	}

	@Override
	protected void definirColumnas() {
		tablero.setColumnas(15);
	}

	@Override
	protected void definirMinas() {
		tablero.setMinas(30);
	}
}
